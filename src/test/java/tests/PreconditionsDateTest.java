package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
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

		return Arrays.asList(new Object[][] { { "22081985", "Hups! Dieses Datum liegt in der Vergangenheit. Bitte überprüfe deine Eingabe." },
			{ "22082035", "Hups! Dieses Datum liegt zu weit in der Zukunft. Bitte überprüfe deine Eingabe." } });
	}
	
	
	@ParameterizedTest
	@MethodSource("getCollection")
	public void setEnsuranceDateTest(String date, String errorMessage) throws IOException {		
		precondition.setEnsuranceDate(date);
		assertEquals(errorMessage, precondition.getErrorMessage());
		page.takeScreenshot(date + "_", errorMessage.substring(13, 44));
	}
}
