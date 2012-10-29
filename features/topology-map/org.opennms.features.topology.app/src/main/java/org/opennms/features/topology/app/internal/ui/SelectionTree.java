package org.opennms.features.topology.app.internal.ui;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.opennms.features.topology.api.GraphContainer;
import org.opennms.features.topology.api.VertexContainer;
import org.opennms.features.topology.app.internal.TopologyComponent;
import org.opennms.features.topology.app.internal.TopologyComponent.SelectionListener;

import com.vaadin.data.Item;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Tree;

@SuppressWarnings({"serial", "unchecked"})
public class SelectionTree extends Tree implements SelectionListener{
    
    private class TreeItemClickTracker{
        
        private Object m_clickedItemId;
        private boolean m_remove;
        public TreeItemClickTracker() {}
        
        public void setClickedItemId(Object itemId) {
            m_clickedItemId = itemId;
            m_remove = false;
        }
        public Object getClickedItemId() {
            return m_clickedItemId;
        }
        
        public void setRemove(boolean remove) {
            m_remove = remove;
        }
        
        public boolean isRemoved() {
            return m_remove;
        }
    }
    
    private final TreeItemClickTracker m_treeItemClickTracker = new TreeItemClickTracker();
    private final TopologyComponent m_topologyComponent;
    private boolean m_itemClicked = false;
    
    public SelectionTree(TopologyComponent topoComponent) {
        super();
        
        m_topologyComponent = topoComponent;
        
        this.addListener(new ValueChangeListener() {
            
            @Override
            public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
                
                if(m_itemClicked) {
                    Set<Object> selectedIds = (Set<Object>) event.getProperty().getValue();
                    
                    Collection<Object> allIds = (Collection<Object>) getContainerDataSource().getItemIds();
                    
                    Set<Object> itemsToSelect = getSelectedItemIds(selectedIds);
                    
                    Set<Object> itemsToDeselected = getItemsToDeselecte(allIds, itemsToSelect);
                    
                    deselectContainerItems(itemsToDeselected);
                    
                    selectContainerItemAndChildren(itemsToSelect);
                } 
                
            }
        });
        
        this.addListener(new ItemClickListener() {
            
            @Override
            public void itemClick(ItemClickEvent event) {
                m_itemClicked = true;
                Set<Object> selectedIds = (Set<Object>) ((SelectionTree) event.getSource()).getValue();
                
                Object itemId = event.getItemId();
                m_treeItemClickTracker.setClickedItemId(itemId);
                
                if((event.isCtrlKey() || event.isMetaKey()) && selectedIds.contains(itemId)) {
                    m_treeItemClickTracker.setRemove(true);
                } 
                
                m_topologyComponent.requestRepaint();
                
            }
        });
    }

    @Override
    public void onSelectionUpdate(GraphContainer graphContainer) {
        m_itemClicked = false;
        VertexContainer<?,?> vertexContainer = graphContainer.getVertexContainer();
        Collection<?> itemIds = vertexContainer.getItemIds();
        
        for(Object itemId : itemIds) {
            Item item = vertexContainer.getItem(itemId);
            if((Boolean) item.getItemProperty("selected").getValue()) {
                select(itemId);
            } else {
                unselect(itemId);
            }
        }
    }
    
    public void select(Collection<Object> itemIds) {
        
        for(Object itemId : itemIds) {
            select(itemId);
        }
    }
    
    public void deselect(Collection<Object> itemIds) {
        for(Object itemId : itemIds) {
            unselect(itemId);
        }
    }

    private Set<Object> getSelectedItemIds(Set<Object> selectedIds) {
        Set<Object> itemsToSelect = new LinkedHashSet<Object>(selectedIds);
        if(m_treeItemClickTracker.isRemoved()) {
            if(getParent(m_treeItemClickTracker.getClickedItemId()) != null) {
                unselect( getParent(m_treeItemClickTracker.getClickedItemId() ) );
            }
            unselect(m_treeItemClickTracker.getClickedItemId());
            itemsToSelect.remove(m_treeItemClickTracker.getClickedItemId());
        }
        return itemsToSelect;
    }

    private Set<Object> getItemsToDeselecte(Collection<Object> allIds, Set<Object> itemsToSelect) {
        Set<Object> itemsToDeselected = new LinkedHashSet<Object>(allIds);
        itemsToDeselected.removeAll(itemsToSelect);
        return itemsToDeselected;
    }

    private void deselectContainerItems(Set<Object> itemsToDeselected) {
        for(Object itemId : itemsToDeselected) {
            Item item = getContainerDataSource().getItem(itemId);
            item.getItemProperty("selected").setValue(false);
        }
    }

    private void selectContainerItemAndChildren(Set<Object> itemsToSelect) {
        for(Object itemId : itemsToSelect) {
            Item item = getContainerDataSource().getItem(itemId);
            item.getItemProperty("selected").setValue(true);
            if( hasChildren(itemId) ) {
                for(Object id : getChildren(itemId)) {
                    select(id);
                }
            }
        }
    }
}