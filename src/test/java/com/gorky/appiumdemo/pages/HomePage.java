package com.gorky.appiumdemo.pages;

import org.openqa.selenium.By;

/**
 * @author GUO
 * @description 首页元素
 */
public class HomePage {
	/**
	 * 定位元素：更多
	 * */
	public static final By HP_IMAGEVIEW_MORE = By.id("cn.jufuns.laikebao:id/common_iv_titlebar_left");
	
	/**
	 * 定位元素：我的客户数
	 * */
	public static final By HP_TEXTVIEW_GETCUSTOMER_COUNT = By.id("cn.jufuns.laikebao:id/tv_fragment_getcustomer_count");
	
	/**
	 * 定位元素：今日来电
	 * */
	public static final By HP_TEXTVIEW_GETCUSTOMER_INCALLING = By.id("cn.jufuns.laikebao:id/tv_fragment_getcustomer_incoming");
	
	/**
	 * 定位元素：今日抢客
	 * */
	public static final By HP_TEXTVIEW_GETCUSTOMER_ROBGUEST = By.id("cn.jufuns.laikebao:id/tv_fragment_getcustomer_robGuest");
	
	/**
	 * 定位元素： 累计来电
	 * */
	public static final By HP_TEXTVIEW_GETCUSTOMER_INCALLINGNUM = By.id("cn.jufuns.laikebao:id/tv_fragment_getcustomer_incomingNum");
	
	/**
	 * 定位元素：累计抢客
	 * */
	public static final By HP_TEXTVIEW_GETCUSTOMER_ROBGUESTNUM = By.id("cn.jufuns.laikebao:id/tv_fragment_getcustomer_robCount");
	
	/**
	 * 定位元素：抢客
	 * */
	public static final By HP_TEXTVIEW_GETCUSTOMER_ROB = By.id("cn.jufuns.laikebao:id/item_recyclerview_fragment_getcustomer_iv_rob");
	
	/**
	 * 定位元素：我的客户
	 * */
	public static final By HP_TEXT_MYCUSTOMER = By.id("cn.jufuns.laikebao:id/tv_my_customer");
	
	/**
	 * 定位元素：疯狂抢客
	 * */
	public static final By HP_TEXT_GETCUSTOMER = By.id("cn.jufuns.laikebao:id/tv_get_customer");
	
	/**
	 * 定位元素：抢客成功弹窗--标题
	 */
	public static final By HP_TEXTVIEW_TITLE = By.id("cn.jufuns.laikebao:id/title");
	
	/**
	 * 定位元素：抢客成功弹窗--继续抢客
	 */
	public static final By HP_BUTTON_NEGATIVE = By.id("cn.jufuns.laikebao:id/negativeButton");
	
	/**
	 * 定位元素：抢客成功弹窗--立即联系
	 */
	public static final By HP_BUTTON_POSITIVE = By.id("cn.jufuns.laikebao:id/positiveButton");
}
