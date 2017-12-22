package com.gorky.appiumdemo.testcases.customer;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.CallingPage;
import com.gorky.appiumdemo.pages.SearchPage;
import com.gorky.appiumdemo.pages.TitlebarPage;
import com.gorky.appiumdemo.pageshelper.CallingPageHelper;
import com.gorky.appiumdemo.pageshelper.SearchPageHelper;
import com.gorky.appiumdemo.pageshelper.TitlebarPageHelper;
import com.gorky.appiumdemo.testcases.home.HomePage_002_HomeCase_Test;

/**
 * @author GUO
 * @description 今日来电用例
 */

public class CallingPage_001_CallingCase_Test extends BasePrepare1{
	protected String title_text,actrual_text,actrual_num;
	
	/**
	 * 用例1：1、检查今日来电页面的今日来电数是否与首页的今日来电数相等；
	 *        2、检查今日来电页面的标题是否与首页的今日来电入口标题是否一致；
	 */
	@Test
	public void callingCase1() {
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
		System.out.println("实际标题："+actrual_text+",实际今日来电数："+actrual_num);
		CallingPageHelper.isTextCorrect(appiumUtil,actrual_num, HomePage_002_HomeCase_Test.expected_num);
		CallingPageHelper.isTextCorrect(appiumUtil,"今日来电", actrual_text);
			
		//点击返回按钮，返回首页
//		TitlebarPageHelper.clickElement(appiumUtil, TitlebarPage.TP_IMAGEVIEWE_GOBACK);
	}
	
	/**
	 * 用例2：判断今日来电数与列表中的个数是否一致
	 */
	@Test
	public void callingCase2() {
		if(HomePage_002_HomeCase_Test.expected_num.equals("0")) {
			CallingPageHelper.doesElement(appiumUtil, CallingPage.CP_IMAGEVIEW_CALL);
			CallingPageHelper.doesElement(appiumUtil, CallingPage.CP_TEXTVIEW_CALL);
		}else {
			CallingPageHelper.doesElement(appiumUtil, CallingPage.CP_LISTVIEW);
			System.out.println("listview的大小："+CallingPageHelper.getListviewCount(appiumUtil, CallingPage.CP_LISTVIEW_LINEARLAYOUT).size());
		}
	}
	
	/**
	 * 用例3：点击今日来电下拉框中的内容是否可正常切换到对应界面
	 */
	@Test
	public void callingCase3() {
		By[] elements = {TitlebarPage.TP_TEXTVIEEW_CALLINGNUM,TitlebarPage.TP_TEXTVIEW_CALLING,TitlebarPage.TP_TEXTVIEW_ROBGUEST,TitlebarPage.TP_TEXTVIEW_ROBGUESTNUM};
		TitlebarPageHelper.clickElement(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE);
		for(int i=0;i<4;i++) {
			if(elements[i].equals(TitlebarPage.TP_TEXTVIEEW_CALLINGNUM)) {
				System.out.println("elements[i]:"+elements[i]);
				clickSelectedTitle(elements, i, "累计来电");
			}else if(elements[i].equals(TitlebarPage.TP_TEXTVIEW_CALLING)) {
				clickSelectedTitle(elements, i, "今日来电");
			}else if(elements[i].equals(TitlebarPage.TP_TEXTVIEW_ROBGUEST)) {
				clickSelectedTitle(elements, i, "今日抢客");
			}else if(elements[i].equals(TitlebarPage.TP_TEXTVIEW_ROBGUESTNUM)) {
				TitlebarPageHelper.clickElement(appiumUtil, elements[i]);
				CallingPageHelper.isTextCorrect(appiumUtil, "累计抢客", TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE).substring(0, 4));
			}
		}
		//点击返回按钮，返回首页
		TitlebarPageHelper.clickElement(appiumUtil, TitlebarPage.TP_IMAGEVIEWE_GOBACK);
	}
	
	//切换Activity的点击操作
	public void clickSelectedTitle(By elements[],int i,String title) {
		TitlebarPageHelper.clickElement(appiumUtil, elements[i]);
		CallingPageHelper.isTextCorrect(appiumUtil, title, TitlebarPageHelper.getText(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE).substring(0, 4));
		TitlebarPageHelper.clickElement(appiumUtil, TitlebarPage.TP_TEXTVIEW_TITLE);
	}
	
	/**
	 * 用例4：点击搜索按钮，测试搜索功能
	 */
	public void callingNumCase4(Map<String,String> data) {
		TitlebarPageHelper.clickElement(appiumUtil, TitlebarPage.TP_IMAGEVIEW_SEARCH);
		SearchPageHelper.clearKeyword(appiumUtil, SearchPage.SP_EDITTEXT_SEARCH);
		System.out.println("关键词："+data.get("keyword"));
		SearchPageHelper.inputKeyword(appiumUtil, SearchPage.SP_EDITTEXT_SEARCH, data.get("keyword"));
		SearchPageHelper.pressSearchkeyword(appiumUtil,SearchPage.SP_EDITTEXT_SEARCH,"adb shell ime set com.meizu.flyme.input/com.meizu.input.MzInputService");
	}
	
	@Override
	protected String getModuleName() {
		return "search";
	}

	@Override
	protected String getCaseNum() {
		return "002";
	}
}
