/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mailservice;

import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author sriha
 */
public class MailService {

	final static String gmailAccountEmail = "sriharshaperi@gmail.com";
	final static String gmailAccountPassword = "HARSHperi@96";

	public static void senMail(String recipient, String text, String Org) {

		try {
			String host = "smtp.gmail.com";
			text = "Hello customersupport@"+Org+".com . Please deliver the following items to this address : 123 Fenway, Boston, MA 02215 -------: " + text;
			Properties properties = new Properties();
			properties.put("mail.transport.protocol", "smtp");
			properties.put("mail.setup.auth", "true");
 properties.put("mail.smtp.socketFactory.port", "465");    
properties.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
			//			properties.put("mail.smtp.ssl.trust", host);
			properties.put("mail.smtp.user", gmailAccountEmail);
			properties.put("mail.smtp.password", gmailAccountPassword);
			//properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.setup.starttls.enable", "true");

			properties.put("mail.smtp.EnableSSL.enable","true");

			properties.put("mail.setup.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "465");

			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(gmailAccountEmail, gmailAccountPassword);
				}
			};

			Session session = Session.getDefaultInstance(properties, auth);
			session.setDebug(true);

			Message message = prepareMessage(session, recipient, text);

			Transport transport = session.getTransport();

			transport.connect(host, gmailAccountEmail, gmailAccountPassword);
			transport.sendMessage(message,
				message.getRecipients(Message.RecipientType.TO));
			transport.close();

		} catch (Exception e) {
			Logger.getLogger(MailService.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	private static Message prepareMessage(Session session, String recipient, String text) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(gmailAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("Equipment Order received from Khake Jao Restaurant");
			message.setText(text);
			String htmlCode = "<h1>***Khake-Jao Restaurant***</h1>" + "\n" +text;
			message.setContent(htmlCode, "text/html");
			return message;
		} catch (Exception e) {
			Logger.getLogger(MailService.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
}
