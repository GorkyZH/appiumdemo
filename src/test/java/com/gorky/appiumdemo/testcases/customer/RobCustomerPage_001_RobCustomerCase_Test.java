package com.gorky.appiumdemo.testcases.customer;


import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.HomePage;
import com.gorky.appiumdemo.pages.TitlebarPage;
import com.gorky.appiumdemo.pageshelper.HomePageHelper;
import com.gorky.appiumdemo.pageshelper.RobCustomerPageHelper;
import com.gorky.appiumdemo.pageshelper.TitlebarPageHelper;

/**
 * @author GUO
 * @description 今日抢客页面用例类
 */

public class RobCustomerPage_001_RobCustomerCase_Test extends BasePrepare1{
	protected String actrual_text,actrual_num;
	protected String expected_num;
	
	@Test
	public void robCustomerCase1() {
		expected_num = HomePageHelper.getText(appiumUtil, HomePage.HP_TEXTVIEW_GETCUSTOMER_INCALLING);
		System.out.println("今日抢客数："+expected_num);
		HomePageHelper.clickText(appiumUtil, HomePage.HP_TEXTVIEW_GETCUSTOMER_INCALLING);
		
		actrual_text = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(0,4);
		actrual_num = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(5, 6);
		System.out.println("实际标题："+actrual_text+"实际抢客数："+actrual_num);
		RobCustomerPageHelper.isTextCorrect(appiumUtil,actrual_num, expected_num);
		RobCustomerPageHelper.isTextCorrect(appiumUtil,"今日抢客", actrual_text);
		
	}
	
	@Test
	public void robCustomerCase2() {
		
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
