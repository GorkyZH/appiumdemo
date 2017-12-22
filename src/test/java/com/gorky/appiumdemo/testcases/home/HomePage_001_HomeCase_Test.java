package com.gorky.appiumdemo.testcases.home;

import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.HomePage;
import com.gorky.appiumdemo.pageshelper.HomePageHelper;

/**
 * @author GUO
 * @description 跳转到我的客户页面
 */
public class HomePage_001_HomeCase_Test extends BasePrepare1{
	public static String expected_num;
	
	@Test
	public void homeDemo() {
		HomePageHelper.waitHomeUI(appiumUtil, elementTimeOut);
	}
	
	//点击我的客户数，进入我的客户页面
	@Test
	public void intoMyguest() {
		expected_num = HomePageHelper.getText(appiumUtil, HomePage.HP_TEXTVIEW_GETCUSTOMER_COUNT);
		HomePageHelper.clickText(appiumUtil, HomePage.HP_TEXTVIEW_GETCUSTOMER_COUNT);
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
