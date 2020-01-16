package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import core.BasePage;
import core.BaseTest;
import pages.PreconditionsPage;

public class PreconditionsDateTest extends BaseTest{

	PreconditionsPage precondition = new PreconditionsPage();
	BasePage page = new BasePage();
	
	public static Collection<Object[]> getCollection() {

		return Arrays.asList(new Object[][] { { "22081985", "Hups! Dieses Datum liegt in der Vergangenheit. Bitte �berpr�fe deine Eingabe." },
			{ "22082035", "Hups! Dieses Datum liegt zu weit in der Zukunft. Bitte �berpr�fe deine Eingabe." } });
	}
	
	
	@ParameterizedTest
	@MethodSource("getCollection")
	public void setEnsuranceDateTest(String date, String errorMessage) {		
		precondition.setEnsuranceDate(date);
		assertEquals(errorMessage, precondition.getErrorMessage());
	}
}
