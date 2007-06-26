/*******************************************************************************
 * Copyright (c) 2004, 2007 Mylyn project committers and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.mylyn.monitor.ui;

import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Monitors interaction with workbench parts.
 * 
 * @author Mik Kersten
 * @since 2.0
 */
public abstract class AbstractPartTracker implements IPartListener {

	public void install(IWorkbench workbench) {
		MonitorUiPlugin.getDefault().addWindowPartListener(this);
	}

	public void dispose(IWorkbench workbench) {
		MonitorUiPlugin.getDefault().removeWindowPartListener(this);
	}

	public abstract void partActivated(IWorkbenchPart part);

	public abstract void partBroughtToTop(IWorkbenchPart part);

	public abstract void partClosed(IWorkbenchPart part);

	public abstract void partDeactivated(IWorkbenchPart part);

	public abstract void partOpened(IWorkbenchPart part);

}