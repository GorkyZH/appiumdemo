package com.gorky.appiumdemo.base;

import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.Assert;
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
import com.gorky.appiumdemo.utils.SelectDriver;

import io.appium.java_client.AppiumDriver;

/**
 * @author GUO
 * @description 启动和结束测试，以及数据提供者，提供测试数据
 */

public abstract class BasePrepare {
	protected AppiumDriver driver;
	protected AppiumUtil appiumUtil;
	public static Logger logger = Logger.getLogger(BasePrepare.class);
	protected ITestContext textContext;
	
	@BeforeSuite
	public void initTest(ITestContext context) {
		//使log4j的配置生效，以便输出日志
		LogConfiguration.initLog(this.getClass().getSimpleName());
		appiumUtil = new AppiumUtil();
		this.textContext = context;
		
//		System.out.println("BasePrepare.class"+elementTimeOut);
		
		//调用SelectDriver类的selectDriver方法，生成driver对象
		driver = new SelectDriver().selectDriver(context, appiumUtil);
		System.out.println("BasePrepare---driver驱动:"+driver);
		System.out.println("appiumUtil:"+appiumUtil);
		textContext.setAttribute("APPIUMUTIL", appiumUtil);
		
		System.out.println("获取ITextContext中的appiumUtil:"+textContext.getAttribute("APPIUMUTIL"));
	}
	
	@AfterClass
	public void clenTest() {
		System.out.println("close afterClass");
		System.out.println("AfterClass----------:"+textContext.getAttribute("APPIUMUTIL"));
		/*if(driver != null) {
//			appiumUtil.closeApp(PropertiesDataProvider.getTestData(appFilePath, appPackage));//appium模式
		  //driver.quit();//selendroid模式
		}else{
			Assert.fail("driver没有获得对象，退出操作失败");
		}*/
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
	
	/*@DataProvider(name = "testData")
	public Iterator<Object[]> dataFortestMethod() throws IOException {
		String moduleName = getModuleName();//模块的名字
		String caseNum = getCaseNum();//用例编号
		String className = this.getClass().getName();
		int dotIndexNum = className.indexOf(".");//取得第一个.的index
		int underlineIndexNum = className.indexOf("_");//取得第一个_的index
		
		if(dotIndexNum > 0) {
			*//**这里的calssName原始值大概是这样的：com.gorky.appiumdemo.testcase.login.LoginPage_001_LoginCase_Test
			 * 那么下面这段代码className.substring(30, className.lastIndexOf("."))是什么意思？substring方法参数有两个
			 * 一个开始位置，一个结束位置，30表示这个字符串的第30个位置，这个位置当前字符是l,className.lastIndexOf(".")表示返回这字符串最后一个.所在
			 * 的位置，它是35，那么className.substring(30, className.lastIndexOf("."))可以转换成：className.substring(30, 35)，最终取得的值是login，
			 * 也就是moduleName的值
			 * *//*
			moduleName = className.substring(31, className.lastIndexOf("."));//取到模块的名称
		}
		
		if(underlineIndexNum > 0) {
			//这个分析方法和moduleName的分析方法一样
			caseNum = className.substring(underlineIndexNum+1,underlineIndexNum+4);//取到用例编号名称
		}
		//将模块名称和用例的编号传给ExcelDataProvider,然后进行读取excel数据
		System.out.println("moduleName: "+moduleName+" caseNum: "+caseNum);
		return new ExcelDataProvider(moduleName, caseNum);
	}*/
	
}
