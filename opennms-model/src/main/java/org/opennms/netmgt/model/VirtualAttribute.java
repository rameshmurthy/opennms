package org.opennms.netmgt.model;

public class VirtualAttribute implements OnmsAttribute {
    private String m_name;
    private String m_originalResourceId;
    private OnmsResource m_resource;

    /**
     * <p>Constructor for RrdGraphAttribute.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param relativePath a {@link java.lang.String} object.
     * @param rrdFile a {@link java.lang.String} object.
     */
    public VirtualAttribute(String name, String resourceId) {
        m_name = name;
        m_originalResourceId = resourceId;
    }

    @Override
    public String getName() {
        return m_name;
    }

    @Override
    public OnmsResource getResource() {
        return m_resource;
    }

    @Override
    public void setResource(OnmsResource resource) {
        m_resource = resource;
    }

    public String getOriginalResourceId() {
        return m_originalResourceId;
    }
}
