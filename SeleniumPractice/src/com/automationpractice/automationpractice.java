package com.automationpractice;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.GenericExecutor;

public class automationpractice {

//	GenericExecutor g = new GenericExecutor();
	automationpracticeMethods a = new automationpracticeMethods();

	@Test
	public void automationpracticeTest() throws InterruptedException, IOException {
	//	a.register();
		// Assert.assertTrue(a.verifyEmail());
	//	a.login();
	//	a.buy();
	//   a.searchProduct();
	//	a.getAllPageLinks();
		a.getBrokenLinks();
	}

	@BeforeTest
	public void beforeTest() {
//		System.out.println("Before test");
	}

	@AfterTest
	public void afterTest() {
//		System.out.println("After test");

	}

}
