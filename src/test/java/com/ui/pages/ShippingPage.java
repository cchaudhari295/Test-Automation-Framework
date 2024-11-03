package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingPage extends BrowserUtility {

	private static final By ACCEPT_TERMS_CHECKBOX_LOCATOR=By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT=By.xpath("//button[@name='processCarrier']");

	public ShippingPage(WebDriver driver) {
		super(driver);
	}

	public ShippingPage clickOnTermsAndConditions() {
		clickOn(ACCEPT_TERMS_CHECKBOX_LOCATOR);
		return new ShippingPage(getDriver());
	}
	
	public PaymentPage goToPaymentPage() {
		clickOn(PROCEED_TO_CHECKOUT);
		return new PaymentPage(getDriver());
	}
}
