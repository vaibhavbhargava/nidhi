package com.nb.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.day.cq.wcm.api.Page;
import com.nb.services.GenericService;

@Component(service = Servlet.class, property = {
		Constants.SERVICE_DESCRIPTION + "=Lazy Search Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET,
		"sling.servlet.paths=" + "/bin/lazysearch",
		"sling.servlet.extensions=" + "json" })
public class LazySearch extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = -2888250212102271872L;
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LazySearch.class);

	@Reference
	private GenericService genSer;
	
	@Reference
	private QueryBuilder builder;
	
	@Override
	protected void doGet(final SlingHttpServletRequest req,
			final SlingHttpServletResponse resp) throws ServletException,
			IOException {
		try {
			String searchKey = req.getParameter("key");
					JSONArray array = new JSONArray();
					Set<String> pathSets = new HashSet<String>();
					 
			Session session = req.getResourceResolver().adaptTo(Session.class);
			Map<String, String> params = new HashMap<String, String>();
					params.put("path",genSer.getPath());
							params.put("type","cq:Page");
									params.put("fulltext",searchKey);
											params.put("orderby","@jcr:content/jcr:lastModified");
			

											Query query = builder.createQuery(PredicateGroup.create(params), session);

											SearchResult result = query.getResult();
											for(Hit hit: result.getHits()){
												Page page;
												try {
													page = hit.getResource().adaptTo(Page.class);

													pathSets.add(page.getTitle());
												} catch (RepositoryException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											array.put(pathSets);
			resp.setContentType("application/json");
			resp.getWriter().write(array.toString());
		} catch (final IOException e) {
			LOGGER.error("Error occurred while writing values in response", e);
		}
	}
}
