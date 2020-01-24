package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import core.BasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.PreconditionsPage;

/**
 * This class is used to test the input field that asks for the date of
 * insurance coverage
 * All screenshots are saved on target/screenshots
 * 
 * @author rstargino
 * 
 **/

public class PreconditionsDateTest extends BaseTest {

	PreconditionsPage precondition = new PreconditionsPage();
	BasePage page = new BasePage();

//	public static Collection<Object[]> getCollection() {
//
//		return Arrays.asList(new Object[][] {
//				{ "22081985", "Hups! Dieses Datum liegt in der Vergangenheit. Bitte �berpr�fe deine Eingabe." },
//				{ "22082035", "Hups! Dieses Datum liegt zu weit in der Zukunft. Bitte �berpr�fe deine Eingabe." } });
//	}

	// This method tests if putting a date in the past or in the future will return
	// the proper error message

	@ParameterizedTest
//	@MethodSource("getCollection")
	@CsvSource({"22081985,Hups!! Dieses Datum liegt in der Vergangenheit. Bitte �berpr�fe deine Eingabe.", "22082035,Hups! Dieses Datum liegt zu weit in der Zukunft. Bitte �berpr�fe deine Eingabe."})
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Typing an insurance start date in the past and in the future and getting error messages")
	@Story("Story Name: Insurance Start Date of Coverage")
	public void setEnsuranceDateTest(String date, String errorMessage) throws IOException {
		precondition.setInsuranceDate(date);
		assertEquals(errorMessage, precondition.getErrorMessage());
		page.takeScreenshot(date + "_", errorMessage.substring(13, 44));
	}
}
