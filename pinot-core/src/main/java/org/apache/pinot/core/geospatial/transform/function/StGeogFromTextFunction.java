/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pinot.core.geospatial.transform.function;

import org.apache.pinot.segment.local.utils.GeometryUtils;
import org.locationtech.jts.io.WKTReader;


/**
 * Constructor function for geography object from text.
 */
public class StGeogFromTextFunction extends ConstructFromTextFunction {
  public static final String FUNCTION_NAME = "ST_GeogFromText";

  @Override
  protected WKTReader getWKTReader() {
    return GeometryUtils.GEOGRAPHY_WKT_READER;
  }

  @Override
  public String getName() {
    return FUNCTION_NAME;
  }
}
