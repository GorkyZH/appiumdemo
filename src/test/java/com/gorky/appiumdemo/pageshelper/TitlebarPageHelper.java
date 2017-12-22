package com.gorky.appiumdemo.pageshelper;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

import com.gorky.appiumdemo.utils.AppiumUtil;

public class TitlebarPageHelper {
	public static Logger logger = Logger.getLogger(TitlebarPageHelper.class);
	
	/**在该页面执行点击操作*/
	public static void clickElement(AppiumUtil appiumUtil,By byElement) {
		appiumUtil.click(byElement);
	}
	
	/**
	 * 获取文本值
	 * @return 
	 */
	public static String getText(AppiumUtil appiumUtil,By byElement) {
		return appiumUtil.getText(byElement);
	}
}
