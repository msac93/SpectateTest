package com.spectate.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spectate.base.BasePage;
import com.spectate.pages.GoogleMap;
import com.spectate.pages.SearchPage;
import com.spectate.pages.SearchResultsPage;
import com.spectate.utilities.Utilities;

public class VerifyOptionExists extends BasePage {
	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void verifyMapOptionsExists(Hashtable<String,String> data) {
		SearchPage sp = new SearchPage();
		SearchResultsPage srp= sp.enterSearchQuery(data.get("SearchQuery"), "input_searchBox_XPATH");
		GoogleMap gm = srp.goToGoogleMaps("link_googleMap_XPATH");
		gm.clickonOption();
		Assert.assertEquals(gm.checkLabelExists(data.get("OptionName")), true, "Verification Failed: The link 'Flat Earth View' does not exist in the options");
	}
}
