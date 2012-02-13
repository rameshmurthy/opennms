package org.opennms.netmgt.rrd.cassandra;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.cassandra.thrift.ConsistencyLevel;
import org.scale7.cassandra.pelops.Mutator;
import org.scale7.cassandra.pelops.Pelops;

class Persister implements Runnable {
	String m_poolName;
	String m_columnFamily;
	int m_ttl;
	BlockingQueue<Datapoint> m_queue = new LinkedBlockingQueue<Datapoint>();
	int m_maxBatchSize = 100000;
	int m_naglesDelay = 0;
	Thread m_thread;
	AtomicBoolean m_finish = new AtomicBoolean(false);
	CountDownLatch m_finishLatch = new CountDownLatch(1);

	Persister(String poolName, String columnFamily, int ttl) {
		m_poolName = poolName;
		m_columnFamily = columnFamily;
		m_ttl = ttl;
		m_thread = new Thread(this, "Cassandra-Persister");
		m_thread.setDaemon(true);
		m_thread.start();
	}

    public List<Datapoint> getDatapoints() throws InterruptedException {
        List<Datapoint> datapoints = m_maxBatchSize > 0 ? new ArrayList<Datapoint>(m_maxBatchSize) : new ArrayList<Datapoint>();

        Datapoint d = m_queue.take();
        datapoints.add(d);

        drainTo(datapoints);

        if (m_naglesDelay <= 0) {
            return datapoints;
        }

        long now = System.currentTimeMillis();
        long expirationTime = now + m_naglesDelay;
        while (hasMoreRoom(datapoints) && now < expirationTime) {
            Datapoint datapoint = m_queue.poll(expirationTime - now, TimeUnit.MILLISECONDS);

            if (datapoint != null) {
                datapoints.add(datapoint);
                drainTo(datapoints);
            }

            now = System.currentTimeMillis();
        }

        return datapoints;

    }

	public void drainTo(List<Datapoint> datapoints) {
		if (m_maxBatchSize > 0) {
			m_queue.drainTo(datapoints, m_maxBatchSize - datapoints.size());
		} else {
			m_queue.drainTo(datapoints);
		}
	}

	public boolean hasMoreRoom(List<Datapoint> datapoints) {
		return m_maxBatchSize <= 0 || datapoints.size() < m_maxBatchSize;
	}

	public void run() {
		while (true) {
		try {
			if (m_finish.get() && m_queue.peek() == null) {
				m_finishLatch.countDown();
				return;
			}
			List<Datapoint> datapoints = getDatapoints();
			if (datapoints == null) continue;

			System.err.print("Writing " + datapoints.size() + " datapoints...");

			long start = System.currentTimeMillis();
			Mutator mutator = Pelops.createMutator(m_poolName);

			for(Datapoint datapoint : datapoints) {
				datapoint.perist(mutator, m_columnFamily, m_ttl);
			}

			mutator.execute(ConsistencyLevel.ONE);
			long end = System.currentTimeMillis();

			System.err.println((end - start) + " ms.");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	}

	public void persist(Datapoint datapoint) {
		m_queue.offer(datapoint);
	}

	public void waitForFinish() throws InterruptedException {
		m_finish.set(true);
		m_finishLatch.await();
	}

}