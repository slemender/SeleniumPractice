package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.GenericExecutor;

public class automationpractice {

	GenericExecutor g = new GenericExecutor();
	automationpracticeMethods a = new automationpracticeMethods();

	@Test
	public void automationpracticeTest() throws InterruptedException {
		a.register();
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After test");
		// g.close();
	}

}
