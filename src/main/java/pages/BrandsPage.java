package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;
import core.DriverFactory;

public class BrandsPage extends BasePage {

	public ArrayList<WebElement> getBrands(String className) {
		ArrayList<WebElement> brands = (ArrayList<WebElement>) DriverFactory.getDriver()
				.findElements(By.className(className));
		return brands;
	}

	public void selectBrand(int index) {
		ArrayList<WebElement> brandsButtons = this.getBrands("SingleClickListField__button--3UZuT");
		WebElement brand = brandsButtons.get(index);
		brand.click();
	}

	public void typeBrand(String brand) {
		this.clickButtonClass("Button__style_primary--1-CZ1");
		this.clickButtonClass("Button__style_primary--1-CZ1");
		this.waitForClass("SingleClickListField__button--3UZuT");
		writeClass("TextInput__textInput--3aA1s", brand);
	}

	public String getFilteredBrand() {
		String filteredBrand = DriverFactory.getDriver()
				.findElement(By.className("SingleClickListField__button--3UZuT")).getText();
		return filteredBrand;
	}
	
	public String getErrorBrands() {
		String errorMessage = DriverFactory.getDriver().findElement(By.className("HelpText__helpText--2dQU6")).getText();
		return errorMessage;
	}
}
