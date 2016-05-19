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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductService
 * @generated
 */
@ProviderType
public class ProductServiceWrapper implements ProductService,
	ServiceWrapper<ProductService> {
	public ProductServiceWrapper(ProductService productService) {
		_productService = productService;
	}

	@Override
	public com.prjteam.usergroup.model.Product createProduct(
		java.lang.String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException {
		return _productService.createProduct(name, serviceContext);
	}

	@Override
	public com.prjteam.usergroup.model.Product deleteProduct(long productId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _productService.deleteProduct(productId, serviceContext);
	}

	@Override
	public com.prjteam.usergroup.model.Product getProduct(long productId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _productService.getProduct(productId);
	}

	@Override
	public com.prjteam.usergroup.model.Product updateProduct(long productId,
		java.lang.String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException {
		return _productService.updateProduct(productId, name, serviceContext);
	}

	@Override
	public int countProducts() {
		return _productService.countProducts();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _productService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.prjteam.usergroup.model.Product> getProducts(
		int start, int end) {
		return _productService.getProducts(start, end);
	}

	@Override
	public java.util.List<com.prjteam.usergroup.model.Product> search(
		java.lang.String keywords, int start, int end) {
		return _productService.search(keywords, start, end);
	}

	@Override
	public long searchCount(java.lang.String keywords) {
		return _productService.searchCount(keywords);
	}

	@Override
	public ProductService getWrappedService() {
		return _productService;
	}

	@Override
	public void setWrappedService(ProductService productService) {
		_productService = productService;
	}

	private ProductService _productService;
}