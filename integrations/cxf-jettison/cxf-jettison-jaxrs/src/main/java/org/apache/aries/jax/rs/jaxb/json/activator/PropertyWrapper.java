/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.aries.jax.rs.jaxb.json.activator;

import java.util.Dictionary;
import java.util.function.Consumer;

public class PropertyWrapper {

    public PropertyWrapper(Dictionary<String, ?> properties) {
        this._properties = properties;
    }

    public void applyBoolean(String property, Consumer<Boolean> consumer) {

        Object value = _properties.get(property);

        if ((value != null) && (value instanceof Boolean)) {
            consumer.accept((Boolean) value);
        }
        if ((value != null) && (value instanceof String)) {
            consumer.accept(Boolean.parseBoolean((String) value));
        }
    }

    public void applyString(String property, Consumer<String> consumer) {

        Object value = _properties.get(property);

        if ((value != null)) {
            consumer.accept(value.toString());
        }
    }

    private Dictionary<String, ?> _properties;
}
