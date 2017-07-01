/*
 * Copyright (c) 2017 D3adspace
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.d3adspace.seraphim.protocol.packet;

import de.d3adspace.seraphim.protocol.SeraphimPacket;
import de.d3adspace.skylla.commons.buffer.SkyllaBuffer;
import de.d3adspace.skylla.commons.protocol.packet.SkyllaPacketMeta;

/**
 * @author Felix 'SasukeKawaii' Klauke
 */
@SkyllaPacketMeta(id = 4)
public class PacketInGetResponse extends SeraphimPacket {
	
	private int callbackId;
	private Object value;
	
	public PacketInGetResponse(int callbackId, Object value) {
		this.callbackId = callbackId;
		this.value = value;
	}
	
	public PacketInGetResponse() {
	}
	
	public Object getValue() {
		return value;
	}
	
	public int getCallbackId() {
		return callbackId;
	}
	
	@Override
	public void write(SkyllaBuffer skyllaBuffer) {
		skyllaBuffer.writeInt(callbackId);
		getMapping().write(skyllaBuffer, value);
	}
	
	@Override
	public void read(SkyllaBuffer skyllaBuffer) {
		callbackId = skyllaBuffer.readInt();
		value = getMapping().read(skyllaBuffer);
	}
	
	@Override
	public String toString() {
		return "PacketInGetResponse{" +
			"callbackId=" + callbackId +
			", value=" + value +
			'}';
	}
}