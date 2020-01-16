package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import core.BasePage;
import core.BaseTest;
import pages.EnsuranceRegister;

public class ParameterizedEnsuranceTest extends BaseTest{

	EnsuranceRegister ensurance = new EnsuranceRegister();
	BasePage page = new BasePage();

	public static Collection<Object[]> getCollection() {

		return Arrays.asList(new Object[][] { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 },
				{ 2, 1 }, { 2, 2 } });
	}

	@ParameterizedTest
	@MethodSource("getCollection")
	public void ensuranceRegisterTest(int indexBrand, int indexModel) throws InterruptedException, IOException {
		ensurance.registerEnsurance(indexBrand, indexModel);
		assertEquals("https://hello.friday.de/quote/enterBirthDate", page.getURL());
		page.takeScreenshot(String.valueOf(indexBrand) + String.valueOf(indexModel), "funnel");
	}
}
