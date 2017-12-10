package com.gorky.appiumdemo.pages;

import org.openqa.selenium.By;

/**
 * @author GUO
 * @description 今日来电、累计来电页面元素定位
 */
public class CallingPage {
	/**
	 * 定位元素：标题
	 */
	public static final By CP_TEXTVIEW_TITLEBAR = By.id("cn.jufuns.laikebao:id/common_tv_titlebar_title");
	
	/**
	 * 定位元素：返回
	 */
	public static final By CP_IMAGEVER_BACK = By.id("cn.jufuns.laikebao:id/common_iv_titlebar_left");
	
	/**
	 * 定位元素：搜索
	 */
	public static final By CP_IMAGEVIEW_SEARCH = By.id("cn.jufuns.laikebao:id/common_iv_titlebar_right");
	
	/**
	 * 定位元素：来电列表
	 */
	public static final By CP_LISTVIEW = By.id("cn.jufuns.laikebao:id/erv_phone_list");
	
	/**
	 * 定位元素：今日来电或累计来电列表中没有记录时的图标
	 */
	public static final By CP_IMAGEVIEW_CALL = By.id("cn.jufuns.laikebao:id/iv_fragment_call_record");
	
	/**
	 * 定位元素：今日来电或累计来电列表中没有记录时的提示语
	 */
	public static final By CP_TEXTVIEW_CALL = By.id("cn.jufuns.laikebao:id/tv_fragment_call_record");
	
	/**
	 * 定位元素：item中的手机号码
	 */
	public static final By RCP_TEXTVIEW_PHONE = By.id("cn.jufuns.laikebao:id/tv_customer_phone");
	
	/**
	 * 定位元素：item中的项目名称
	 */
	public static final By RCP_TEXTVIEW_PROJECT = By.id("cn.jufuns.laikebao:id/tv_customer_project_name");
	
	/**
	 * 定位元素：item中的拨号图标
	 */
	public static final By RCP_IMAGEVIEW_CALL = By.id("cn.jufuns.laikebao:id/iv_phone_call");
}
