/*******************************************************************************
 * Copyright (c) 2010 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.commons.ui.actions;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.mylyn.commons.ui.CommonImages;
import org.eclipse.mylyn.internal.commons.ui.Messages;

/**
 * @author Mik Kersten
 * @author Steffen Pingel
 * @since 3.7
 */
public class CollapseAllAction extends Action {

	private final AbstractTreeViewer viewer;

	public CollapseAllAction(AbstractTreeViewer viewer) {
		Assert.isNotNull(viewer);
		this.viewer = viewer;
		setText(Messages.CollapseAllAction_Label);
		setToolTipText(Messages.CollapseAllAction_ToolTip);
		setImageDescriptor(CommonImages.COLLAPSE_ALL);
	}

	@Override
	public void run() {
		viewer.collapseAll();
	}

}
