/**
 * Copyright (c) 2014,2018 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.smarthome.model.thing.test.hue

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*
import static org.junit.matchers.JUnitMatchers.*

import org.eclipse.smarthome.config.core.ConfigDescription
import org.eclipse.smarthome.config.core.ConfigDescriptionParameter
import org.eclipse.smarthome.config.core.ConfigDescriptionProvider
import org.eclipse.smarthome.config.core.ConfigDescriptionParameter.Type

import com.google.common.collect.Lists

/**
 *
 * @author Simon Kaufmann - initial contribution and API
 *
 */
class TestHueConfigDescriptionProvider implements ConfigDescriptionProvider {

    @Override
    public Collection<ConfigDescription> getConfigDescriptions(Locale locale) {
        return null
    }

    @Override
    public ConfigDescription getConfigDescription(URI uri, Locale locale) {
        if (uri.equals(new URI("hue:LCT001:color"))) {
            ConfigDescriptionParameter paramDefault = new ConfigDescriptionParameter("defaultConfig", Type.TEXT) {
                        String getDefault() {
                            return "defaultValue"
                        };
                    }
            ConfigDescriptionParameter paramCustom = new ConfigDescriptionParameter("customConfig", Type.TEXT) {
                        String getDefault() {
                            return "none"
                        };
                    }
            return new ConfigDescription(uri, Lists.newArrayList(paramDefault, paramCustom));
        }
        return null
    }
}
