package com.spectate.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spectate.base.BasePage;
import com.spectate.pages.SearchPage;
import com.spectate.pages.SearchResultsPage;

public class VerifySearchResultImageTitleText extends BasePage{
	
	@Test
	public void verifyImageTitleText() throws IOException {
		String searchQuery = "dealey plaza";
		SearchPage sp = new SearchPage();
		SearchResultsPage srp = sp.enterSearchQuery(searchQuery, "input_searchBox_XPATH");
		srp.clickImages("link_images_XPATH");
		validateEquals(srp.getResultText(or.getProperty("link_imageTitleText_XPATH")).toLowerCase(), searchQuery);	
	}
}
