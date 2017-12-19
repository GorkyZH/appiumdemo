package com.gorky.appiumdemo.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.gorky.appiumdemo.pages.HomePage;
import com.gorky.appiumdemo.utils.AppiumUtil;

/**
 * @author GUO
 * @description 在首页上进行点击操作
 */
public class HomePageHelper {
	public static Logger logger = Logger.getLogger(HomePageHelper.class);
	
	/**
	 * 等待首页元素全部显示出来
	 */
	public static void waitHomeUI(AppiumUtil appiumUtil,int elementTimeOut) {
		logger.info("正在等待首页元素加载... ...");
		
		System.out.println("elementTimeOut:"+elementTimeOut+",更多元素："+HomePage.HP_IMAGEVIEW_MORE);
		appiumUtil.waitForElementToLoad(elementTimeOut, HomePage.HP_IMAGEVIEW_MORE);
		appiumUtil.waitForElementToLoad(elementTimeOut, HomePage.HP_TEXT_GETCUSTOMER);
		appiumUtil.waitForElementToLoad(elementTimeOut, HomePage.HP_TEXTVIEW_GETCUSTOMER_COUNT);
		appiumUtil.waitForElementToLoad(elementTimeOut, HomePage.HP_TEXTVIEW_GETCUSTOMER_INCALLING);
		appiumUtil.waitForElementToLoad(elementTimeOut, HomePage.HP_TEXTVIEW_GETCUSTOMER_INCALLINGNUM);
//		appiumUtil.waitForElementToLoad(elementTimeOut, HomePage.HP_TEXTVIEW_GETCUSTOMER_ROB);
		appiumUtil.waitForElementToLoad(elementTimeOut, HomePage.HP_TEXTVIEW_GETCUSTOMER_ROBGUEST);
		appiumUtil.waitForElementToLoad(elementTimeOut, HomePage.HP_TEXTVIEW_GETCUSTOMER_ROBGUESTNUM);
		logger.info("元素加载完毕！");
	}
	
	/**在页面执行点击操作 */
	public static void clickText(AppiumUtil appiumUtil,By byElement){
		appiumUtil.click(byElement);
	}
	
	/**
	 * 获取文本值
	 * @return 
	 */
	public static String getText(AppiumUtil appiumUtil,By byElement) {
		return appiumUtil.getText(byElement);
	}
	
	/**
	 * 点击手机返回键 
	 * */
	public static void pressBack(AppiumUtil appiumUtil) {
		appiumUtil.goback();
	}
}
