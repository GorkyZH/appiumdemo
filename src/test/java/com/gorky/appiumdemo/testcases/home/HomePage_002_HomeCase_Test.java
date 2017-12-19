package com.gorky.appiumdemo.testcases.home;

import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.HomePage;
import com.gorky.appiumdemo.pages.TitlebarPage;
import com.gorky.appiumdemo.pageshelper.HomePageHelper;

/**
 * @author GUO
 * @description 首页跳转到今日来电页面
 */
public class HomePage_002_HomeCase_Test extends BasePrepare1{
	public static String expected_num;
	@Test
	public void homeDemo() {
		HomePageHelper.waitHomeUI(appiumUtil, elementTimeOut);
	}
	
	//跳转到今日来电页面
	@Test
	public void intoIncallingPagedemo() {
		expected_num = HomePageHelper.getText(appiumUtil, HomePage.HP_TEXTVIEW_GETCUSTOMER_INCALLING);
		System.out.println("今日来电数："+expected_num);
		HomePageHelper.clickText(appiumUtil, HomePage.HP_TEXTVIEW_GETCUSTOMER_INCALLING);
	}
	
	@Override
	protected String getModuleName() {
		return null;
	}

	@Override
	protected String getCaseNum() {
		return null;
	}
	
}
