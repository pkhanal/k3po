/*
 * Copyright (c) 2014 "Kaazing Corporation," (www.kaazing.com)
 *
 * This file is part of Robot.
 *
 * Robot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.kaazing.k3po.lang.el;

import java.lang.reflect.Method;

import javax.el.FunctionMapper;
import javax.el.ValueExpression;
import javax.el.VariableMapper;

import de.odysseus.el.util.SimpleContext;

public class ExpressionContext extends SimpleContext {

    protected FunctionMapper functionMapper;
    protected VariableMapper variableMapper;

    public ExpressionContext() {
        super();
        this.functionMapper = org.kaazing.k3po.lang.el.FunctionMapper.newFunctionMapper();
        this.variableMapper = new org.kaazing.k3po.lang.el.VariableMapper();
    }

    @Override
    public FunctionMapper getFunctionMapper() {
        return functionMapper;
    }

    @Override
    public VariableMapper getVariableMapper() {
        return variableMapper;
    }

    @Override
    public void setFunction(String prefix, String localName, Method method) {
        throw new IllegalArgumentException("setFunction not supported");
    }

    @Override
    public ValueExpression setVariable(String name, ValueExpression expr) {
        return variableMapper.setVariable(name, expr);
    }
}