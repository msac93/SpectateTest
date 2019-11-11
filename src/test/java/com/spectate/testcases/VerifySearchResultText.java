package com.spectate.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.spectate.base.BasePage;
import com.spectate.pages.SearchPage;
import com.spectate.pages.SearchResultsPage;
import com.spectate.utilities.Utilities;

public class VerifySearchResultText extends BasePage{

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void verifySearchText(Hashtable<String,String> data) throws IOException {
		String searchQuery = data.get("SearchQuery");
		SearchPage sp = new SearchPage();
		SearchResultsPage srp = sp.enterSearchQuery(searchQuery, "input_searchBox_XPATH");
		validateEquals(srp.getResultText(or.getProperty("link_firstResult_XPATH")).toLowerCase(), searchQuery);
	}

}
