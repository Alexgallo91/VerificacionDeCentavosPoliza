package com.test.sumarestabigdecimals.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.test.sumarestabigdecimals.beans.PolizaBean;
import com.test.sumarestabigdecimals.beans.SeccionPolizaTotalBean;

public final class ExcelUtils {

	private static final Logger LOGGER = LogManager.getLogger(ExcelUtils.class.getName());

	public static final Workbook generarExcelPoliza() {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet hoja = wb.createSheet();
		XSSFCell celda;
		XSSFRow fila;
		int numeroFila = 0;
		int numeroCelda = 0;

		SeccionPolizaTotalBean sptb = new PolizaUtils().generarSeccionTotalPoliza();

		XSSFFont fuenteHeader = wb.createFont();
		fuenteHeader.setFontName("Arial");
		fuenteHeader.setBold(true);
		fuenteHeader.setColor(IndexedColors.WHITE.getIndex());
		fuenteHeader.setFontHeightInPoints((short) 11);

		XSSFCellStyle styleHeader = wb.createCellStyle();
		styleHeader.setFont(fuenteHeader);
		styleHeader.setFillForegroundColor(IndexedColors.RED.getIndex());
		styleHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		XSSFCellStyle styleTotal = wb.createCellStyle();
		styleHeader.setFont(fuenteHeader);
		styleHeader.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		styleHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		fila = hoja.createRow(numeroFila);
		celda = fila.createCell(numeroCelda);
		celda.setCellValue("DEBE");
		celda.setCellStyle(styleHeader);

		celda = fila.createCell(++numeroCelda);
		celda.setCellValue("HABER");
		celda.setCellStyle(styleHeader);

		numeroCelda = 0;
		for (PolizaBean p : sptb.getListaDePolizasDebe()) {
			fila = hoja.createRow(++numeroFila);

			celda = fila.createCell(numeroCelda);
			celda.setCellValue(p.getDebe().toString());
		}

		// establece por ultimo el total de haber
		++numeroCelda;
		fila = hoja.createRow(++numeroFila);
		celda = fila.createCell(numeroCelda);
		celda.setCellValue(sptb.getPolizaTotalHaber().getHaber().toString());
		
		//establece los totales
		numeroCelda = 0;
		numeroFila+=2;
		
		fila = hoja.createRow(numeroFila);
		celda = fila.createCell(numeroCelda);
		celda.setCellValue(sptb.getTotalDebe().toString());
		celda.setCellStyle(styleTotal);
		
		celda = fila.createCell(++numeroCelda);
		celda.setCellValue(sptb.getTotalHaber().toString());
		celda.setCellStyle(styleTotal);

		return wb;
	}

	public static final void escribirExcel(Workbook wb) {
		try {
			// se obtiene el path en donde se escribira el archivo excel
			ResourceBundle rb = ResourceBundle.getBundle("excel_apache_poi");
			String pathExcelWrite = rb.getString("path.excel.centavos");
			String fileName = rb.getString("path.excel.fileName");
			LOGGER.info("Key path en donde se escribira el archivo excel: " + pathExcelWrite);

			// verifica que la carpeta este creada
			File carpetaExcel = new File(pathExcelWrite);

			if (!carpetaExcel.exists()) {
				if (carpetaExcel.mkdirs()) {
					LOGGER.info("Se han creado los directorios de la siguiente URI: " + pathExcelWrite);
				} else {
					LOGGER.error("Fue imposible crear los directorios");
					LOGGER.info("Favor de verificar los permisos para crear los directorios necesarios");
					System.exit(1);
				}
			}
			LOGGER.info("Creando archivo en el siguiente parth: " + pathExcelWrite + "/" + fileName + ".xlsx");
			FileOutputStream out = new FileOutputStream(new File(pathExcelWrite + "/" + fileName + ".xlsx"), false);
			wb.write(out);
			out.close();
		} catch (IOException e) {
			LOGGER.error("Sucedio un error al momento de escribir el archivo excel");
		}
	}

}
