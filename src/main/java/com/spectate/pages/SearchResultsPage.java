package com.spectate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.spectate.base.BasePage;

public class SearchResultsPage extends BasePage{
	
	public void clickImages(String identifier) {
		//driver.findElement(By.xpath(identifier)).click();
		click(identifier);
	}
	
	public GoogleMap goToGoogleMaps(String identifier) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty(identifier))));
		click(identifier);
		return new GoogleMap();
	}
	public String getResultText(String identifier) {
		String resultText = "";
		try {
			resultText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier))).getText();
		} catch (Exception e) {
			e.printStackTrace();
			resultText = "";
		}
		return resultText;
	}
}
