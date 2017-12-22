package com.gorky.appiumdemo.pages;

import org.openqa.selenium.By;

/**
 * @author GUO
 * @description 定位搜索页面的元素
 */

public class SearchPage {
	/**
	 * 定位元素：搜索框
	 */
	public static final By SP_EDITTEXT_SEARCH = By.id("cn.jufuns.laikebao:id/edt_search_keyword");
	
	/**
	 * 定位元素：取消按钮
	 */
	public static final By SP_TEXTVIEW_SEARCHCANCEL = By.id("cn.jufuns.laikebao:id/tv_search_cancel");
}
