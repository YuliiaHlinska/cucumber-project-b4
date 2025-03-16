package io.loop.utilities;

public class TestExcel {
    public static void main(String[] args) {


        ExcelUtils excelUtils = new ExcelUtils("C:\\Users\\admin\\IdeaProjects\\cucumber-project-b4\\src\\test\\resources\\Book1.xlsx", "Sheet1");

        System.out.println("excelUtils.getCellData(0,0) = " + excelUtils.getCellData(0, 0));

        excelUtils.setCellData("Yuliia is more sleepy, then Nadir", 3,4);
        System.out.println("excelUtils.getCellData(3,4) = " + excelUtils.getCellData(3, 4));


    }

}
