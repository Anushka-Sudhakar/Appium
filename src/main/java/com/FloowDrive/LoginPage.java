package com.FloowDrive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	private static final By tc_AgreeId  = By.id("btn_agree");
	 private static final By userId      = By.id("edit_text_email");
	 private static final By password  = By.id("edit_text_password");
	 private static final By login_Button = By.id("btn_login");
	 private static final By welcome_Msg  = By.id("btn_welcome_close");

	 public LoginPage(WebDriver driver)
	 {
	  super(driver);
	 }

	 public boolean agreeTermsAndConditions()
	 {
	  boolean flag = false;
	  super.waitDefault();
	  if (super.existsElement(tc_AgreeId))
	  {
	   super.clickOnWebElement(tc_AgreeId);
	   flag = true;
	  }
	  return flag;

	 }

	 public boolean invalidLogin()
	 {
	  super.waitDefault();
	  super.clearTextOnWebElement(userId);
	  super.enterTextOnWebElement(userId, "Pswaea72@gmail.com");
	  super.enterTextOnWebElement(password, "anishka2003");
	  super.clickOnWebElement(login_Button);
	  return super.existsElement(welcome_Msg);

	 }
}
