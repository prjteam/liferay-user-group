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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.prjteam.usergroup.service.ProductServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link ProductServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductServiceSoap
 * @see HttpPrincipal
 * @see ProductServiceUtil
 * @generated
 */
@ProviderType
public class ProductServiceHttp {
	public static com.prjteam.usergroup.model.Product createProduct(
		HttpPrincipal httpPrincipal, java.lang.String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"createProduct", _createProductParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, name,
					serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.NoSuchUserException) {
					throw (com.liferay.portal.kernel.exception.NoSuchUserException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.prjteam.usergroup.model.Product)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.prjteam.usergroup.model.Product updateProduct(
		HttpPrincipal httpPrincipal, long productId, java.lang.String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"updateProduct", _updateProductParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					productId, name, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.NoSuchUserException) {
					throw (com.liferay.portal.kernel.exception.NoSuchUserException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.prjteam.usergroup.model.Product)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.prjteam.usergroup.model.Product deleteProduct(
		HttpPrincipal httpPrincipal, long productId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"deleteProduct", _deleteProductParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					productId, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.prjteam.usergroup.model.Product)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.prjteam.usergroup.model.Product> getProducts(
		HttpPrincipal httpPrincipal, int start, int end) {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"getProducts", _getProductsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, start,
					end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.prjteam.usergroup.model.Product>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int countProducts(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"countProducts", _countProductsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.prjteam.usergroup.model.Product getProduct(
		HttpPrincipal httpPrincipal, long productId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"getProduct", _getProductParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, productId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.prjteam.usergroup.model.Product)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.prjteam.usergroup.model.Product> search(
		HttpPrincipal httpPrincipal, java.lang.String keywords, int start,
		int end) {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"search", _searchParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					keywords, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.prjteam.usergroup.model.Product>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static long searchCount(HttpPrincipal httpPrincipal,
		java.lang.String keywords) {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"searchCount", _searchCountParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ProductServiceHttp.class);
	private static final Class<?>[] _createProductParameterTypes0 = new Class[] {
			java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateProductParameterTypes1 = new Class[] {
			long.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteProductParameterTypes2 = new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getProductsParameterTypes3 = new Class[] {
			int.class, int.class
		};
	private static final Class<?>[] _countProductsParameterTypes4 = new Class[] {  };
	private static final Class<?>[] _getProductParameterTypes5 = new Class[] {
			long.class
		};
	private static final Class<?>[] _searchParameterTypes6 = new Class[] {
			java.lang.String.class, int.class, int.class
		};
	private static final Class<?>[] _searchCountParameterTypes7 = new Class[] {
			java.lang.String.class
		};
}