package core;

/**
 * This class is used to define what browser to use for testing
 * 
 * @author rstargino
 * 
 **/

public class Propriedades {

	public static boolean FECHAR_BROWSER = true;

	public static Browsers browser = Browsers.FIREFOX;

	public enum Browsers {
		CHROME, FIREFOX
	}
}