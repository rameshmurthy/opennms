/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2011-2012 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2012 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.features.gwt.combobox.client;

import org.opennms.features.gwt.combobox.client.presenter.Presenter;
import org.opennms.features.gwt.combobox.client.presenter.SuggestionComboboxPresenter;
import org.opennms.features.gwt.combobox.client.rest.DefaultNodeService;
import org.opennms.features.gwt.combobox.client.view.NodeDetail;
import org.opennms.features.gwt.combobox.client.view.SuggestionComboboxView;
import org.opennms.features.gwt.combobox.client.view.SuggestionComboboxViewImpl;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * The Class AppController.
 */
public class AppController implements Presenter {

    /** The m_event bus. */
    private final SimpleEventBus m_eventBus;

    /** The m_suggestion combobox view. */
    private SuggestionComboboxView<NodeDetail> m_suggestionComboboxView;

    /** The m_container. */
    private HasWidgets m_container;

    /**
     * Instantiates a new app controller.
     *
     * @param eventBus
     *            the event bus
     */
    public AppController(SimpleEventBus eventBus) {
        m_eventBus = eventBus;
    }

    /* (non-Javadoc)
     * @see org.opennms.features.gwt.combobox.client.presenter.Presenter#go(com.google.gwt.user.client.ui.HasWidgets)
     */
    @Override
    public void go(HasWidgets container) {
        m_container = container;

        if (m_suggestionComboboxView == null) {
            m_suggestionComboboxView = new SuggestionComboboxViewImpl();
        }

        new SuggestionComboboxPresenter(m_eventBus, m_suggestionComboboxView, new DefaultNodeService()).go(m_container);
    }

}
