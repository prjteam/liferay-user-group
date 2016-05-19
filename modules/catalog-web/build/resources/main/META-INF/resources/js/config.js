;(function() {
	var PATH_PRODUCT_ITEM_SELECTOR = Liferay.ThemeDisplay.getPathContext() + '/o/catalog-web';

	
	
	AUI().applyConfig(
		{
			groups: {
				product: {
					base: PATH_PRODUCT_ITEM_SELECTOR + '/js/item_selector/',
					modules: {
						'product-item-selector': {
							path: 'product_item_selector.js',
							requires: [
								'liferay-item-viewer',
								'liferay-portlet-base'
							]
						}
					},
					root: PATH_PRODUCT_ITEM_SELECTOR + '/js/'
				}
			}
		}
	);
})();