package com.nb.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Servlet.class, property = {
		Constants.SERVICE_DESCRIPTION + "=Server Time Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET,
		"sling.servlet.paths=" + "/bin/servertime",
		"sling.servlet.extensions=" + "json" })
public class ServerTime extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 4182221959515663216L;
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ServerTime.class);

	@Override
	protected void doGet(final SlingHttpServletRequest req,
			final SlingHttpServletResponse resp) throws ServletException,
			IOException {
		try {
			Calendar cal = new GregorianCalendar();
			long millisecondTime = cal.getTimeInMillis() - 1000;
			JSONObject assetsObj = new JSONObject();

			assetsObj.put("serverTime", millisecondTime);

			resp.setContentType("application/json");
			resp.getWriter().write(assetsObj.toString());
		} catch (final IOException | JSONException e) {
			LOGGER.error("Error occurred while writing values in response", e);
		}
	}
}
