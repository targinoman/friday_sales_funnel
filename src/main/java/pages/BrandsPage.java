package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;
import core.DriverFactory;
import io.qameta.allure.Step;

/**
 * This class is used to manipulate operations on the selectBrand page 
 * 
 * @author rstargino
 * 
 **/

public class BrandsPage extends BasePage {

	//This method returns all the brands that can be selected on the page
	@Step("Capturing all clickable brands")
	public ArrayList<WebElement> getBrands(String className) {
		ArrayList<WebElement> brands = (ArrayList<WebElement>) DriverFactory.getDriver()
				.findElements(By.className(className));
		return brands;
	}

	//Based on the previous method this one is used to click on the selected brand
	@Step("Clicking on the desired brand: {0}")
	public void selectBrand(int index) {
		ArrayList<WebElement> brandsButtons = this.getBrands("SingleClickListField__button--3UZuT");
		WebElement brand = brandsButtons.get(index);
		brand.click();
	}

	//This method is used to type a desired brand on the search field
	@Step("Typing desired brand on the search field:  {0}")
	public void typeBrand(String brand) {
		this.clickButtonClass("Button__style_primary--1-CZ1");
		this.clickButtonClass("Button__style_primary--1-CZ1");
		this.waitForClass("SingleClickListField__button--3UZuT");
		writeClass("TextInput__textInput--3aA1s", brand);
	}

	//This method is used to get the searched brand
	@Step("Capturing the typed brand")
	public String getFilteredBrand() {
		String filteredBrand = DriverFactory.getDriver()
				.findElement(By.className("SingleClickListField__button--3UZuT")).getText();
		return filteredBrand;
	}
	
	//This method is used to capture the error message in case of the brand typed is not found
	@Step("Capturing error message when typed brand was not found")
	public String getErrorBrands() {
		String errorMessage = DriverFactory.getDriver().findElement(By.className("HelpText__helpText--2dQU6")).getText();
		return errorMessage;
	}
}
