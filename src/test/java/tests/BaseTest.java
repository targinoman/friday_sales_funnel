package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import core.DriverFactory;
import core.Propriedades;
import listener.AllureTestWatcher;

/**
 * This superclass has methods that will be used for all other
 * test classes
 * 
 * @author rstargino
 * 
 **/
@ExtendWith(AllureTestWatcher.class)
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