package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class OrderConfirmationPage extends BrowserUtility {

	private static final By ORDER_CONFIRMATION_MSG_TEXT_LOCATOR=By.xpath("//*[@class='alert alert-success']");

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}

	public String getOrderCompletionMsg() {
		return getVisibleText(ORDER_CONFIRMATION_MSG_TEXT_LOCATOR);	
	}
}
