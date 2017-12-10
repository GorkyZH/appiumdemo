package com.gorky.appiumdemo.pages;

import org.openqa.selenium.By;

/**
 * @author GUO
 * @description App登录页元素
 */

public class LoginPage {
	/**
	 * 定位元素：用户名输入框
	 * */
	public static final By LP_EDITTEXT_USERNAME = By.id("cn.jufuns.laikebao:id/et_user_name");
	
	/**
	 * 定位元素：密码输入框
	 * */
	public static final By LP_EDITTEXT_PWD = By.id("cn.jufuns.laikebao:id/et_user_pwd");
	
	/**
	 * 定位元素：登录按钮
	 * */
	public static final By LP_BUTTON_LOGIN = By.id("cn.jufuns.laikebao:id/btn_logon");
	
	/**
	 * 定位元素：忘记密码
	 * */
	public static final By LP_TEXTVIEW_RESETPWD = By.id("cn.jufuns.laikebao:id/tv_reset_pwd");
	
}
