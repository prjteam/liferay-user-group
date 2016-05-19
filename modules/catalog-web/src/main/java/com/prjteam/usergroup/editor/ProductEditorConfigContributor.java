package com.prjteam.usergroup.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorCriterion;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.prjteam.usergroup.itemselector.ProductItemSelectorCriterion;



@Component(
	property = {
        "editor.name=alloyeditor",
        "javax.portlet.name=com_liferay_journal_web_portlet_JournalPortlet"
    },
    service = EditorConfigContributor.class
   )
public class ProductEditorConfigContributor extends BaseEditorConfigContributor{

	@Override
	public void populateConfigJSONObject(JSONObject jsonObject, Map<String, Object> inputEditorTaglibAttributes,
			ThemeDisplay themeDisplay, RequestBackedPortletURLFactory requestBackedPortletURLFactory) {
		
		
		JSONObject toolbars = jsonObject.getJSONObject("toolbars");
		
		

		if (toolbars != null) {
		    JSONObject toolbarAdd = toolbars.getJSONObject("add");

		    if (toolbarAdd != null) {
		        JSONArray addButtons = toolbarAdd.getJSONArray("buttons");

		        addButtons.put("product");
		        
		    }
		}
		
		jsonObject.put(
				"extraPlugins", jsonObject.getString("extraPlugins") +  ",productselector");
		
		List<ItemSelectorCriterion> itemSelectorCriteria = new ArrayList<>();
		
		itemSelectorCriteria.add(new ProductItemSelectorCriterion());
		
		
		PortletURL itemSelectorURL = getItemSelectorPortletURL(
				inputEditorTaglibAttributes, requestBackedPortletURLFactory,
				itemSelectorCriteria.toArray(
					new ItemSelectorCriterion[itemSelectorCriteria.size()]));
		
		
		jsonObject.put(
				"productBrowseLinkUrl", itemSelectorURL.toString());
	}
	
	public PortletURL getItemSelectorPortletURL(
			Map<String, Object> inputEditorTaglibAttributes,
			RequestBackedPortletURLFactory requestBackedPortletURLFactory,
			ItemSelectorCriterion... itemSelectorCriteria) {

			List<ItemSelectorReturnType> desiredItemSelectorReturnTypes =
				new ArrayList<>();

			desiredItemSelectorReturnTypes.add(new URLItemSelectorReturnType());

			for (ItemSelectorCriterion itemSelectorCriterion :
					itemSelectorCriteria) {

				itemSelectorCriterion.setDesiredItemSelectorReturnTypes(
					desiredItemSelectorReturnTypes);
			}

			String name = GetterUtil.getString(
				inputEditorTaglibAttributes.get("liferay-ui:input-editor:name"));

			boolean inlineEdit = GetterUtil.getBoolean(
				inputEditorTaglibAttributes.get(
					"liferay-ui:input-editor:inlineEdit"));

			if (!inlineEdit) {
				String namespace = GetterUtil.getString(
					inputEditorTaglibAttributes.get(
						"liferay-ui:input-editor:namespace"));

				name = namespace + name;
			}

			ItemSelector itemSelector = getItemSelector();

			return itemSelector.getItemSelectorURL(
				requestBackedPortletURLFactory, name + "selectItem",
				itemSelectorCriteria);
		}

	@Reference(unbind = "-")
	public void setItemSelector(ItemSelector itemSelector) {
		_itemSelector = itemSelector;
	}

	protected ItemSelector getItemSelector() {
		return _itemSelector;
	}

	private ItemSelector _itemSelector;
}
