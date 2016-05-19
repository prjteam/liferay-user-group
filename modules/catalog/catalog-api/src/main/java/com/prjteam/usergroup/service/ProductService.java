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

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.prjteam.usergroup.model.Product;

import java.util.List;

/**
 * Provides the remote service interface for Product. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ProductServiceUtil
 * @see com.prjteam.usergroup.service.base.ProductServiceBaseImpl
 * @see com.prjteam.usergroup.service.impl.ProductServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=catalog", "json.web.service.context.path=Product"}, service = ProductService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ProductService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductServiceUtil} to access the product remote service. Add custom service methods to {@link com.prjteam.usergroup.service.impl.ProductServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Product createProduct(java.lang.String name,
		ServiceContext serviceContext) throws NoSuchUserException;

	public Product deleteProduct(long productId, ServiceContext serviceContext)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Product getProduct(long productId) throws PortalException;

	public Product updateProduct(long productId, java.lang.String name,
		ServiceContext serviceContext) throws NoSuchUserException;

	public int countProducts();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Product> getProducts(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Product> search(java.lang.String keywords, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long searchCount(java.lang.String keywords);
}