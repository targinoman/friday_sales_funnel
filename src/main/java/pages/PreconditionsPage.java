package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;
import core.DriverFactory;

/**
 * This class is used to manipulate operations on the selectPreconditions page 
 * 
 * @author rstargino
 * 
 **/


public class PreconditionsPage extends BasePage{

	
	//This method is used to get all the preconditions
	
	public ArrayList<WebElement> getPreconditions(String className) {
		ArrayList<WebElement> preconditions = (ArrayList<WebElement>) DriverFactory.getDriver().findElements(By.className(className));
		return preconditions;
	}
	
	//This method is used to click on the selected precondition
	
	public void selectPrecondition (int index) {
		ArrayList<WebElement> preconditionsButtons = this.getPreconditions("SingleClickListField__button--3UZuT");
		WebElement precondition = preconditionsButtons.get(index);
		precondition.click();
	}
	
	//This method types a date on the field
	
	public void setInsuranceDate(String date) {
		DriverFactory.getDriver().findElement(By.className("TextInput__textInput--3aA1s")).clear();
		this.writeClass("TextInput__textInput--3aA1s", date);
	}
	
	//This method captures the error message below the date input field
	
	public String getErrorMessage() {
		String message = DriverFactory.getDriver().findElement(By.className("ValidationLabel__validationLabel--2km9U")).getText();
		return message;
	}
}
