package com.gorky.appiumdemo.pages;

import org.openqa.selenium.By;

public class TitlebarPage {
	/**
	 * 点击返回按钮
	 */
	public static final By TP_IMAGEVIEWE_GOBACK = By.id("cn.jufuns.laikebao:id/common_iv_titlebar_left");
	
	/**
	 * 定位元素：页面标题
	 */
	public static final By TP_TEXTVIEW_TITLE = By.id("cn.jufuns.laikebao:id/common_tv_titlebar_title");
	
	/**
	 * 定位元素：搜索图标
	 */
	public static final By TP_IMAGEVIEW_SEARCH = By.id("cn.jufuns.laikebao:id/common_iv_titlebar_right");
	
	/**
	 * 定位元素：今日来电
	 */
	public static final By TP_TEXTVIEW_CALLING = By.id("cn.jufuns.laikebao:id/tv_today_incomming_call");
	
	/**
	 * 定位元素：今日抢客
	 */
	public static final By TP_TEXTVIEW_ROBGUEST = By.id("cn.jufuns.laikebao:id/tv_today_customer");
	
	/**
	 * 定位元素：累计来电
	 */
	public static final By TP_TEXTVIEEW_CALLINGNUM = By.id("cn.jufuns.laikebao:id/tv_total_incomming_call");
	
	/**
	 * 定位元素：累计抢客
	 */
	public static final By TP_TEXTVIEW_ROBGUESTNUM = By.id("cn.jufuns.laikebao:id/tv_total_customer");
}
