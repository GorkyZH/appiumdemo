package com.gorky.appiumdemo.pageshelper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gorky.appiumdemo.utils.AppiumUtil;

/**
 * @author GUO
 * @description 来电页面操作
 */

public class CallingPageHelper {
	/**
	 * 判断是否包含没有记录时的图标和提示语
	 */
	public static void doesElement(AppiumUtil appiumUtil,By byElement) {
		appiumUtil.doesElementsExist(byElement);
	}
	
	/**
	 * 获取listview中的item个数
	 */
	public static List<WebElement> getListviewCount(AppiumUtil appiumUtil,By by) {
		return appiumUtil.findElements(by);
	}
	
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
