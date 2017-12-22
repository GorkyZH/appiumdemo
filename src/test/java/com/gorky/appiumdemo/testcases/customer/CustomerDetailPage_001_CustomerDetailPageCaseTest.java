package com.gorky.appiumdemo.testcases.customer;

import com.gorky.appiumdemo.base.BasePrepare1;
import com.gorky.appiumdemo.pages.CustomerDetailPage;
import com.gorky.appiumdemo.pageshelper.CustomerPageHelper;

/**
 * @author GUO
 * @description 我的客户详情页面
 */
public class CustomerDetailPage_001_CustomerDetailPageCaseTest extends BasePrepare1{
	//判断客户详情页与抢客列表中的item值是否一致
	public void robguestValueCorrect(String str_name,String str_phone,String str_project) {
		CustomerPageHelper.isTextCorrect(appiumUtil, str_name, CustomerPageHelper.getText(appiumUtil, CustomerDetailPage.CDP_TEXTVIEW_NAMEVALUE));
		CustomerPageHelper.isTextCorrect(appiumUtil, str_phone, CustomerPageHelper.getText(appiumUtil, CustomerDetailPage.CDP_TEXTVIEW_PHONE));
		CustomerPageHelper.isTextCorrect(appiumUtil, str_project, CustomerPageHelper.getText(appiumUtil, CustomerDetailPage.CDP_TEXTVIEW_PROJECT));
	}
	
	//判断我的客户详情页与我的客户列表中的item值是否一致
	public void myguestValueCorrect(String str_name,String str_phone,String str_project,String str_channel) {
		CustomerPageHelper.isTextCorrect(appiumUtil, str_name, CustomerPageHelper.getText(appiumUtil, CustomerDetailPage.CDP_TEXTVIEW_NAMEVALUE));
		CustomerPageHelper.isTextCorrect(appiumUtil, str_phone, CustomerPageHelper.getText(appiumUtil, CustomerDetailPage.CDP_TEXTVIEW_PHONE));
		CustomerPageHelper.isTextCorrect(appiumUtil, str_project, CustomerPageHelper.getText(appiumUtil, CustomerDetailPage.CDP_TEXTVIEW_PROJECT));
		CustomerPageHelper.isTextCorrect(appiumUtil, str_channel, CustomerPageHelper.getText(appiumUtil, CustomerDetailPage.CDP_TEXTVIEW_CHANNEL));
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
