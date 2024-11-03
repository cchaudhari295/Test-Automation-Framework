package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.UserDetails;

@Listeners(com.ui.listeners.TestListener.class)
public class InvalidCredLoginTest extends TestBase{

	private static final String INVALID_EMAIL_ADDRESS="test@gmail.com";
	private static final String INVALID_PASSWORD="password";
	
	@Test(description="Verify that proper error message is shown when the user enters invalid credentials",groups= {"e2e","Sanity"},
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTestWithInvalidDetails() {
		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD).getErrorMessage(),"Authentication failed.");
	}
}
