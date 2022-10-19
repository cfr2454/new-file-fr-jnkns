package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcellRead {

    @Test
    public void read_from_excell_file() throws IOException {

        String path= "SampleData.xlsx";

        //File file = new File(path);(videoda geçen ve atlanan konu);
        //to read from excell we need to load it to fileInput Stream
        FileInputStream fileInputStream = new FileInputStream(path);

        //workbook>sheet>row>cell

        //<2> create a work book
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //we need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        //3 select row and cell
        //point out mary's cell
        //Indexes start from 0
        System.out.println(sheet.getRow(1).getCell(0));

        //print out developer
        System.out.println(sheet.getRow(3).getCell(2));

        //Return the count of used cells only
        //Starts counting from 1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        //Returns the numnber from top cell to bottom cell
        //it doesn't care if the cell is empty or not
        //starts counting from 0
        int lastUsedRaw = sheet.getLastRowNum();
        System.out.println(lastUsedRaw);

        //todo: create a logic to print Vinod's name
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }  }
                // todo: create a logic to print out Linda's Job ID
                //check if name is Linda -->print out Job_ID of Linda

                for (int rownum = 0; rownum < usedRows; rownum++) {
                    if(sheet.getRow(rownum).getCell(0).toString().equals("Linda")){
                        System.out.println("Linda's Job_ID "+ sheet.getRow(rownum).getCell(2));
                    }




        }


    }
}
