package com.gorky.appiumdemo.testcases.customer;

import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.HomePage;
import com.gorky.appiumdemo.pages.TitlebarPage;
import com.gorky.appiumdemo.pageshelper.CallingPageHelper;
import com.gorky.appiumdemo.pageshelper.HomePageHelper;
import com.gorky.appiumdemo.pageshelper.TitlebarPageHelper;
import com.gorky.appiumdemo.testcases.home.HomePage_001_HomeCase_Test;
import com.gorky.appiumdemo.testcases.home.HomePage_004_HomeCase_Test;

/**
 * @author GUO
 * @description 累计来电页面
 */

public class CallingNumPage_001_CallingNumCase_Test extends BasePrepare1{
	protected String actrual_text,actrual_num;
	
	/**
	 * 1、检查(累计来电)页面的(累计来电数)是否与首页的(累计来电数)相等；
	 * 2、检查(累计来电)页面的标题是否与首页的(累计来电)入口标题是否一致；
	 */
	@Test
	public void callingNumTitleCase1() {
			actrual_text = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(0,4);
			actrual_num = (TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE)).substring(5, 6);
			System.out.println("实际标题："+actrual_text+",实际累计来电数："+actrual_num);
			CallingPageHelper.isTextCorrect(appiumUtil,actrual_num, HomePage_004_HomeCase_Test.expected_num);
			CallingPageHelper.isTextCorrect(appiumUtil,"累计来电", actrual_text);
			
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
