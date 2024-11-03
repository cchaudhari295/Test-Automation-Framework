package com.ui.tests;

import static com.ui.pages.Size.L;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase{
    private SearchResultPage searchResultPage;
    private static final String SEARCH_TERM="Printed Summer Dress";
    private static final String ORDER_CONFIRMATION_MSG="Your order on My Shop is complete.";
    
	@BeforeMethod(description="Valid user logs into the application and searches for the product")
	public void setUp() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("logag61737@jameagle.com", "password").searchForAProduct(SEARCH_TERM);
	}
	
	@Test
	public void addToCartTest() throws InterruptedException {
		String result=searchResultPage.clickOnTheProductAtIndex(0).changeSize(L).addProductToCart().proceedToCheckOutFromProductPage().goToConfirmAddressPage().goToShipmentPage().clickOnTermsAndConditions().goToPaymentPage().placeOrderByPayByCheck().getOrderCompletionMsg();
		assertEquals(result, ORDER_CONFIRMATION_MSG);
	}
	
}
