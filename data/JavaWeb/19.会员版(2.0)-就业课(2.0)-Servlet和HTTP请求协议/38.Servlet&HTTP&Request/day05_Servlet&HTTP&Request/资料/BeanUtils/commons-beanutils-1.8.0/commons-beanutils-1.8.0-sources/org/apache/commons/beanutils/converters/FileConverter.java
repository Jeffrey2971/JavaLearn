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
package org.apache.commons.beanutils.converters;

import java.io.File;

/**
 * {@link org.apache.commons.beanutils.Converter} implementaion that handles conversion
 * to and from <b>java.io.File</b> objects.
 * <p>
 * Can be configured to either return a <i>default value</i> or throw a
 * <code>ConversionException</code> if a conversion error occurs.
 *
 * @author James Strachan
 * @version $Revision: 640131 $ $Date: 2008-03-23 02:10:31 +0000 (Sun, 23 Mar 2008) $
 * @since 1.6
 */
public final class FileConverter extends AbstractConverter {

    /**
     * Construct a <b>java.io.File</b> <i>Converter</i> that throws
     * a <code>ConversionException</code> if an error occurs.
     */
    public FileConverter() {
        super();
    }

    /**
     * Construct a <b>java.io.File</b> <i>Converter</i> that returns
     * a default value if an error occurs.
     *
     * @param defaultValue The default value to be returned
     * if the value to be converted is missing or an error
     * occurs converting the value.
     */
    public FileConverter(Object defaultValue) {
        super(defaultValue);
    }

    /**
     * Return the default type this <code>Converter</code> handles.
     *
     * @return The default type this <code>Converter</code> handles.
     */
    protected Class getDefaultType() {
        return File.class;
    }

    /**
     * <p>Convert the input object into a java.io.File.</p>
     *
     * @param type Data type to which this value should be converted.
     * @param value The input value to be converted.
     * @return The converted value.
     * @throws Throwable if an error occurs converting to the specified type
     */
    protected Object convertToType(Class type, Object value) throws Throwable {
        return new File(value.toString());
    }
}
