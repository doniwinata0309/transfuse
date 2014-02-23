/**
 * Copyright 2013 John Ericksen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.androidtransfuse.gen.componentBuilder;

import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpression;
import org.androidtransfuse.adapter.ASTMethod;
import org.androidtransfuse.adapter.ASTStringType;
import org.androidtransfuse.gen.InvocationBuilder;
import org.androidtransfuse.model.TypedExpression;

import javax.inject.Inject;
import java.util.Collections;

/**
 * @author John Ericksen
 */
public class ActivityMethodDelegateASTReference implements ActivityDelegateASTReference {

    private final ASTMethod method;
    private final InvocationBuilder invocationBuilder;

    @Inject
    public ActivityMethodDelegateASTReference(/*@Assisted*/ ASTMethod method, InvocationBuilder invocationBuilder) {
        this.method = method;
        this.invocationBuilder = invocationBuilder;
    }

    @Override
    public JExpression buildReference(JDefinedClass definedClass, TypedExpression rootExpression) {
        return invocationBuilder.buildMethodCall(
                new ASTStringType(definedClass.name()),
                method,
                Collections.EMPTY_LIST,
                rootExpression);
    }
}
