package com.nb.viewhelpers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.jcr.Node;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.settings.SlingSettingsService;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.commons.Externalizer;
import com.day.cq.wcm.api.Page;
import com.nb.services.GenericService;

public class LinkController extends WCMUsePojo {

	
	private String link;
	private String target;
	private String title;

	@Override
	public void activate() throws Exception {
		GenericService service = getSlingScriptHelper().getService(GenericService.class);
		
		//Set<String> runModes = getSlingScriptHelper().getService(SlingSettingsService.class).getRunModes();
		Resource defaultPage = getResourceResolver().getResource(service.getPath().replace(".html",StringUtils.EMPTY));
		if(defaultPage!=null){
			Page page = defaultPage.adaptTo(Page.class);
			title = page.getTitle();
		}
		link = getProperties().get("link", service.getPath());

		if (!(link.startsWith("http") || link.startsWith("www") || link
				.contains("html"))) {
			link = link + ".html";
		}
		if (link.startsWith("/content")) {
			target = StringUtils.EMPTY;
		} else {
			target = "_blank";
		}
		
		link = getSlingScriptHelper().getService(Externalizer.class).externalLink(getResourceResolver(), "mydomain",service.getPath());
		
	}

	public String getLink() {
		return link;
	}

	public String getTarget() {
		return target;
	}

}
