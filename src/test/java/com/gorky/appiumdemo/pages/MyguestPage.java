package com.gorky.appiumdemo.pages;

import org.openqa.selenium.By;

/**
 * @author GUO
 * @description 我的客户页面
 */
public class MyguestPage {
	/**
	 * 定位元素：搜索
	 */
	public static final By MP_IMAGEVIEW_SEARCH = By.id("cn.jufuns.laikebao:id/common_iv_titlebar_right");
	
	/**
	 * 定位元素：搜索框
	 */
	public static final By MP_EDITTEXT_SEARCH = By.id("cn.jufuns.laikebao:id/edt_search_keyword");
	
	/**
	 * 定位元素：取消按钮
	 */
	public static final By MP_TEXTVIEW_SEARCHCANCEL = By.id("cn.jufuns.laikebao:id/tv_search_cancel");
	
	/**
	 * 定位元素：listview
	 */
	public static final By MP_LISTVIEW_MYGUEST = By.id("cn.jufuns.laikebao:id/lv_my_customer_list");
	
	/**
	 * 定位元素：item中的客户姓名
	 */
	public static final By RCP_TEXTVIEW_CUSTOMERNAME = By.id("cn.jufuns.laikebao:id/item_customer_name");
	
	/**
	 * 定位元素：item中的电话号码
	 */
	public static final By RCP_TEXTVIEW_PHONE = By.id("cn.jufuns.laikebao:id/item_customer_phone");
	
	/**
	 * 定位元素：item中的项目名称
	 */
	public static final By RCP_TEXTVIEW_PROJECT = By.id("cn.jufuns.laikebao:id/tv_item_customer_project_name");
	
	/**
	 * 定位元素：item中的拨号
	 */
	public static final By RCP_IMAGEVIEW_CALL = By.id("cn.jufuns.laikebao:id/iv_phone_call");
	
	/**
	 * 定位元素：item中的来源渠道
	 */
	public static final By RCP_TEXTVIEW_CHANNEL = By.id("cn.jufuns.laikebao:id/tv_channel");
}
