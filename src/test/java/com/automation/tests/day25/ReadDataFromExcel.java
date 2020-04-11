package com.automation.tests.day25;

import com.automation.utilities.ExcelUtil;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReadDataFromExcel {

    @Test(description = "get the first row and cell from excel file")
    public void readExcelFileText() throws IOException {
        //we need to get a file as an object
        //path->location of the file
        File file = new File("VytrackTestUsers.xlsx");
        //object that represents excel file
        //workbook coming from Apache, usually all files create throws exception
        Workbook workbook = WorkbookFactory.create(file);
        //sheet we want to open / get QA!-short
        Sheet workSheet = workbook.getSheet("QA1-short");
        //get 1st row
        Row firstRow = workSheet.getRow(0);
        //get 1st cell
        Cell firstCell = firstRow.getCell(0);

        String value = firstCell.getStringCellValue();
        String secondCellValue = firstRow.getCell(1).getStringCellValue();

        System.out.println(value);
        System.out.println(secondCellValue);

        int lastCell = firstRow.getLastCellNum();
        System.out.println("=========================");
        for(int i=0; i<lastCell;i++){
            System.out.print(firstRow.getCell(i)+" | ");
        }
        System.out.println();
        System.out.print("==============================");
        System.out.println();

        // this code wil print out all excel spreadsheet with iterator
        //this code is optional not related to class
//        Sheet worksheet=workbook.getSheet("QA1-short");
//        Iterator<Row> rows=worksheet.rowIterator();
//        while(rows.hasNext()) {
//            Iterator<Cell> cells = rows.next().cellIterator();
//            while (cells.hasNext()) {
//                System.out.print(cells.next().getStringCellValue() + " ");
//            }
//
//        }
//            System.out.println();

            // to get number of rows
            //last row is 16th --> index is 15
            //index of last row
            int numberOfRows = workSheet.getLastRowNum(); // to gethe last row ex: 16 index is 15
            //returns how many rows at all
            int numberOfRows2 = workSheet.getPhysicalNumberOfRows();

            System.out.println("\nIndex of last row = " + numberOfRows);
            System.out.println("\nnumberOfRows2 = " + numberOfRows2);

        System.out.println("====================================");

        for(int row = 0; row <workSheet.getPhysicalNumberOfRows(); row++){
            for(int cell =0; cell <workSheet.getRow(row).getLastCellNum(); cell++){
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.print(cellValue + " | ");
            }
            System.out.println();
        }
    }

        @Test
        public void excelUtilityTest(){
            String path = "VytrackTestUsers.xlsx";
            String spreadSheet = "QA1-all";
            ExcelUtil excelUtil = new ExcelUtil(path,spreadSheet);
         // excelUtil.getDataList().forEach(System.out::println);//shortcut for For each loop

            //getDataList returns list of data in spreadsheet
            for(Map<String,String> record: excelUtil.getDataList()){
                System.out.println(record);
            }

        }

        @Test(description = "Getting column names")
        public void getColumnNamesTest(){
            String path = "VytrackTestUsers.xlsx";
            String spreadSheet = "QA1-short";
            ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);

            System.out.println(excelUtil.getColumnsNames());
        }


        @Test(description = "test from Muhtar's class")
        public void readExcelTest(){
        //create an instance of the excel utility
            //argument 1: location of the file
            //argument 2: sheet we want to open
            //when we create object of this utility it means we opened the file and accessed certain sheet inside it
        ExcelUtil qa1short = new ExcelUtil("VytrackTestUsers.xlsx", "QA1-short");
            // get number of columns
            System.out.println("columnCount = " +qa1short.columnCount());
            //get all column names
            System.out.println(qa1short.getColumnsNames());

            //get all data
            List<Map<String, String>> dataList = qa1short.getDataList();
            for(Map<String,String> stringStringMap : dataList ){
                System.out.println(stringStringMap);

            }

            //get all data in 2D array

            String[][] dataArray = qa1short.getDataArray();
            System.out.println("===============================");
            System.out.println(Arrays.deepToString(dataArray));

        }




    }

