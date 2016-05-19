
<%--
/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
--%>


<%@ include file="./init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
long productId = ParamUtil.getLong(request, "productId");
		 
		 
Product product = null;
if (productId > 0) {
	product = productService.getProduct(productId);
}
%>

<aui:form action="<%= renderResponse.createActionURL() %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= product == null ? Constants.ADD : Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="productId" type="hidden" value="<%= productId %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title='<%= (product != null) ? product.getName() : "new-product" %>'
	/>

	<liferay-ui:asset-categories-error />

	<liferay-ui:asset-tags-error />

	<aui:model-context bean="<%= product %>" model="<%= Product.class %>" />

	<aui:fieldset>
		<aui:input name="name" />

		

		<liferay-ui:custom-attributes-available className="<%= Product.class.getName() %>">
			<liferay-ui:custom-attribute-list
				className="<%= Product.class.getName() %>"
				classPK="<%= (product != null) ? product.getProductId() : 0 %>"
				editable="<%= true %>"
				label="<%= true %>"
			/>
		</liferay-ui:custom-attributes-available>

		
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>
