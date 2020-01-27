package listener;

import java.util.Optional;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.DriverFactory;
import io.qameta.allure.Attachment;

public class AllureTestWatcher implements TestWatcher {

	// Screenshot attachment for Allure

//	@Attachment(value = "Page screenshot", type = "image/png")
//	public byte[] saveScreenshot(WebDriver driver) {
//		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
//		return ss.getScreenshotAs(OutputType.BYTES);
//	}
	
	
	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshot(byte[] screenShot) {
	    return screenShot;
	}

	@Override
	public void testAborted(ExtensionContext arg0, Throwable arg1) {
		System.out.println("Test aborted");

	}

	@Override
	public void testDisabled(ExtensionContext arg0, Optional<String> arg1) {
		System.out.println("Test Disabled");

	}

	@Override
	public void testFailed(ExtensionContext arg0, Throwable arg1) {
		byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
		saveScreenshot(screenshot);
//		Allure.addAttachment("Screenshot", "image/png");
//		Path content = Paths.get("allure-results");
//		try (InputStream is = Files.newInputStream(content)) {
//			Allure.addAttachment("My attachment", is);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 

	}

	@Override
	public void testSuccessful(ExtensionContext arg0) {
		System.out.println("Test Sucessful");

	}

}
