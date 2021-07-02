package com.automationpractice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import utils.GenericExecutor;

public class annotationsPractice {
	static GenericExecutor g = new GenericExecutor();
	String URL="http://automationpractice.com/index.php";
	WebDriverWait wait = new WebDriverWait(g.getDriver(), 30);
	automationpracticeMethods a = new automationpracticeMethods();
	Actions actions = new Actions(g.getDriver());
	String homePage = "http://automationpractice.com/index.php";
	String username = "somerandommail" + Math.random() * 1000 + "@gmail.com";
	String pass = "Password12345";

	@Test
	public void register() throws InterruptedException {	
		 Reporter.log("Register start");
		g.getDriver().get(URL);
		g.getDriver().findElement(By.linkText("Sign in")).click();
		g.getDriver().findElement(By.id("email_create")).sendKeys(username);
		g.getDriver().findElement(By.id("SubmitCreate")).click();
		Thread.sleep(5000);
		g.getDriver().findElement(By.id("id_gender1")).click();
		g.getDriver().findElement(By.id("customer_firstname")).sendKeys("someFirstName");

		g.getDriver().findElement(By.id("customer_lastname")).sendKeys("someLastName");
		g.getDriver().findElement(By.id("passwd")).sendKeys(pass);
		// g.writeToFile("automationPractice",username,pass);
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

		if (g.getDriver().findElement(By.className("info-account")).getText()
				.equals("Welcome to your account. Here you can manage all of your personal information and orders.")) {
			System.out.println("SUccess");
		} else {
			System.out.println("Failed");
		}

	}

	public boolean verifyEmail() throws InterruptedException {
		
		g.getDriver().findElement(By.linkText("Sign in")).click();
		g.getDriver().findElement(By.id("email_create")).sendKeys("somerandommail" + Math.random() * 10);
		g.getDriver().findElement(By.id("SubmitCreate")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_account_error")));
		if (g.getDriver().findElement(By.id("create_account_error")).getText().equals("Invalid email address.")) {
			return true;
		} else {
			return false;
		}
	}

	public void writeToFile(String testCase, String user, String pass) throws IOException {
		File myObj = new File("Text Files\\" + testCase + ".txt");
		FileOutputStream fos = new FileOutputStream(myObj);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		osw.write(user);
		osw.append('\n');
		osw.write(pass);
		osw.close();
	}
	
	@Test(dependsOnMethods = { "register", "login"})
	public void buy() throws InterruptedException {
		Actions actions = new Actions(g.getDriver());
		WebElement target = g.getDriver().findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/a[1]"));

		Action mouseOverHome = actions.moveToElement(target).build();
		mouseOverHome.perform();
		g.getDriver().findElement(By.linkText("T-shirts")).click();

		g.getDriver().findElement(By.xpath("//span[contains(text(),'More')]")).click();
		g.getDriver().findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
		g.getDriver().findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("2");
		Select id_state = new Select(g.getDriver().findElement(By.id("group_1")));
		id_state.selectByVisibleText("L");
		g.getDriver().findElement(By.id("color_14")).click();
		g.getDriver().findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Proceed to checkout")));
		g.getDriver().findElement(By.partialLinkText("Proceed to checkout")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Proceed to checkout")));
		g.getDriver().findElement(By.partialLinkText("Proceed to checkout")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")));
		g.getDriver()
				.findElement(By
						.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/div[1]/div[3]/textarea[1]"))
				.sendKeys("Some special order");
		g.getDriver()
				.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]"))
				.click();

		g.getDriver()
				.findElement(By.xpath("//label[contains(text(),'I agree to the terms of service and will adhere to')]"))
				.click();
		g.getDriver()
				.findElement(
						By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]/span[1]"))
				.click();
		g.getDriver().findElement(By.partialLinkText("Pay by bank wi")).click();
		g.getDriver()
				.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]"))
				.click();
		g.getDriver().findElement(By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]"));

	}

	
	
	@Test(dependsOnMethods = { "register"})
	public void login () {
		
		g.getDriver().get(URL);
		g.getDriver().findElement(By.linkText("Sign in")).click();
		g.getDriver().findElement(By.id("email")).sendKeys(username);
		g.getDriver().findElement(By.id("passwd")).sendKeys(pass);
		g.getDriver().findElement(By.id("SubmitLogin")).click();
	}
	
	@Test
	public void searchProduct() {
		WebElement target = g.getDriver().findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/a[1]"));
		Action mouseOverHome = actions.moveToElement(target).build();
		mouseOverHome.perform();
		g.getDriver().findElement(By.linkText("T-shirts")).click();
		String productName = g.getDriver().findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]"))
				.getText();
		g.getDriver().findElement(By.id("search_query_top")).sendKeys(productName);
		g.getDriver().findElement(By.id("search_query_top")).sendKeys(Keys.RETURN);
		if (g.getDriver().findElement(By.id("page")).getText().contains(productName)) {
			System.out.println("Test was successful");
		} else {
			System.out.println("Test was not successful");
		}

	}

	public void getAllPageLinks() {

		List<WebElement> allLinks = g.getDriver().findElements(By.tagName("a"));
		for (WebElement link : allLinks) {
			System.out.println(link.getText() + " - " + link.getAttribute("href"));
		}
	}

	public void getBrokenLinks() { 
		
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		g.getDriver().manage().window().maximize();

		g.getDriver().get(homePage);

		List<WebElement> links = g.getDriver().findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {

			url = it.next().getAttribute("href");

		//	System.out.println(url);

			if (url == null || url.isEmpty()) {
				System.out.println(url+ " - URL is either not configured for anchor tag or it is empty");
				continue;
			}

//			if (!url.startsWith(homePage)) {
//				System.out.println("URL belongs to another domain, skipping it.");
//				continue;
//			}

			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
//				} else {
//					System.out.println(url + " is a valid link");
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) throws InterruptedException {
		annotationsPractice ap= new annotationsPractice();
		
	//	ap.register();
	//	ap.login();
		
	}
	@AfterTest
	public void close() {
		g.getDriver().close();
	}
}
