package com.insight68.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.insight68.models.InsightUsers;
import com.insight68.models.LoginDetails;
import com.insight68.repositories.InsightUsersRepo;
import com.insight68.repositories.LoginDetailsRepo;
import com.insight68.utils.UtilClass;

@Service
public class InsightUserService {

	@Autowired
	InsightUsersRepo repo;

	@Autowired
	LoginDetailsRepo loginRepo;

	@Value("${email}")
	String Email_Id;

	@Value("${password}")
	String password;

	@Value("${adminEmail}")
	String adminEmail;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// Saves the user
	public Map<String, String> savefirstLastEmailFromForm(InsightUsers insightUsers) {
		Map<String, String> map = new HashMap<String, String>();
		if (((findUserbyEmail(insightUsers.getEmailAddress()))
				|| (findUserbyPhoneNumber(insightUsers.getPhoneNumber())))) {
			map.put("status", "exists");
			return map;

		} else {
			repo.save(insightUsers);
			map.put("status", "Ok");
			map.put("id", insightUsers.getId().toString());
			return map;
		}
	}

	// Check whether user exists by Email

	public boolean findUserbyEmail(String emailAddress) {
		if (Objects.nonNull(repo.findOneByEmailAddress(emailAddress))) {
			return true;
		} else {
			return false;
		}
	}

	// Check whether user exists by phone number
	public boolean findUserbyPhoneNumber(String phoneNumber) {
		if (Objects.nonNull(repo.findOneByPhoneNumber(phoneNumber))) {
			return true;
		} else {
			return false;
		}
	}

	// Check whether user exists by Id
	public boolean findUserbyId(Long id) {
		if (Objects.nonNull(repo.findOneById(id))) {
			return true;
		} else {
			return false;
		}
	}

	// get user details by email Id
	public InsightUsers getInsightUserEmailAddress(String emailaddress) {
		return repo.findByEmailAddress(emailaddress);
	}

	// Password saving
	public boolean savePassword(InsightUsers insightUsers) {
		if (findUserbyId(insightUsers.getId())) {
			InsightUsers existing = repo.findOneById(insightUsers.getId());
			UtilClass.copyNonNullProperties(insightUsers, existing);
			repo.save(existing);
			return true;
		} else {
			return false;
		}
	}

	// All user details will be saved if id exists
	public boolean saveDetails(InsightUsers insightUsers) {
		if (findUserbyId(insightUsers.getId())) {
			InsightUsers existing = repo.findOneById(insightUsers.getId());
			UtilClass.copyNonNullProperties(insightUsers, existing);
			repo.save(existing);
			return true;
		} else {
			return false;
		}
	}

	// MailCode http://54.90.104.27:8080/createpassword.html
	// Mail for sending password message to User
	public void createPassword(String email, Long id, String userName) throws Exception {

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		// InetAddress inetAddress = InetAddress.getLocalHost();
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
			message.setSubject("Password recover - Insight68!!");
			message.setText("Hi " + userName + ",\t\r\n" + "\n" + "Greeting for the day!\r\n" + "\n" + "https://"
					+ getHostName + "/passwordreset.jsp" + "?id=" + id + "\n" + "\n" + "Kind Regards,\r\n"
					+ "Team Insight68.");
			Transport.send(message);
			// http://54.90.104.27:8080/Insight68/passwordreset.jsp
			// http://localhost:8080/Insight68/passwordreset.jsp
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	// Mail for sending password message to User
	public boolean sendPasswordChangeLinkEmail(LoginDetails logindetails) throws Exception {
		if (findLoginedUserbyEmail(logindetails.getEmail())) {
			LoginDetails existing = getLoginUserEmailAddress(logindetails.getEmail());
			String userName = existing.getUserName();
			// gotoMail(existing.getEmailAddress(), existing.id, "passwordreset.html");
			createPassword(existing.getEmail(), existing.id, userName);
			return true;
		}
		return false;
	}

//Mail will be sent to user as soon as User registers with try for free form	
	private void gotoMail(String email, Long id, String firstName) throws Exception {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		// InetAddress inetAddress = InetAddress.getLocalHost();
		String getHostName = "insight68.com";
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Email_Id, password);
			}
		});
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(Email_Id, "Insight68"));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		message.setSubject("Thank You for your interest on Insight68!!");
		message.setText("Hi " + firstName + ",\t\r\n" + "Greeting for the day!\r\n"
				+ "We appreciate your interest in Insight68. Our Customer Support Team will contact you shortly to discuss about the set up of your free account. To know more about our Pricing Plans, please visit http://"
				+ getHostName + "/index.jsp#pricing \r\n"
				+ "NOTE: Your Username and Password will be created by our team only after the discussion. \r\n"
				+ "Insight68 is an AI-Driven platform and set of applications driving digital transformation for manufacturers in Process and Discrete industries. Personalized Therapy has different production requirements in which it is a combination of Batch and Discrete manufacturing. Insight68 has AI-Driven capabilities to reach the goal of the \"Golden Batch\".\r\n"
				+ "With 25 years of experience in delivering solutions for Manufacturers across the globe, we lead the 4th Industrial Revolution by simplifying Digital Transformation and by utilizing advanced technologies. We enable our customers to cost-effectively produce best quality products. We have experience in working with the industries such as Life Science, Medical Device, Automotive, Contract Manufacturing, Metals, Mining, Foods and Beverages. Our products include Analytics, MES, Quality, Inventory, Scheduling and HMI.\r\n"
				+ "We promise an exciting experience with Insight68. So, get ready for a breathtaking journey. To know more about our products, please visit http://"
				+ getHostName + "/index.jsp#pro-Overview .\r\n" + "Kind Regards,\r\n" + "Team Insight68\r\n"
				+ "sales@insight68.com\r\n");
		Transport.send(message);
	}

	// Returns user id for continuation of Sign up form
	public Long getUserbyEmail(String emailAddress) {
		if (Objects.nonNull(repo.findOneByEmailAddress(emailAddress))) {
			InsightUsers ius = repo.findOneByEmailAddress(emailAddress);
			return ius.getId();
		} else {
			return Long.valueOf(0);
		}
	}

	// Return true if User exists by first name
	public boolean findUserByfirstName(String firstName) {
		if (Objects.nonNull(repo.findOneByFirstName(firstName))) {
			return true;
		} else {
			return false;
		}
	}

	// Checks the login Status
	public boolean loginStatus() {
		return true;
	}

	// User details will be saved for login credentials
	public boolean saveUserForLogin(InsightUsers insightUsers) {
		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setUserName(insightUsers.getFirstName());
		loginDetails.setPassword(insightUsers.getFirstName());
		loginDetails.setEmail(insightUsers.getEmailAddress());
		loginRepo.save(loginDetails);
		return true;
	}

	// Gets user by Email Address from login_credentials table
	public LoginDetails getLoginUserEmailAddress(String emailaddress) {
		return loginRepo.findByEmail(emailaddress);
	}

	// Verifies whether User exists by email address or not
	public boolean verifyEmailAddress(String emailaddress) {
		if (Objects.nonNull(loginRepo.findByEmail(emailaddress))) {
			return true;
		} else {
			return false;
		}
	}

	// Check whether user exists by Email

	public boolean findLoginedUserbyEmail(String emailAddress) {
		if (Objects.nonNull(loginRepo.findOneByEmail(emailAddress))) {
			return true;
		} else {
			return false;
		}
	}

	// Check whether user exists by Id

	public boolean findLoginedUserbyId(Long id) {
		if (Objects.nonNull(loginRepo.findById(id))) {
			return true;
		} else {
			return false;
		}
	}

	// Password code
	public boolean passwordreset(LoginDetails loginDetails) {
		if (findLoginedUserbyId(loginDetails.getId())) {
			if (Objects.nonNull(loginDetails.getPassword())) {
				LoginDetails existing = loginRepo.findById(loginDetails.getId());
				loginDetails.setPassword(bCryptPasswordEncoder.encode(loginDetails.getPassword()));
				UtilClass.copyNonNullProperties(loginDetails, existing);
				loginRepo.save(existing);
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	// All user details will be saved if id exists
	public boolean saveDetailsAndSendEmail(InsightUsers insightUsers) throws Exception {
		if (findUserbyId(insightUsers.getId())) {
			InsightUsers existing = repo.findOneById(insightUsers.getId());
			UtilClass.copyNonNullProperties(insightUsers, existing);
			repo.save(existing);
			if (Objects.nonNull(existing.getEmailAddress())) {
				gotoMail(existing.getEmailAddress(), existing.getId(), existing.getFirstName());
				sendMailWithUserDetialsFromDataBase(existing);
			}
			return true;
		} else {
			return false;
		}
	}

	// Mail will be sent to user as soon as User registers with try for free form
	private void sendMailWithUserDetialsFromDataBase(InsightUsers insightUsers) {
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
			message.setSubject("Try for Free Enquiry Form from -" + insightUsers.getFirstName() + " "
					+ (Objects.nonNull(insightUsers.getLastName()) ? insightUsers.getLastName() : ""));
			message.setContent(
					("<html><body>Hi !,<br/>Form Details<br/><br/><table style='border: 1px solid black;border-collapse: collapse;'><tr><td style='border: 1px solid black'><b>First Name</b></td><td style='border: 1px solid black'>"
							+ insightUsers.getFirstName() + "</td></tr>"
							+ "<tr><td style='border: 1px solid black'><b>Last Name</b></td><td style='border: 1px solid black'>"
							+ ((Objects.nonNull(insightUsers.getLastName()) ? insightUsers.getLastName() : "-")
									+ "</td></tr>"
									+ "<tr><td style='border: 1px solid black'><b>Email Address</b></td><td style='border: 1px solid black'>"
									+ insightUsers.getEmailAddress() + "</td></tr>"
									+ "<tr><td style='border: 1px solid black'><b>Phone Number</b></td><td style='border: 1px solid black'>"
									+ insightUsers.getPhoneNumber() + "</td></tr>"
									+ "<tr><td style='border: 1px solid black'><b>Company Domain</b></td><td style='border: 1px solid black'>"
									+ (Objects.nonNull(insightUsers.getCompanyDomain())
											? insightUsers.getCompanyDomain()
											: "-")
									+ "</td></tr>"
									+ "<tr><td style='border: 1px solid black'><b>Company Name</b></td><td style='border: 1px solid black'>"
									+ (Objects.nonNull(insightUsers.getCompanyName()) ? insightUsers.getCompanyName()
											: "-")
									+ "</td></tr>"
									+ "<tr><td style='border: 1px solid black'><b>How many people work at your company?</b></td><td style='border: 1px solid black'>"
									+ insightUsers.getHowmanypeopleworkatyourcompany() + "</td></tr>"
									+ "<tr><td style='border: 1px solid black'><b>What field do you work in?</b></td><td style='border: 1px solid black'>"
									+ insightUsers.getWhatfielddoyouworkin() + "</td></tr>"
									+ "<tr><td style='border: 1px solid black'><b>Which of the following best describes your role?</b></td><td style='border: 1px solid black'>"
									+ insightUsers.getWhichofthefollowingbestdescribesyourrole() + "</td></tr>"
									+ "<tr><td style='border: 1px solid black'><b>Which of these sounds most like you?</b></td><td style='border: 1px solid black'>"
									+ insightUsers.getWhichofthesesoundsmostlikeyou() + "</td></tr>"
									+ "</table><br/>Thanks<br/>Insight68</body></html>")),
					"text/html");
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
