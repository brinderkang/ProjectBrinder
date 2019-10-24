package bpo.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bpo.base.BpoBase;
import bpo.pages.BpoQuotationPage;
import bpo.pages.HomePage;
import bpo.pages.LoginPage;

public class BpoQuotationPagetest extends BpoBase {
	
	LoginPage objloginpage;	
	HomePage objhomepage;
	BpoQuotationPage objbpoquotation;
	
	BpoQuotationPagetest()
	{
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException
	{
		initialisation();
		objloginpage=new LoginPage();
		objhomepage=new HomePage();
		objloginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		objbpoquotation=objhomepage.BPOQuotationTile();
	}
	@Test(priority=1)
	public void searchpaneltest()
	{
		objbpoquotation.SearchPanel();
	}
	
	@Test(priority=2)
	public void ClintDDTest() throws InterruptedException
	{
		objbpoquotation.SelectClient();
		String client=objbpoquotation.GetClient();
		Assert.assertEquals(client, prop.getProperty("clientname"));
	}
	@Test(priority=3)
	public void SearchJobTest() throws InterruptedException
	{
		objbpoquotation.SearchJob();
	}
	@AfterMethod
	public void Teardown()
	{
		driver.close();
		driver.quit();
	}
}
