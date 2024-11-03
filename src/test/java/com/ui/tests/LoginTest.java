package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.UserDetails;
import com.utility.LoggerUtility;


@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase {
	
	@Test(description="Verify that user is able to login into the application",groups= {"e2e","Sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider")
	public void loginTest(UserDetails userDetails) {
		assertEquals(homePage.goToLoginPage().doLoginWith(userDetails.getEmailAddress(), userDetails.getPassword())
				.getUserName(), "James Eagl");
		
	}
	
	@Test(description="Verify that user is able to login into the application",groups= {"e2e","Sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestCSVDataProvider")
	public void loginCSVTest(UserDetails userDetails) {
		assertEquals(homePage.goToLoginPage().doLoginWith(userDetails.getEmailAddress(), userDetails.getPassword())
				.getUserName(), "James Eagle");
		
	}
	
	@Test(description="Verify that user is able to login into the application",groups= {"e2e","Sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestExcelDataProvider",retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(UserDetails userDetails) {
		assertEquals(homePage.goToLoginPage().doLoginWith(userDetails.getEmailAddress(), userDetails.getPassword())
				.getUserName(), "James Eagle");
		
	}
	


}
