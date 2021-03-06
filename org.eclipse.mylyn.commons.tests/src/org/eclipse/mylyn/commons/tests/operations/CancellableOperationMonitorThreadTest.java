/*******************************************************************************
 * Copyright (c) 2013 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.commons.tests.operations;

import junit.framework.TestCase;

import org.eclipse.mylyn.commons.core.operations.CancellableOperationMonitorThread;
import org.eclipse.mylyn.commons.core.operations.ICancellableOperation;
import org.junit.Test;

/**
 * @author Steffen Pingel
 */
public class CancellableOperationMonitorThreadTest extends TestCase {

	private CancellableOperationMonitorThread thread;

	class MockOperation implements ICancellableOperation {

		boolean canceled;

		boolean aborted;

		@Override
		public void abort() {
			aborted = true;
		}

		@Override
		public boolean isCanceled() {
			return canceled;
		}

	}

	@Override
	protected void setUp() throws Exception {
		thread = new CancellableOperationMonitorThread();
	}

	@Override
	protected void tearDown() throws Exception {
		thread.shutdown();
	}

	@Test
	public void testShutdownAddOperation() throws InterruptedException {
		thread.shutdown();
		try {
			thread.addOperation(new MockOperation());
			fail("Expected IllegalStateException");
		} catch (IllegalStateException expected) {
		}
	}

	@Test
	public void testShutdownProcessOnce() throws InterruptedException {
		thread.shutdown();
		try {
			thread.processOperations();
			fail("Expected IllegalStateException");
		} catch (IllegalStateException expected) {
		}
	}

	@Test
	public void testShutdownRemoveOperation() throws InterruptedException {
		thread.shutdown();
		try {
			thread.removeOperation(new MockOperation());
			fail("Expected IllegalStateException");
		} catch (IllegalStateException expected) {
		}
	}

	@Test
	public void testShutdownStart() throws InterruptedException {
		thread.shutdown();
		try {
			thread.start();
			fail("Expected IllegalStateException");
		} catch (IllegalStateException expected) {
		}
	}

	@Test
	public void testShutdownTwice() throws InterruptedException {
		thread.start();
		assertTrue(thread.isAlive());
		thread.shutdown();
		assertFalse(thread.isAlive());
		thread.shutdown();
		assertFalse(thread.isAlive());
	}

	@Test
	public void testShutdown() throws Exception {
		assertFalse(thread.isAlive());
		thread.start();
		assertTrue(thread.isAlive());
		thread.shutdown();
		assertFalse(thread.isAlive());
	}

	@Test
	public void testShutdownNotStarted() throws Exception {
		assertFalse(thread.isAlive());
		thread.shutdown();
		assertFalse(thread.isAlive());
	}

	public void testNotCancelOperation() throws Exception {
		MockOperation operation = new MockOperation();
		thread.addOperation(operation);
		assertFalse(operation.aborted);
		thread.processOperations();
		assertFalse(operation.aborted);
	}

	public void testCancelOperation() throws Exception {
		MockOperation operation = new MockOperation();
		thread.addOperation(operation);
		assertFalse(operation.aborted);
		operation.canceled = true;
		thread.processOperations();
		assertTrue(operation.aborted);
	}

	public void testAddRemoveOperation() throws Exception {
		MockOperation operation = new MockOperation();
		thread.addOperation(operation);
		assertTrue(thread.isAlive());
		thread.removeOperation(operation);
		assertTrue(thread.isAlive());
		operation.canceled = true;
		try {
			thread.processOperations();
		} catch (IllegalStateException expected) {
		}
		assertFalse(operation.aborted);
	}

}
