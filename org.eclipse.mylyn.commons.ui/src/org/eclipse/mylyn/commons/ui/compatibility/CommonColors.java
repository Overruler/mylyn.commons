/*******************************************************************************
 * Copyright (c) 2004, 2010 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.commons.ui.compatibility;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * Provides common colors. Class must be referenced from the SWT UI thread only.
 * <p>
 * NOTE: Use of this class is discouraged. Colors are not theme dependent.
 * </p>
 * 
 * @author Mik Kersten
 * @since 3.7
 */
public class CommonColors {

	public static final Color HYPERLINK_WIDGET = new Color(Display.getDefault(), 12, 81, 172);

	public static final Color TEXT_QUOTED = new Color(Display.getDefault(), 38, 86, 145);

	/**
	 * NOTE: disposal of JFaceResources fonts handled by registry.
	 */
	public static void dispose() {
		HYPERLINK_WIDGET.dispose();
		TEXT_QUOTED.dispose();
	}

}
