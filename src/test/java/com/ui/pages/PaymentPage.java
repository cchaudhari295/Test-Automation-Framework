package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class PaymentPage extends BrowserUtility{
	private static final By PAY_BY_CHECK_BUTTON_LOCATOR=By.xpath("//*[@title='Pay by check.']");
	private static final By CONFIRM_MY_ORDER_BUTTON_LOCATOR=By.xpath("//*[@class='button btn btn-default button-medium']");

	public PaymentPage(WebDriver driver) {
		super(driver);
	}


	public OrderConfirmationPage placeOrderByPayByCheck() {
		clickOn(PAY_BY_CHECK_BUTTON_LOCATOR);
		clickOn(CONFIRM_MY_ORDER_BUTTON_LOCATOR);
		return new OrderConfirmationPage(getDriver());
	}
	

	
}
