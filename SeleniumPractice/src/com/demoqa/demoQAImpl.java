package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.GenericExecutor;

public class demoQAImpl {

	@Test
	public void alert() throws InterruptedException {
		GenericExecutor g = new GenericExecutor();

		WebDriverWait wait = new WebDriverWait(g.getDriver(), 30);
		
		g.loadURL("https://demoqa.com/");
		g.getDriver().findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[6]")).click();
	}
}
