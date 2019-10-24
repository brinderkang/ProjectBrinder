package bpo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import bpo.util.BpoUtil;

public class WebDriverDemo {

	public static WebDriver driver;
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Brinder\\BrowserDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(BpoUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(BpoUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("http://oca-mel-test:8108");
		
		driver.findElement(By.id("txtLogin")).sendKeys("bpo.admin@yopmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("Dell@123");;
//		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();;
		driver.findElement(By.name("btnSign")).click();
		

	}

}
