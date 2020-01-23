package pages;

import core.BasePage;
import io.qameta.allure.Step;

public class InsuranceRegister {

	BasePage page = new BasePage();
	BrandsPage brands = new BrandsPage();
	ModelsPage models = new ModelsPage();
	
	@Step("Navigate through screens and selecting desired options")
	public void registerEnsurance(int indexBrand, int indexModel) throws InterruptedException {
		page.clickButtonClass("Button__style_primary--1-CZ1");
		page.clickButtonClass("Button__style_primary--1-CZ1");
		page.waitForClass("SingleClickListField__button--3UZuT");
		brands.selectBrand(indexBrand);
		Thread.sleep(1500);
		models.selectModel(indexModel);
		String pageURL = page.getURL();
		while(!(pageURL.endsWith("enterBirthDate"))) {
			page.pageAnalysis();
			pageURL = page.getURL();
		}
	}
}
