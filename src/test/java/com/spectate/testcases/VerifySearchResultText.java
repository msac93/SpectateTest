package com.spectate.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.spectate.base.BasePage;
import com.spectate.pages.SearchPage;
import com.spectate.pages.SearchResultsPage;

public class VerifySearchResultText extends BasePage{

	@Test
	public void verifySearchText() throws IOException {
		String searchQuery = "chemtrail";
		SearchPage sp = new SearchPage();
		SearchResultsPage srp = sp.enterSearchQuery(searchQuery, "input_searchBox_XPATH");
		validateEquals(srp.getResultText(or.getProperty("link_firstResult_XPATH")).toLowerCase(), searchQuery);
	}

}
