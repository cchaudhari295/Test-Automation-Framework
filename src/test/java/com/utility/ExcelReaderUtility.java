package com.utility;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.UserDetails;

public class ExcelReaderUtility {

	public static Iterator<UserDetails> readExcelFile(String fileName) {

		File xlsxFile = new File(System.getProperty("user.dir") + "//testData//" + fileName);
		XSSFWorkbook xssfWorkbook;
		Iterator<Row> rowIterator;
		XSSFSheet xssfSheet;
		UserDetails userDetails;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		List<UserDetails> userList = null;
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			xssfSheet = xssfWorkbook.getSheet("LoginTestData");
		    userList = new ArrayList<UserDetails>();
			rowIterator = xssfSheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				userDetails = new UserDetails(emailAddressCell.toString(), passwordCell.toString());
				userList.add(userDetails);
				xssfWorkbook.close();
			}

		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}

}
