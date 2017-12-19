package com.gorky.appiumdemo.pageshelper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gorky.appiumdemo.utils.AppiumUtil;

/**
 * @author GUO
 * @description 抢客页面操作
 */

public class RobCustomerPageHelper {
	/**
	 * 判断文本内容是否一致
	 */
	public static void isTextCorrect(AppiumUtil appiumUtil,String actual,String expected) {
		appiumUtil.isTextCorrect(actual, expected);
	}
	
	/**
	 * 点击listview
	 */
	public static void clickListview(AppiumUtil appiumUtil,By byElement) {
		appiumUtil.click(byElement);
	}
	
	/**
	 * 遍历元素
	 */
	public static List<WebElement> itemElement(AppiumUtil appiumUtil,String locateWay,String locateValue) {
		return (List<WebElement>) appiumUtil.findElements("ClassName","android.widget.RelativeLayout");
	}
}
