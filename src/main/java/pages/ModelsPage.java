package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;
import core.DriverFactory;

/**
 * This class is used to manipulate operations on the selectModel page 
 * 
 * @author rstargino
 * 
 **/


public class ModelsPage extends BasePage {

	//This method returns all the models that can be selected on the page
	
	public ArrayList<WebElement> getModels(String className) {
		ArrayList<WebElement> models = (ArrayList<WebElement>) DriverFactory.getDriver()
				.findElements(By.className(className));
		return models;
	}

	//Based on the previous method this one is used to click on the selected model
	
	public void selectModel(int index) {
		ArrayList<WebElement> modelsButtons = this.getModels("SingleClickListField__button--3UZuT");
		WebElement model = modelsButtons.get(index);
		model.click();
	}

	//This method is used to type a desired model on the search field
	
	public void typeModel(String searchBrand, String searchModel) throws InterruptedException {
		BrandsPage brand = new BrandsPage();
		brand.typeBrand(searchBrand);
		this.clickButtonClass("SingleClickListField__button--3UZuT");
		Thread.sleep(1000);
		writeClass("TextInput__textInput--3aA1s", searchModel);

	}
	
	//This method is used to get the searched model

	public String getFilteredModel() {
		String filteredModel = DriverFactory.getDriver()
				.findElement(By.className("SingleClickListField__button--3UZuT")).getText();
		return filteredModel;
	}
	
	//This method is used to capture the error message in case of the brand typed is not found
	
	public String getErrorModels() {
		String errorMessage = DriverFactory.getDriver().findElement(By.className("HelpText__helpText--2dQU6")).getText();
		return errorMessage;
	}
}
