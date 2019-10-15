package bpo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bpo.base.BpoBase;
import bpo.pages.HomePage;
import bpo.pages.LoginPage;

public class LoginpageTest extends BpoBase{
	
	LoginPage objloginpage;
	HomePage objhomePage;
	
	LoginpageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialisation();
		objloginpage=new LoginPage();
		
	} 
	
	@Test(priority=1)
	public void loginpagetitletest()
	{
		String title=objloginpage.validateLoginPageTile();
		Assert.assertEquals(title, "ASCENT ONE Login");
	}
	
	@Test(priority=2)
	public void logoImagetest()
	{
		boolean flag=objloginpage.validatelogo();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=3)
	public void logintest() throws InterruptedException
	{
		objhomePage=objloginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
//		driver.quit();
	}


}
