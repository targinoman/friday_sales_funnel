package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import core.BasePage;
import core.BaseTest;
import pages.BrandsPage;
import pages.ModelsPage;

public class FiltersTest extends BaseTest{

	BasePage page = new BasePage();
	BrandsPage brands = new BrandsPage();
	ModelsPage models = new ModelsPage();
	
	
	@Test
	public void brandsFilterTest() {
		String expectedBrand = "Corvette";
		brands.typeBrand(expectedBrand);
		String filteredBrand = brands.getFilteredBrand();
		assertEquals(expectedBrand.toUpperCase(), filteredBrand);
	}
	
	@Test
	public void brandsFilterErrorTest() {
		brands.typeBrand("Xunda");
		assertEquals("Diese Marke ist uns nicht bekannt. Bitte überprüfe deine Eingabe.", brands.getErrorBrands());
	}
	
	@Test
	public void modelsFilterTest() throws InterruptedException {
		String expectedModel = "Spider";		
		models.typeModel("Alfa Romeo", expectedModel);
		String actualModel = models.getFilteredModel();
		assertEquals(expectedModel.toUpperCase(), actualModel.toUpperCase());
		
	}
	
	@Test
	public void modelsFilterErrorTest() throws InterruptedException {		
		models.typeModel("VW", "Mopa");
		assertEquals("Dieses Modell ist uns nicht bekannt. Bitte überprüfe deine Eingabe.", models.getErrorModels());
	}
	
}
