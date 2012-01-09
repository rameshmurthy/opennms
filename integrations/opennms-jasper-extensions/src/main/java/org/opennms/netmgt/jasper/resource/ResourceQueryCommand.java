package org.opennms.netmgt.jasper.resource;

import java.io.File;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;

import org.opennms.netmgt.jasper.helper.ResourcePathFileTraversal;

public class ResourceQueryCommand {
    
    JRDataSource executeCommand(String command) {
        
        ResourceQuery query = new ResourceQueryCommandParser().parseQueryCommand(command);
        
        ResourcePathFileTraversal traverser = new ResourcePathFileTraversal(new File(query.constructBasePath()));
        traverser.addFilenameFilters(query.getFilters());
        List<String> paths = traverser.traverseDirectory();
        System.err.println("paths: " + paths);
        
        JRDataSource dataSource = new ResourceDataSource(paths);
        //TODO: stopped here
        return dataSource;
    }

}