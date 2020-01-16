package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;
import core.DriverFactory;

public class ModelsPage extends BasePage {

	public ArrayList<WebElement> getModels(String className) {
		ArrayList<WebElement> models = (ArrayList<WebElement>) DriverFactory.getDriver()
				.findElements(By.className(className));
		return models;
	}

	public void selectModel(int index) {
		ArrayList<WebElement> modelsButtons = this.getModels("SingleClickListField__button--3UZuT");
		WebElement model = modelsButtons.get(index);
		model.click();
	}

	public void typeModel(String searchBrand, String searchModel) throws InterruptedException {
		BrandsPage brand = new BrandsPage();
		brand.typeBrand(searchBrand);
		this.clickButtonClass("SingleClickListField__button--3UZuT");
		Thread.sleep(1000);
		writeClass("TextInput__textInput--3aA1s", searchModel);

	}

	public String getFilteredModel() {
		String filteredModel = DriverFactory.getDriver()
				.findElement(By.className("SingleClickListField__button--3UZuT")).getText();
		return filteredModel;
	}
	
	public String getErrorModels() {
		String errorMessage = DriverFactory.getDriver().findElement(By.className("HelpText__helpText--2dQU6")).getText();
		return errorMessage;
	}
}
