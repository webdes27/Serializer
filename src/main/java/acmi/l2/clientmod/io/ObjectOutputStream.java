/*
 * Copyright (c) 2016 acmi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package acmi.l2.clientmod.io;

import java.io.OutputStream;
import java.nio.charset.Charset;

public class ObjectOutputStream<T extends Context> extends DataOutputStream implements ObjectOutput<T> {
    private final SerializerFactory<T> serializerFactory;
    private final T context;

    public ObjectOutputStream(OutputStream out, Charset charset, SerializerFactory<T> serializerFactory, T context) {
        this(out, charset, 0, serializerFactory, context);
    }

    public ObjectOutputStream(OutputStream out, Charset charset, int position, SerializerFactory<T> serializerFactory, T context) {
        super(out, charset, position);
        this.serializerFactory = serializerFactory;
        this.context = context;
    }

    @Override
    public SerializerFactory<T> getSerializerFactory() {
        return serializerFactory;
    }

    @Override
    public T getContext() {
        return context;
    }
}
