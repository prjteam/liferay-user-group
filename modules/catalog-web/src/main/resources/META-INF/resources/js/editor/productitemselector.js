(function() {
		
	var STR_PRODUCT_RETURN_TYPE = "PRODUCT";
	
	CKEDITOR.plugins.add(
		'productselector',
		{
			init: function(editor) {
				var instance = this;

				
				editor.addCommand(
					'productitemselector',
					{
						
						canUndo: false,
						exec: function(editor, callback) {
							
							var onSelectedImageChangeFn = AUI().bind(
								'_onSelectedImageChange',
								instance,
								editor,
								callback
							);

							instance._getItemSelectorDialog(
								editor,
								editor.config.productBrowseLinkUrl,
								function(itemSelectorDialog) {
									itemSelectorDialog.once('selectedItemChange', onSelectedImageChangeFn);
									itemSelectorDialog.open();
								}
							);
						}
					}
				);

				

				CKEDITOR.on(
					'dialogDefinition',
					function(event) {
						var dialogName = event.data.name;

						var dialogDefinition = event.data.definition;

						if (dialogName === 'image') {
							instance._bindBrowseButton(editor, dialogDefinition, 'info', 'imageselector', 'txtUrl');
							instance._bindBrowseButton(editor, dialogDefinition, 'Link', 'imageselector', 'txtUrl');
						}
						
					}
				);

				editor.once(
					'destroy',
					function() {
						if (instance._itemSelectorDialog) {
							instance._itemSelectorDialog.destroy();
						}
					}
				);
			},

			_bindBrowseButton: function(editor, dialogDefinition, tabName, commandName, targetField) {
				var tab = dialogDefinition.getContents(tabName);

				if (tab) {
					var browseButton = tab.get('browse');

					if (browseButton) {
						browseButton.onClick = function() {
							editor.execCommand(
								commandName,
								function(newVal) {
									dialogDefinition.dialog.setValueOf(tabName, targetField, newVal);
								}
							);
						};
					}
				}
			},

			
			_commitMediaValue: function(value, editor, type) {
				var instance = this;

				var mediaPlugin = editor.plugins.media;

				if (mediaPlugin) {
					var eventName = editor.name + 'selectItem';

					Liferay.Util.getWindow(eventName).onceAfter(
						'destroy',
						function() {
							mediaPlugin.onOkCallback(
								{
									commitContent: instance._getCommitMediaValueFn(value, editor, type)
								},
								editor,
								type
							);
						}
					);
				}
			},

			
			_getCommitMediaValueFn: function(value, editor, type) {
				var instance = this;

				var commitValueFn = function(node, extraStyles) {
					var mediaScript;

					

					var mediaPlugin = editor.plugins.media;

					if (mediaPlugin) {
						mediaPlugin.applyMediaScript(node, type, mediaScript);
					}
				};

				return commitValueFn;
			},

			_getItemSelectorDialog: function(editor, url, callback) {
				var instance = this;

				var eventName = editor.name + 'selectItem';

				var itemSelectorDialog = instance._itemSelectorDialog;

				if (itemSelectorDialog) {
					itemSelectorDialog.set('eventName', eventName);
					itemSelectorDialog.set('url', url);
					itemSelectorDialog.set('zIndex', CKEDITOR.getNextZIndex());

					callback(itemSelectorDialog);
				}
				else {
					AUI().use(
						'liferay-item-selector-dialog',
						function(A) {

							itemSelectorDialog = new A.LiferayItemSelectorDialog(
								{
									eventName: eventName,
									url: url,
									zIndex: CKEDITOR.getNextZIndex()
								}
							);

							instance._itemSelectorDialog = itemSelectorDialog;

							callback(itemSelectorDialog);
						}
					);
				}
			},

			

			_onSelectedImageChange: function(editor, callback, event) {
				var instance = this;

				var selectedItem = event.newVal;

				if (selectedItem) {
					var eventName = editor.name + 'selectItem';

					

					Liferay.Util.getWindow(eventName).onceAfter(
						'destroy',
						function() {
							if (selectedItem.value) {
								if (callback) {
									callback(selectedItem.value);
								}
								else {
									var attributes = {};
									
									attributes['data-cke-saved-href'] = selectedItem.value.url;

									attributes.href = selectedItem.value.url;

									var selection = editor.getSelection();

									var ranges = selection.getRanges(true);

									if (ranges.length == 1 && ranges[0].collapsed) {
										var text = new CKEDITOR.dom.text(selectedItem.value.title, editor.document);

										ranges[0].insertNode(text);
										ranges[0].selectNodeContents(text);

										selection.selectRanges(ranges);
									}

									var style = new CKEDITOR.style(
										{
											attributes: attributes,
											element: 'a'
										}
									);

									style.type = CKEDITOR.STYLE_INLINE;

									editor.applyStyle(style);
								
									
									//var el = CKEDITOR.dom.element.createFromHtml('<a href="'+ selectedItem.value.url +'">' + selectedItem.value.title +'</a>');

									//editor.insertElement(el);

									//editor.setData(editor.getData());
								}
							}
						}
					);
				}
			}

			
		}
	);
})();