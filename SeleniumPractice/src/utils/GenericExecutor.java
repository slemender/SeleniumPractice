package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericExecutor {

	private WebDriver driver;

	public GenericExecutor() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		this.driver = new ChromeDriver();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void loadURL(String URL) {
		getDriver().get(URL);
	}

	public void close() {
		getDriver().close();

	}
}
