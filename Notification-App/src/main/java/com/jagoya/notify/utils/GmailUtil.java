package com.jagoya.notify.utils;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import com.jagoya.notify.data.maps.tables.Message;
import com.jagoya.notify.data.maps.tables.User;

public class GmailUtil extends EmailUtil {

	/**
	 * Outgoing Mail (SMTP) Server requires TLS or SSL: smtp.gmail.com (use
	 * authentication) Use Authentication: Yes Port for TLS/STARTTLS: 587
	 * 
	 * @throws Exception
	 */
	public void sendGmail(List<User> users, Message message) throws Exception {
//		if (users == null || users.isEmpty()) {
//			throw new Exception("Atleast one user is required");
//		}
//
//		if (message == null) {
//			throw new Exception("Message cant be null");
//		}

		final String fromEmail = "goelpulkit@gmail.com"; // requires valid gmail
														// id
		final String password = "pgoel007"; // correct password for gmail id

		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
		props.put("mail.smtp.port", "587"); // TLS Port
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		// create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);

	//	String emailIds = getEmailIds(users);
	//	sendEmail(session, fromEmail, emailIds, message.getSubject(), message.getContent());
		sendEmail(session, fromEmail, "praveen.awasthi@gmail.com,reachrky@gmail.com", "Jagoya Test Mail", "Hi Guys,\nI'm testing our application. Hopefully it will be completed in 2-3 days :).\nThanks,\nPulkit");
	}

	public static void main(String[] args) throws Exception {
		GmailUtil util = new GmailUtil();
		util.sendGmail(null, null);
	}
	
	private String getEmailIds(List<User> users) {
		StringBuilder emailIds = new StringBuilder();
		for (User user : users) {
			emailIds.append(user.getEmailId());
			emailIds.append(",");
		}
		emailIds.deleteCharAt(emailIds.length() - 1);
		return emailIds.toString();
	}
}
