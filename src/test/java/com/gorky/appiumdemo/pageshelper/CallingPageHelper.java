package com.gorky.appiumdemo.pageshelper;

import org.openqa.selenium.By;

import com.gorky.appiumdemo.utils.AppiumUtil;

/**
 * @author GUO
 * @description 来电页面操作
 */

public class CallingPageHelper {
	/**
	 * 点击listview
	 */
	public static void clickListview(AppiumUtil appiumUtil,By byElement) {
		appiumUtil.click(byElement);
	}
	
	/**
	 * 判断文本内容是否一致
	 */
	public static void isTextCorrect(AppiumUtil appiumUtil,String actual,String expected) {
		appiumUtil.isTextCorrect(actual, expected);
	}
}
