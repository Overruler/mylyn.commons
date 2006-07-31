/*******************************************************************************
 * Copyright (c) 2004 - 2006 University Of British Columbia and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     University Of British Columbia - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylar.monitor.workbench;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author Mik Kersten
 */
public abstract class AbstractEditorTracker extends AbstractPartTracker {

	public void partClosed(IWorkbenchPart part) {
		if (part instanceof IEditorPart) {
			editorClosed((IEditorPart) part);
		}
	}

	public void partOpened(IWorkbenchPart part) {
		if (part instanceof IEditorPart) {
			editorOpened((IEditorPart) part);
		}
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
		if (part instanceof IEditorPart) {
			editorBroughtToTop((IEditorPart) part);
		}
	}

	protected abstract void editorOpened(IEditorPart part);

	protected abstract void editorClosed(IEditorPart part);

	protected abstract void editorBroughtToTop(IEditorPart part);
	
	@Override
	public void partActivated(IWorkbenchPart part) {
		// ignore
	}

	public void partDeactivated(IWorkbenchPart part) {
	}

}