package com.gorky.appiumdemo.plugins.excelReporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.gorky.appiumdemo.utils.AppiumUtil;
import com.gorky.appiumdemo.utils.PropertiesDataProvider;

import io.appium.java_client.AppiumDriver;

/**
 * @author GUO
 * @description 负责监听每个测试用例的测试过程，比如什么时候开始的测试，什么时候结束的测试，这个测试用例是否通过测试等
 */

public class TestResultListener extends TestListenerAdapter{
	private static Logger logger = Logger.getLogger(TestResultListener.class);
	protected ITestContext textContext = null; // 这里也是新加的
	protected String appFilePath;
	protected String appPackage; 
	
	@Override
	public void onStart(ITestContext testContext) { // 这里也是新加的，用于对context进行统一
		this.textContext = testContext;
		super.onStart(testContext);
	}
	
	@Override
	public void onTestStart(ITestResult tr) {
		super.onTestStart(tr);
		logger.info(tr.getName() + " 测试用例开始执行！");
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		logger.warn(tr.getName() + " 测试用例执行失败！"+tr.getThrowable());
		AppiumDriver driver = (AppiumDriver) textContext.getAttribute("APPIUM_DRIVER"); // 这里就是取driver
		saveScreenShot(tr, driver);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		AppiumDriver driver = (AppiumDriver) textContext.getAttribute("APPIUM_DRIVER");
		logger.warn(tr.getName() + " 测试用例由于某些原因被跳过！");
		saveScreenShot(tr, driver);

	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		System.out.println("测试用例执行成功:"+(AppiumDriver) textContext.getAttribute("APPIUM_DRIVER"));
		AppiumDriver driver = (AppiumDriver) textContext.getAttribute("APPIUM_DRIVER");
		logger.info(tr.getName() + " 测试用例执行成功！");
		saveScreenShot(tr, driver);
	}


	@Override
	public void onFinish(ITestContext textContext) {
		super.onFinish(textContext);
		System.out.println("onFinish()--driver:"+(AppiumDriver) textContext.getAttribute("APPIUM_DRIVER"));
		System.out.println("onFinish()--appiumUtil:"+(AppiumUtil) textContext.getAttribute("APPIUMUTIL"));
//		AppiumDriver driver = (AppiumDriver)textContext.getAttribute("APPIUM_DRIVER");
		AppiumUtil appiumUtil = (AppiumUtil)textContext.getAttribute("APPIUMUTIL");
//		if(driver!=null && appiumUtil!=null) {
			appFilePath = (String) textContext.getAttribute("APPFILEPATH");
			appPackage = (String) textContext.getAttribute("APPPACKAGE");
			appiumUtil.closeApp(PropertiesDataProvider.getTestData(appFilePath, appPackage));
		/*}else {
			
		}*/

		// List of test results which we will delete later
		ArrayList<ITestResult> testsToBeRemoved = new ArrayList<ITestResult>();
		// 罗列所有成功的用例
		Set<Integer> passedTestIds = new HashSet<Integer>();
		for (ITestResult passedTest : textContext.getPassedTests().getAllResults()) {
			logger.info("执行成功的用例 = " + passedTest.getName());
			passedTestIds.add(getId(passedTest));
		}

		// Eliminate the repeat methods
		Set<Integer> skipTestIds = new HashSet<Integer>();
		for (ITestResult skipTest : textContext.getSkippedTests().getAllResults()) {
			logger.info("被跳过的用例 = " + skipTest.getName());
			int skipTestId = getId(skipTest);

			if (skipTestIds.contains(skipTestId) || passedTestIds.contains(skipTestId)) {
				testsToBeRemoved.add(skipTest);
			} else {
				skipTestIds.add(skipTestId);
			}
		}

		// Eliminate the repeat failed methods
		Set<Integer> failedTestIds = new HashSet<Integer>();
		for (ITestResult failedTest : textContext.getFailedTests().getAllResults()) {
			logger.info("执行失败的用例 = " + failedTest.getName());
			int failedTestId = getId(failedTest);
			if (failedTestIds.contains(failedTestId) || passedTestIds.contains(failedTestId) || skipTestIds.contains(failedTestId)) {
				testsToBeRemoved.add(failedTest);
			} else {
				failedTestIds.add(failedTestId);
			}
		}

	}

	private int getId(ITestResult result) {
		int id = result.getTestClass().getName().hashCode();
		id = id + result.getMethod().getMethodName().hashCode();
		id = id + (result.getParameters() != null ? Arrays.hashCode(result.getParameters()) : 0);
		System.out.println("id:"+id);
		return id;
	}

	private void saveScreenShot(ITestResult tr, AppiumDriver driver) {
		String fileName =tr.getTestClass().getRealClass().getSimpleName();
		String folderName = fileName.substring(0, fileName.indexOf("P")).toLowerCase();
		System.out.println("folderName:"+folderName);
		String filePath = "";
		SimpleDateFormat df = new SimpleDateFormat("MMddHHmmss");
		System.out.println("---------截图序号：-----------"+df.format(new Date()));
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			filePath = "result/screenshots/"+folderName+"/"+fileName+df.format(new Date())+".png";
			System.out.println("filePath:"+filePath);
			
			File destFile = new File(filePath);
			if(destFile.exists()){
				destFile.delete();
			}
			FileUtils.copyFile(screenshot, destFile);
			logger.info("["+fileName+"] 截图成功，保存在：" + "[ " + filePath + " ]");

		} catch (Exception e) {
			filePath = "["+fileName+"]" + " ,截图失败，原因：" + e.getMessage();
			logger.error(filePath);
		}
	}
}
