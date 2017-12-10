package com.gorky.appiumdemo;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class AppiumTest {
	public AppiumDriver driver;
	private String serverURL = "http://127.0.0.1:4723/wd/hub";//appium测试服务的地址
	
	@BeforeClass
	public void beforeClass() throws Exception{
		//设置apk的路径
		File classpathRoot = new File(System.getProperty("user.dir"));//获得项目的路径
		File appDir = new File(classpathRoot,"res/app");//获得apk所在文件夹的路径
		File app = new File(appDir,"laikebao-test_172.16.3.219-8699-2.apk");//获得被测apk文件
		
		//设置自动化相关参数
		DesiredCapabilities capabilities = new DesiredCapabilities(); 
		capabilities.setCapability("automationName", "Appium");//自动化测试名称
        capabilities.setCapability("platformName", "Android");//被测的平台名称
        capabilities.setCapability("deviceName", "Custom Phone");//被测设备的名称
        //设置安卓系统版本
        capabilities.setCapability("platformVersion", "5.0.0");//模拟器的版本号
        //设置apk路径
        capabilities.setCapability("app", app.getAbsolutePath());//被测apk文件
        
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "cn.jufuns.laikebao");
        capabilities.setCapability("appActivity", "cn.jufuns.laikebao.activity.LoginActivity");
        capabilities.setCapability("unicodeKeyboard" ,"True");
        capabilities.setCapability("resetKeyboard", "True");
        
        //核心关键步骤，创建驱动，指定服务地址，和初始化信息；
        driver = new AndroidDriver(new URL(serverURL), capabilities); 
	}
	
	
	@Test
	public void login() {
//		WebElement user_edit = driver.findElement(By.id("cn.jufuns.laikebao:id/et_user_name"));
		WebElement user_edit = driver.findElementById("cn.jufuns.laikebao:id/et_user_name");
//		WebElement pwd_edit = driver.findElement(By.id("cn.jufuns.laikebao:id/et_user_pwd"));
		WebElement pwd_edit = driver.findElementById("cn.jufuns.laikebao:id/et_user_pwd");
		WebElement button = driver.findElement(By.id("cn.jufuns.laikebao:id/btn_logon"));
		
		user_edit.click();
		user_edit.clear();
		user_edit.sendKeys("15521322686");
		System.out.println("用户名："+user_edit.getText());
		pwd_edit.sendKeys("aaa123");
		System.out.println("密码："+pwd_edit.getText());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		button.click();
	}
	
	@Test
	public void todayCalling() {
		WebElement text_todaycalling = driver.findElementById("cn.jufuns.laikebao:id/tv_fragment_getcustomer_incoming");
		String number1 = text_todaycalling.getText();
//		WebElement<List> list = driver.findElementById("cn.jufuns.laikebao:id/erv_phone_list");
		text_todaycalling.click();
	//	assertTrue(number1.equals(list.getSize()));
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
	
}
