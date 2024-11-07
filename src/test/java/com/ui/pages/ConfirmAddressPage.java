package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class ConfirmAddressPage extends BrowserUtility {

	private static final By PROCEED_TO_CHECKOUT=By.xpath("//button[@name='processAddress']");

	public ConfirmAddressPage(WebDriver driver) {
		super(driver);
	}

	public ShippingPage goToShipmentPage() {
		clickOn(PROCEED_TO_CHECKOUT);
		return new ShippingPage(getDriver());
		
	}
	
}
