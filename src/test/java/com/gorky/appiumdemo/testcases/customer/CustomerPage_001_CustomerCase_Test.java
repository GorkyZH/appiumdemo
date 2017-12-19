package com.gorky.appiumdemo.testcases.customer;


import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.HomePage;
import com.gorky.appiumdemo.pages.TitlebarPage;
import com.gorky.appiumdemo.pageshelper.CustomerPageHelper;
import com.gorky.appiumdemo.pageshelper.HomePageHelper;
import com.gorky.appiumdemo.pageshelper.TitlebarPageHelper;

/**
 * @author GUO
 * @description 我的客户页面用例类
 */

public class CustomerPage_001_CustomerCase_Test extends BasePrepare1{
	protected String actrual_text,actrual_num;
	protected String expected_num;
	
	//判断我的客户页面标题与首页我的客户入口标题是否一致
	@Test
	public void customerCase1() {
		actrual_text = TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE);
		System.out.println("实际标题："+actrual_text);
		CustomerPageHelper.isTextCorrect(appiumUtil,"我的客户", actrual_text);
		
		//返回首页
		HomePageHelper.clickText(appiumUtil,HomePage.HP_TEXT_GETCUSTOMER);
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
