package com.pages;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Report {
	Row row;
	Cell cell;
	String path;
	private static Report instance;
	Workbook xl;;
    Sheet sheet;;

	private Report() {
		if(instance == null)
		{
			xl = new XSSFWorkbook();
			sheet =  xl.createSheet("Report");
			row = sheet.createRow(0);
			row.createCell(0).setCellValue("S/N");
			row.createCell(1).setCellValue("Title");
			row.createCell(2).setCellValue("Server Up");
		}
		
	}
	
	public static Report getInstance() {
        if (instance == null) {
            instance = new Report();
        }
        return instance;
    }
	
	public void addReport(int rowValue, String Title, String value) throws IOException {
		row = sheet.createRow(rowValue);
		row.createCell(0).setCellValue(rowValue);
		row.createCell(1).setCellValue(Title);
		row.createCell(2).setCellValue(value);
	}

	public void save() throws IOException {
		// TODO Auto-generated method stub
		LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd_HH-mm-ss");
        String timestamp = currentTime.format(formatter);
		path = System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\file"+timestamp+".xlsx";
		FileOutputStream fileOut = new FileOutputStream(path);
		xl.write(fileOut);
		fileOut.close();
	}
}
