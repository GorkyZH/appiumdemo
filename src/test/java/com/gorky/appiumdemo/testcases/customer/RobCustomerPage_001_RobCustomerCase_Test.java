package com.gorky.appiumdemo.testcases.customer;


import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.HomePage;
import com.gorky.appiumdemo.pages.TitlebarPage;
import com.gorky.appiumdemo.pageshelper.HomePageHelper;
import com.gorky.appiumdemo.pageshelper.RobCustomerPageHelper;
import com.gorky.appiumdemo.pageshelper.TitlebarPageHelper;
import com.gorky.appiumdemo.testcases.home.HomePage_003_HomeCase_Test;

/**
 * @author GUO
 * @description 今日抢客页面用例类
 */

public class RobCustomerPage_001_RobCustomerCase_Test extends BasePrepare1{
	protected String title_text,actrual_text,actrual_num;
	
	@Test
	public void robCustomerCase1() {
		title_text = TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE);
		if(title_text.length()==7) {
			actrual_num = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(5, 6);
		}else if(title_text.length()==8) {
			actrual_num = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(5, 7);
		}else if(title_text.length()==9) {
			actrual_num = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(5, 8);
		}
		actrual_text = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(0,4);
		actrual_num = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(5, 6);
		System.out.println("实际标题："+actrual_text+"实际抢客数："+actrual_num);
		RobCustomerPageHelper.isTextCorrect(appiumUtil,actrual_num, HomePage_003_HomeCase_Test.expected_num);
		RobCustomerPageHelper.isTextCorrect(appiumUtil,"今日抢客", actrual_text);
		
		//点击返回按钮，返回首页
		TitlebarPageHelper.clickElement(appiumUtil, TitlebarPage.TP_IMAGEVIEWE_GOBACK);
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
