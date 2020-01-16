package core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Esta classe tem a função de atribuir linguagem de alto nível aos métodos do
 * Selenium
 * 
 * @author rstargino
 * 
 **/

public class BasePage {

	/* ================================= URL ==================================	*/

	public void goToURL(String url) {
		DriverFactory.getDriver().get(url);
	}

	public String getURL() {
		return DriverFactory.getDriver().getCurrentUrl();
	}
	
	/* ================================= PAGES ================================== */
	
	public void pageAnalysis() throws InterruptedException {
		Thread.sleep(1500);
		String pageURL = this.getURL();
		
		if(pageURL.endsWith("selectBodyType") || pageURL.endsWith("selectFuelType") || pageURL.endsWith("selectEnginePower") || pageURL.endsWith("selectEngine")) {
			this.clickButtonClass("SingleClickListField__button--3UZuT");
		}
		
		if(pageURL.endsWith("enterRegistrationDate")) {
			this.writeClass("TextInput__textInput--3aA1s", "081985");
			this.clickButtonClass("Button__style_primary--1-CZ1");
		}
	}

	/* ================================= INPUT TEXT ================================== */

	public void writeClass(String classe, String text) {
		DriverFactory.getDriver().findElement(By.className(classe)).sendKeys(text);
	}

	/* ====================================== BUTTON ====================================== */

	public void clickButtonClass(String buttonClass) {
		DriverFactory.getDriver().findElement(By.className(buttonClass)).click();
	}
	
	/* ====================================== SCREENSHOT ====================================== */
	
	public void takeScreenshot(String fileName, String complemento) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File file = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(
				"target" + File.separator + "screenshot" + File.separator + fileName + " " + complemento + ".jpg"));
	}
	
	/* =========================== EXPLICIT WAIT =========================== */

	public void waitForClass(String className) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
	}

}