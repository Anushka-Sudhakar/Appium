package com.FloowDrive;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;

	 public BasePage(WebDriver driver)
	 {
	  this.driver = driver;
	 }

	 public void clickOnWebElement(By aBy)
	 {
	  WebElement element = this.getWebElementByLocator(aBy);
	  element.click();
	  this.waitDefault();
	 }

	 public void clearTextOnWebElement(By aBy)
	 {
	  WebElement element = this.getWebElementByLocator(aBy);
	  element.clear();
	  this.waitDefault();
	 }

	 public void enterTextOnWebElement(By aBy, String aText)
	 {
	  WebElement element = this.getWebElementByLocator(aBy);
	  element.sendKeys(aText);
	  this.waitDefault();
	 }

	 public boolean existsElement(By aBy)
	 {
	  try
	  {
	   driver.findElement(aBy);
	  } catch (NoSuchElementException e)
	  {
	   return false;
	  }
	  return true;
	 }

	 public void waitDefault()
	 {
	  this.wait(1000);
	 }

	 private void waitForVisibilityOf(By aByElementLocator)
	 {
	  WebDriverWait wait = new WebDriverWait(this.driver, 30);
	  try
	  {
	   wait.until(ExpectedConditions.presenceOfElementLocated(aByElementLocator));
	   wait.until(ExpectedConditions.visibilityOfElementLocated(aByElementLocator));
	  } catch (NoSuchElementException e)
	  {
	   e.printStackTrace();
	  }
	 }

	 private WebElement getWebElementByLocator(By aBy)
	 {
	  this.waitForVisibilityOf(aBy);
	  WebElement webElement = this.driver.findElement(aBy);
	  this.waitDefault();
	  return webElement;
	 }

	 private void wait(int aTime)
	 {
	  try
	  {
	   Thread.sleep(aTime);
	  } catch (InterruptedException e)
	  {
	   e.printStackTrace();
	  }
	 }
}
