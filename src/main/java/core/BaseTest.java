package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Esta superclasse contém métodos que serão utilizados por todas as classes de
 * testes como @Before e @After escrita e leitura de arquivos
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