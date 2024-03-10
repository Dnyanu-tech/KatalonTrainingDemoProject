package com.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")
	public String[][] getAllData(Method method) throws IOException {
		ExcelDataSourceInfo info = method.getAnnotation(ExcelDataSourceInfo.class);
		String fileName = info.fileName();
		String sheet = info.sheetName();

		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\" + fileName;
		XLUtility xl = new XLUtility(path);
		int rowNum = xl.getRowCount(sheet);
		int colCount = xl.getCellCount(sheet, 1);

		String apiData[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				apiData[i - 1][j] = xl.getCellData(sheet, i, j);
			}
		}
		return apiData;
	}

	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\UserData.xlsx";
		XLUtility xl = new XLUtility(path);

		int rowNum = xl.getRowCount("Sheet1");
		String apiData[] = new String[rowNum];

		for (int i = 1; i <= rowNum; i++) {
			apiData[i - 1] = xl.getCellData("Sheet1", i, 1);
		}

		return apiData;
	}
}
