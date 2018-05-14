

package com.nb.dto;

import java.util.Arrays;
public class EmailPropertiesDto {
	
	/** array of reciever of email. */
	private String[] receivers; 
	
	/** sender email. */
	private String sender;
	
	/** subject of mail. */
	private String subject;

	/** mail id array for cc in mail. */
	private String[] mailCc;
	
	/** mail id array for bcc in mail. */
	private String[] mailbCc;
	
	/**Mail type. */ 
	private String mailType;
	
	/** response redirect path. */
	private String redirectedPath;
	
	/** Blank constructor. */
	public EmailPropertiesDto() {
		super();
	}

	/** Parameterized Constructor. */ 
	public EmailPropertiesDto(String[] receiver, String sender, 
			String subject, String[] cc, String[] bcc, String templateType,
			String redirectPath) {

		this.receivers = Arrays.copyOf(receiver, receiver.length);
		this.sender = sender;
		this.subject = subject;
		this.mailCc = Arrays.copyOf(cc, cc.length);
		this.mailbCc = Arrays.copyOf(bcc, bcc.length);
		this.mailType = templateType;
		this.redirectedPath = redirectPath;
	}

	/**
	 * @return the receivers
	 */
	public String[] getReceivers() {
		return Arrays.copyOf(receivers, receivers.length);
	}

	/**
	 * @param receivers the receivers to set
	 */
	public void setReceivers(String[] receivers) {
		this.receivers = Arrays.copyOf(receivers, receivers.length);
	}

	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the mailCc
	 */
	public String[] getMailCc() {
		return Arrays.copyOf(mailCc, mailCc.length);
	}

	/**
	 * @param mailCc the mailCc to set
	 */
	public void setMailCc(String[] mailCc) {
		this.mailCc =Arrays.copyOf(mailCc, mailCc.length);
	}

	/**
	 * @return the mailbCc
	 */
	public String[] getMailbCc() {
		return Arrays.copyOf(mailbCc, mailbCc.length);
	}

	/**
	 * @param mailbCc the mailbCc to set
	 */
	public void setMailbCc(String[] mailbCc) {
		this.mailbCc = Arrays.copyOf(mailbCc, mailbCc.length);
	}

	/**
	 * @return the mailType
	 */
	public String getMailType() {
		return mailType;
	}

	/**
	 * @param mailType the mailType to set
	 */
	public void setMailType(String mailType) {
		this.mailType = mailType;
	}

	/**
	 * @return the redirectedPath
	 */
	public String getRedirectedPath() {
		return redirectedPath;
	}

	/**
	 * @param redirectedPath the redirectedPath to set
	 */
	public void setRedirectedPath(String redirectedPath) {
		this.redirectedPath = redirectedPath;
	}
	
}