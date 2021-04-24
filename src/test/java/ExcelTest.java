import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.Test;
import utils.excel.ExcelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: suyue
 * @time: 2021/4/24 22:42
 */
public class ExcelTest {

    private static String EXCEL_FILE_FORMAT = ".xlsx";

    private static String EXPORT_FILE_SUFFIX = "-export";

    @Test
    public void excelTest1() {
        String sourceFilePath = "C:\\D\\Learning\\excelTest\\source\\";
        String sourceFileName = "原始文件";
        String sourceFilePathName = sourceFilePath + sourceFileName + EXCEL_FILE_FORMAT;
        // 获取Excel文件
        File sourceFile = new File(sourceFilePathName);

        //读取单页excel，获取List<HashMap<String, Object>>格式
//        List<HashMap<String, Object>> list = ExcelUtils.parseSingleExcelToMap(sourceFile);

        //读取多页excel，获取List<HashMap<String, Object>>格式
        List<List<HashMap<String, Object>>> lists = ExcelUtils.parseComplexExcel(sourceFile);

        //导出到本地磁盘
        String exportFilePath = "C:\\D\\Learning\\excelTest\\target\\";
        String exportFileName = sourceFileName + EXPORT_FILE_SUFFIX + EXCEL_FILE_FORMAT;
        ExcelUtils.exportExcelToDisks(lists.get(0), exportFilePath, exportFileName);
    }

    @Test
    public void excelTest2() throws IOException {
        String sourceFilePath = "C:\\D\\Learning\\excelTest\\source\\";
        String sourceFileName = "原始文件";
        String sourceFilePathName = sourceFilePath + sourceFileName + EXCEL_FILE_FORMAT;
        //获取Excel文件
        FileInputStream fileIn = new FileInputStream(sourceFilePathName);
        //创建工作薄对象
        Workbook workbook = WorkbookFactory.create(fileIn);
        fileIn.close();

        //workbook从旧模板调整为新模板

        //获取sheet
        XSSFSheet sheet = (XSSFSheet) workbook.getSheet("一班");

        //sheet插入新行
        /*int last = sheet.getLastRowNum();
        for (int i = 1; i < 6; i++) {
            XSSFRow row1 = sheet.createRow(last + i);
            row1.createCell(0).setCellValue("静静");
            row1.createCell(1).setCellValue("18");
            row1.createCell(2).setCellValue("女孩子");
        }*/

        //sheet修改单元格内容
        /*sheet.getRow(0).getCell(0).setCellValue("姓名呀");
        sheet.getRow(3).getCell(0).setCellValue("王五呀");*/

        //sheet删除某行，不行
        /*int lastRowNum = sheet.getLastRowNum();
        sheet.shiftRows(2, lastRowNum, -1,true,false);*/

        //sheet删除某列，不行
        /*int column = 1;
        for (Iterator<Row> rowIterator = sheet.rowIterator(); rowIterator.hasNext(); ) {
            XSSFRow row = (XSSFRow) rowIterator.next();
            XSSFCell cell = row.getCell(column);
            if (cell == null) {
                continue;
            }
            row.removeCell(cell);
        }*/

        //导出到本地磁盘
        String exportFilePath = "C:\\D\\Learning\\excelTest\\target\\";
        String exportFileName = sourceFileName + EXPORT_FILE_SUFFIX + EXCEL_FILE_FORMAT;
        FileOutputStream fileOut = new FileOutputStream(exportFilePath + exportFileName);
        workbook.write(fileOut);
        fileOut.close();

    }

    //

    //修改指定位置单元格数据
    public void updateSheet(XSSFSheet sheet,int row,int column,String value){
        sheet.getRow(row).getCell(column).setCellValue(value);
    }


}
