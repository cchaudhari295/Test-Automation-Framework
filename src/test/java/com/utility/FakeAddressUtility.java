package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {

	public static AddressPOJO getFakeAddress() {
		Faker faker=new Faker(Locale.US);
		AddressPOJO addressPojo=new AddressPOJO(faker.company().name(),faker.address().streetName(),faker.address().streetAddress(),faker.address().city(),faker.address().zipCode(),faker.phoneNumber().cellPhone(),faker.phoneNumber().cellPhone(),"other", "office address",faker.address().state());
		return addressPojo;
	}
}
