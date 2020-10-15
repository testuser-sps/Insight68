package com.insight68.service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.insight68.models.TryForFree;
import com.insight68.repositories.TryForFreeRepo;

@Service
public class TryForFreeService {

	@Autowired
	TryForFreeRepo tryForFreeRepo;

	@Value("${email}")
	String Email_Id;

	@Value("${password}")
	String password;

	public boolean saveTryForFree(TryForFree tryForFree) {
		tryForFreeRepo.save(tryForFree);
		contactUsMail(tryForFree.getEmailAddress());
		return true;
	}

	// MailCode http://14.143.13.66:8080/createpassword.html
	public void contactUsMail(String email) {

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Email_Id, password);
			}
		});
		try {

			Message message = new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress(Email_Id, "Insight68"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Insight68-TryForFree!");
			message.setText("Hi Insight68 User," + "\n" + "\n"
					+ "Thanks for your interest in Insight68, someone will contact you shortly to discuss with you about setting up the free trial.");
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
