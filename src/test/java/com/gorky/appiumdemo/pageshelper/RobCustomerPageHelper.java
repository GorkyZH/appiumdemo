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
	 * 判断是否包含没有记录时的图标和提示语
	 */
	public static void doesElement(AppiumUtil appiumUtil,By byElement) {
		appiumUtil.doesElementsExist(byElement);
	}
	
	/**
	 * 判断抢客个数与首页的抢客个数是否一致
	 */
	public static void isTextCorrect(AppiumUtil appiumUtil,String actual,String expected) {
		appiumUtil.isTextCorrect(actual, expected);
	}
	
	/**
	 * 获取listview中的item个数
	 */
	public static List<WebElement> getListviewCount(AppiumUtil appiumUtil,By by) {
		return appiumUtil.findElements(by);
	}
	
	/**
	 * 遍历元素
	 */
	public static List<WebElement> itemElement(AppiumUtil appiumUtil,String locateWay,String locateValue) {
		return (List<WebElement>) appiumUtil.findElements("ClassName","android.widget.RelativeLayout");
	}
	
	/**
	 * 点击操作
	 */
	public static void clickItem(AppiumUtil appiumUtil,By byElement) {
		appiumUtil.click(byElement);
	}
	
	/**
	 * 获取item的文本内容
	 */
	public static String getText(AppiumUtil appiumUtil,By byElement) {
		return appiumUtil.getText(byElement);
		
	}
}
