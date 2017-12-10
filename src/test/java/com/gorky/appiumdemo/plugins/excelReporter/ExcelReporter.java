package com.gorky.appiumdemo.plugins.excelReporter;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import com.gorky.appiumdemo.plugins.excelReporter.utils.CreateExcelForResult;

/**
 * @author GUO
 *
 */

public class ExcelReporter implements IReporter{
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		CreateExcelForResult.createExcelReport(xmlSuites, suites,outputDirectory);
	}
}
