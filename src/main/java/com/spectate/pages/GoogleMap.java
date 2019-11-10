package com.spectate.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

import com.spectate.base.BasePage;

public class GoogleMap extends BasePage{

	public void clickonOption() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("link_signin_XPATH")))); // wait till the last element is loaded
		type("button_options_XPATH", Keys.RETURN);
		
	}
	
	public boolean checkLabelExists(String labelName) {
		boolean returnValue = false;
		List<WebElement> labels = driver.findElements(By.xpath(or.getProperty("label_flatEarthView_XPATH")));
		for(WebElement w: labels) {
			if(w.getText().equalsIgnoreCase(labelName))
				returnValue = true;
		}		
		return returnValue;
	}
}
