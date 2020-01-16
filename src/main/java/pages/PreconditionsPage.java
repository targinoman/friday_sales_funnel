package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;
import core.DriverFactory;

public class PreconditionsPage extends BasePage{

	
	public ArrayList<WebElement> getPreconditions(String className) {
		ArrayList<WebElement> preconditions = (ArrayList<WebElement>) DriverFactory.getDriver().findElements(By.className(className));
		return preconditions;
	}
	
	public void selectPrecondition (int index) {
		ArrayList<WebElement> preconditionsButtons = this.getPreconditions("SingleClickListField__button--3UZuT");
		WebElement precondition = preconditionsButtons.get(index);
		precondition.click();
	}
	
	public void setEnsuranceDate(String date) {
		DriverFactory.getDriver().findElement(By.className("TextInput__textInput--3aA1s")).clear();
		this.writeClass("TextInput__textInput--3aA1s", date);
	}
	
	public String getErrorMessage() {
		String message = DriverFactory.getDriver().findElement(By.className("ValidationLabel__validationLabel--2km9U")).getText();
		return message;
	}
}
