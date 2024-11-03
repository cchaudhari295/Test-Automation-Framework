package com.ui.tests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewAddressTest extends TestBase{

	private MyAccountPage myAccountPage;
	private AddressPOJO address;
	
	@BeforeMethod(description="Valid first time user logs into the application")
	public void setUp() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("logag61737@jameagle.com", "password");
		address=FakeAddressUtility.getFakeAddress();
	}
	
	
	@Test
	public void addNewAddress() {
		String newAddress=myAccountPage.goToAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
	}
	
}
