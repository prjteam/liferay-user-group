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

package com.prjteam.usergroup.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Product. This utility wraps
 * {@link com.prjteam.usergroup.service.impl.ProductServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ProductService
 * @see com.prjteam.usergroup.service.base.ProductServiceBaseImpl
 * @see com.prjteam.usergroup.service.impl.ProductServiceImpl
 * @generated
 */
@ProviderType
public class ProductServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.prjteam.usergroup.service.impl.ProductServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.prjteam.usergroup.model.Product createProduct(
		java.lang.String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException {
		return getService().createProduct(name, serviceContext);
	}

	public static com.prjteam.usergroup.model.Product deleteProduct(
		long productId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteProduct(productId, serviceContext);
	}

	public static com.prjteam.usergroup.model.Product getProduct(long productId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getProduct(productId);
	}

	public static com.prjteam.usergroup.model.Product updateProduct(
		long productId, java.lang.String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException {
		return getService().updateProduct(productId, name, serviceContext);
	}

	public static int countProducts() {
		return getService().countProducts();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.prjteam.usergroup.model.Product> getProducts(
		int start, int end) {
		return getService().getProducts(start, end);
	}

	public static java.util.List<com.prjteam.usergroup.model.Product> search(
		java.lang.String keywords, int start, int end) {
		return getService().search(keywords, start, end);
	}

	public static long searchCount(java.lang.String keywords) {
		return getService().searchCount(keywords);
	}

	public static ProductService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProductService, ProductService> _serviceTracker =
		ServiceTrackerFactory.open(ProductService.class);
}