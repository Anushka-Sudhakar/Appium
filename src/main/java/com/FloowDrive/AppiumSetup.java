package com.FloowDrive;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AppiumSetup {

	public WebDriver driver;

	 public void prepareAndroidForAppium() throws MalformedURLException
	 {
	  File appDir = new File("./src/resources");
	  File app = new File(appDir, "FlowDrive.apk");
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("platformName", "Android");
	  capabilities.setCapability("deviceName", "emulator");
	  capabilities.setCapability("app", app.getAbsolutePath());
	  capabilities.setCapability("appPackage", "com.thefloow.flo");
	  capabilities.setCapability("appActivity", "com.thefloow.flo.activity.LauncherActivity");
	  capabilities.setCapability("noReset", "true");
	  this.driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	 }
	 public void startServer()
	 {
	  Runtime runtime = Runtime.getRuntime();
	  try
	  {
	   runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 \"");
	   Thread.sleep(30000);
	  } catch (IOException | InterruptedException e)
	  {
	   e.printStackTrace();
	  }
	 }

	 public void stopServer()
	 {
	  Runtime runtime = Runtime.getRuntime();
	  try
	  {
	   runtime.exec("taskkill /F /IM node.exe");
	   runtime.exec("taskkill /F /IM cmd.exe");
	  } catch (IOException e)
	  {
	   e.printStackTrace();
	  }
	 }
}
