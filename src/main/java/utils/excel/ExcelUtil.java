package utils.excel;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * ==================================================
 * FileName: ExcelUtils
 *
 * @author : renkaijiang
 * @create 2020/6/2
 * @since 1.0.0
 * 〈功能〉：Excel导入导出工具类
 * ==================================================
 */
public class ExcelUtil {
    private static Logger logger = Logger.getLogger(ExcelDataChecker.class.getName()); // 日志打印类

    private ExcelUtil() {
        throw new IllegalStateException("ExcelUtils class");
    }

    /**
     * 读取单sheet(单页) excel文件
     *
     * @param excelFile excel文件
     * @return List<List < HashMap < String, Object>>> 读取的数据
     */
    public static List<HashMap<String, Object>> parseSingleExcelToMap(@NotNull File excelFile) {
        return ExcelDataChecker.parseSingleExcelToMap(excelFile);
    }

    /**
     * 读取多sheet(多页) excel文件
     * 自动的，一页则一个，多页则多个
     *
     * @param excelFile excel文件
     * @return List<List < HashMap < String, Object>>> 读取的数据
     */
    public static List<List<HashMap<String, Object>>> parseComplexExcel(@NotNull File excelFile) {
        return ExcelDataChecker.parseComplexExcel(excelFile);
    }


    /**
     * 读取单sheet(单页) excel文件为bean
     * 此速度最快，要求顺序
     * *****************************************
     * * 一定注意excel列的顺序要和bean字段的顺序一致  *
     * *****************************************
     *
     * @param excelFile excel文件
     * @param tClass    bean
     * @param <T>
     * @return
     */
    public static <T> List<T> readExcelToBean(@NotNull File excelFile, @NotNull Class<T> tClass) {
        return ExcelDataChecker.readExcelToBean(excelFile, tClass);
    }

    /**
     * 读取单sheet(单页) excel文件为bean
     * 此方法速度逊色一些，不要求顺序，在不能保证字段和excel列顺序的情况下使用
     *
     * @param file   excel文件
     * @param tClass 实体类
     * @param <T>    泛型
     * @return
     */
    public static <T> List<T> excelToBean(@NotNull File file, @NotNull Class<T> tClass) {
        return ExcelDataChecker.excelToBean(file, tClass);
    }

    /**
     * 导出excel到本地磁盘
     *
     * @param dataVOList     数据
     * @param exportFilePath 磁盘路径,注意后面有\\  如：C:\\WorkFile\\
     * @param excelName      excel文件名 文件全名 如xx.xls   xx.xlsx
     */
    public static void exportExcelToDisks(@NotNull List<HashMap<String, Object>> dataVOList, @NotNull String exportFilePath, @NotNull String excelName) {

        ExcelDataChecker.exportExcelToDisks(dataVOList, exportFilePath, excelName);
    }

    /**
     * 下载excel
     *
     * @param response   HttpServletResponse对象
     * @param excelName  文件名 文件全名 如xx.xls   xx.xlsx
     * @param dataVOList 数据
     */
    public static void mapExportExcelToResponse(@NotNull HttpServletResponse response, @NotNull String excelName, @NotNull List<HashMap<String, Object>> dataVOList) {

        // 根据业务需求获取需要写入Excel的数据列表 dataList
        try (Workbook workbook = ExcelDataChecker.mapExportData(dataVOList, excelName);) {
            putTogetherData(response, workbook, excelName);
        } catch (Exception e) {
            logger.warning("写入Excel过程出错！错误原因：" + e.getMessage());
        }
    }

    /**
     * 下载excel
     *
     * @param response   HttpServletResponse对象
     * @param excelName  文件名 文件全名 如xx.xls   xx.xlsx
     * @param dataVOList 数据
     */
    public static <T> void beanExportExcelToResponse(@NotNull HttpServletResponse response, @NotNull String excelName, @NotNull List<T> dataVOList) {
        // 根据业务需求获取需要写入Excel的数据列表 dataList
        try (Workbook workbook = ExcelDataChecker.beanExportData(dataVOList, excelName)) {
            putTogetherData(response, workbook, excelName);
        } catch (Exception e) {
            logger.warning("写入Excel过程出错！错误原因：" + e.getMessage());
        }
    }

    /**
     * 将公共的HttpServletResponse组装提出来
     *
     * @param response  上下文对象
     * @param workbook  工作簿对象
     * @param excelName 文件名 文件全名 如xx.xls   xx.xlsx
     * @throws IOException
     */
    private static void putTogetherData(HttpServletResponse response, Workbook workbook, String excelName) throws IOException {
        OutputStream out = null;
        // 写入Excel文件到前端
        if (null != workbook) {
            excelName = new String(excelName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            response.setHeader("Content-Disposition", "attachment;filename=" + excelName);
            response.setContentType("application/x-download");
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            response.flushBuffer();
            out = response.getOutputStream();
            workbook.write(out);
            out.flush();
        }
    }

    //2021-5-5补充部分常用方法

    /**
     * 复制行
     *
     * @param startRow  开始行
     * @param endRow    结束行
     * @param pPosition 目标行
     * @param sheet     工作表对象
     */
    public static void copyRows(int startRow, int endRow, int pPosition, XSSFSheet sheet) {
        int pStartRow = startRow;
        int pEndRow = endRow;
        int targetRowFrom;
        int targetRowTo;
        int columnCount;
        CellRangeAddress region = null;
        int i;
        int j;
        if (pStartRow == -1 || pEndRow == -1) {
            return;
        }
        // 拷贝合并的单元格
        for (i = 0; i < sheet.getNumMergedRegions(); i++) {
            region = sheet.getMergedRegion(i);
            if ((region.getFirstRow() >= pStartRow) && (region.getLastRow() <= pEndRow)) {
                targetRowFrom = region.getFirstRow() - pStartRow + pPosition;
                targetRowTo = region.getLastRow() - pStartRow + pPosition;
                CellRangeAddress newRegion = region.copy();
                newRegion.setFirstRow(targetRowFrom);
                newRegion.setFirstColumn(region.getFirstColumn());
                newRegion.setLastRow(targetRowTo);
                newRegion.setLastColumn(region.getLastColumn());
                sheet.addMergedRegion(newRegion);
            }
        }
        // 设置列宽
        for (i = pStartRow; i <= pEndRow; i++) {
            XSSFRow sourceRow = sheet.getRow(i);
            columnCount = sourceRow.getLastCellNum();
            if (sourceRow != null) {
                XSSFRow newRow = sheet.createRow(pPosition - pStartRow + i);
                newRow.setHeight(sourceRow.getHeight());
                for (j = 0; j < columnCount; j++) {
                    XSSFCell templateCell = sourceRow.getCell(j);
                    if (templateCell != null) {
                        XSSFCell newCell = newRow.createCell(j);
                        copyCell(templateCell, newCell, true);
                    }
                }
            }
        }
    }

    /**
     * 复制单元格
     *
     * @param srcCell        原始单元格
     * @param distCell       目标单元格
     * @param isSameWorkbook 是否同一workbook内复制
     */
    public static void copyCell(XSSFCell srcCell, XSSFCell distCell, boolean isSameWorkbook) {

        if (srcCell == null || distCell == null) return;

        if (isSameWorkbook) {
            distCell.setCellStyle(srcCell.getCellStyle());
        } else {
            distCell.getCellStyle().cloneStyleFrom(srcCell.getCellStyle());
        }

        if (srcCell.getCellComment() != null) {
            distCell.setCellComment(srcCell.getCellComment());
        }
        CellType srcCellType = srcCell.getCellType();
        distCell.setCellType(srcCellType);
        if (srcCellType == CellType.NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(srcCell)) {
                distCell.setCellValue(srcCell.getDateCellValue());
            } else {
                distCell.setCellValue(srcCell.getNumericCellValue());
            }
        } else if (srcCellType == CellType.STRING) {
            distCell.setCellValue(srcCell.getRichStringCellValue());
        } else if (srcCellType == CellType.BLANK) {
            // nothing21
        } else if (srcCellType == CellType.BOOLEAN) {
            distCell.setCellValue(srcCell.getBooleanCellValue());
        } else if (srcCellType == CellType.ERROR) {
            distCell.setCellErrorValue(srcCell.getErrorCellValue());
        } else if (srcCellType == CellType.FORMULA) {
            distCell.setCellFormula(srcCell.getCellFormula());
        } else { // nothing29

        }
    }

    /**
     * 表格中指定位置插入行
     *
     *
     * @param sheet    工作表对象
     * @param rowIndex 指定的行数
     * @return 当前行对象
     */
    public static XSSFRow insertRow(XSSFSheet sheet, int rowIndex) {
        XSSFRow row = null;
        if (sheet.getRow(rowIndex) != null) {
            int lastRowNo = sheet.getLastRowNum();
            sheet.shiftRows(rowIndex, lastRowNo, 1);
        }
        row = sheet.createRow(rowIndex);
        return row;
    }
}
