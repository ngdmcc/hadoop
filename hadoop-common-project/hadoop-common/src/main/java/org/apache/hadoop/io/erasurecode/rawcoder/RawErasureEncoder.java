/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.io.erasurecode.rawcoder;

import org.apache.hadoop.io.erasurecode.ECChunk;

import java.nio.ByteBuffer;

/**
 * RawErasureEncoder performs encoding given chunks of input data and generates
 * parity outputs that corresponds to an erasure code scheme, like XOR and
 * Reed-Solomon.
 *
 * It extends the {@link RawErasureCoder} interface.
 */
public interface RawErasureEncoder extends RawErasureCoder {

  /**
   * Encode with inputs and generates outputs.
   *
   * Note, for both inputs and outputs, no mixing of on-heap buffers and direct
   * buffers are allowed.
   *
   * @param inputs inputs to read data from, contents may change after the call
   * @param outputs
   */
  public void encode(ByteBuffer[] inputs, ByteBuffer[] outputs);

  /**
   * Encode with inputs and generates outputs
   * @param inputs inputs to read data from, contents may change after the call
   * @param outputs outputs to write into for data generated, ready for reading
   *                the result data from after the call
   */
  public void encode(byte[][] inputs, byte[][] outputs);

  /**
   * Encode with inputs and generates outputs.
   *
   * Note, for both input and output ECChunks, no mixing of on-heap buffers and
   * direct buffers are allowed.
   *
   * @param inputs inputs to read data from, contents may change after the call
   * @param outputs outputs to write into for data generated, ready for reading
   *                the result data from after the call
   */
  public void encode(ECChunk[] inputs, ECChunk[] outputs);

}
