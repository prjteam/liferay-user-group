<%--
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
--%>

<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="../init.jsp" %>


<%
PortletURL myportletURL = (PortletURL)request.getAttribute("portletURL");
List<Product> products = (List<Product>)request.getAttribute("products");
String itemSelectedEventName = (String)request.getAttribute("itemSelectedEventName");

%>

<div id="<portlet:namespace />productsImageSelectorWrapper">

	<liferay-ui:search-container
		emptyResultsMessage="there-are-no-products"
		iteratorURL="<%= myportletURL %>"
		total="<%= GetterUtil.getInteger(request.getAttribute("total")) %>"
	>
		<liferay-ui:search-container-results
			results="<%= products %>"
		/>

		<liferay-ui:search-container-row
			className="com.prjteam.usergroup.model.Product"
			modelVar="product" cssClass="product-row" 
		>
			
			
			
			<liferay-ui:search-container-column-text>
				
				<%
				long productPlid = PortalUtil.getPlidFromPortletId(product.getGroupId(),"com_prjteam_usergroup_ProductPortlet");

				
				
				
				//themeDisplay.getURLHome()+layout.getFriendlyURL()+"/-/56/"+article.getGroupId()+"/"+article.getArticleId()
				
				
				%>
			
				
				
				<div class="product-name"
					data-id="<%= product.getProductId() %>"
					data-plid="<%= productPlid %>"
					 data-title="<%= product.getName() %>" >
					<%= product.getName() %>
				</div>
			</liferay-ui:search-container-column-text>
			
			
			
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator  />

		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>"   />
	</liferay-ui:search-container>
</div>

<aui:script use="product-item-selector">
	new Liferay.ProductItemSelector(
		{
			closeCaption: 'product',
			namespace: '<portlet:namespace/>',
			on: {
				selectedItem: function(event) {
					Liferay.Util.getOpener().Liferay.fire('<%= itemSelectedEventName %>', event);
				}
			}
		}
	);
</aui:script>