package com.nb.slingmodels;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.nb.services.GenericService;

@Model(adaptables = Resource.class, defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class LinkModel {
	
	@OSGiService
	private GenericService genSer;

	@ValueMapValue
	private String link;

	private String target;

	@PostConstruct
	protected void init() {
		if(StringUtils.isEmpty(link)){
			link = genSer.getPath();
		}
		if (!(link.startsWith("http") || link.startsWith("www") || link
				.contains("html"))) {
			link = link + ".html";
		}
		if (link.startsWith("/content")) {
			target = StringUtils.EMPTY;
		} else {
			target = "_blank";
		}
	}

	public String getLink() {
		return link;
	}

	public String getTarget() {
		return target;
	}

}
