package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import core.BasePage;
import core.BaseTest;
import pages.InsuranceRegister;

/**
 * This class is used to test Friday's sales funnel
 * 
 * @author rstargino
 * 
 **/

public class ParameterizedInsuranceTest extends BaseTest {

	InsuranceRegister ensurance = new InsuranceRegister();
	BasePage page = new BasePage();

	public static Collection<Object[]> getCollection() {

		return Arrays.asList(new Object[][] { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 },
				{ 2, 1 }, { 2, 2 } });
	}

	// This method will test the sales funnel using 3 brands and 3 models of each
	// brand, stopping on the Date Of Birthday page as requested

	@ParameterizedTest
	@MethodSource("getCollection")
	public void ensuranceRegisterTest(int indexBrand, int indexModel) throws InterruptedException, IOException {
		ensurance.registerEnsurance(indexBrand, indexModel);
		assertEquals("https://hello.friday.de/quote/enterBirthDate", page.getURL());
		page.takeScreenshot(String.valueOf(indexBrand) + String.valueOf(indexModel), "funnel");
	}
}