package com.gorky.appiumdemo.pageshelper;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

import com.gorky.appiumdemo.utils.AppiumUtil;

public class TitlebarPageHelper {
	public static Logger logger = Logger.getLogger(TitlebarPageHelper.class);
	
	/**在该页面执行点击操作*/
	public static void clickGoback(AppiumUtil appiumUtil,By byElement) {
		appiumUtil.click(byElement);
	}
}
