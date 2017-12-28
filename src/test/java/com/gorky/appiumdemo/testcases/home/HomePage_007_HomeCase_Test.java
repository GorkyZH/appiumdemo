package com.gorky.appiumdemo.testcases.home;

import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.HomePage;
import com.gorky.appiumdemo.pageshelper.HomePageHelper;

/**
 * @author GUO
 * @description 跳转到设置页面
 */

public class HomePage_007_HomeCase_Test extends BasePrepare1{

	@Test
	public void homeCase() {
		HomePageHelper.waitHomeUI(appiumUtil, elementTimeOut);
	}
	
	//跳转到设置页面
	@Test
	public void intoSettingPageCase() {
		HomePageHelper.clickText(appiumUtil, HomePage.HP_IMAGEVIEW_MORE);
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
