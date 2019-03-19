package com.test.sumarestabigdecimals.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.sumarestabigdecimals.utils.ExcelUtils;

/**
 * Hello world!
 *
 */
public class App {

	private static final Logger LOGGER = LogManager.getLogger(App.class);

	public static void main(String[] args) {

		ExcelUtils.escribirExcel(ExcelUtils.generarExcelPoliza());
		
	}

//	public static int addition(int first, int second) {
//		return first + second;
//	}
//
//	public static double divide(int first, int second) {
//		if (second != 0) {
//			return (double) first / (double) second;
//		}
//
//		return 0;
//	}
}
