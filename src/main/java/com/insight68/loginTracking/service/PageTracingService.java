package com.insight68.loginTracking.service;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insight68.loginTracking.IndividualPageTracing;
import com.insight68.loginTracking.PageLoginLogoutTracing;
import com.insight68.models.LoginDetails;
import com.insight68.repositories.IndividualPageTracingRepo;
import com.insight68.repositories.LoginDetailsRepo;
import com.insight68.repositories.PageTracingRepo;
import com.insight68.utils.UtilClass;

@Service
public class PageTracingService {

	@Autowired
	PageTracingRepo pageTracingRepo;

	@Autowired
	LoginDetailsRepo loginDetailsRepo;

	@Autowired
	IndividualPageTracingRepo individualPageTracingRepo;

	public boolean savePageDetails(PageLoginLogoutTracing pageLoginLogoutTracing) {
		if (Objects.nonNull(pageLoginLogoutTracing)) {
			pageTracingRepo.save(pageLoginLogoutTracing);
			return true;
		}
		return false;
	}

	// Update Login/Logout Time of Users
	public boolean updateLoginLogoutDetails(LoginDetails loginDetails) {
		if (Objects.nonNull(loginDetailsRepo.findByEmail(loginDetails.getEmail()))) {
			LoginDetails existing = loginDetailsRepo.findByEmail(loginDetails.getEmail());
			if (existing.isFirstLoginStatus()) {
				loginDetails.setFirstLoginStatus(true);
			} else {
				loginDetails.setFirstLoginStatus(false);
			}
			UtilClass.copyNonNullProperties(loginDetails, existing);
			loginDetailsRepo.save(existing);
			return true;
		} else {
			return false;
		}
	}

	// Update logout Time when user logout
	public boolean updateLoginLogoutDetailsinPageTracing(PageLoginLogoutTracing pageLoginLogoutTracing) {
		if (Objects.nonNull(pageTracingRepo.findByEmailAndToken(pageLoginLogoutTracing.getEmail(),
				pageLoginLogoutTracing.getToken()))) {
			PageLoginLogoutTracing existing = pageTracingRepo.findByEmailAndToken(pageLoginLogoutTracing.getEmail(),
					pageLoginLogoutTracing.getToken());
			Date date = new Date();
			pageLoginLogoutTracing.setUserLogoutTime(date);
			UtilClass.copyNonNullProperties(pageLoginLogoutTracing, existing);
			pageTracingRepo.save(existing);
			// On logout updating recent logout time
			if (Objects.nonNull(loginDetailsRepo.findByEmail(pageLoginLogoutTracing.getEmail()))) {
				LoginDetails loginDetails = loginDetailsRepo.findByEmail(pageLoginLogoutTracing.getEmail());
				loginDetails.setRecentLogoutTime(date);
				updateLoginLogoutDetails(loginDetails);
			}
			// On logout updating recent page exited time
			if (Objects.nonNull(individualPageTracingRepo.findFirstByTokenAndEmailOrderByLastModifiedDateDesc(
					pageLoginLogoutTracing.getToken(), pageLoginLogoutTracing.getEmail()))) {
				IndividualPageTracing previousPage = individualPageTracingRepo
						.findFirstByTokenAndEmailOrderByLastModifiedDateDesc(pageLoginLogoutTracing.getToken(),
								pageLoginLogoutTracing.getEmail());
				previousPage.setPageExitedTime(date);
				individualPageTracingRepo.save(previousPage);
			}
			return true;
		} else {
			return false;
		}
	}

	// Individual Page Tracing Code
	public boolean saveIndividualPageDetails(IndividualPageTracing individualPageTracing) {
		if (Objects.nonNull(individualPageTracing)) {
			Date date = new Date();
			// Updating previous visited Page pageExit time and time spent calculation
			if (Objects.nonNull(individualPageTracingRepo.findFirstByTokenAndEmailOrderByLastModifiedDateDesc(
					individualPageTracing.getToken(), individualPageTracing.getEmail()))) {
				IndividualPageTracing previousPage = individualPageTracingRepo
						.findFirstByTokenAndEmailOrderByLastModifiedDateDesc(individualPageTracing.getToken(),
								individualPageTracing.getEmail());
				previousPage.setPageExitedTime(date);
				individualPageTracingRepo.save(previousPage);
			}
			individualPageTracing.setPageEnteredTime(date);
			if (Objects.nonNull(individualPageTracing.getPageEnteredName())) {
				individualPageTracingRepo.save(individualPageTracing);
			}
			return true;
		}
		return false;
	}

}
