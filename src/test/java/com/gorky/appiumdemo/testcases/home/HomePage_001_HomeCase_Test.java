package com.gorky.appiumdemo.testcases.home;

import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.HomePage;
import com.gorky.appiumdemo.pages.TitlebarPage;
import com.gorky.appiumdemo.pageshelper.HomePageHelper;

/**
 * @author GUO
 * @description 编写首页测试用例
 */
public class HomePage_001_HomeCase_Test extends BasePrepare1{
	
	@Test
	public void homeDemo() {
		System.out.println("homeclass");
		System.out.println("点击我的客户数"+HomePage.HP_TEXTVIEW_GETCUSTOMER_COUNT);
		
		HomePageHelper.waitHomeUI(appiumUtil, elementTimeOut);
	//	HomePageHelper.clickText(appiumUtil, HomePage.HP_IMAGEVIEW_MORE);
		
		/**
		 * 点击我的客户数，进入我的客户页面
		 */
		HomePageHelper.clickText(appiumUtil, HomePage.HP_TEXTVIEW_GETCUSTOMER_COUNT);
		HomePageHelper.clickText(appiumUtil, HomePage.HP_TEXT_GETCUSTOMER);
		
		
		HomePageHelper.clickText(appiumUtil, HomePage.HP_TEXTVIEW_GETCUSTOMER_INCALLING);
		HomePageHelper.clickText(appiumUtil, TitlebarPage.TP_IMAGEVIEWE_GOBACK);
		
		HomePageHelper.clickText(appiumUtil, HomePage.HP_TEXTVIEW_GETCUSTOMER_ROBGUEST);
		HomePageHelper.clickText(appiumUtil, TitlebarPage.TP_IMAGEVIEWE_GOBACK);
		
		HomePageHelper.clickText(appiumUtil, HomePage.HP_TEXTVIEW_GETCUSTOMER_INCALLINGNUM);
		HomePageHelper.clickText(appiumUtil, TitlebarPage.TP_IMAGEVIEWE_GOBACK);
		
		HomePageHelper.clickText(appiumUtil, HomePage.HP_TEXTVIEW_GETCUSTOMER_ROBGUESTNUM);
		HomePageHelper.clickText(appiumUtil, TitlebarPage.TP_IMAGEVIEWE_GOBACK);
		
		HomePageHelper.clickText(appiumUtil, HomePage.HP_TEXT_MYCUSTOMER);
		HomePageHelper.clickText(appiumUtil, HomePage.HP_TEXT_GETCUSTOMER);
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
