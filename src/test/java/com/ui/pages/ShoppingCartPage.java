package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class ShoppingCartPage extends BrowserUtility {

	private final static By ADDED_PRODUCT_TEXT_LOCATOR=By.xpath("//*[@class='cart_description']/p[@class='product-name']/a");
	private final static By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR=By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']");
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	public String getAddedProductInCart() {
		return getVisibleText(ADDED_PRODUCT_TEXT_LOCATOR);
	}

	public ConfirmAddressPage goToConfirmAddressPage() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ConfirmAddressPage(getDriver());
	}
	
}
