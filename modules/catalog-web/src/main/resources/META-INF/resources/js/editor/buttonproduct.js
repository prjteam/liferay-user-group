/* global React, AlloyEditor */

(function() {
	'use strict';

	var React = AlloyEditor.React;

	var ButtonProduct = React.createClass(
		{
			mixins: [AlloyEditor.ButtonCommand],

			displayName: 'ButtonProduct',

			propTypes: {
				editor: React.PropTypes.object.isRequired,
				imageTPL: React.PropTypes.string
			},

			getDefaultProps: function() {
				return {
					command: 'productitemselector'
				};
			},

			statics: {
				key: 'product'
			},

			render: function() {
				return React.createElement(
					'button',
					{
						className: 'ae-button',
						'data-type': 'button-image',
						onClick: this._handleClick,
						tabIndex: this.props.tabIndex
					},
					React.createElement(
						'span',
						{
							className: 'icon-th-list'
						}
					)
				);
			},

			_handleClick: function() {
				this.execCommand(null);
			}
		}
	);

	AlloyEditor.Buttons[ButtonProduct.key] = AlloyEditor.ButtonProduct = ButtonProduct;
}());