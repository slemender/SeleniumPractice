package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import utils.GenericExecutor;

public class automationpracticeMethods {

	GenericExecutor g = new GenericExecutor();
	
	public void register () throws InterruptedException {
		g.loadURL("http://automationpractice.com/");
		g.getDriver().findElement(By.linkText("Sign in")).click();
		g.getDriver().findElement(By.id("email_create")).sendKeys("somerandommail"+Math.random()*10+"@mail.com");
		g.getDriver().findElement(By.id("SubmitCreate")).click();
		Thread.sleep(5000);
		g.getDriver().findElement(By.id("id_gender1")).click();
		g.getDriver().findElement(By.id("customer_firstname")).sendKeys("someFirstName");
		g.getDriver().findElement(By.id("customer_lastname")).sendKeys("someLastName");
		g.getDriver().findElement(By.id("passwd")).sendKeys("Password12345");
		Select day = new Select(g.getDriver().findElement(By.id("days")));
		day.selectByValue("15");
		Select months = new Select(g.getDriver().findElement(By.id("months")));
		months.selectByValue("7");
		Select years = new Select(g.getDriver().findElement(By.id("years")));
		years.selectByValue("1991");
		g.getDriver().findElement(By.id("newsletter")).click();
		g.getDriver().findElement(By.id("optin")).click();
		g.getDriver().findElement(By.id("firstname")).sendKeys("someFirstName");
		g.getDriver().findElement(By.id("lastname")).sendKeys("someLastName");
		g.getDriver().findElement(By.id("company")).sendKeys("some company");
		g.getDriver().findElement(By.id("address1")).sendKeys("some address");
		g.getDriver().findElement(By.id("address2")).sendKeys("some address no 2");
		g.getDriver().findElement(By.id("city")).sendKeys("some city");
		g.getDriver().findElement(By.id("postcode")).sendKeys("85281");
		Select id_state = new Select(g.getDriver().findElement(By.id("id_state")));
		id_state.selectByVisibleText("Arizona");
		g.getDriver().findElement(By.id("other")).sendKeys("other info bla bla bla");
		g.getDriver().findElement(By.id("phone")).sendKeys("1234567890");
		g.getDriver().findElement(By.id("phone_mobile")).sendKeys("0640987654321");
		g.getDriver().findElement(By.id("alias")).clear();
		g.getDriver().findElement(By.id("alias")).sendKeys("This is my alias");
		
		g.getDriver().findElement(By.id("submitAccount")).click();
		
		if (g.getDriver().findElement(By.className("info-account")).getText().equals("Welcome to your account. Here you can manage all of your personal information and orders.")) {
			System.out.println("SUccess");
		}
		else {
			System.out.println("Failed");
		}
		
	}
}
