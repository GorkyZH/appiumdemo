package com.gorky.appiumdemo.testcases.customer;


import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.RobCustomerPage;
import com.gorky.appiumdemo.pages.TitlebarPage;
import com.gorky.appiumdemo.pageshelper.RobCustomerPageHelper;
import com.gorky.appiumdemo.pageshelper.TitlebarPageHelper;
import com.gorky.appiumdemo.testcases.home.HomePage_005_HomeCase_Test;

/**
 * @author GUO
 * @description 累计抢客页面用例类
 */

public class RobCustomerNumPage_001_RobCustomerNumCase_Test extends BasePrepare1{
	protected String title_text,actrual_text,actrual_num;
	protected String item_name,item_phone,item_project;
	
	/**
	 * 用例1：判断首页累计抢客数与累计抢客页面的累计抢客数是否一致
	 */
	@Test
	public void robCustomerNumCase1() {
		title_text = TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE);
		System.out.println("累计抢客字节长度："+title_text.length());
		if(title_text.length()==7) {
			actrual_num = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(5, 6);
		}else if(title_text.length()==8) {
			actrual_num = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(5, 7);
		}else if(title_text.length()==9) {
			actrual_num = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(5, 8);
		}
		actrual_text = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(0,4);
		
		System.out.println("实际标题："+actrual_text+"实际抢客数："+actrual_num);
		RobCustomerPageHelper.isTextCorrect(appiumUtil,actrual_num, HomePage_005_HomeCase_Test.expected_num);
		RobCustomerPageHelper.isTextCorrect(appiumUtil,"累计抢客", actrual_text);
	}
	
	/**
	 * 用例2：判断累计抢客数与列表中的个数是否一致
	 */
	@Test
	public void robCustomerNumCase2() {
		if(HomePage_005_HomeCase_Test.expected_num.equals("0")) {
			System.out.println("累计抢客数为0");
			RobCustomerPageHelper.doesElement(appiumUtil, RobCustomerPage.RCP_IMAGEVIEW_CUSTOMER);
			RobCustomerPageHelper.doesElement(appiumUtil, RobCustomerPage.RCP_TEXTVIEW_CUSTOMER);
		}else {
			System.out.println("累计抢客数不为0");
			RobCustomerPageHelper.doesElement(appiumUtil, RobCustomerPage.RCP_LISTVIEW);
			System.out.println("listview的大小："+RobCustomerPageHelper.getListviewCount(appiumUtil, RobCustomerPage.RCP_LISTVIEW_LINEARLAYOUT).size());
		}
		//点击返回按钮，返回首页
//		TitlebarPageHelper.clickElement(appiumUtil, TitlebarPage.TP_IMAGEVIEWE_GOBACK);
	}
	
	/**
	 * 用例3：点击列表中的第一条记录
	 */
	@Test
	public void robCustmoerNumCase3() {
		System.out.println("case3--------------"+HomePage_005_HomeCase_Test.expected_num);
		item_name = RobCustomerPageHelper.getText(appiumUtil, RobCustomerPage.RCP_TEXTVIEW_CUSTOMERNAME);
		item_phone = RobCustomerPageHelper.getText(appiumUtil, RobCustomerPage.RCP_TEXTVIEW_PHONE);
		item_project = RobCustomerPageHelper.getText(appiumUtil, RobCustomerPage.RCP_TEXTVIEW_PROJECT);
		
		if(!"0".equals(HomePage_005_HomeCase_Test.expected_num)) {
			//点击item进入客户详情页面
			RobCustomerPageHelper.clickItem(appiumUtil, RobCustomerPage.RCP_ITEM_RELATIVELAYOUT);
			
			CustomerDetailPage_001_CustomerDetailPageCaseTest customer_detail = new CustomerDetailPage_001_CustomerDetailPageCaseTest();
			customer_detail.robguestValueCorrect(item_name,item_phone,item_project);
		}
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
