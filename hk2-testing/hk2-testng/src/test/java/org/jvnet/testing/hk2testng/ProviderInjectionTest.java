/*
 * Copyright (c) 2013, 2018 Oracle and/or its affiliates. All rights reserved.
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

package org.jvnet.testing.hk2testng;

import org.jvnet.testing.hk2testng.service.PrimaryService;
import jakarta.inject.Inject;
import jakarta.inject.Provider;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author saden
 */
@HK2
public class ProviderInjectionTest {

    @Inject
    Provider<PrimaryService> primaryServiceProvider;

    @Test
    public void assertPrimaryServiceInjecton() {
        assertThat(primaryServiceProvider).isNotNull();
    }

    @Test
    public void assertSecondaryService() {
        PrimaryService primaryService = primaryServiceProvider.get();
        assertThat(primaryService).isNotNull();
        assertThat(primaryService.getSecondaryService()).isNotNull();
    }
}
