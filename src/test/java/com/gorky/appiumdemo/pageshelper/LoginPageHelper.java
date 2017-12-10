package com.gorky.appiumdemo.pageshelper;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

import com.gorky.appiumdemo.utils.AppiumUtil;

/**
 * @author GUO
 * @description 在登录页面上进行点击操作
 */

public class LoginPageHelper {
	public static Logger logger = Logger.getLogger(LoginPageHelper.class);
	
	/**向输入框输入内容*/
	public static void typeInfo(AppiumUtil appiumUtil,By byElement,String info) {
		appiumUtil.typeContent(byElement, info);
	}
	
	/**在该页面执行点击操作*/
	public static void clickLoginBtn(AppiumUtil appiumUtil,By byElement) {
		appiumUtil.click(byElement);
	}
	
	/**清空输入框内容*/
	public static void clearContent(AppiumUtil appiumUtil,By byElement) {
		appiumUtil.clear(byElement);
	}
	
	
}

