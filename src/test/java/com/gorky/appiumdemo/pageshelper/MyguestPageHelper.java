package com.gorky.appiumdemo.pageshelper;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.gorky.appiumdemo.utils.AppiumUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * @author GUO
 * @description 我的客户页面操作类
 */
public class MyguestPageHelper {
	public static Logger logger = Logger.getLogger(MyguestPageHelper.class);
	
	/**
	 * 判断是否包含元素
	 */
	public static void isContainElement(AppiumUtil appiumUtil,String actrual,String expected) {
		appiumUtil.isContains(actrual, expected);
	}
	
	/**
	 * 点击搜索按钮
	 */
	public static void clickSearchImageview(AppiumUtil appiumUtil,By byElement) {
		appiumUtil.click(byElement);
	}
	
	/**
	 * 清楚搜索框内容
	 */
	public static void clearKeyword(AppiumUtil appiumUtil,By byElement) {
		appiumUtil.clear(byElement);
	}
	
	/**
	 * 输入关键字
	 */
	public static void inputKeyword(AppiumUtil appiumUtil,By byElement,String keyword) {
		appiumUtil.typeContent(byElement, keyword);
	}
	
	/**
	 * 点击键盘上的搜索键
	 */
	public static void pressSearchkeyword(AppiumUtil appiumUtil,By byElement,String s) {
		//使用adb shell 切换输入法-更改为LatinIME
		appiumUtil.excuteAdbShell(s);
		//再次点击输入框，调取键盘，软键盘被成功调取
		appiumUtil.click(byElement);
		//点击右下角的搜索，即ENTER键
		(appiumUtil.driver).sendKeyEvent(AndroidKeyCode.ENTER);
		System.out.println("按下搜索键"+AndroidKeyCode.ENTER);
		System.out.println("当前输入法："+s);
		//再次切换输入法键盘为Appium unicodeKeyboard
		appiumUtil.excuteAdbShell("adb shell ime set io.appium.android.ime/.UnicodeIME");
	}
	
	/**
	 * 点击取消按钮
	 */
	public static void clickCancel(AppiumUtil appiumUtil,By byElement) {
		appiumUtil.click(byElement);
	}
	
	/**
	 * 滚动列表
	 */
	public static void scrollListview(AppiumUtil appiumUtil,By byElement) {
		
	}
}
