package bpo.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bpo.base.BpoBase;
import bpo.util.BpoUtil;

public class LoginPage extends BpoBase {
	
	@FindBy(id="txtLogin")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive center-block')]")
	WebElement logo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTile()
	{
		return driver.getTitle();
	}
	
	public boolean validatelogo()
	{
		return logo.isDisplayed();
	}
	public HomePage login(String un, String pwd) throws InterruptedException 
	{
		
		username.clear();
		username.sendKeys(un);	
		password.clear();
		password.sendKeys(pwd);
		loginbtn.click();
		Thread.sleep(5000);
//		driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
//		String script="window.location = \'http://flipkart.com'";
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("return window.stop");
//		Robot robot=new Robot();
//		robot.keyPress(KeyEvent.VK_ESCAPE);
//		Thread.sleep(3000);
//		robot.keyRelease(KeyEvent.VK_ESCAPE);
//		
//		
//		driver.navigate().refresh();

//		BpoUtil.webdriverwait(BpoBase.driver, HomePage.Logout);
		WebDriverWait wait=new WebDriverWait(driver,40);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@id='imgLogo']")));
		return new HomePage();
	}

}
