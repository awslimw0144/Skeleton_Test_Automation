package com.mainDemo.pojo;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class ExcelMain {
    private Workbook workbook;

    public ExcelMain(String filePath){
        try {
            this.workbook = WorkbookFactory.create(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    public Sheet getWorksheet(String sSheetName){
        return this.workbook.getSheet(sSheetName);
    }
}
