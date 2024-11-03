package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listeners.TestListener.class)

public class SearchProductTest extends TestBase {

	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "Printed Summer Dress";

	@BeforeMethod(description = "Valid user logs into the application")
	public void setUp() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("logag61737@jameagle.com", "password");
	}

	@Test(description = "Verify if the logged in user is able to search for a product and proper search results are displayed ", groups = {
			"e2e", "Smoke", "Sanity" }, retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void verifyProductSearchTest() {
		boolean actualResult = myAccountPage.searchForAProduct(SEARCH_TERM)
				.isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}
}
