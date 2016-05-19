package com.prjteam.usergroup.itemselector;


import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.ItemSelectorView;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.LayoutService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.prjteam.usergroup.model.Product;
import com.prjteam.usergroup.service.ProductService;

import java.io.IOException;

import java.util.Collections;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.PortletURL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marco Leo
 */
@Component(
	immediate = true, service = ItemSelectorView.class
)


public class ProductItemSelector
	implements ItemSelectorView<ProductItemSelectorCriterion> {

	public ProductItemSelector(){
		
		_log.info("LOADED");
		
	}
	
	@Override
	public Class<ProductItemSelectorCriterion> getItemSelectorCriterionClass() {
		return ProductItemSelectorCriterion.class;
	}

	public ServletContext getServletContext() {
		return _servletContext;
	}

	@Override
	public List<ItemSelectorReturnType> getSupportedItemSelectorReturnTypes() {
		return _supportedItemSelectorReturnTypes;
	}

	@Override
	public String getTitle(Locale locale) {
		//return getLanguageKey(locale, "products");
		return "Products";
	}

	@Override
	public boolean isShowSearch() {
		return true;
	}

	@Override
	public boolean isVisible(ThemeDisplay themeDisplay) {
		
		return true;
	}

	@Override
	public void renderHTML(
			ServletRequest request, ServletResponse response,
			ProductItemSelectorCriterion imageItemSelectorCriterion,
			PortletURL portletURL, String itemSelectedEventName, boolean search)
		throws IOException, ServletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);
		
		
		
		

		
		int delta = GetterUtil.getInteger(
				request.getParameter(SearchContainer.DEFAULT_DELTA_PARAM),
				SearchContainer.DEFAULT_DELTA);
		
		int cur = GetterUtil.getInteger(
				request.getParameter(SearchContainer.DEFAULT_CUR_PARAM),
				SearchContainer.DEFAULT_CUR);
			
			
		String keywords = GetterUtil.getString(
				request.getParameter("keywords"));
		
		List<Product> products = getProductService().search(keywords, (delta * cur) - delta ,((delta * cur) + delta)  );

		long productsCount = getProductService().searchCount(keywords);
		

		request.setAttribute("total", productsCount);
		request.setAttribute("products", products);
		request.setAttribute("portletURL", portletURL);
		request.setAttribute("itemSelectedEventName", itemSelectedEventName);
		
		

		ServletContext servletContext = getServletContext();

		RequestDispatcher requestDispatcher =
			servletContext.getRequestDispatcher("/item_selector/products_item_selector_view.jsp");

		requestDispatcher.include(request, response);
	}

	@Reference(
		target = "(osgi.web.symbolicname=catalog.web)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_log.info("SPEREM");
	}

	

	protected String getLanguageKey(Locale locale, String key) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content/Language", locale, getClass());

		return resourceBundle.getString(key);
	}


	private static final Log _log = LogFactoryUtil.getLog(
		ProductItemSelector.class);

	private static final List<ItemSelectorReturnType>
		_supportedItemSelectorReturnTypes = Collections.unmodifiableList(
			ListUtil.fromArray(
				new ItemSelectorReturnType[] {
					new URLItemSelectorReturnType()
				}));

	
	private ServletContext _servletContext;
	
	

	
	private ProductService _productService;

	public ProductService getProductService() {
		return _productService;
	}

	@Reference
	public void setProductService(ProductService _productService) {
		this._productService = _productService;
	} 
	

	private LayoutLocalService _layoutService;

	public LayoutLocalService getLayoutService() {
		return _layoutService;
	}

	@Reference
	public void setLayoutService(LayoutLocalService layoutService) {
		this._layoutService = layoutService;
	} 

}