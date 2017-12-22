package com.gorky.appiumdemo.utils;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.NoSuchContextException;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;

/**
 * @author GUO
 * @description appium api封装
 */

public class AppiumUtil {
	
	public AppiumDriver driver;
	public ITestResult it;
	
	/**
	 * 定义日志输出对象
	 */
	public static Logger logger = Logger.getLogger(AppiumUtil.class);
	
	/**
	 * 获取driver
	 */
	public AppiumDriver getDriver(String url,DesiredCapabilities capabilities,String platform) {
		if(platform.equalsIgnoreCase("Android")){
			 try {
			      driver = new AndroidDriver(new URL(url), capabilities);
			      System.out.println("url:"+url+",driver:"+driver);
			  } catch (MalformedURLException e) {
			      e.printStackTrace();
			  }
		}else if(platform.equalsIgnoreCase("ios")){
			  try {
			       driver = new IOSDriver(new URL(url),capabilities);
			  } catch (MalformedURLException e) {
			       e.printStackTrace();
			  }
		}else{
			                 
		}
		return driver;
	}
	
	/**
	 * 退出app
	 */
	public void closeApp(String appName) {
		driver.closeApp();
		logger.info(appName+"已经关闭");
	}
	
	/**
	 * 退出移动浏览器
	 */
	public void quit() {
		driver.quit();
		logger.info("driver已被清理");
	}
	
	/**
	 * 通过By对象去查找某个元素
	 */
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}
	
	/**
	 * 通过By对象去查找一组元素
	 */
	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}
	
	/**
	 * 清空元素内容
	 */
	public void clear(By byElement) {
		WebElement element = findElement(byElement);
		element.clear();
		logger.info("清空元素："+getLocatorByElement(element,">")+"上的内容");
	}
	
	/**
	 * 输入内容
	 */
	public void typeContent(By byElement,String str) {
		WebElement element = findElement(byElement);
		element.sendKeys(str);
		logger.info("在元素："+getLocatorByElement(element,">")+"输入内容："+str);
	}
	
	/**
	 * 点击
	 */
	public void click(By byElement) {
		WebElement element = findElement(byElement);
		try {
			element.click();
			logger.info("点击元素："+getLocatorByElement(element, ">"));
		} catch (Exception e) {
			logger.error("点击元素："+getLocatorByElement(element, ">")+"失败",e);
			Assert.fail("点击元素："+getLocatorByElement(element, ">")+"失败",e);
		}
	}
	
	/**
	 * 查找一个元素 （appium新增的查找元素方法）
	 */
	public WebElement findElement(String locateWay,String locateValue) {
		WebElement element = null;
		switch (locateWay) {
		case "AccessibilityId":
			element = driver.findElementByAccessibilityId(locateValue);
			break;
		case "ClassName":
			element = driver.findElementByClassName(locateValue);
			break;
		case "CSS":
			element = driver.findElementByCssSelector(locateValue);
			break;
		case "ID":
			element = driver.findElementById(locateValue);
			break;
		case "LinkText":
			element = driver.findElementByLinkText(locateValue);
			break;
		case "Name":
			element = driver.findElementByName(locateValue);
			break;
		case "PartialLinkText":
			element = driver.findElementByPartialLinkText(locateValue);
			
			break;
		case "TagName":
			element = driver.findElementByTagName(locateValue);
			break;
		case "Xpath":
			element = driver.findElementByXPath(locateValue);
			break;
		default:
			logger.error("定位方式："+locateWay+"不被支持");
			Assert.fail("定位方式："+locateWay+"不被支持");
		}
		return element;
	}
	
	/**
	 * 查找一组元素 （appium新增的查找元素方法）
	 */
	public List<?> findElements(String locateWay,String locateValue) {
		List<?> element = null;
		switch (locateWay) {
		case "AccessibilityId":
			element = driver.findElementsByAccessibilityId(locateValue);
			break;
		case "ClassName":
			element = driver.findElementsByClassName(locateValue);
			break;
		case "CSS":
			element = driver.findElementsByCssSelector(locateValue);
			break;
		case "ID":
			element = driver.findElementsById(locateValue);
			break;
		case "LinkText":
			element = driver.findElementsByLinkText(locateValue);
			break;
		case "Name":
			element = driver.findElementsByName(locateValue);
			break;
		case "PartialLinkText":
			element = driver.findElementsByPartialLinkText(locateValue);
			break;
		case "TagName":
			element = driver.findElementsByTagName(locateValue);
			break;
		case "Xpath":
			element = driver.findElementsByXPath(locateValue);
			break;
		default:
			logger.error("定位方式："+locateWay+"不被支持");
			Assert.fail("定位方式："+locateWay+"不被支持");
		}
		return element;
	}
	
	/**
	 * 获取文本1
	 */
	public String getText(By by) {
		return findElement(by).getText().trim();
	}
	
	/**
	 * 获取文本2
	 */
	public String getText(String locateWay,String locateValue) {
		String str = "";
		switch (locateWay) {
		case "":
		case "AccessibilityId":
			str = driver.findElementByAccessibilityId(locateValue).getText().trim();
			break;
		case "ClassName":
			str = driver.findElementByClassName(locateValue).getText().trim();
			break;
		case "CSS":
			str = driver.findElementByCssSelector(locateValue).getText().trim();
			break;
		case "ID":
			str = driver.findElementById(locateValue).getText().trim();
			break;
		case "LinkText":
			str = driver.findElementByLinkText(locateValue).getText().trim();
			break;
		case "Name":
			str = driver.findElementByName(locateValue).getText().trim();
			break;
		case "PartialLinkText":
			str = driver.findElementByPartialLinkText(locateValue).getText().trim();
			break;
		case "TagName":
			str = driver.findElementByTagName(locateValue).getText().trim();
			break;
		case "Xpath":
			str = driver.findElementByXPath(locateValue).getText().trim();
			break;
		default:
			logger.error("定位方式："+locateWay+"不被支持");
			Assert.fail("定位方式："+locateWay+"不被支持");
		}
		return str;
	}
	
	/**
	 * 提交
	 */
	public void submit(By by) {
		WebElement element = findElement(by);
		try {
			element.submit();
		} catch (Exception e) {
			logger.error("在元素："+getLocatorByElement(element, ">")+"做的提交操作失败",e);
			Assert.fail("在元素："+getLocatorByElement(element, ">")+"做的提交操作失败",e);
		}
		logger.info("在元素："+getLocatorByElement(element, ">")+"做了提交操作");
	}
	
	/**
	 * 获得webview页面的标题
	 */
	public String getTitle() {
		return driver.getTitle();
	}
	
	/**
	 * 获得元素属性的文本
	 */
	public String getAttributeText(By elementLocator,String attribute) {
		return findElement(elementLocator).getAttribute(attribute).trim();
	}
	
	/**
	 * 在给定的时间内去查找元素，如果没有找到则超时，抛出异常
	 */
	public void waitForElementToLoad(int elementTimeOut,final By By) {
		logger.info("开始查找元素["+By+"]");
		try {
			(new WebDriverWait(driver, elementTimeOut)).until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					WebElement element = driver.findElement(By);
					return element.isDisplayed();
				}
			});
		} catch (TimeoutException e) {
			logger.error("超时!!"+elementTimeOut+"秒之后还没找到元素["+By+"]");
			Assert.fail("超时!!"+elementTimeOut+"秒之后还没找到元素["+By+"]");
		}
		logger.info("找到了元素["+By+"]");
	}
	 
	/**
	 * 判断文本是不是和需求要求的文本一致
	 */
	public void isTextCorrect(String actual,String expected) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			logger.error("期望的文字是["+expected+"]但是找到了["+actual+"]");
			Assert.fail("期望的文字是["+expected+"]但是找到了["+actual+"]");
		}
		logger.info("找到了期望的文字：["+expected+"]");
	}
	
	/**
	 * 暂停当前用例的执行，暂停的时间为：sleepTime
	 */
	public void pause(int sleepTime) {
		if(sleepTime <= 0) {
			return;
		}
		try {
			TimeUnit.SECONDS.sleep(sleepTime);
			logger.info("暂停："+sleepTime+"秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据元素来获取此元素的定位值
	 */
	public String getLocatorByElement(WebElement element,String expectText) {
		String text = element.toString();
		String expect = null;
		try {
			expect = text.substring(text.indexOf(expectText)+1, text.length()-1);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("failed to find the string ["+expectText+"]");
		}
		return expect;
	}
	
	/**
	 * 判断实际文本是否包含期望文本
	 */
	public void isContains(String actrual,String expected) {
		try {
			Assert.assertTrue(actrual.contains(expected));
		} catch (AssertionError e) {
			logger.error("The ["+actrual+"] is not contains ["+expected+"]");
			Assert.fail("The ["+actrual+"] is not contains ["+expected+"]");
		}
		logger.info("The ["+actrual+"] is contains ["+expected+"]");
	}
	
	/**
	 * 跳转到webview页面
	 */
	public void switchWebview(int index) {
		Set<String> contexts = driver.getContextHandles();
		for (String context:contexts) {
			System.out.println(context);//打印出来看看有哪些context
		}
		driver.context((String)contexts.toArray()[index]);
	}
	
	/**
	 * 跳转到webview页面
	 */
	public void switchWebview(String contextName) {
		try {
			Set<String> contexts = driver.getContextHandles();
			for (String context:contexts) {
				System.out.println(context);//打印出来看看有哪些context
			}
			driver.context(contextName);
		} catch (NoSuchContextException ne) {
			logger.error("没有这个context："+contextName,ne);
			Assert.fail("没有这个context："+contextName,ne);
		}
	}
	
	/**
	 * 执行JavaScript方法
	 */
	public void executeJS(String js) {
		((JavascriptExecutor) driver).executeScript(js);
		logger.info("执行JavaScript语句：["+js+"]");
	}
	
	/**
	 * 执行JavaScript方法和对象
	 */
	public void executeJS(String js,Object... args) {
		((JavascriptExecutor) driver).executeScript(js,args);
		logger.info("执行JavaScript语句：["+js+"]");
	}
	
	/**
	 * 检查元素是不是存在
	 */
	public boolean doesElementsExist(By byElement) {
		try {
			findElement(byElement);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	/**
	 * 获取当前activity
	 */
	public void getCurrentActivity() {
		driver.getClass();
	}
	
	/**
	 * 长按操作
	 */
	public void longPress(By by) {
		TouchAction tAction = new TouchAction(driver);
		tAction.longPress(findElement(by)).perform();
	}
	
	/**
	 * 滑动
	 */
	public void swipe(int beginX,int beginY,int endX,int endY) {
		TouchAction tAction = new TouchAction(driver);
		try {
			tAction.press(beginX, beginY).moveTo(endX,endY).release().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 滑动-根据文本模糊匹配
	 */
	public void scroll(String text) {
		driver.scrollTo(text);
	}
	
	/**
	 * 滑动 - 根据文本精准匹配
	 */
	public WebElement scrollExact(String text) {
		return driver.scrollToExact(text);
	}
	
	/**
	 * 拖拽操作
	 */
	public void DragAndDrop(By dragElement,By dropElement) {
		TouchAction act = new TouchAction(driver);
		act.press(findElement(dragElement)).perform();
		act.moveTo(findElement(dropElement)).release().perform();
	}
	
	/**
	 * 放大和缩小
	 */
	public void zoomAndPinch(int beginX,int beginY,int endX,int endY){
		int scrHeight = driver.manage().window().getSize().getHeight();
		int scrWidth = driver.manage().window().getSize().getWidth();
		MultiTouchAction multiTouch = new MultiTouchAction(driver);
		TouchAction tAction0 = new TouchAction(driver);
		TouchAction tAction1 = new TouchAction(driver);
		tAction0.longPress(scrWidth/2,scrHeight/2).waitAction(1000).moveTo(beginX, beginY).release();
		tAction1.longPress(scrWidth/2,scrHeight/2+40).waitAction(1000).moveTo(endX, endY).release();
		multiTouch.add(tAction0).add(tAction1);
		multiTouch.perform();
	}
	
	/**
	 * app置于后台运行
	 */
	public void runBackground(int runTimes) {
		driver.runAppInBackground(runTimes);
	}
	
	/**
	 * 收起键盘
	 */
	public void hideKeyboard() {
		driver.hideKeyboard();
		logger.info("虚拟键盘已经收起");
	}
	
	/**
	 * 返回上一页
	 */
	public void goback(){
		/*TouchAction tAction = new TouchAction(driver);
		tAction.*/
		driver.sendKeyEvent(AndroidKeyCode.BACK);
	}
	
	/**
	 * 打开cmd，执行adb命令
	 * @param  要执行的命令
	 */
	public void excuteAdbShell(String s) {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(s);
		} catch (IOException e) {
			System.err.println("执行命令"+s+"出错");
		}
	}
	
	/**
	 * 安装app
	 */
	public void installApp(String appPath) {
		try {
			driver.installApp(appPath);
		} catch (Exception e) {
			logger.error("app安装失败",e);
			Assert.fail("app安装失败");
		}
	}
	
	/**
	 * app是否安装
	 */
	public boolean isAppInstalled(String appPackage) {
		if(driver.isAppInstalled(appPackage)) {
			logger.info(appPackage+"已经安装");
			return true;
		}else {
			logger.info(appPackage+":未安装");
			return false;
		}
	}
	
	/**
	 * 页面过长时候滑动页面window.scrollTo(左边距,上边距)
	 */
	public void scrollPage(int x,int y) {
		String js = "window.scrllTo("+x+","+y+");";
		((JavascriptExecutor)driver).executeScript(js);
	}
	
	
}
