/*******************************************************************************
 * Copyright (c) 2012 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.commons.repositories.tests.core;

import static org.junit.Assert.assertEquals;

import org.eclipse.mylyn.commons.repositories.core.auth.CertificateCredentials;
import org.junit.Test;

/**
 * @author Steffen Pingel
 */
public class CertificateCredentialsTest {

	@Test
	public void testConstructor() {
		CertificateCredentials credentials = new CertificateCredentials("filename", "password", "type");
		assertEquals("filename", credentials.getKeyStoreFileName());
		assertEquals("password", credentials.getPassword());
		assertEquals("type", credentials.getKeyStoreType());
		assertEquals(true, credentials.getSavePassword());
	}

	@Test
	public void testConstructorSavePassword() {
		CertificateCredentials credentials = new CertificateCredentials("filename", "password", "type", false);
		assertEquals("filename", credentials.getKeyStoreFileName());
		assertEquals("password", credentials.getPassword());
		assertEquals("type", credentials.getKeyStoreType());
		assertEquals(false, credentials.getSavePassword());
	}

}