/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.prjteam.usergroup.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.prjteam.usergroup.service.ProductServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link ProductServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.prjteam.usergroup.model.ProductSoap}.
 * If the method in the service utility returns a
 * {@link com.prjteam.usergroup.model.Product}, that is translated to a
 * {@link com.prjteam.usergroup.model.ProductSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductServiceHttp
 * @see com.prjteam.usergroup.model.ProductSoap
 * @see ProductServiceUtil
 * @generated
 */
@ProviderType
public class ProductServiceSoap {
	public static com.prjteam.usergroup.model.ProductSoap createProduct(
		java.lang.String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.prjteam.usergroup.model.Product returnValue = ProductServiceUtil.createProduct(name,
					serviceContext);

			return com.prjteam.usergroup.model.ProductSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.prjteam.usergroup.model.ProductSoap updateProduct(
		long productId, java.lang.String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.prjteam.usergroup.model.Product returnValue = ProductServiceUtil.updateProduct(productId,
					name, serviceContext);

			return com.prjteam.usergroup.model.ProductSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.prjteam.usergroup.model.ProductSoap deleteProduct(
		long productId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.prjteam.usergroup.model.Product returnValue = ProductServiceUtil.deleteProduct(productId,
					serviceContext);

			return com.prjteam.usergroup.model.ProductSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.prjteam.usergroup.model.ProductSoap[] getProducts(
		int start, int end) throws RemoteException {
		try {
			java.util.List<com.prjteam.usergroup.model.Product> returnValue = ProductServiceUtil.getProducts(start,
					end);

			return com.prjteam.usergroup.model.ProductSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countProducts() throws RemoteException {
		try {
			int returnValue = ProductServiceUtil.countProducts();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.prjteam.usergroup.model.ProductSoap getProduct(
		long productId) throws RemoteException {
		try {
			com.prjteam.usergroup.model.Product returnValue = ProductServiceUtil.getProduct(productId);

			return com.prjteam.usergroup.model.ProductSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.prjteam.usergroup.model.ProductSoap[] search(
		java.lang.String keywords, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.prjteam.usergroup.model.Product> returnValue = ProductServiceUtil.search(keywords,
					start, end);

			return com.prjteam.usergroup.model.ProductSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long searchCount(java.lang.String keywords)
		throws RemoteException {
		try {
			long returnValue = ProductServiceUtil.searchCount(keywords);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ProductServiceSoap.class);
}