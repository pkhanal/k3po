/*
 * Copyright 2014, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaazing.specification.ws.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.kaazing.k3po.lang.internal.el.ExpressionFactoryUtils.newExpressionFactory;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import org.junit.Before;
import org.junit.Test;
import org.kaazing.k3po.lang.internal.el.ExpressionContext;

public class FunctionsTest {

    private ExpressionFactory factory;
    private ELContext ctx;

    @Before
    public void setUp() throws Exception {

        factory = newExpressionFactory();
        ctx = new ExpressionContext();
    }

    @Test
    public void shouldComputeHandshakeHash() throws Exception {

        String expressionText = "${ws:handshakeHash('dGhlIHNhbXBsZSBub25jZQ==')}";
        ValueExpression expression = factory.createValueExpression(ctx, expressionText, String.class);
        String computedHash = (String) expression.getValue(ctx);

        assertEquals("Inconsistent handshake hash", "s3pPLMBiTxaQ9kYGzzhZRbK+xOo=", computedHash);
    }

    @Test
    public void shouldRandomizeString() {
        String orig = "changeMyCase";
        String result;
        do {
            result = Functions.randomizeLetterCase(orig);
        } while (result.equals(orig));
        assertTrue(result.equalsIgnoreCase(orig));
    }
}
