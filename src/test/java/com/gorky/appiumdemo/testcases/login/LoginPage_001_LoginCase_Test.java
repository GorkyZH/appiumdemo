package com.gorky.appiumdemo.testcases.login;

import java.util.Map;

import org.testng.annotations.Test;

import com.gorky.appiumdemo.base.BasePrepare;
import com.gorky.appiumdemo.pages.HomePage;
import com.gorky.appiumdemo.pages.LoginPage;
import com.gorky.appiumdemo.pages.CustomerPage;
import com.gorky.appiumdemo.pageshelper.HomePageHelper;
import com.gorky.appiumdemo.pageshelper.LoginPageHelper;
import com.gorky.appiumdemo.pageshelper.CustomerPageHelper;


/**
 * @author GUO
 * @description 编写登录测试用例
 */

public class LoginPage_001_LoginCase_Test extends BasePrepare{
	
	@Test(dataProvider="testData")
	public void loginDemo(Map<String,String> data) {
		
		System.out.println("用户名"+LoginPage.LP_EDITTEXT_USERNAME);
		LoginPageHelper.clearContent(appiumUtil, LoginPage.LP_EDITTEXT_USERNAME);
		LoginPageHelper.clearContent(appiumUtil, LoginPage.LP_EDITTEXT_PWD);
		
		LoginPageHelper.typeInfo(appiumUtil, LoginPage.LP_EDITTEXT_USERNAME, data.get("username"));
		LoginPageHelper.typeInfo(appiumUtil, LoginPage.LP_EDITTEXT_PWD, data.get("password"));
		
		LoginPageHelper.clickLoginBtn(appiumUtil, LoginPage.LP_BUTTON_LOGIN);
		
	}

	
	@Override
	protected String getModuleName() {
		return "login";
	}
	
	@Override
	protected String getCaseNum() {
		return "001";
	}
}
