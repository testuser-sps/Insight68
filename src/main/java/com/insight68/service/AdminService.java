package com.insight68.service;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.insight68.dto.ContactUsDTO;
import com.insight68.dto.InsightUsersDTO;
import com.insight68.dto.LoginDetailsDTO;
import com.insight68.dto.PricingDTO;
import com.insight68.loginTracking.IndividualPageTracing;
import com.insight68.loginTracking.IndividualPageTracingDTO;
import com.insight68.loginTracking.PageLoginLogoutTracing;
import com.insight68.loginTracking.PageLoginLogoutTracingDTO;
import com.insight68.models.ContactUs;
import com.insight68.models.Coupons;
import com.insight68.models.InsightUsers;
import com.insight68.models.LoginDetails;
import com.insight68.models.NumberOfLoginAttempts;
import com.insight68.models.Pricing;
import com.insight68.repositories.ContactsRepo;
import com.insight68.repositories.CouponsRepo;
import com.insight68.repositories.IndividualPageTracingRepo;
import com.insight68.repositories.InsightUsersRepo;
import com.insight68.repositories.LoginDetailsRepo;
import com.insight68.repositories.NumberOfLoginAtrtemptsRepo;
import com.insight68.repositories.PageTracingRepo;
import com.insight68.repositories.PricingRepo;
import com.insight68.security.JwtTokenProvider;
import com.insight68.utils.UtilClass;

@Service
public class AdminService {

	@Autowired
	InsightUsersRepo repo;

	@Autowired
	PricingRepo pricingRepo;

	@Value("${email}")
	String Email_Id;

	@Value("${password}")
	String password;

	@Autowired
	ContactsRepo contactUsRepo;

	@Autowired
	CouponsRepo couponsRepo;

	@Autowired
	LoginDetailsRepo loginDetailsRepo;

	@Autowired
	PageTracingRepo pageTracingRepo;

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Autowired
	NumberOfLoginAtrtemptsRepo numberOfLoginAtrtemptsRepo;

	@Autowired
	IndividualPageTracingRepo individualPageTracingRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// Returns all InsightUsers details saved using try for free forms
	public List<InsightUsersDTO> getAllTryForFreeUsers() {
		List<InsightUsers> insightUsers = getInsightUsers();
		List<InsightUsersDTO> insightUsersDTOs = new ArrayList<>();
		if (Objects.nonNull(insightUsers) && insightUsers.size() > 0) {
			for (InsightUsers insghtUser : insightUsers) {
				insightUsersDTOs.add(getInsightUser(insghtUser));
			}
		}
		return insightUsersDTOs;
	}

	// Converts InsightUsers to InsightUsersDTO
	private InsightUsersDTO getInsightUser(InsightUsers insightUser) {
		InsightUsersDTO insightUserDTO = new InsightUsersDTO();
		insightUserDTO.setFirstName(insightUser.getFirstName());
		insightUserDTO.setLastName(insightUser.getLastName());
		insightUserDTO.setEmailAddress(insightUser.getEmailAddress());
		insightUserDTO.setCompanyDomain(insightUser.getCompanyDomain());
		insightUserDTO.setCompanyName(insightUser.getCompanyName());
		insightUserDTO.setHowmanypeopleworkatyourcompany(insightUser.getHowmanypeopleworkatyourcompany());
		insightUserDTO.setWhatfielddoyouworkin(insightUser.getWhatfielddoyouworkin());
		insightUserDTO
				.setWhichofthefollowingbestdescribesyourrole(insightUser.getWhichofthefollowingbestdescribesyourrole());
		insightUserDTO.setWhichofthesesoundsmostlikeyou(insightUser.getWhichofthesesoundsmostlikeyou());
		insightUserDTO.setPhoneNumber(insightUser.getPhoneNumber());
		return insightUserDTO;
	}

	// gets InsightUsers from repository
	private List<InsightUsers> getInsightUsers() {
		return repo.findAllByOrderByLastModifiedDateDesc();
	}

	// Saves pricing plans
	public boolean savePricingDetails(Pricing pricing) {
		if ((Objects.nonNull(pricing.pricingPlans))
				|| Objects.nonNull(pricingRepo.findOneByPricingPlans(pricing.pricingPlans))) {
			Pricing existing = pricingRepo.findOneByPricingPlans(pricing.pricingPlans);
			UtilClass.copyNonNullProperties(pricing, existing);
			pricingRepo.save(existing);
			return true;
		} else {
			return false;
		}
	}

	// gets ContactUs Users from repository
	private List<ContactUs> getContactUsUsers() {
		return contactUsRepo.findAllByOrderByLastModifiedDateDesc();
	}

	// getAll Users for EnquiryForm
	public List<ContactUsDTO> getAllEnquiryUsers() {
		List<ContactUs> contactUsUsers = getContactUsUsers();
		List<ContactUsDTO> contactUsDTOs = new ArrayList<>();
		if (Objects.nonNull(contactUsUsers) && contactUsUsers.size() > 0) {
			for (ContactUs ContactUsUser : contactUsUsers) {
				contactUsDTOs.add(getcontactUsUser(ContactUsUser));
			}
		}
		return contactUsDTOs;
	}

	// Converts ContactUs user to ContactUsDTO
	private ContactUsDTO getcontactUsUser(ContactUs contactUsUser) {
		ContactUsDTO contactUsDTO = new ContactUsDTO();
		contactUsDTO.setfName(contactUsUser.getfName());
		contactUsDTO.setlName(contactUsUser.getlName());
		contactUsDTO.setEmailAddress(contactUsUser.getEmailAddress());
		contactUsDTO.setSubject(contactUsUser.getSubject());
		contactUsDTO.setSelectProduct(contactUsUser.getSelectProduct());
		contactUsDTO.setSocialMediaId(contactUsUser.getSocialMediaId());
		contactUsDTO.setWhatsappNumber(
				Objects.nonNull(contactUsUser.getWhatsappNumber()) ? contactUsUser.getWhatsappNumber() : "-");
		contactUsDTO.setMessage(contactUsUser.getMessage());
		return contactUsDTO;
	}

	// GetPricingbyPricingPlan
	private Pricing getPricingByPricingPlan(String pricingPlan) {
		return pricingRepo.findOneByPricingPlans(pricingPlan);
	}

	// Convert Pricing to PrincingDTO

	private PricingDTO getPrincing(Pricing pricing) {
		PricingDTO pricingDTO = new PricingDTO();
		pricingDTO.setAiModule(pricing.getAiModule());
		pricingDTO.setInventoryModule(pricing.getInventoryModule());
		pricingDTO.setSchedularOrderLogistics(pricing.getSchedularOrderLogistics());
		pricingDTO.setIrtClinicalStudied(pricing.getIrtClinicalStudied());
		return pricingDTO;
	}

	// Get Pricing Plan
	public PricingDTO getPricingByPlan(String pricingPlan) {
		Pricing pricing = getPricingByPricingPlan(pricingPlan);
		return getPrincing(pricing);
	}

	// Get Unique EmailID for Coupons
	public List<String> getUniqueEmailID() {
		// InsightUsers
		// return repo.findDistinctEmailAddress();
		// LoginCredentials
		return loginDetailsRepo.findDistinctEmail();
	}

	public boolean saveCouponsDetails(Coupons coupons) {
		couponsRepo.save(coupons);
		/*
		 * if (!verifyEmailAddress(coupons.getEmailAddress())) { LoginDetails
		 * loginDetails = new LoginDetails(); loginDetails.setUserName("User");
		 * loginDetails.setEmail(coupons.getEmailAddress());
		 * loginDetails.setPassword(passwordGenerator()); loginDetails.setRole("USER");
		 * loginDetailsRepo.save(loginDetails); }
		 */
		return true;
	}

//Coupons save and send Email
	public boolean saveCouponsDetailsAndSendEmail(Coupons coupons) throws AddressException, MessagingException {
		if (saveCouponsDetails(coupons)) {
			// mailCode
			// Mail for sending password message to User
			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");
			// LoginDetails loginDetails =
			// loginDetailsRepo.findOneByEmail(coupons.getEmailAddress());
			Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(Email_Id, password);
				}
			});

			Message message = new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress(Email_Id, "Insight68"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(coupons.getEmailAddress()));
			message.setSubject("Exclusive Discount on Insight68");
			message.setText("Hi " + UserNameByEmail(coupons.getEmailAddress()) + ",\r\n"
					+ "Congratulations! Our Insight68 team has recommended Insight68 " + coupons.getPlanName()
					+ " plan exclusively for you. \r\n" + "Use Coupon Code and get " + coupons.getDiscount()
					+ "% off on our " + coupons.getPlanName()
					+ " plan. Apply the Coupon Code and generate the invoice to discover the amazing deals offered by Insight68. \r\n"
					+ "Coupon Code: " + coupons.getCouponCode() + "\r\n"
					+ "\nNOTE: Coupon Code can be used only once. \r\n\n"
					+ "With insight68’s advanced technologies: \r\n"
					+ "•	Easily manage and monitor complex Batch and Discrete industrial manufacturing processes\r\n"
					+ "•	Collect and integrate data of all the departments of your industry \r\n"
					+ "•	Create and customize Dashboards and Reports to analyse the data to get detailed insight\r\n"
					+ "We promise an exciting experience with Insight68. So, get ready for an amazing journey.\r\n"
					+ "Kind Regards,\r\n" + "Team Insight68\r\n" + "sales@insight68.com\r\n");
			Transport.send(message);
		}
		return true;
	}

	public String UserNameByEmail(String email) {
		// From InsightUsers
		// return repo.findDistinctEmailAddress(email);
		return loginDetailsRepo.findDistinctUserName(email);
	}

	public boolean checkCouponsLimit(Coupons coupons) {
		if (!(Objects.nonNull(couponsRepo.findEmailAddress(coupons.getEmailAddress(), coupons.getPlanName())))) {
			return true;
		} else {
			return false;
		}
	}

	// Password Generator
	public String passwordGenerator() {

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();
		return generatedString;
	}

	// Verifies Email for login Credentials
	// Verifies whether User exists by email address or not
	public boolean verifyEmailAddress(String emailaddress) {
		if (Objects.nonNull(loginDetailsRepo.findByEmail(emailaddress))) {
			return true;
		} else {
			return false;
		}
	}

	// Creates User if email Id not Exists
	public boolean creteUserByadmin(LoginDetails loginDetails) {
		if (!verifyEmailAddress(loginDetails.getEmail())) {
			loginDetails.setPassword(bCryptPasswordEncoder.encode(loginDetails.getPassword()));
			loginDetails.setIsUserBlocked("ALLOWED");
			loginDetailsRepo.save(loginDetails);
			return true;
		}
		return false;
	}

	// Retruns everything from LoginDetails
	public List<LoginDetails> getAllLoginDetailsFromRepo() {
		// return loginDetailsRepo.findAll();
		// return loginDetailsRepo.findAllByOrderByIdDesc();
		return loginDetailsRepo.findAllByOrderByLastModifiedDateDesc();
	}

	// Retruns everything as LoginDetailsDTO list
	public List<LoginDetailsDTO> getAllLoginDetails(String zone) {
		List<LoginDetails> LoginDetails = getAllLoginDetailsFromRepo();
		List<LoginDetailsDTO> loginDetailsDTOs = new ArrayList<>();
		if (Objects.nonNull(LoginDetails) && LoginDetails.size() > 0) {
			for (LoginDetails LoginDetail : LoginDetails) {
				loginDetailsDTOs.add(getLoginedUser(LoginDetail, zone));
			}
		}
		return loginDetailsDTOs;
	}

	// Converts LoginDetails user to LoginDetailsDTO
	private LoginDetailsDTO getLoginedUser(LoginDetails loginDetails, String zone) {
		String pattern = "dd-MM-yyyy HH:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone(zone));
		LoginDetailsDTO loginDetailsDTO = new LoginDetailsDTO();
		String recentLoginTime = Objects.nonNull(loginDetails.getRecentLoginTime())
				? simpleDateFormat.format(loginDetails.getRecentLoginTime())
				: "-";
		String recentLogoutTime = Objects.nonNull(loginDetails.getRecentLogoutTime())
				? simpleDateFormat.format(loginDetails.getRecentLogoutTime())
				: "-";
		loginDetailsDTO.setEmail((loginDetails.getEmail()));
		loginDetailsDTO.setUserName(loginDetails.getUserName());
		loginDetailsDTO.setLastName(loginDetails.getLastName());
		loginDetailsDTO.setRole(loginDetails.getRole());
		loginDetailsDTO.setRecentLoginTime(recentLoginTime);
		loginDetailsDTO.setRecentLogoutTime(recentLogoutTime);
		return loginDetailsDTO;
	}

	// Get PageTracing Details
	public List<PageLoginLogoutTracing> getAllPageTracingDetailsFromRepo(String email) {
		// return pageTracingRepo.findAllByEmailOrderByIdDesc(email);
		// return pageTracingRepo.findAllByEmailOrderByUserLoginedTimeDesc(email);
		return pageTracingRepo.findAllByEmailOrderByLastModifiedDateDesc(email);
	}

	// Retruns everything as LoginDetailsDTO list
	public List<PageLoginLogoutTracingDTO> getAllPageTracingDetails(String email, String zone) {
		List<PageLoginLogoutTracing> pageTracingDetailsFromRepo = getAllPageTracingDetailsFromRepo(email);
		List<PageLoginLogoutTracingDTO> pageLoginLogoutTracingDTO = new ArrayList<>();
		if (Objects.nonNull(pageTracingDetailsFromRepo) && pageTracingDetailsFromRepo.size() > 0) {
			for (PageLoginLogoutTracing pageTracingDetail : pageTracingDetailsFromRepo) {
				pageLoginLogoutTracingDTO.add(getPageTracingForUser(pageTracingDetail, zone));
			}
		}
		return pageLoginLogoutTracingDTO;
	}

	private PageLoginLogoutTracingDTO getPageTracingForUser(PageLoginLogoutTracing pageTracingDetail, String zone) {
		String pattern = "dd-MM-yyyy HH:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone(zone));

		// Calucalte time difference
		// in milliseconds
		String userLoginTime = Objects.nonNull(pageTracingDetail.getUserLoginedTime())
				? simpleDateFormat.format(pageTracingDetail.getUserLoginedTime())
				: "-";
		String userLogoutTime = Objects.nonNull(pageTracingDetail.getUserLogoutTime())
				? simpleDateFormat.format(pageTracingDetail.getUserLogoutTime())
				: "-";
		PageLoginLogoutTracingDTO pageLoginLogoutTracingDTO = new PageLoginLogoutTracingDTO();
		pageLoginLogoutTracingDTO.setEmail(pageTracingDetail.getEmail());
		pageLoginLogoutTracingDTO.setUserLoginedTime(userLoginTime);
		pageLoginLogoutTracingDTO.setUserLogoutTime(userLogoutTime);
		pageLoginLogoutTracingDTO.setToken(pageTracingDetail.getToken());

		// Date Difference

		if ((Objects.nonNull(pageTracingDetail.getUserLoginedTime()))
				&& (Objects.nonNull(pageTracingDetail.getUserLogoutTime()))) {
			Date d1;
			try {
				d1 = simpleDateFormat.parse(userLoginTime);
				Date d2 = simpleDateFormat.parse(userLogoutTime);
				long difference_In_Time = d2.getTime() - d1.getTime();
				long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;
				pageLoginLogoutTracingDTO
						.setTotalTimeSpentOnWebsite(String.valueOf(difference_In_Minutes) + " minutes");
			} catch (ParseException e) {
				pageLoginLogoutTracingDTO.setTotalTimeSpentOnWebsite("-");
				e.printStackTrace();
			}
		} else {
			pageLoginLogoutTracingDTO.setTotalTimeSpentOnWebsite("-");
		}
		// Date Difference end
		return pageLoginLogoutTracingDTO;
	}

	// Check User Password by Email
	public boolean checkUserPassword(String oldPassword, String email) {
		LoginDetails existing = loginDetailsRepo.findByEmail(email);
		if (bCryptPasswordEncoder.matches(oldPassword, existing.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	// save Changed Password when Users enters first time
	public boolean saveChangedPassword(LoginDetails loginDetails) {
		if (Objects.nonNull(loginDetails.getPassword())) {
			loginDetails.setPassword(bCryptPasswordEncoder.encode(loginDetails.getPassword()));
			loginDetails.setFirstLoginStatus(false);
			LoginDetails existing = loginDetailsRepo.findByEmail(loginDetails.getEmail());
			UtilClass.copyNonNullProperties(loginDetails, existing);
			loginDetailsRepo.save(existing);
			return true;
		} else {
			return false;
		}
	}

	// Updating failed login attempts to block the user
	public boolean numberOfLoginAttempts(NumberOfLoginAttempts numberOfLoginAttempts) {
		if (Objects.nonNull(numberOfLoginAttempts)) {
			if (numberOfLoginAtrtemptsRepo.findAll().isEmpty()) {
				numberOfLoginAtrtemptsRepo.save(numberOfLoginAttempts);
				return true;
			} else {
				NumberOfLoginAttempts existing = numberOfLoginAtrtemptsRepo.findTopByOrderById();
				UtilClass.copyNonNullProperties(numberOfLoginAttempts, existing);
				numberOfLoginAtrtemptsRepo.save(existing);
				return true;
			}
		}
		return false;
	}

	// Security tab setting number of failure login attempts
	public Long AllowedNumberOfLoginAttempts() {
		if (Objects.nonNull(numberOfLoginAtrtemptsRepo.findTopByOrderById())) {
			return numberOfLoginAtrtemptsRepo.findTopByOrderById().getNumberOfLoginAttemptsToAllow();
		}
		return (long) 5;
	}

	// Number of failed login attempts by user
	public Long getLoginAttemptsNumber() {
		return Objects.nonNull(numberOfLoginAtrtemptsRepo.findTopByOrderById())
				? numberOfLoginAtrtemptsRepo.findTopByOrderById().getNumberOfLoginAttemptsToAllow()
				: 0;
	}

	// Get all records of individual pages by token and email
	public List<IndividualPageTracing> getAllIndividualPagesRecord(String email, String token) {
		return individualPageTracingRepo.findAllByEmailAndTokenOrderByLastModifiedDateAsc(email, token);
	}

	// DTOs of individual pages record
	// Retruns everything as IndividualPageTracingDTO list
	public List<IndividualPageTracingDTO> getAllPagesDetails(String email, String token, String zone) {
		List<IndividualPageTracing> individualPageTracings = getAllIndividualPagesRecord(email, token);
		List<IndividualPageTracingDTO> individualPageTracingsDTOs = new ArrayList<>();
		if (Objects.nonNull(individualPageTracings) && individualPageTracings.size() > 0) {
			for (IndividualPageTracing individualPageTracing : individualPageTracings) {
				individualPageTracingsDTOs.add(getPagesDetailsForUserLoginTime(individualPageTracing, zone));
			}
		}
		return individualPageTracingsDTOs;
	}

	// Convert individualPageTracing to individualPageTracingDTO
	private IndividualPageTracingDTO getPagesDetailsForUserLoginTime(IndividualPageTracing individualPageTracing,
			String zone) {
		String pattern = "dd-MM-yyyy HH:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone(zone));
		// Calucalte time difference
		// in milliseconds
		String pageEnterTime = Objects.nonNull(individualPageTracing.getPageEnteredTime())
				? simpleDateFormat.format(individualPageTracing.getPageEnteredTime())
				: "-";
		String pageExitTime = Objects.nonNull(individualPageTracing.getPageExitedTime())
				? simpleDateFormat.format(individualPageTracing.getPageExitedTime())
				: "-";
		IndividualPageTracingDTO individualPageTracingDTO = new IndividualPageTracingDTO();
		individualPageTracingDTO.setPageEnteredName(individualPageTracing.getPageEnteredName());
		individualPageTracingDTO.setPageEnteredTime(pageEnterTime);
		individualPageTracingDTO.setPageExitedTime(pageExitTime);
		// System.out.println(pageEnterTime +"-"+pageExitTime);
		// Date Difference
		if ((Objects.nonNull(individualPageTracing.getPageEnteredTime()))
				&& (Objects.nonNull(individualPageTracing.getPageExitedTime()))) {
			Date d1;
			try {
				d1 = simpleDateFormat.parse(pageEnterTime);
				Date d2 = simpleDateFormat.parse(pageExitTime);
				long difference_In_Time = d2.getTime() - d1.getTime();
				long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;
				individualPageTracingDTO.setTotalTimeSpentOnPage(String.valueOf(difference_In_Minutes) + " minutes");
			} catch (ParseException e) {
				individualPageTracingDTO.setTotalTimeSpentOnPage("-");
				e.printStackTrace();
			}
		} else {
			individualPageTracingDTO.setTotalTimeSpentOnPage("-");
		}
		// Date Difference end

		return individualPageTracingDTO;
	}

}
