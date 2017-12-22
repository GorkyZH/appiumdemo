package com.gorky.appiumdemo.testcases.home;

import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.HomePage;
import com.gorky.appiumdemo.pages.TitlebarPage;
import com.gorky.appiumdemo.pageshelper.HomePageHelper;

/**
 * @author GUO
 * @description 从首页跳转到今日抢客页面
 */
public class HomePage_003_HomeCase_Test extends BasePrepare1{
	public static String expected_num;
	@Test
	public void homeDemo() {
		HomePageHelper.waitHomeUI(appiumUtil, elementTimeOut);
	}
	
	@Test
	public void intoRobguestPagedemo() {
		expected_num = HomePageHelper.getText(appiumUtil, HomePage.HP_TEXTVIEW_GETCUSTOMER_ROBGUEST);
		HomePageHelper.clickText(appiumUtil, HomePage.HP_TEXTVIEW_GETCUSTOMER_ROBGUEST);
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
