package com.gorky.appiumdemo.testcases.search;

import java.util.Map;

import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.CustomerPage;
import com.gorky.appiumdemo.pageshelper.CustomerPageHelper;

/**
 * @author GUO
 * @description 搜索客户类
 */
public class SearchPage_001_SearchCase_Test extends BasePrepare1{
	 
	 @Test(dataProvider="testData")
	 public void searchDemo(Map<String,String> data) {
		 CustomerPageHelper.clearKeyword(appiumUtil, CustomerPage.CP_EDITTEXT_SEARCH);
			System.out.println("关键词："+data.get("keyword"));
			CustomerPageHelper.inputKeyword(appiumUtil, CustomerPage.CP_EDITTEXT_SEARCH, data.get("keyword"));
			CustomerPageHelper.pressSearchkeyword(appiumUtil,CustomerPage.CP_EDITTEXT_SEARCH,"adb shell ime set com.meizu.flyme.input/com.meizu.input.MzInputService");
	 }

	@Override
	protected String getModuleName() {
		return "search";
	}

	@Override
	protected String getCaseNum() {
		return "004";
	}
}
