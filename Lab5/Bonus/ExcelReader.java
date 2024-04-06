package com.company.command;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    public static void main(String[] args) {
        try {
            // Creăm un obiect XSSFWorkbook din fișierul de intrare
            try (FileInputStream file = new FileInputStream(new File("path_to_excel_file.xlsx"))) {
                // Creăm un obiect XSSFWorkbook din fișierul de intrare
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                
                // Obținem prima foaie de lucru din caietul de lucru
                XSSFSheet sheet = workbook.getSheetAt(0);
                
                // Parcurgem fiecare rând din foaia de lucru
                for (Row row : sheet) {
                    // Parcurgem fiecare celulă din rândul curent
                    for (Cell cell : row) {
                        // Afișăm valoarea celulei
                        System.out.print(cell.toString() + "\t");
                    }
                    System.out.println();
                }

                // Închidem fișierul de lucru
                workbook.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
