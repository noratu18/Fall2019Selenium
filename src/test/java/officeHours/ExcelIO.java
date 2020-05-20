package officeHours;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Date;

public class ExcelIO {

    @Test
    public void creteExcelFileTest() throws IOException {

        //how to create a file? We need to create a class File and provide path
        // user.dir is general,this one will create new excel g=file everytime
       // File file = new File(System.getProperty("user.dir")+"/regression_test_result.xlsx");
        String filepath = System.getProperty("user.dir")+ File.separator + "VytrackTestUsers(1).xlsx";
        FileInputStream file = new FileInputStream(filepath);
       // file.createNewFile();//to create new file
        Workbook workbook = WorkbookFactory.create(file); //
        file.close();
        //Sheet sheet = workbook.createSheet("test_output");
        Sheet sheet = workbook.getSheet("QA3-short");
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(5);


        System.out.println(cell);
        cell.setCellValue("FAILED"); // to modify cell value
        System.out.println(cell);
        //to write changes into the file
        FileOutputStream fileOutputStream = new FileOutputStream(filepath);
        workbook.write(fileOutputStream);
        fileOutputStream.close();

        workbook.close();


    }

    @Test
    public void createFile() throws IOException {
        File file = new File("regression_test_results.xlsx");
        boolean isCreated = file.createNewFile(); // to create new file

        //used to get data INTO that file we created
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.close(); // don't forget to close

        //new excel .xlsx file object
        //XSSFWorkbook --> is class extends extends POIXMLDocument implements Workbook, Date1904Support
        XSSFWorkbook workbook = new XSSFWorkbook();
        //new worksheet name
        Sheet sheet = workbook.createSheet("test_results");

        Row firstRow = sheet.createRow(0);//create first row
        Cell firstCell = firstRow.createCell(0);// to create first Cell

        Row secondRow = sheet.createRow(1);//to create second row
        Cell secondCell = secondRow.createCell(0);// create cell into the second column

        firstCell.setCellValue("Test Status"); // to write into cell
        secondCell.setCellValue("PASSED");

        //to write excel object into file
        //new Date() -->
        //     * Allocates a {@code Date} object and initializes it so that
        //     * it represents the time at which it was allocated, measured to the
        //     * nearest millisecond.
        FileOutputStream fileOutputStream = new FileOutputStream(new Date() + "_regression_test_results.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
