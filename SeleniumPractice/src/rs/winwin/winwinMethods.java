package rs.winwin;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.GenericExecutor;

public class winwinMethods {

	
	GenericExecutor g= new GenericExecutor();
	
@Test
public void loadSamsung() {
	g.loadURL("https://www.winwin.rs/");
	g.getDriver().findElement(By.tagName("span")).click();
	g.getDriver().findElement(By.linkText("PROIZVODI")).click();
	g.getDriver().findElement(By.partialLinkText("Mobilni")).click();
}

}
