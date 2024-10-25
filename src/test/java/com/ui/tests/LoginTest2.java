package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTest2 {

	public static void main(String[] args) {
		
		WebDriver wb = new ChromeDriver();
		HomePage homePage=new HomePage(wb);
		LoginPage loginPage=homePage.goToLoginPage();
		loginPage.doLoginWith("logag61737@jameagle.com", "password");
		
	}

}
