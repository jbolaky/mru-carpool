package com.javaid.bolaky.component.email;

public class MailConfig {

	private String hostName;
	private Integer smtpPort;
	private String username;
	private String password;
	private Boolean tls;
	private String fromEmailAddress;

	public String getHostName() {
		return hostName;
	}

	public Integer getSmtpPort() {
		return smtpPort;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Boolean getTls() {
		return tls;
	}

	public String getFromEmailAddress() {
		return fromEmailAddress;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public void setSmtpPort(Integer smtpPort) {
		this.smtpPort = smtpPort;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTls(Boolean tls) {
		this.tls = tls;
	}

	public void setFromEmailAddress(String fromEmailAddress) {
		this.fromEmailAddress = fromEmailAddress;
	}

}
