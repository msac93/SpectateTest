package com.spectate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.spectate.base.BasePage;

public class SearchPage extends BasePage{

	public SearchResultsPage enterSearchQuery(String searchQuery, String identifier){
		type(identifier, searchQuery);
		type(identifier, Keys.ENTER);
		//driver.findElement(By.xpath(identifier)).sendKeys(searchQuery);
		//driver.findElement(By.xpath(identifier)).sendKeys(Keys.ENTER);
		return new SearchResultsPage();
	}
	
	public GoogleMap selectOptionMap() {
		click("link_googleApps_XPATH");
		//driver.findElement(By.xpath(or.getProperty("link_googleApps_XPATH"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("link_maps_XPATH"))));
		click("link_maps_XPATH");
		return new GoogleMap();
	}
}
