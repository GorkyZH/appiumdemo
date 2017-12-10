package com.gorky.appiumdemo.pages;

import org.openqa.selenium.By;

/**
 * @author GUO
 * @description 今日抢客、累计抢客页面元素定位
 */
public class RobCustomerPage {
	/**
	 * 定位元素：标题
	 */
	public static final By RCP_TEXTVIEW_TITLEBAR = By.id("cn.jufuns.laikebao:id/common_tv_titlebar_title");
	
	/**
	 * 定位元素：返回
	 */
	public static final By RCP_IMAGEVIEW_BACK = By.id("cn.jufuns.laikebao:id/common_iv_titlebar_left");
	
	/**
	 * 定位元素：搜索
	 */
	public static final By RCP_IMAGEVIEW_SEARCH = By.id("cn.jufuns.laikebao:id/common_iv_titlebar_right");
	
	/**
	 * 定位元素：抢客列表
	 */
	public static final By RCP_LISTVIEW = By.id("cn.jufuns.laikebao:id/lv_rob_customer_list");
	
	/**
	 * 定位元素：今日抢客或累计抢客列表中没有记录时的图标
	 */
	public static final By RCP_IMAGEVIEW_CUSTOMER = By.id("cn.jufuns.laikebao:id/iv_fragment_customer_record");
	
	/**
	 * 定位元素：今日抢客或累计抢客列表中没有记录时的提示语
	 */
	public static final By RCP_TEXTVIEW_CUSTOMER = By.id("cn.jufuns.laikebao:id/tv_fragment_customer_record");

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
}
