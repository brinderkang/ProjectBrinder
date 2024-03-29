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

public class HomePageTest extends BpoBase {
	
	
	LoginPage objloginpage;
	HomePage objhomepage;
	BpoQuotationPage objbpoquotation;
	
	HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException, AWTException
	{
		initialisation();
		
		objloginpage=new LoginPage();
		objbpoquotation=new BpoQuotationPage();
		objhomepage=objloginpage.login(prop.getProperty("username"), prop.getProperty("password"));			
	}
	
	@Test(priority=1)
	public void homepagelogotest()
	{
		boolean logo=objhomepage.HomepageLogo();
		Assert.assertTrue(logo, "Logo not matched");
	}
	
	@Test(priority=2)
	public void headerLinks()
	{
		boolean link=objhomepage.profilelink();
		boolean support=objhomepage.supportlink();
		boolean logout=objhomepage.logoutlink();		
	}
	
	@Test(priority=3)
	public void companynametest()
	{
		String companyname=objhomepage.CompanyName();
		Assert.assertEquals(companyname, "BPO Intelligence Pty Ltd");
	}
	
	@Test(priority=4)
	public void logoutLabel()
	{
		String logout=objhomepage.logoutlable();
		Assert.assertEquals(logout, "LOGOUT");
	}
	
	@Test(priority=5)
	public void clickbpoquotationtab()
	{
		objbpoquotation=objhomepage.BPOQuotationTile();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
		driver.quit();
	}
}
