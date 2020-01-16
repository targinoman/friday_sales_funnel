package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;
import core.DriverFactory;

public class ModelsPage extends BasePage {

	public ArrayList<WebElement> getModels(String className) {
		ArrayList<WebElement> models = (ArrayList<WebElement>) DriverFactory.getDriver().findElements(By.className(className));
		return models;
	}
	
	public void selectModel (int index) {
		ArrayList<WebElement> modelsButtons = this.getModels("SingleClickListField__button--3UZuT");
		WebElement model = modelsButtons.get(index);
		model.click();
	}
	
	public void typeModel (String model) {
		writeClass("TextInput__textInput--3aA1s", model);
	}
}
