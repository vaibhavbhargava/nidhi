package com.nb.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.jcr.api.SlingRepository;
import org.apache.sling.xss.XSSFilter;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.mailer.MessageGatewayService;

@Component(service = Servlet.class, property = {
		Constants.SERVICE_DESCRIPTION + "=Form Submit Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST,
		"sling.servlet.paths=" + "/bin/form-submit-servlet",
		"sling.servlet.extensions=" + "json" })
public class FormSubmitServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 6590780809236596615L;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FormSubmitServlet.class);
	
	@Reference
	private MessageGatewayService messageGateway;
	
	@Reference
	private transient ResourceResolverFactory resFac;

	@Reference
	private transient SlingRepository slingRepo;
	
	@Reference
	private transient XSSFilter xssFilter;

	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(final SlingHttpServletRequest req,
			final SlingHttpServletResponse resp) throws ServletException,
			IOException {
		Session session;
		
		try {
			session = resFac.getAdministrativeResourceResolver(null).adaptTo(Session.class);

			session = slingRepo.loginAdministrative(null);
			
			final Map<String, Object> param = new HashMap<String, Object>();
	        param.put(ResourceResolverFactory.SUBSERVICE, "write-user");
			session = resFac.getServiceResourceResolver(param).adaptTo(Session.class);
			
		} catch (LoginException | RepositoryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String firstName = xssFilter.filter(StringUtils.isNotBlank(req.getParameter("firstname"))?req.getParameter("firstname"):StringUtils.EMPTY);
		String lastName =xssFilter.filter(StringUtils.isNotBlank(req.getParameter("lastname"))?req.getParameter("lastname"):StringUtils.EMPTY);
		String gender = xssFilter.filter(StringUtils.isNotBlank(req.getParameter("gender"))?req.getParameter("gender"):StringUtils.EMPTY);
		
		//String vehicles = req.getParameter("cars");
		String vehicles = xssFilter.filter(StringUtils.isNotBlank(req.getParameter("cars"))?req.getParameter("cars"):StringUtils.EMPTY);
		String chkBox = xssFilter.filter(StringUtils.isNotBlank(req.getParameter("acceptance"))?req.getParameter("acceptance"):StringUtils.EMPTY);
		
		LOGGER.error("firstName = " + firstName);
		SimpleEmail mail = new SimpleEmail();
		try {
			mail.addTo("vbhargava@sapient.com");
			mail.addCc("nidhibhargava91@gmail.com");
			mail.setFrom("bhargava.vaibhav1@gmail.com");
			mail.setSubject("Form Submission");
			mail.setMsg("Form Submitted with following data:\nfirstname: "+firstName+"\nlastname: "+lastName);
		} catch (EmailException e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		messageGateway.getGateway(SimpleEmail.class).send(mail);
	}
}
