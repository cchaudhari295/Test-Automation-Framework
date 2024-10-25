package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.UserDetails;

public class CSVReaderUtility {
	public static Iterator<UserDetails> readCSVFile(String fileName) {
		File csvFile = new File(System.getProperty("user.dir") + "//testData//"+fileName);
		FileReader fileReader;
		CSVReader csvReader;
		String[] line;
		UserDetails userDetails;
		List<UserDetails> userList = null;
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();
			userList = new ArrayList<UserDetails>();
			while ((line = csvReader.readNext()) != null) {
				userDetails = new UserDetails(line[0], line[1]);
				userList.add(userDetails);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}
}
