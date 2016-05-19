;(function() {
	AUI().applyConfig(
		{
			groups: {
				product: {
					base: MODULE_PATH + '/js/item_selector/',
					modules: {
						'product-item-selector': {
							path: 'product_item_selector.js',
							requires: [
								'liferay-item-viewer',
								'liferay-portlet-base'
							]
						}
					},
					root: MODULE_PATH + '/js/'
				}
			}
		}
	);
})();
