package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;
import core.DriverFactory;

public class BrandsPage extends BasePage{

	public ArrayList<WebElement> getBrands(String className) {
		ArrayList<WebElement> brands = (ArrayList<WebElement>) DriverFactory.getDriver().findElements(By.className(className));
		return brands;
	}
	
	public void selectBrand (int index) {
		ArrayList<WebElement> brandsButtons = this.getBrands("SingleClickListField__button--3UZuT");
		WebElement brand = brandsButtons.get(index);
		brand.click();
	}
	
	public void typeBrand (String brand) {
		writeClass("TextInput__textInput--3aA1s", brand);
	}
}
