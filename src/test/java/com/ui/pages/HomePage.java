package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static final By SIGNINLINKLOCATOR = By.xpath("//a[contains(text(),'Sign in')]");

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(Env.QA).getUrl());
		maximizeWindow();
	
	}
	

	
	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);
		// goToWebsite(readProperty(QA, "URL"));
		goToWebsite(JSONUtility.readJSON(Env.QA).getUrl());
		maximizeWindow();
	
	}



	public LoginPage goToLoginPage() {
		logger.info("Clicking on SignIn Link");
		clickOn(SIGNINLINKLOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	

}
