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

package com.prjteam.usergroup.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Product service. Represents a row in the &quot;CATALOG_Product&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProductModel
 * @see com.prjteam.usergroup.model.impl.ProductImpl
 * @see com.prjteam.usergroup.model.impl.ProductModelImpl
 * @generated
 */
@ImplementationClassName("com.prjteam.usergroup.model.impl.ProductImpl")
@ProviderType
public interface Product extends ProductModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.prjteam.usergroup.model.impl.ProductImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Product, Long> PRODUCT_ID_ACCESSOR = new Accessor<Product, Long>() {
			@Override
			public Long get(Product product) {
				return product.getProductId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Product> getTypeClass() {
				return Product.class;
			}
		};
}