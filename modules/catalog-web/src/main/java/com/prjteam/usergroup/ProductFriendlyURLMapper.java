package com.prjteam.usergroup;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;


@Component(
	    property = {
	        "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
	        "javax.portlet.name=com_prjteam_usergroup_ProductPortlet" 
	    },
	    service = FriendlyURLMapper.class
	)
public class ProductFriendlyURLMapper extends DefaultFriendlyURLMapper {

	@Override
    public String getMapping() {
        return _MAPPING;
    }

    private static final String _MAPPING = "products";

	
}
