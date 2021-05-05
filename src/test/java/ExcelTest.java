import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import utils.excel.ExcelUtil;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: suyue
 * @time: 2021/4/24 22:42
 */
public class ExcelTest {

    private static String EXCEL_FILE_FORMAT = ".xlsx";

    private static String EXPORT_FILE_SUFFIX = "-autoExport";

    private static String PATH = "src/main/resources/file/";

    //基本的读取操作
    @Test
    public void excelReadTest() throws Exception {
        String fileName = "excel-read-test";
        //获取文件流
        FileInputStream inputStream = new FileInputStream(PATH + fileName + EXCEL_FILE_FORMAT);
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        //获取工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //获取行
        XSSFRow row = sheet.getRow(0);
        //获取列（单元格），注意数据类型
        XSSFCell cell = row.getCell(0);
        System.out.println(cell.getStringCellValue());

        //关闭流
        inputStream.close();

    }

    //基本的写入操作
    @Test
    public void excelWriteTest() throws Exception {
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = workbook.createSheet("商品清单");
        //创建行
        XSSFRow row0 = sheet.createRow(0);
        XSSFRow row1 = sheet.createRow(1);
        //创建列（单元格），注意数据类型
        XSSFCell cell00 = row0.createCell(0);
        cell00.setCellValue("序号");
        XSSFCell cell01 = row0.createCell(1);
        cell01.setCellValue("商品名称");
        XSSFCell cell10 = row1.createCell(0);
        cell10.setCellValue("1");
        XSSFCell cell11 = row1.createCell(1);
        cell11.setCellValue("牛奶");
        //导出到本地
        String fileName = "excel-write-test";
        FileOutputStream outputStream = new FileOutputStream(PATH + fileName + EXCEL_FILE_FORMAT);
        workbook.write(outputStream);

        //关闭流
        outputStream.close();
    }

    //ExcelUtil工具类，可用于Excel表头与java实体类有映射关系的场景
    @Test
    public void excelTest1() {
        String sourceFileName = "原始文件";
        String sourceFilePathName = PATH + sourceFileName + EXCEL_FILE_FORMAT;
        // 获取Excel文件
        File sourceFile = new File(sourceFilePathName);

        //读取单页excel，获取List<HashMap<String, Object>>格式
//        List<HashMap<String, Object>> list = ExcelUtils.parseSingleExcelToMap(sourceFile);

        //读取多页excel，获取List<HashMap<String, Object>>格式
        List<List<HashMap<String, Object>>> lists = ExcelUtil.parseComplexExcel(sourceFile);

        //导出到本地
        String exportFileName = PATH + EXPORT_FILE_SUFFIX + EXCEL_FILE_FORMAT;
        ExcelUtil.exportExcelToDisks(lists.get(0), PATH, exportFileName);
    }

    @Test
    public void excelTest2() throws IOException {
        String sourceFileName = "原始文件";
        String sourceFilePathName = PATH + sourceFileName + EXCEL_FILE_FORMAT;
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

        //导出到本地
        String exportFileName = sourceFileName + EXPORT_FILE_SUFFIX + EXCEL_FILE_FORMAT;
        FileOutputStream fileOut = new FileOutputStream(PATH + exportFileName);
        workbook.write(fileOut);
        fileOut.close();

    }

    //修改指定位置单元格数据
    public void updateSheet(XSSFSheet sheet, int row, int column, String value) {
        sheet.getRow(row).getCell(column).setCellValue(value);
    }


}
