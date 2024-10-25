package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest1 {

	public static void main(String[] args) {
		
		WebDriver wb = new ChromeDriver();
		wb.get("http://www.automationpractice.pl/index.php");
		wb.manage().window().maximize();
		By signInLinkLocator=By.xpath("//a[contains(text(),'Sign in')]");
		WebElement signInLinkWebElement=wb.findElement(signInLinkLocator);
		signInLinkWebElement.click();
		
		
		By emailTextBoxLocator=By.id("email");
		WebElement emailTextBoxWebElement=wb.findElement(emailTextBoxLocator);
		emailTextBoxWebElement.sendKeys("test@gmail.com");
		
		By passwordTextBoxLocator=By.id("passwd");
		WebElement passwordTextBoxWebElement=wb.findElement(passwordTextBoxLocator);
		passwordTextBoxWebElement.sendKeys("test@gmail.com");	
		
		
		By submitLoginButtonLocator=By.id("SubmitLogin");
		WebElement submitLoginButtonWebElement=wb.findElement(submitLoginButtonLocator);
		submitLoginButtonWebElement.click();
	}

}
