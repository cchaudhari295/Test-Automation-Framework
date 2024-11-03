package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			System.out.println(driver);
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			System.err.println("Invalid Browser Name..BrowserUtility.Please select Chrome or Edge");
		}
	}

	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}

		else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			System.err.println("Invalid Browser Name..BrowserUtility.Please select Chrome or Edge");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

			else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		}

		else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

			else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else {
			System.err.println("Invalid Browser Name..BrowserUtility.Please select Chrome or Edge");
		}
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void goToWebsite(String url) {
		logger.info("Visting the website");
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding Element with the locator" + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Element Found and now performing Click");
		element.click();
	}
	
	public void clickOnCheckbox(By locator) {
		logger.info("Finding Element with the locator" + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element Found and now performing Click");
		element.click();
	}


	public void clickOn(WebElement element) {
		logger.info("Element Found and now performing Click");
		element.click();
	}

	public void enterText(By locator, String value) {
		logger.info("Finding Element with the locator" + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element Found and now enter text " + locator);
		element.sendKeys(value);
	}

	public void clearText(By locator) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element Found and clearing the text box field");
		element.clear();
	}

	public void enterSpecialKeys(By locator, Keys keyToEnter) {
		logger.info("Finding Element with the locator" + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element Found and now enter text " + locator);
		element.sendKeys(keyToEnter);
	}

	public void selectFromDropDown(By locator, String optionToSelect) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		Select select = new Select(element);
		logger.info("Selecting the option " + optionToSelect);
		select.selectByVisibleText(optionToSelect);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element Found and now returning the visibile " + element.getText());
		return element.getText();
	}

	public String getVisibleText(WebElement element) {
		logger.info("Returning the visibile Text" + element.getText());
		return element.getText();
	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding All Elements with the locator" + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements Found and now printing the List of Elements");
		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;
	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding All Elements with the locator" + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements Found");
		return elementList;
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE); // get data in file format
		String path = "./screenshot/" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public void quit() {
		driver.get().quit();
	}

}
