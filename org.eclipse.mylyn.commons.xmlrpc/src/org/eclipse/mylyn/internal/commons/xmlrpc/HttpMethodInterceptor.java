/*******************************************************************************
 * Copyright (c) 2006, 2010 Steffen Pingel and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Steffen Pingel - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.internal.commons.xmlrpc;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClientException;

/**
 * @author Steffen Pingel
 */
interface HttpMethodInterceptor {

	public abstract void processRequest(HttpMethod method) throws XmlRpcClientException;

	public abstract void processResponse(HttpMethod method) throws XmlRpcException;

}
