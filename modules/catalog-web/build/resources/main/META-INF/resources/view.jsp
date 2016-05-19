<%@ include file="./init.jsp" %>


	<aui:button-row>
		<portlet:renderURL var="editProductURL">
			<portlet:param name="mvcPath" value="/edit_product.jsp" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</portlet:renderURL>
	
		<aui:button href="<%= editProductURL %>" value="add-product" />
	</aui:button-row>
	
	

	<liferay-ui:search-container
		total="<%=   productService.countProducts()  %>" >
	
	<liferay-ui:search-container-results
		results="<%= productService.getProducts(searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>

	<liferay-ui:search-container-row
		className="com.prjteam.usergroup.model.Product"
		escapedModel="true"
		modelVar="product"
	>
			<liferay-ui:search-container-column-text
				name="id"
				property="productId"
				valign="top"
			/>
	
			<portlet:renderURL var="viewEntryURL">
			    <portlet:param name="mvcRenderCommandName" value="/view/product" />
			    <portlet:param name="productId" value="<%= String.valueOf(product.getProductId()) %>" />
			</portlet:renderURL>
						
	
			<liferay-ui:search-container-column-text
				property="name"
				valign="top"
				href="<%= viewEntryURL %>"
			/>
			
			<liferay-ui:search-container-column-jsp
				cssClass="entry-action"
				path="/product_action.jsp"
				valign="top"
			/>
			
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	