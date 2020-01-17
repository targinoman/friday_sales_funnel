package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * This superclass has methods that will be used for all other
 * test classes
 * 
 * @author rstargino
 * 
 **/

public abstract class BaseTest {

	@BeforeEach
	public void setup() {
		DriverFactory.getDriver().get("https://hello.friday.de/quote/selectPrecondition");
	}

	@AfterEach
	public void tearDown() {
		if (Propriedades.FECHAR_BROWSER) {
			DriverFactory.killDriver();
		}
	}

}