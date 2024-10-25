package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.UserDetails;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider(name="LoginTestDataProvider")
	public Iterator<Object[]> loginJsonDataProvider() {
		File testDataFile = new File(System.getProperty("user.dir") + File.separator + "testData" + File.separator + "logindata.json");

		FileReader fileReader = null;
		try {
			fileReader = new FileReader(testDataFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		TestData testData = gson.fromJson(fileReader, TestData.class);

		List<Object[]> dataToReturn = new ArrayList<Object[]>();

		for (UserDetails userDetails : testData.getData()) {
			dataToReturn.add(new Object[] { userDetails });

			
		}
		return dataToReturn.iterator();
	}
	
	@DataProvider(name="LoginTestCSVDataProvider")
	public Iterator<UserDetails> loginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("loginData.csv");
	}
	

	@DataProvider(name="LoginTestExcelDataProvider")
	public Iterator<UserDetails> loginExcelDataProvider() {
		return ExcelReaderUtility.readExcelFile("loginData.xlsx");
	}
}
