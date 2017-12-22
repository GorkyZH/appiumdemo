package com.gorky.appiumdemo.testcases.customer;


import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.CustomerDetailPage;
import com.gorky.appiumdemo.pages.CustomerPage;
import com.gorky.appiumdemo.pages.HomePage;
import com.gorky.appiumdemo.pages.TitlebarPage;
import com.gorky.appiumdemo.pageshelper.CustomerPageHelper;
import com.gorky.appiumdemo.pageshelper.HomePageHelper;
import com.gorky.appiumdemo.pageshelper.TitlebarPageHelper;
import com.gorky.appiumdemo.testcases.home.HomePage_001_HomeCase_Test;

/**
 * @author GUO
 * @description 我的客户页面用例类
 */

public class CustomerPage_001_CustomerCase_Test extends BasePrepare1{
	protected String actrual_text,actrual_num;
	protected String expected_num;
	
	/**
	 * 用例1：判断我的客户页面标题与首页我的客户入口标题是否一致
	 */
	@Test
	public void customerCase1() {
		actrual_text = TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE);
		System.out.println("实际标题："+actrual_text);
		CustomerPageHelper.isTextCorrect(appiumUtil,"我的客户", actrual_text);
		
		//返回首页
//		HomePageHelper.clickText(appiumUtil,HomePage.HP_TEXT_GETCUSTOMER);
	}
	
	/**
	 * 用例2：点击列表中第一个Item,进入客户详情页
	 */
	@Test(dataProvider="testData")
	public void customerCase2(Map<String,By> data) {
		if(!"0".equals(HomePage_001_HomeCase_Test.expected_num)) {
			System.out.print("我的客户数："+HomePage_001_HomeCase_Test.expected_num);
			String name = CustomerPageHelper.getText(appiumUtil, CustomerPage.CP_TEXTVIEW_CUSTOMERNAME);
			String phone = CustomerPageHelper.getText(appiumUtil, CustomerPage.CP_TEXTVIEW_PHONE);
			String project = CustomerPageHelper.getText(appiumUtil, CustomerPage.CP_TEXTVIEW_PROJECT);
			String channel = CustomerPageHelper.getText(appiumUtil, CustomerPage.CP_TEXTVIEW_CHANNEL);
			
			System.out.println("name:"+name);
			System.out.println("phone:"+phone);
			System.out.println("project:"+project);
			System.out.println("channel:"+channel);
			CustomerPageHelper.click(appiumUtil, CustomerPage.CP_ITEM_MYGUEST);
			valueCorrect(name, phone, project, channel);
		}
	}
	
	public void valueCorrect(String str_name,String str_phone,String str_project,String str_channel) {
		CustomerPageHelper.isTextCorrect(appiumUtil, str_name, CustomerPageHelper.getText(appiumUtil, CustomerDetailPage.CDP_TEXTVIEW_NAMEVALUE));
		CustomerPageHelper.isTextCorrect(appiumUtil, str_phone, CustomerPageHelper.getText(appiumUtil, CustomerDetailPage.CDP_TEXTVIEW_PHONE));
		CustomerPageHelper.isTextCorrect(appiumUtil, str_project, CustomerPageHelper.getText(appiumUtil, CustomerDetailPage.CDP_TEXTVIEW_PROJECT));
		CustomerPageHelper.isTextCorrect(appiumUtil, str_channel, CustomerPageHelper.getText(appiumUtil, CustomerDetailPage.CDP_TEXTVIEW_CHANNEL));
	}
	
	@Override
	protected String getModuleName() {
		return "customer";
	}

	@Override
	protected String getCaseNum() {
		return "002";
	}
	
}
