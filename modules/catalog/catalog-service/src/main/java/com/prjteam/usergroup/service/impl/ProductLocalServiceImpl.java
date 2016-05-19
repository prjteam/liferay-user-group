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
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.prjteam.usergroup.model.Product;
import com.prjteam.usergroup.service.base.ProductLocalServiceBaseImpl;

/**
 * The implementation of the product local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.prjteam.usergroup.service.ProductLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductLocalServiceBaseImpl
 * @see com.prjteam.usergroup.service.ProductLocalServiceUtil
 */
@ProviderType
public class ProductLocalServiceImpl extends ProductLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.prjteam.usergroup.service.ProductLocalServiceUtil} to access the product local service.
	 */
	public Product createProduct(String name, ServiceContext serviceContext) throws NoSuchUserException{
		long resourcePrimKey = counterLocalService.increment(Product.class.getName());
		
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		
		long groupId = serviceContext.getScopeGroupId();
		
		long entryId = counterLocalService.increment();
		
		Product product = createProduct(entryId);
		
		product.setGroupId(groupId);
		product.setCompanyId(user.getCompanyId());
		product.setUserId(user.getUserId());
		product.setUserName(user.getFullName());
		
		product.setName(name);
		
		product.setExpandoBridgeAttributes(serviceContext);
		
		return updateProduct(product);
		
		
	}
	
	public Product updateProduct(long productId,String name, ServiceContext serviceContext) throws NoSuchUserException{
		
		Product product = productPersistence.fetchByPrimaryKey(productId);
		
		product.setName(name);
		
		product.setExpandoBridgeAttributes(serviceContext);
		
		return updateProduct(product);
		
	}
	
	public DynamicQuery getDynamicQuery(String keywords){
		
		DynamicQuery dynamicQuery = dynamicQuery();
		
		
		dynamicQuery.add(PropertyFactoryUtil.forName("name").like("%"+keywords +"%"));
		
		return dynamicQuery;
	}
	
	public List<Product> search(String keywords,int start, int end){
		
		DynamicQuery dynamicQuery = getDynamicQuery(keywords);
		
		return productPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}
	
	public long searchCount(String keywords){
		
		DynamicQuery dynamicQuery = getDynamicQuery(keywords);
		
		return productPersistence.countWithDynamicQuery(dynamicQuery);
	}
	
	public List<Product> getProducts(int start, int end){
		
		return productPersistence.findAll(start, end);
	}
	
	public int countProducts(){
		
		return productPersistence.countAll();
	}
	
	public Product getProduct(long productId){
		
		return productPersistence.fetchByPrimaryKey(productId);
		
	}
}