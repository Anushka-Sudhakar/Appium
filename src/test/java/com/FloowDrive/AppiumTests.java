package com.FloowDrive;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AppiumTests extends AppiumSetup {
	private LoginPage loginPageObj;
	private SoftAssert softAssert = new SoftAssert();

	@BeforeClass
	public void setUp() throws Exception {
		super.startServer();
		super.prepareAndroidForAppium();
	}

	@AfterClass
	public void tearDown() throws Exception {
		super.driver.quit();
		super.stopServer();
	}

	@Test(priority = 0)
	public void verifyTermsAndConditionsButton() {
		this.loginPageObj = new LoginPage(super.driver);

		if (this.loginPageObj.agreeTermsAndConditions()) {
			System.out.println("Reporting - Passed : Accepted Terms And Conditions");
			softAssert.assertTrue(true, "Accepted Terms And Conditions");

		} else {
			System.out.println(
					"Reporting - Failed : Terms And Conditions does not exist or accepted Terms And Conditions");
			softAssert.assertTrue(false, "Terms And Conditions does not exist or accepted Terms And Conditions");
		}
	}

	@Test(priority = 1)
	public void verifyLoginFunctionalityWithInvalidCredentials() {
		this.loginPageObj = new LoginPage(super.driver);

		if (!this.loginPageObj.invalidLogin()) {
			System.out.println("Reporting - Passed : User can not logged-in with invalid credentials");
			softAssert.assertTrue(true, "User can not logged-in with invalid credentials");
		} else {
			System.out.println("Reporting - Failed : User able to logged-in with invalid credentials");
			softAssert.assertTrue(false, "User able to logged-in with invalid credentials");
		}
	}
}
