package com.gorky.appiumdemo.utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;

/**
 * @author GUO
 * @description 根据测试平台的不同生成不同的driver
 */

public class SelectDriver {
	//声明driver
	public AppiumDriver driver;
	
	//声明DesiredCapabilities
	public DesiredCapabilities capabilities;
	
	//声明ITestContext,用来获取Testng的配置文件
	public ITestContext textContext;
	
	//声明appium服务地址
	public String serverUrl;
	
	//测试引擎名称
	public String automationName;
	
	//测试平台名称
	public String platformName;
	
	//测试平台版本号
	public String platformVersion;
	
	//测试设备名称
	public String deviceName;
	
	//ios app的路径
	public String iosAppPath;
	
	//android app的路径
	public String androidAppPath;
	
	//android app的Package
	public String appPackage;
	
	//android app的activity
	public String appActivity;
	
	//安卓独有-是否使用unicode键盘，使用该键盘可支持中文字符输入
	public boolean unicodeKeyboard;
	
	//安卓独有-是否重置键盘
	public boolean resetKeyboard;
	
	//是否覆盖已有的session,这个用于多用例执行，如果不设置，会提示前一个用例还没有结束，用例不能继续执行了
	public boolean sessionOverride;
	
	//暂停等待时间
	public int sleepTime;
	
	//元素等待超时时间
	public int elementTimeOut;
	
	//appid文件路径，用于存储app的名字
	public String appFilePath;
	
	//实例化本类的日志输出对象
	public static Logger logger = Logger.getLogger(SelectDriver.class);
	
	public AppiumDriver selectDriver(ITestContext context,AppiumUtil appiumUtil) {
		//通过testng的xml文件获取serverUrl的参数值，并赋予serverUrl变量
		serverUrl = context.getCurrentXmlTest().getParameter("serverURL");
		
		//通过testng的xml文件获取platformName参数值，并赋予platformName变量
		platformName = context.getCurrentXmlTest().getParameter("platformName");
		
		//通过testng的xml文件获取platformVersion参数值，并赋予platformVersion变量
		platformVersion = context.getCurrentXmlTest().getParameter("platformVersion");
		
		//通过testng的xml文件获取deviceName参数值，并赋予deviceName变量
		deviceName = context.getCurrentXmlTest().getParameter("deviceName");
		
		//通过testng的xml文件获取iosAppPath参数值，并赋予iosAppPath变量
		iosAppPath = context.getCurrentXmlTest().getParameter("iosAppPath");
		
		//通过testng的xml文件获取androidAppPath参数值，并赋予androidAppPath变量
		androidAppPath = context.getCurrentXmlTest().getParameter("androidAppPath");
		
		//通过testng的xml文件获取appPackage参数值，并赋予appPackage变量
		appPackage = context.getCurrentXmlTest().getParameter("appPackage");
		
		//通过testng的xml文件获取appActivity参数值，并赋予appActivity变量
		appActivity = context.getCurrentXmlTest().getParameter("appActivity");
		
		//通过testng的xml文件获取unicodeKeyboard参数值，并赋予unicodeKeyboard变量
		unicodeKeyboard = Boolean.parseBoolean(context.getCurrentXmlTest().getParameter("unicodeKeyboard"));
		
		//通过testng的xml文件获取resetKeyboard参数值，并赋予resetKeyboard变量
		resetKeyboard = Boolean.parseBoolean(context.getCurrentXmlTest().getParameter("resetKeyboard"));
		
		//通过testng的xml文件获取sessionOverride参数值，并赋予sessionOverride变量
		sessionOverride = Boolean.parseBoolean(context.getCurrentXmlTest().getParameter("sessionOverride"));
		
		//通过testng的xml文件获取sleepTime参数值，并赋予sleepTime变量
		sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		
		//通过testng的xml文件获取elementTimeOut参数值，并赋予elementTimeOut变量
		elementTimeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("elementTimeOut"));
		
		//通过testng的xml文件获取appFilePath参数值，并赋予appFilePath变量
		appFilePath = context.getCurrentXmlTest().getParameter("appFilePath");
		
		this.textContext = context;
		
		capabilities = new DesiredCapabilities();
		
		//告诉测试程序，当前项目的目录在哪
		File classpathRoot = new File(System.getProperty("user.dir"));//获得项目的路径
		
		//设置capabilities，以便和appium创建session
        capabilities.setCapability("platformName", platformName);//被测的平台名称
        capabilities.setCapability("platformVersion", platformVersion);//模拟器的版本号
        capabilities.setCapability("deviceName", deviceName);//被测设备的名称
        capabilities.setCapability("sessionOverride", sessionOverride);
        
        //如果测试平台是android的话，执行下面的if语句
        if(platformName.equalsIgnoreCase("Android")) {
        	File app = new File(classpathRoot,androidAppPath);//获得apk所在文件夹的路径
        	capabilities.setCapability("app", app.getAbsolutePath());
        	capabilities.setCapability("unicodeKeyboard", unicodeKeyboard);
            capabilities.setCapability("resetKeyboard", resetKeyboard);
            capabilities.setCapability("automationName", automationName);
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            driver = appiumUtil.getDriver(serverUrl, capabilities, platformName);
            textContext.setAttribute("APPIUM_DRIVER", driver);
            textContext.setAttribute("APPFILEPATH", appFilePath);
            textContext.setAttribute("APPPACKAGE", appPackage);
            
            System.out.println("获取ITextcontext中的驱动值："+textContext.getAttribute("APPIUM_DRIVER"));
           
            logger.info(PropertiesDataProvider.getTestData(appFilePath,appPackage)+"已经启动");
            driver.manage().timeouts().implicitlyWait(elementTimeOut, TimeUnit.SECONDS);
            return driver;
        }else if(platformName.equalsIgnoreCase("ios")) {
        	/**
        	 * 设置和ios测试相关的capability并实例化driver对象
        	 */
        	File app = new File(classpathRoot,iosAppPath);//获得apk所在文件夹的路径
        	capabilities.setCapability("app", app.getAbsolutePath());
        	
        	//ios设置自动接收系统alert，注意IOS弹出的alert，APPIUM可以支持ios8以上系统
        	capabilities.setCapability("autoAcceptAlerts" ,true);
            driver = appiumUtil.getDriver(serverUrl, capabilities, platformName);
            textContext.setAttribute("APPIUM_DRIVER", driver);
            driver.manage().timeouts().implicitlyWait(elementTimeOut, TimeUnit.SECONDS);
        }else {
        	logger.error("初始化driver失败");
        	Assert.fail("初始化driver失败");
        }
        return driver;
	}
	
	
}
