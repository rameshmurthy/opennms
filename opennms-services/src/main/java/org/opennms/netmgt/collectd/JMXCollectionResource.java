package org.opennms.netmgt.collectd;

import java.io.File;

import org.opennms.netmgt.config.collector.CollectionAttributeType;
import org.opennms.netmgt.config.collector.ServiceParameters;
import org.opennms.netmgt.model.RrdRepository;

class JMXCollectionResource extends AbstractCollectionResource {
    String m_resourceName;
    private int m_nodeId;

    JMXCollectionResource(CollectionAgent agent, String resourceName) {
        super(agent);
        m_resourceName=resourceName;
        m_nodeId = agent.getNodeId();
    }

    @Override
    public String toString() {
        return "node["+m_nodeId+']';
    }

    @Override
    public int getType() {
        return -1; //Is this correct?
    }

    @Override
    public boolean rescanNeeded() {
        return false;
    }

    @Override
    public boolean shouldPersist(ServiceParameters params) {
        return true;
    }

    public void setAttributeValue(CollectionAttributeType type, String value) {
        JMXCollectionAttribute attr = new JMXCollectionAttribute(this, type, type.getName(), value);
        addAttribute(attr);
    }

    @Override
    public File getResourceDir(RrdRepository repository) {
        return new File(repository.getRrdBaseDir(), getParent() + File.separator + m_resourceName);
    }

    @Override
    public String getResourceTypeName() {
        return "node"; //All node resources for JMX; nothing of interface or "indexed resource" type
    }

    @Override
    public String getInstance() {
        return null; //For node type resources, use the default instance
    }

    @Override
    public String getParent() {
        return m_agent.getStorageDir().toString();
    }
}