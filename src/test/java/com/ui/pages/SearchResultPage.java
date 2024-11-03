package com.ui.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {
	private static final By PRODUCT_LISTS_NAME=By.xpath("//*[@itemprop='name']/a[@class='product-name']");
	private static final By PRODUCT_LISTING_TITLE_LOCATOR=By.xpath("//*[@class='lighter']");


	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	public String getSearchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}
	
	public boolean isSearchTermPresentInProductList(String searchTerm) {
		
		List<String> keywords=Arrays.asList(searchTerm.toLowerCase());
		List<String> productNamesList=getAllVisibleText(PRODUCT_LISTS_NAME);
		boolean result=productNamesList.stream().anyMatch(name->(keywords.stream().anyMatch(name.toLowerCase()::contains)));
		return result;
	}
	
	public ProductDetailPage clickOnTheProductAtIndex(int index) throws InterruptedException {
		clickOn(getAllElements(PRODUCT_LISTS_NAME).get(index));
		return new ProductDetailPage(getDriver());
	}

}
