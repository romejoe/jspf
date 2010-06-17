/*
 * CacheEntry.java
 * 
 * Copyright (c) 2010, Ralf Biedert All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer. Redistributions in binary form must reproduce the
 * above copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of the author nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 */
package net.xeoh.plugins.cache.impl.functioncache.v1;

import java.lang.reflect.Method;

/**
 * @author rb
 *
 */
public class CacheEntry {

    /** */
    private final Method method;

    /** */
    private final Object[] args;

    /** */
    private final Object result;

    /**
     * @param method
     * @param args
     * @param result 
     */
    public CacheEntry(Method method, Object[] args, Object result) {
        this.method = method;
        this.args = args == null ? new Object[0] : args;

        this.result = result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CacheEntry)) return false;

        CacheEntry cc = (CacheEntry) obj;

        if (!this.method.equals(cc.method)) return false;
        if (this.args.length != cc.args.length) return false;

        for (int i = 0; i < this.args.length; i++) {
            if (!this.args[i].equals(cc.args[i])) return false;
        }

        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return this.method.hashCode() + this.args.length;
    }

    /**
     * @return the method
     */
    public Method getMethod() {
        return this.method;
    }

    /**
     * @return the args
     */
    public Object[] getArgs() {
        return this.args;
    }

    /**
     * @return the result
     */
    public Object getResult() {
        return this.result;
    }
}