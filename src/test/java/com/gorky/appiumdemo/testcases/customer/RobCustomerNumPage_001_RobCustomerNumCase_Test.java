package com.gorky.appiumdemo.testcases.customer;


import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.TitlebarPage;
import com.gorky.appiumdemo.pageshelper.RobCustomerPageHelper;
import com.gorky.appiumdemo.pageshelper.TitlebarPageHelper;
import com.gorky.appiumdemo.testcases.home.HomePage_005_HomeCase_Test;

/**
 * @author GUO
 * @description 累计抢客页面用例类
 */

public class RobCustomerNumPage_001_RobCustomerNumCase_Test extends BasePrepare1{
	protected String actrual_text,actrual_num;
	
	@Test
	public void robCustomerNumCase1() {
		actrual_text = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(0,4);
		actrual_num = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(5, 6);
		System.out.println("实际标题："+actrual_text+"实际抢客数："+actrual_num);
		RobCustomerPageHelper.isTextCorrect(appiumUtil,actrual_num, HomePage_005_HomeCase_Test.expected_num);
		RobCustomerPageHelper.isTextCorrect(appiumUtil,"累计抢客", actrual_text);
		
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
