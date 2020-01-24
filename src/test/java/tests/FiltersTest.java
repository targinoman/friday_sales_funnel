package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import core.BasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.BrandsPage;
import pages.ModelsPage;

/**
 * This class is used to test Brands and Models Filter All screenshots are saved
 * on target/screenshots
 * 
 * @author rstargino
 * 
 **/


public class FiltersTest extends BaseTest {

	BasePage page = new BasePage();
	BrandsPage brands = new BrandsPage();
	ModelsPage models = new ModelsPage();

	// This method will test if the brand Corvette appears after the user types it
	// on the search

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: To Verify if the search feature returns the typed brand")
	@Story("Story Name: Search Brand")
	public void brandsFilterTest() throws IOException {

		String expectedBrand = "Corvette";
		brands.typeBrand(expectedBrand);
		String filteredBrand = brands.getFilteredBrand();
		assertEquals(expectedBrand.toUpperCase(), filteredBrand);
		page.takeScreenshot("brandFilter", "_success");
	}

	// This method will test if typing a word that is not on the brands' list will
	// return the correct error message

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: To Verify if the search feature returns correct error message when a brand is not found")
	@Story("Story Name: Search Brand")
	public void brandsFilterErrorTest() throws IOException {

		brands.typeBrand("Xunda");
		assertEquals("Diese Marke ist uns nicht bekannt. Bitte überprüfe deine Eingabe.", brands.getErrorBrands());
		page.takeScreenshot("brandFilter", "_NotSuccess");
	}

	// This method will test if the model Spider appears after the user selects the
	// brand Alfa Romeo and types this model on the search

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: To Verify if the search feature returns the typed model")
	@Story("Story Name: Search Model")
	public void modelsFilterTest() throws InterruptedException, IOException {

		String expectedModel = "Spider";
		models.typeModel("Alfa Romeo", expectedModel);
		String actualModel = models.getFilteredModel();
		assertEquals(expectedModel.toUpperCase(), actualModel.toUpperCase());
		page.takeScreenshot("modelFilter", "_success");
	}

	// This method will test if typing a word that is not on the models' list will
	// return the correct error message

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: To Verify if the search feature returns correct error message when a model is not found")
	@Story("Story Name: Search Model")
	public void modelsFilterErrorTest() throws InterruptedException, IOException {

		models.typeModel("VW", "Mopa");
		assertEquals("Dieses Modell ist uns nicht bekannt. Bitte überprüfe deine Eingabe.", models.getErrorModels());
		page.takeScreenshot("modelFilter", "_NotSuccess");
	}

}
