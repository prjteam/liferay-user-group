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

package com.prjteam.usergroup.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.prjteam.usergroup.exception.NoSuchProductException;
import com.prjteam.usergroup.model.Product;

/**
 * The persistence interface for the product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.prjteam.usergroup.service.persistence.impl.ProductPersistenceImpl
 * @see ProductUtil
 * @generated
 */
@ProviderType
public interface ProductPersistence extends BasePersistence<Product> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductUtil} to access the product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the products where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching products
	*/
	public java.util.List<Product> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the products where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of matching products
	*/
	public java.util.List<Product> findByUuid(java.lang.String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the products where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching products
	*/
	public java.util.List<Product> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator);

	/**
	* Returns an ordered range of all the products where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching products
	*/
	public java.util.List<Product> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first product in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product
	* @throws NoSuchProductException if a matching product could not be found
	*/
	public Product findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator)
		throws NoSuchProductException;

	/**
	* Returns the first product in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product, or <code>null</code> if a matching product could not be found
	*/
	public Product fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator);

	/**
	* Returns the last product in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product
	* @throws NoSuchProductException if a matching product could not be found
	*/
	public Product findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator)
		throws NoSuchProductException;

	/**
	* Returns the last product in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product, or <code>null</code> if a matching product could not be found
	*/
	public Product fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator);

	/**
	* Returns the products before and after the current product in the ordered set where uuid = &#63;.
	*
	* @param productId the primary key of the current product
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product
	* @throws NoSuchProductException if a product with the primary key could not be found
	*/
	public Product[] findByUuid_PrevAndNext(long productId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator)
		throws NoSuchProductException;

	/**
	* Removes all the products where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of products where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching products
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the product where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchProductException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching product
	* @throws NoSuchProductException if a matching product could not be found
	*/
	public Product findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchProductException;

	/**
	* Returns the product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching product, or <code>null</code> if a matching product could not be found
	*/
	public Product fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching product, or <code>null</code> if a matching product could not be found
	*/
	public Product fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the product where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the product that was removed
	*/
	public Product removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchProductException;

	/**
	* Returns the number of products where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching products
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the products where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching products
	*/
	public java.util.List<Product> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the products where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of matching products
	*/
	public java.util.List<Product> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the products where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching products
	*/
	public java.util.List<Product> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator);

	/**
	* Returns an ordered range of all the products where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching products
	*/
	public java.util.List<Product> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first product in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product
	* @throws NoSuchProductException if a matching product could not be found
	*/
	public Product findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator)
		throws NoSuchProductException;

	/**
	* Returns the first product in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product, or <code>null</code> if a matching product could not be found
	*/
	public Product fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator);

	/**
	* Returns the last product in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product
	* @throws NoSuchProductException if a matching product could not be found
	*/
	public Product findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator)
		throws NoSuchProductException;

	/**
	* Returns the last product in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product, or <code>null</code> if a matching product could not be found
	*/
	public Product fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator);

	/**
	* Returns the products before and after the current product in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param productId the primary key of the current product
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product
	* @throws NoSuchProductException if a product with the primary key could not be found
	*/
	public Product[] findByUuid_C_PrevAndNext(long productId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator)
		throws NoSuchProductException;

	/**
	* Removes all the products where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of products where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching products
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Caches the product in the entity cache if it is enabled.
	*
	* @param product the product
	*/
	public void cacheResult(Product product);

	/**
	* Caches the products in the entity cache if it is enabled.
	*
	* @param products the products
	*/
	public void cacheResult(java.util.List<Product> products);

	/**
	* Creates a new product with the primary key. Does not add the product to the database.
	*
	* @param productId the primary key for the new product
	* @return the new product
	*/
	public Product create(long productId);

	/**
	* Removes the product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productId the primary key of the product
	* @return the product that was removed
	* @throws NoSuchProductException if a product with the primary key could not be found
	*/
	public Product remove(long productId) throws NoSuchProductException;

	public Product updateImpl(Product product);

	/**
	* Returns the product with the primary key or throws a {@link NoSuchProductException} if it could not be found.
	*
	* @param productId the primary key of the product
	* @return the product
	* @throws NoSuchProductException if a product with the primary key could not be found
	*/
	public Product findByPrimaryKey(long productId)
		throws NoSuchProductException;

	/**
	* Returns the product with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param productId the primary key of the product
	* @return the product, or <code>null</code> if a product with the primary key could not be found
	*/
	public Product fetchByPrimaryKey(long productId);

	@Override
	public java.util.Map<java.io.Serializable, Product> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the products.
	*
	* @return the products
	*/
	public java.util.List<Product> findAll();

	/**
	* Returns a range of all the products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of products
	*/
	public java.util.List<Product> findAll(int start, int end);

	/**
	* Returns an ordered range of all the products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of products
	*/
	public java.util.List<Product> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator);

	/**
	* Returns an ordered range of all the products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of products
	*/
	public java.util.List<Product> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the products from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of products.
	*
	* @return the number of products
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}