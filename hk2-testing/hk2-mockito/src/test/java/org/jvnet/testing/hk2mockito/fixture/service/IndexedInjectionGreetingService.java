/*
 * Copyright (c) 2014, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.jvnet.testing.hk2mockito.fixture.service;

import jakarta.inject.Inject;
import org.jvnet.hk2.annotations.Service;
import org.jvnet.testing.hk2mockito.fixture.BasicGreetingService;

/**
 *
 * @author Sharmarke Aden
 */
@Service
public class IndexedInjectionGreetingService {

    private final BasicGreetingService collaborator1;
    private final BasicGreetingService collaborator2;

    @Inject
    IndexedInjectionGreetingService(BasicGreetingService collaborator1,
            BasicGreetingService collaborator2) {
        this.collaborator1 = collaborator1;
        this.collaborator2 = collaborator2;
    }

    public String greet() {
        return collaborator1.greet() + collaborator2.greet();
    }

}
