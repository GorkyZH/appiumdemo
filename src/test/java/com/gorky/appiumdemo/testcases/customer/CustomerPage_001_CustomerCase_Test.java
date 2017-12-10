package com.gorky.appiumdemo.testcases.customer;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.HomePage;
import com.gorky.appiumdemo.pages.MyguestPage;
import com.gorky.appiumdemo.pageshelper.HomePageHelper;
import com.gorky.appiumdemo.pageshelper.MyguestPageHelper;

/**
 * @author GUO
 * @description 我的客户页面用例类
 */

public class CustomerPage_001_CustomerCase_Test extends BasePrepare1{
//	protected boolean containsElement = true;
	/**
	 * 搜索客户号码
	 */
	@Test(dataProvider ="testData")
	public void customerDemo(Map<String,String> data) throws InterruptedException, IOException {
		/*containsElement = appiumUtil.doesElementsExist(HomePage.HP_TEXTVIEW_GETCUSTOMER_COUNT);
		if(containsElement) {
			System.out.println("containsElement:"+containsElement);
			HomePageHelper.clickText(appiumUtil, HomePage.HP_TEXTVIEW_GETCUSTOMER_COUNT);
			MyguestPageHelper.clickSearchImageview(appiumUtil, MyguestPage.MP_IMAGEVIEW_SEARCH);
			MyguestPageHelper.clearKeyword(appiumUtil, MyguestPage.MP_EDITTEXT_SEARCH);
			System.out.println("关键词："+data.get("keyword"));
			MyguestPageHelper.inputKeyword(appiumUtil, MyguestPage.MP_EDITTEXT_SEARCH, data.get("keyword"));
			MyguestPageHelper.pressSearchkeyword(appiumUtil,MyguestPage.MP_EDITTEXT_SEARCH,"adb shell ime set com.meizu.flyme.input/com.meizu.input.MzInputService");
			containsElement = false;
		}else {*/
			MyguestPageHelper.clearKeyword(appiumUtil, MyguestPage.MP_EDITTEXT_SEARCH);
			System.out.println("关键词："+data.get("keyword"));
			MyguestPageHelper.inputKeyword(appiumUtil, MyguestPage.MP_EDITTEXT_SEARCH, data.get("keyword"));
			MyguestPageHelper.pressSearchkeyword(appiumUtil,MyguestPage.MP_EDITTEXT_SEARCH,"adb shell ime set com.meizu.flyme.input/com.meizu.input.MzInputService");
//		}
		
	
//		MyguestPageHelper.clickCancel(appiumUtil, MyguestPage.MP_TEXTVIEW_SEARCHCANCEL);
	}

	@Override
	protected String getModuleName() {
		return "customer";
	}

	@Override
	protected String getCaseNum() {
		return "001";
	}
	
}
