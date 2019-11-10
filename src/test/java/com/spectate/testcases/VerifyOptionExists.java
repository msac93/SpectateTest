package com.spectate.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.spectate.base.BasePage;
import com.spectate.pages.GoogleMap;
import com.spectate.pages.SearchPage;
import com.spectate.pages.SearchResultsPage;

public class VerifyOptionExists extends BasePage {
	@Test
	public void verifyImageTitleText() {
		SearchPage sp = new SearchPage();
		SearchResultsPage srp= sp.enterSearchQuery("Google Maps", "input_searchBox_XPATH");
		GoogleMap gm = srp.goToGoogleMaps("link_googleMap_XPATH");
		gm.clickonOption();
		Assert.assertEquals(gm.checkLabelExists("Flat Earth View"), true, "Verification Failed: The link 'Flat Earth View' does not exist in the options");
	}
}
