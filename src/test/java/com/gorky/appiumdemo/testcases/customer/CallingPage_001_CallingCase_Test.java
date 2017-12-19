package com.gorky.appiumdemo.testcases.customer;

import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.HomePage;
import com.gorky.appiumdemo.pages.TitlebarPage;
import com.gorky.appiumdemo.pageshelper.CallingPageHelper;
import com.gorky.appiumdemo.pageshelper.HomePageHelper;
import com.gorky.appiumdemo.pageshelper.TitlebarPageHelper;
import com.gorky.appiumdemo.testcases.home.HomePage_002_HomeCase_Test;

/**
 * @author GUO
 * @description 今日来电用例
 */

public class CallingPage_001_CallingCase_Test extends BasePrepare1{
	protected String actrual_text,actrual_num;
//	protected String expected_num;
	
	/**
	 * 1、检查今日来电页面的今日来电数是否与首页的今日来电数相等；
	 * 2、检查今日来电页面的标题是否与首页的今日来电入口标题是否一致；
	 */
	@Test
	public void callingTitleCase1() {
		actrual_text = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(0,4);
		actrual_num = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(5, 6);
		System.out.println("实际标题："+actrual_text+",实际今日来电数："+actrual_num);
		CallingPageHelper.isTextCorrect(appiumUtil,actrual_num, HomePage_002_HomeCase_Test.expected_num);
		CallingPageHelper.isTextCorrect(appiumUtil,"今日来电", actrual_text);
			
		//点击返回按钮，返回首页
		TitlebarPageHelper.clickGoback(appiumUtil, TitlebarPage.TP_IMAGEVIEWE_GOBACK);
	}
	
	/**
	 * 判断listview是否有数据
	 */
	/*@Test
	public void callingListviewCase() {
		if(appiumUtil.findElements(C)) {
			CallingPageHelper.clickListview(appiumUtil, CallingPage.CP_LISTVIEW);
		}
	}*/

	@Override
	protected String getModuleName() {
		return null;
	}

	@Override
	protected String getCaseNum() {
		return null;
	}
}
