package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.tests.TestBase;
import com.utility.BrowserUtility;

public final class ProductDetailPage extends BrowserUtility{

	private static final By SIZE_DROPDOWN_LOCATOR=By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_LOCATOR=By.id("add_to_cart");
	private static final By PROCEED_TO_CHECKOUT_LINK_LOCATOR=By.xpath("//*[@class='btn btn-default button button-medium']");

	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}

	public ProductDetailPage changeSize(Size size) {
		selectFromDropDown( SIZE_DROPDOWN_LOCATOR,size.toString());
		return new ProductDetailPage(getDriver());
	}

	public ProductDetailPage addProductToCart() throws InterruptedException {
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailPage(getDriver());
	}

	public ShoppingCartPage proceedToCheckOutFromProductPage() {
		clickOn(PROCEED_TO_CHECKOUT_LINK_LOCATOR);
		return new ShoppingCartPage(getDriver());
	}
}
