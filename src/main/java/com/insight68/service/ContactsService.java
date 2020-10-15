package com.insight68.service;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.Objects;
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

import com.insight68.models.ContactUs;
import com.insight68.repositories.ContactsRepo;

@Service
public class ContactsService {

	@Autowired
	ContactsRepo cos;

	@Value("${email}")
	String Email_Id;

	@Value("${password}")
	String password;

	@Value("${adminEmail}")
	String adminEmail;

	/*
	 * User details who are registered from ContactUs, Service ,Support pages will
	 * be saved here
	 */
	public boolean saveContactUsForm(ContactUs contactus) throws Exception {
		cos.save(contactus);
		contactUsMail(contactus.getEmailAddress(), contactus.getfName());
		copyOfRegisteredUserDetailsToMail(contactus);
		return true;
	}

	// MailCode http://14.143.13.66:8080/createpassword.html
	/*
	 * Mail to the User (User who are registered from ContactUs, Service ,Support
	 * pages will receive an email)
	 */
	public void contactUsMail(String email, String firstName) throws Exception {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		/* InetAddress inetAddress = InetAddress.getLocalHost(); */
		String getHostName = "insight68.com";
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
			message.setSubject("Thank You for Contacting Insight68!");
			/*
			 * message.setText("Hi Insight68 User" + "," + "\n" + "\n" +
			 * "To confirm your account, please click here : " + "http://14.143.13.66:8080/"
			 * + url + "?id=" + id + "\n" + "\n" + "Thank You," + "\n" + "Team Insight68.");
			 */
			message.setText("Hi " + firstName + ",\r\n" + "\n" + "\n" + "Greeting for the day!\r\n" + "\n" + "\n"
					+ "Thank you for contacting us. Our executive will get back to you shortly to discuss about your query. To know more about us, please visit https://"
					+ getHostName + "/index.jsp .\r\n"
					+ "Insight68 is an AI-Driven platform and set of applications driving digital transformation for manufacturers in Process and Discrete industries. Personalized Therapy has different production requirements in which it is a combination of Batch and Discrete manufacturing. Insight68 has AI-Driven capabilities to reach the goal of the \"Golden Batch\".\r\n"
					+ "With 25 years of experience in delivering solutions for Manufacturers across the globe, we lead the 4th Industrial Revolution by simplifying Digital Transformation and by utilizing advanced technologies. We enable our customers to cost-effectively produce best quality products. We have experience in working with the industries such as Life Science, Medical Device, Automotive, Contract Manufacturing, Metals, Mining, Foods and Beverages. Our products include Analytics, MES, Quality, Inventory, Scheduling and HMI.\r\n"
					+ "We promise an exciting experience with Insight68. So, get ready for a breathtaking journey. \r\n"
					+ "\n" + "\n" + "Kind Regards,\r\n" + "Team Insight68.");

			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

//MailCode http://14.143.13.66:8080/createpassword.html
	/*
	 * Mail to the Admin (User Details from ContactUs, Service ,Support pages will
	 * be sent to Admin as a mail)
	 */
	public void copyOfRegisteredUserDetailsToMail(ContactUs contactUs) throws Exception {

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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(adminEmail));
			message.setSubject("Enquiry form from - " + contactUs.getfName() + " "
					+ (Objects.nonNull(contactUs.getlName()) ? contactUs.getlName() : ""));

			message.setContent(
					("<html><body>Hi !,<br/>Form Details<br/><br/><table style='border: 1px solid black;border-collapse: collapse;'><tr><td style='border: 1px solid black'><b>First Name</b></td><td style='border: 1px solid black'>"
							+ contactUs.getfName() + "</td></tr>"
							+ "<tr><td style='border: 1px solid black'><b>Last Name</b></td><td style='border: 1px solid black'>"
							+ contactUs.getlName() + "</td></tr>"
							+ "<tr><td style='border: 1px solid black'><b>Email Address</b></td><td style='border: 1px solid black'>"
							+ contactUs.getEmailAddress() + "</td></tr>"
							+ "<tr><td style='border: 1px solid black'><b>Subject</b></td><td style='border: 1px solid black'>"
							+ contactUs.getSubject() + "</td></tr>"
							+ "<tr><td style='border: 1px solid black'><b>Product</b></td><td style='border: 1px solid black'>"
							+ contactUs.getSelectProduct() + "</td></tr>"
							+ "<tr><td style='border: 1px solid black'><b>SkypeId</b></td><td style='border: 1px solid black'>"
							+ contactUs.getSocialMediaId() + "</td></tr>"
							+ "<tr><td style='border: 1px solid black'><b>WhatsappNumber</b></td><td style='border: 1px solid black'>"
							+ contactUs.getWhatsappNumber() + "</td></tr>"
							+ "<tr><td style='border: 1px solid black'><b>Message</b></td><td style='border: 1px solid black'>"
							+ contactUs.getMessage() + "</td></tr></table>"
							+ "<br/>Thanks<br/>Insight68</body></html>"),
					"text/html");

			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}