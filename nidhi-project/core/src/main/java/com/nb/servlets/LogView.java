package com.nb.servlets;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Servlet.class, property = {
		Constants.SERVICE_DESCRIPTION + "=Server Time Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET,
		"sling.servlet.paths=" + "/bin/logaccess" })
public class LogView extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = -5667667993662313707L;
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LogView.class);

	@Override
	protected void doGet(final SlingHttpServletRequest req,
			final SlingHttpServletResponse resp) throws ServletException,
			IOException {
		RandomAccessFile randomAccess = null;
		try {
			StringBuilder logBuilder = new StringBuilder();
			File logFile = new File("crx-quickstart/logs/error.log");
			randomAccess = new RandomAccessFile(logFile, "r");
			
			long filePointer = randomAccess.length() - 1024*20; //20kb data
			StringBuilder sb = new StringBuilder();
	        randomAccess.seek(filePointer);
			String tmp;
	        while ((tmp = randomAccess.readLine()) != null){
	        	logBuilder.append("<p class=\"logentry\">").append(tmp).append("</p><br/><br/>");
	        }
			resp.setContentType("text/html");
			resp.getWriter().write(logBuilder.toString());
			resp.getWriter().flush();
			resp.getWriter().close();
		} catch (final IOException e) {
			LOGGER.error("Error occurred while writing values in response", e);
		} finally{
			randomAccess.close();
			
		}
	}
}
