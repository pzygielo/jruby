/***** BEGIN LICENSE BLOCK *****
 * Version: EPL 1.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Common Public
 * License Version 1.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.eclipse.org/legal/cpl-v10.html
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 *
 * Copyright (C) 2002-2004 Jan Arne Petersen <jpetersen@uni-bonn.de>
 * Copyright (C) 2004-2005 Thomas E Enebo <enebo@acm.org>
 * 
 * Alternatively, the contents of this file may be used under the terms of
 * either of the GNU General Public License Version 2 or later (the "GPL"),
 * or the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the EPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the EPL, the GPL or the LGPL.
 ***** END LICENSE BLOCK *****/
package org.jruby.internal.runtime.methods;

import org.jruby.RubyModule;
import org.jruby.runtime.Block;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.Visibility;
import org.jruby.runtime.builtin.IRubyObject;

/**
 * 
 * @author jpetersen
 */
public class WrapperMethod extends DynamicMethod {
    private DynamicMethod method;

    /**
     * Constructor for WrapperCallable.
     * @param visibility
     */
    public WrapperMethod(RubyModule implementationClass, DynamicMethod method, Visibility visibility) {
        super(implementationClass, visibility, null);
        this.method = method;
    }
    
    public IRubyObject call(ThreadContext context, IRubyObject self, RubyModule klazz, String name) {
        return method.call(context, self, klazz, name);
    }
    
    public IRubyObject call(ThreadContext context, IRubyObject self, RubyModule klazz, String name, IRubyObject arg) {
        return method.call(context, self, klazz, name, arg);
    }
    
    public IRubyObject call(ThreadContext context, IRubyObject self, RubyModule klazz, String name, IRubyObject arg1, IRubyObject arg2) {
        return method.call(context, self, klazz, name, arg1, arg2);
    }
    
    public IRubyObject call(ThreadContext context, IRubyObject self, RubyModule klazz, String name, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3) {
        return method.call(context, self, klazz, name, arg1, arg2, arg3);
    }
    
    public IRubyObject call(ThreadContext context, IRubyObject self, RubyModule klazz, String name, IRubyObject[] args) {
        return method.call(context, self, klazz, name, args);
    }
    
    public IRubyObject call(ThreadContext context, IRubyObject self, RubyModule klazz, String name, Block block) {
        return method.call(context, self, klazz, name, block);
    }
    
    public IRubyObject call(ThreadContext context, IRubyObject self, RubyModule klazz, String name, IRubyObject arg1, Block block) {
        return method.call(context, self, klazz, name, arg1, block);
    }
    
    public IRubyObject call(ThreadContext context, IRubyObject self, RubyModule klazz, String name, IRubyObject arg1, IRubyObject arg2, Block block) {
        return method.call(context, self, klazz, name, arg1, arg2, block);
    }
    
    public IRubyObject call(ThreadContext context, IRubyObject self, RubyModule klazz, String name, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, Block block) {
        return method.call(context, self, klazz, name, arg1, arg2, arg3, block);
    }
    
    public IRubyObject call(ThreadContext context, IRubyObject self, RubyModule klazz, String name, IRubyObject[] args, Block block) {
        return method.call(context, self, klazz, name, args, block);
    }
    
    public DynamicMethod dup() {
        return new WrapperMethod(getImplementationClass(), method, getVisibility());
    }

    public long getSerialNumber() {
        return method.getSerialNumber();
    }
    
    public DynamicMethod getRealMethod() {
        return method;
    }
}
