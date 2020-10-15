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
import org.springframework.stereotype.Service;

import com.insight68.models.ContactUs;
import com.insight68.models.Coupons;
import com.insight68.models.InsightUsers;
import com.insight68.models.InvoiceBill;
import com.insight68.models.LoginDetails;
import com.insight68.repositories.ContactsRepo;
import com.insight68.repositories.CouponsRepo;
import com.insight68.repositories.InsightUsersRepo;
import com.insight68.repositories.LoginDetailsRepo;

@Service
public class CouponsService {

	@Autowired
	CouponsRepo couRepo;

	@Autowired
	LoginDetailsRepo loginRepo;

	@Autowired
	InsightUserService insightService;

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
	public Map<String, String> getDiscountValue(Coupons coupons) {
		Map<String, String> map = new HashMap<String, String>();
		if (Objects.nonNull(
				couRepo.findCouponCode(coupons.getCouponCode(), coupons.getPlanName(), coupons.getEmailAddress()))) {
			Long discount = couRepo.findCouponCode(coupons.getCouponCode(), coupons.getPlanName(),
					coupons.getEmailAddress());
			map.put("status", "exists");
			map.put("discount", discount.toString());
			return map;

		} else {
			map.put("status", "notexists");
			return map;
		}
	}

//MailCode http://14.143.13.66:8080/createpassword.html
	/*
	 * Mail to the Admin (User Details from ContactUs, Service ,Support pages will
	 * be sent to Admin as a mail)
	 */
	public boolean saveInvoice(InvoiceBill invoicebill) {
		Coupons coupons = couRepo.findOneBycouponCode(invoicebill.getCoupounCode());
		// InsightUsers insightUser =
		// insightService.getInsightUserEmailAddress(coupons.getEmailAddress());
		LoginDetails loginDetails = loginRepo.findOneByEmail(coupons.getEmailAddress());
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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(coupons.getEmailAddress()));
			message.setSubject("Invoice for the Insight68 " + coupons.getPlanName());
			message.setContent(("<html><body>Hi " + loginDetails.getUserName()
					+ "<br/>Thank you for showing interest in Insight68. <br/>You have got a discount of "
					+ coupons.getDiscount() + "% on our " + coupons.getPlanName() + " plan.\r\n"
					+ "Please find the invoice for the " + coupons.getPlanName()
					+ "plan <br/> <br/><table style='border: 1px solid black;border-collapse: collapse;'><tr><td style='border: 1px solid black'><b>Total All Modules</b></td><td style='border: 1px solid black'>"
					+ invoicebill.getTotal() + "</td></tr>"
					+ "<tr><td style='border: 1px solid black'><b>Discount in %</b></td><td style='border: 1px solid black'>"
					+ invoicebill.getDiscount() + "</td></tr>"
					+ "<tr><td style='border: 1px solid black'><b>Discount in Amount</b></td><td style='border: 1px solid black'>"
					+ invoicebill.getAmountSaved() + "</td></tr>"
					+ "<tr><td style='border: 1px solid black'><b>Price after Discount</b></td><td style='border: 1px solid black'>"
					+ invoicebill.getDiscountInAmount() + "</td></tr></table>"
					+ "<br/><br/>If you have any queries on the invoice, please write to us at sales@insight68.com.<br/>Kind Regards,<br/>"
					+ "Team Insight68<br/>" + "sales@insight68.com<br/>" + "</body></html>"), "text/html");
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return true;

	}
}