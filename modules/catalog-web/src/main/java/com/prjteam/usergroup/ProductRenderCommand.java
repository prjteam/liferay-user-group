package com.prjteam.usergroup;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.prjteam.usergroup.model.Product;
import com.prjteam.usergroup.service.ProductService;


@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=com_prjteam_usergroup_ProductPortlet" ,
	       "mvc.command.name=/view/product"
	    },
	    service = MVCRenderCommand.class
	)
public class ProductRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		
		long productId = ParamUtil.getLong(renderRequest, "productId");
		
		try {
			
			Product product = getProductService().getProduct(productId);
						
			renderRequest.setAttribute("product", product );

			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "/product/view_product.jsp";
		
		
		
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
