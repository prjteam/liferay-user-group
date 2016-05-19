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

package com.prjteam.usergroup.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.prjteam.usergroup.model.Product;
import com.prjteam.usergroup.service.base.ProductServiceBaseImpl;

/**
 * The implementation of the product remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.prjteam.usergroup.service.ProductService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductServiceBaseImpl
 * @see com.prjteam.usergroup.service.ProductServiceUtil
 */
@ProviderType
public class ProductServiceImpl extends ProductServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.prjteam.usergroup.service.ProductServiceUtil} to access the product remote service.
	 */
	
	public Product createProduct(String name, ServiceContext serviceContext) throws NoSuchUserException{
		
		return productLocalService.createProduct(name, serviceContext);
		
	}
	
	public Product updateProduct(long productId,String name, ServiceContext serviceContext) throws NoSuchUserException{
		
		return productLocalService.updateProduct(productId,name, serviceContext);
		
	}
	
	public Product deleteProduct(long productId, ServiceContext serviceContext) throws PortalException{
		
		return productLocalService.deleteProduct(productId);
		
	}
	
	public List<Product> getProducts(int start, int end){
		
		return productLocalService.getProducts(start, end);
	}
	
	public int countProducts(){
		
		return productLocalService.countProducts();
	}
	
	
	public Product getProduct(long productId) throws PortalException{
		
		return productLocalService.getProduct(productId);
		
	}
	

	public List<Product> search(String keywords,int start, int end){
		
		
		return productLocalService.search(keywords, start, end);
	}
	
	public long searchCount(String keywords){
		
		
		return productLocalService.searchCount(keywords);
	}
	
}