package com.gorky.appiumdemo.pages;

import org.openqa.selenium.By;

/**
 * @author GUO
 * @description 客户详情页面元素定位
 */
public class CustomerDetailPage {
	/**
	 * 定位元素：客户信息
	 */
	public static final By CDP_TEXTVIEW_INFO = By.id("cn.jufuns.laikebao:id/tv_customer_info_label");
	
	/**
	 * 定位元素：手机号码
	 */
	public static final By CDP_TEXTVIEW_PHONE = By.id("cn.jufuns.laikebao:id/tv_customer_info_phone");
	
	/**
	 * 定位元素：项目名称
	 */
	public static final By CDP_TEXTVIEW_PROJECT = By.id("cn.jufuns.laikebao:id/tv_customer_info_project_name");
	
	/**
	 * 定位元素：客户姓名
	 */
	public static final By CDP_TEXTVIEW_NAMEVALUE = By.id("cn.jufuns.laikebao:id/tv_customer_info_custname");
	
	/**
	 * 定位元素：来源渠道
	 */
	public static final By CDP_TEXTVIEW_CHANNEL = By.id("cn.jufuns.laikebao:id/tv_customer_info_channel");
	
	/**
	 * 定位元素：获客时间
	 */
	public static final By CDP_TEXTVIEW_CSTTIME = By.id("cn.jufuns.laikebao:id/tv_customer_info_csttime");
	
}
