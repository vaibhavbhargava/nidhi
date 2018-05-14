
package com.nb.dto;

import java.util.Arrays;


public class TemplateDTO {

	private String templateType;
	
	// path of the template
	private String templatePath;
	
	// addresses to which emails need to be sent.
	private String[] toEmailId;

	/**
	 * @return the templateType
	 */
	public String getTemplateType() {
		return templateType;
	}

	/**
	 * @param templateType the templateType to set
	 */
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	/**
	 * @return the templatePath
	 */
	public String getTemplatePath() {
		return templatePath;
	}

	/**
	 * @param templatePath the templatePath to set
	 */
	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	/**
	 * @return the toEmailId
	 */
	public String[] getToEmailId() {
		return Arrays.copyOf(toEmailId, toEmailId.length);
	}

	/**
	 * @param toEmailId the toEmailId to set
	 */
	public void setToEmailId(String[] toEmailId) {
		this.toEmailId = Arrays.copyOf(toEmailId, toEmailId.length);
	}



	
	
}
