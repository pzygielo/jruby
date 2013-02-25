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
 * Copyright (C) 2010, Tim Felgentreff
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
package org.jruby.cext;

import org.jruby.RubyArray;
import org.jruby.RubyModule;
import org.jruby.RubyProc;
import org.jruby.runtime.Block;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

/**
 * A {@link NativeProcMethod} represents native functions that are wrapped in a {@link RubyProc}
 * object. They don't have scoping as normal Procs do and are no closures.
 */
public class NativeProcMethod extends NativeMethod {

    public NativeProcMethod(RubyModule clazz, long function) {
        super(clazz, -1, function);
    }
    
    @Override
    public IRubyObject call(ThreadContext context, IRubyObject recv, RubyModule clazz,
            String name, IRubyObject[] args) {
        pre(context, recv, clazz, name);
        try {
            return getNativeInstance().callProcMethod(function, Handle.nativeHandle(RubyArray.newArray(context.runtime, args)));
        } finally {
            post(context);
        }
    }

    @Override
    public IRubyObject call(ThreadContext context, IRubyObject recv, RubyModule clazz,
            String name, IRubyObject[] args, Block block) {

        pre(context, recv, clazz, name, block);
        try {
            return getNativeInstance().callProcMethod(function, Handle.nativeHandle(RubyArray.newArray(context.runtime, args)));
        } finally {
            post(context);
        }
    }

}
