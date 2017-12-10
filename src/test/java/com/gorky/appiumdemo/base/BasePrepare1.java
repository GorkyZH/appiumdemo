package com.gorky.appiumdemo.base;

import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.gorky.appiumdemo.utils.AppiumUtil;
import com.gorky.appiumdemo.utils.ExcelDataProvider;
import com.gorky.appiumdemo.utils.LogConfiguration;


/**
 * @author GUO
 * @description 启动和结束测试，以及数据提供者，提供测试数据
 */

public abstract class BasePrepare1 {
//	protected AppiumDriver driver;
	protected AppiumUtil appiumUtil = null;
	public static Logger logger = Logger.getLogger(BasePrepare1.class);
	protected String appFilePath;
	protected String appPackage;
	protected int elementTimeOut,sleepTime,waitMillSecondsForAlert;
	protected ITestContext textContext = null;
	
	@BeforeClass
	public void initTest(ITestContext context) {
		//使log4j的配置生效，以便输出日志
		LogConfiguration.initLog(this.getClass().getSimpleName());
		this.textContext = context;
		System.out.println("BasePrepare1-----appiumUtil:"+(AppiumUtil) textContext.getAttribute("APPIUMUTIL"));
		appiumUtil = (AppiumUtil) textContext.getAttribute("APPIUMUTIL");
		
		elementTimeOut = Integer.valueOf(textContext.getCurrentXmlTest().getParameter("elementTimeOut"));
		sleepTime = Integer.valueOf(textContext.getCurrentXmlTest().getParameter("sleepTime"));
	}
	
	@AfterSuite
	public void clenTest() {
		System.out.println("AfterSuite套件结束");
	}
	
	abstract protected String getModuleName();
	abstract protected String getCaseNum();
	
	/**
	 * 测试数据提供者 - 方法
	 */
	@DataProvider(name = "testData")
	public Iterator<Object[]> dataFortestMethod() throws IOException {
		String moduleName = getModuleName();//模块的名字
		String caseNum = getCaseNum();//用例编号
		return new ExcelDataProvider(moduleName, caseNum);
	}
}
