package com.automation.tests.day28;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class WriteIntoExcel {

    @Test
    public void writeIntoFileTest() throws IOException {
        FileInputStream inputStream = new FileInputStream("VytrackTestUsers.xlsx");
        //if file is locked then we need to provide password after inputStream
        Workbook workbook = WorkbookFactory.create(inputStream);
        inputStream.close();// we need to close it if not autoclosable

        Sheet sheet = workbook.getSheet("QA3-short");
        Row row = sheet.getRow(1); // 2nd row
       //Cell cell = row.getCell(row.getPhysicalNumberOfCells()); or we can use this code
       // Cell cell = row.getCell(row.getLastCellNum() - 2);//last column //index starts from 0 thats' why we need to put -1 to get last cell
            Cell cell = row.getCell(5); // get result column

        System.out.println("Before: " + cell.getStringCellValue());
        cell.setCellValue("FAILED"); //I am changing from n/a to  passed
        System.out.println("After: " + cell.getStringCellValue());

        //this will create new column after last cell on first row.
        Row firstRow = sheet.getRow(0); // creating object of first row
        //Cell newCell = firstRow.createCell(row.getLastCellNum());// create new cell
        Cell newCell = firstRow.createCell(6);
        newCell.setCellValue("Date of execution"); // give the name to this cell

        //write date and time info into second row, last column
        Row secondRow = sheet.getRow(1);
        Cell newCell2 = secondRow.createCell(6);
        //Cell newCell2 = secondRow.createCell(row.getLastCellNum()); // to create a cell
        newCell2.setCellValue(LocalDateTime.now().toString());//I will set current date and time info into new cell


        // write these changes / I create if I want to write something into the file
        // DON"T forget to close excel file if you opened it.
        FileOutputStream outputStream = new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();




    }

}
