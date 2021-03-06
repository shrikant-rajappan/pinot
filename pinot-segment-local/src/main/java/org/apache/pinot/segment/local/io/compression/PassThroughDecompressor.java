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
package org.apache.pinot.segment.local.io.compression;

import java.nio.ByteBuffer;
import org.apache.pinot.segment.spi.compression.ChunkDecompressor;


/**
 * A pass-through implementation of {@link ChunkDecompressor}, that simply returns the input data without
 * performing any de-compression. This is useful for cases where cost of de-compression out-weighs the benefits
 * of compression.
 */
class PassThroughDecompressor implements ChunkDecompressor {

  static final PassThroughDecompressor INSTANCE = new PassThroughDecompressor();

  private PassThroughDecompressor() {
  }

  @Override
  public int decompress(ByteBuffer compressedInput, ByteBuffer decompressedOutput) {
    decompressedOutput.put(compressedInput);

    // Flip the output ByteBuffer for reading.
    decompressedOutput.flip();
    return decompressedOutput.limit();
  }

  @Override
  public int decompressedLength(ByteBuffer compressedInput) {
    return compressedInput.limit();
  }
}
