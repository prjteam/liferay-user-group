package com.prjteam.usergroup;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.prjteam.usergroup.model.Product;
import com.prjteam.usergroup.service.ProductService;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Product Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProductPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
	
		//set service bean
		renderRequest.setAttribute("productService", getProductService() );

		
		super.render(renderRequest, renderResponse);
	
	
	}
	
	
	@Override
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		try {
			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateProduct(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteProduct(actionRequest);
			}

			if (Validator.isNotNull(cmd)) {
				if (SessionErrors.isEmpty(actionRequest)) {
					SessionMessages.add(actionRequest, "requestProcessed");
				}

				String redirect = ParamUtil.getString(
					actionRequest, "redirect");

				actionResponse.sendRedirect(redirect);
			}
		}
		catch (Exception e) {
			throw new PortletException(e);
		}
	}
	
	
	protected void deleteProduct(ActionRequest actionRequest) throws Exception {
		long productId = ParamUtil.getLong(actionRequest, "productId");
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Product.class.getName(), actionRequest);

		getProductService().deleteProduct(productId, serviceContext);
	}

	protected void updateProduct(ActionRequest actionRequest) throws Exception {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Product.class.getName(), actionRequest);
		
		long productId = ParamUtil.getLong(actionRequest, "productId");

		
		String name = ParamUtil.getString(actionRequest, "name");
		

		if (productId <= 0) {
			Product product = getProductService().createProduct(name,serviceContext);

			
		}
		else {
			Product product = getProductService().updateProduct(productId,name, serviceContext);

		}
	}

	

	
	private ProductService _productService;

	public ProductService getProductService() {
		return _productService;
	}

	@Reference
	public void setProductService(ProductService _productService) {
		this._productService = _productService;
	} 
	
}