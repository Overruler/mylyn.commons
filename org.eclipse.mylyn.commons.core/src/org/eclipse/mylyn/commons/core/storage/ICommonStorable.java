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

package org.eclipse.mylyn.commons.core.storage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author Steffen Pingel
 */
public interface ICommonStorable {

	public void delete(String handle) throws CoreException;

	public void deleteAll() throws CoreException;

	public boolean exists(String handle);

	public InputStream read(String handle, IProgressMonitor monitor) throws IOException, CoreException;

	public void release();

	public OutputStream write(String handle, IProgressMonitor monitor) throws IOException, CoreException;

}
