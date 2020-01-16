package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import core.BasePage;
import core.BaseTest;
import pages.BrandsPage;
import pages.ModelsPage;

public class FiltersTest extends BaseTest {

	BasePage page = new BasePage();
	BrandsPage brands = new BrandsPage();
	ModelsPage models = new ModelsPage();

	@Test
	public void brandsFilterTest() throws IOException {
		String expectedBrand = "Corvette";
		brands.typeBrand(expectedBrand);
		String filteredBrand = brands.getFilteredBrand();
		assertEquals(expectedBrand.toUpperCase(), filteredBrand);
		page.takeScreenshot("brandFilter", "_success");
	}

	@Test
	public void brandsFilterErrorTest() throws IOException {
		brands.typeBrand("Xunda");
		assertEquals("Diese Marke ist uns nicht bekannt. Bitte überprüfe deine Eingabe.", brands.getErrorBrands());
		page.takeScreenshot("brandFilter", "_NotSuccess");
	}

	@Test
	public void modelsFilterTest() throws InterruptedException, IOException {
		String expectedModel = "Spider";
		models.typeModel("Alfa Romeo", expectedModel);
		String actualModel = models.getFilteredModel();
		assertEquals(expectedModel.toUpperCase(), actualModel.toUpperCase());
		page.takeScreenshot("modelFilter", "_success");
	}

	@Test
	public void modelsFilterErrorTest() throws InterruptedException, IOException {
		models.typeModel("VW", "Mopa");
		assertEquals("Dieses Modell ist uns nicht bekannt. Bitte überprüfe deine Eingabe.", models.getErrorModels());
		page.takeScreenshot("modelFilter", "_NotSuccess");
	}

}
