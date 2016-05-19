AUI.add(
	'product-item-selector',
	function(A) {
		var Lang = A.Lang;


		var STR_SELECTED_ITEM = 'selectedItem';


		var ProductItemSelector = A.Component.create(
			{
				ATTRS: {
					closeCaption: {
						validator: Lang.isString,
						value: ''
					}
				},

				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Base,

				NAME: 'productitemselector',

				prototype: {
					initializer: function() {
						var instance = this;

						
						instance._productImageSelectorWrapper = instance.one('#productsImageSelectorWrapper');

						instance._bindUI();
						instance._renderUI();
					},

					destructor: function() {
						var instance = this;

						(new A.EventHandle(instance._eventHandles)).detach();
					},

					_bindUI: function() {
						var instance = this;


						instance._eventHandles = [
							instance._productImageSelectorWrapper.delegate('click', instance._onItemSelected, '.product-row', instance)
						];
					},

					_onItemSelected: function(event) {
						var instance = this;

						var nd = event.currentTarget.one('.product-name');
						
						var url = nd.attr('data-url');
						var plid = nd.attr('data-plid');
						var id = nd.attr('data-id');
						var title = nd.attr('data-title');
						
						  var portletURL = Liferay.PortletURL.createRenderURL();
						  
						    portletURL.setPortletId('com_prjteam_usergroup_ProductPortlet');
						    portletURL.setPlid(plid);
						    //portletURL.setWindowState('');
						    portletURL.setParameter('mvcRenderCommandName', "/view/product");
						    portletURL.setParameter('productId', id);
						 
						
						var returnObj = {url:portletURL.toString() , title : title }
						
						instance.fire(
							STR_SELECTED_ITEM,
							{
								data: {
									returnType: "PRODUCT",
									value: returnObj
								}
							}
						);
					},

					
					_renderUI: function() {
						var instance = this;

						var rootNode = instance.rootNode;

					}
				}
			}
		);

		Liferay.ProductItemSelector = ProductItemSelector;
	},
	'',
	{
		requires: ['liferay-item-viewer', 'liferay-portlet-base','liferay-portlet-url']
	}
);