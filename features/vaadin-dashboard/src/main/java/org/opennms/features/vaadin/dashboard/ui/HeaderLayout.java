/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2006-2012 The OpenNMS Group, Inc.
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
package org.opennms.features.vaadin.dashboard.ui;

import com.vaadin.data.Property;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import org.opennms.features.vaadin.dashboard.config.ui.WallboardProvider;
import org.opennms.features.vaadin.dashboard.ui.wallboard.WallboardView;

/**
 * The top heading layout for the wallboard view.
 *
 * @author Christian Pape
 * @author Marcus Hellberg (marcus@vaadin.com)
 */
public class HeaderLayout extends HorizontalLayout implements ViewChangeListener {

    WallboardView wallboardView = null;
    Button pauseButton, wallboardButton;

    /**
     * Default constructor.
     */
    public HeaderLayout() {
        /**
         * Setting up the layout
         */
        addStyleName("header");
        setMargin(true);
        setSpacing(true);
        setWidth("100%");

        /**
         * Adding the logo
         */
        //Image logo = new Image(null, new ThemeResource("img/logo.png"));
        Link link = new Link(null, new ExternalResource("/opennms/index.jsp"));
        link.setIcon(new ThemeResource("img/logo.png"));
        addComponent(link);
//        setExpandRatio(logo, 1.0f);
        setExpandRatio(link, 1.0f);

        /**
         * Adding the selection box
         */
        final NativeSelect nativeSelect = new NativeSelect();
        nativeSelect.setContainerDataSource(WallboardProvider.getInstance().getBeanContainer());
        nativeSelect.setItemCaptionPropertyId("title");
        nativeSelect.setNullSelectionAllowed(false);
        nativeSelect.setImmediate(true);

        nativeSelect.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                wallboardButton.setEnabled(true);
            }
        });

        /*
        Button dashboardButton = new Button("Dashboard", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                UI.getCurrent().getNavigator().navigateTo("dashboard/" + nativeSelect.getContainerProperty(nativeSelect.getValue(), "title"));
            }
        });
        */

        /**
         * Adding the wallboard button
         */
        pauseButton = new Button("Pause", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                if (wallboardView.isPaused()) {
                    wallboardView.resume();
                } else {
                    wallboardView.pause();
                }

                updatePauseButton();
            }
        });

        /**
         * Adding the wallboard button
         */
        wallboardButton = new Button("Wallboard", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                UI.getCurrent().getNavigator().addViewChangeListener(HeaderLayout.this);
                UI.getCurrent().getNavigator().navigateTo("wallboard/" + nativeSelect.getContainerProperty(nativeSelect.getValue(), "title"));
            }
        });

        pauseButton.setEnabled(false);
        wallboardButton.setEnabled(false);

        addComponents(nativeSelect, /*dashboardButton,*/ wallboardButton, pauseButton);
        setComponentAlignment(nativeSelect, Alignment.MIDDLE_CENTER);
        //setComponentAlignment(dashboardButton, Alignment.MIDDLE_CENTER);
        setComponentAlignment(wallboardButton, Alignment.MIDDLE_CENTER);
        setComponentAlignment(pauseButton, Alignment.MIDDLE_CENTER);
    }

    private void updatePauseButton() {
        if (wallboardView.isPausable()) {
            pauseButton.setEnabled(true);

            if (wallboardView.isPaused()) {
                pauseButton.setCaption("Resume");
            } else {
                pauseButton.setCaption("Pause");
            }
        } else {
            pauseButton.setEnabled(false);
            pauseButton.setCaption("Pause");
        }
    }

    @Override
    public boolean beforeViewChange(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        return true;
    }

    @Override
    public void afterViewChange(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        if (viewChangeEvent.getNewView() instanceof WallboardView) {
            wallboardView = (WallboardView) viewChangeEvent.getNewView();

            updatePauseButton();
        }
    }
}
