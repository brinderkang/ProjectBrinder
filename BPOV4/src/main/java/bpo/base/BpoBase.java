package bpo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import bpo.util.BpoUtil;
import bpo.util.BpoWebEventListener;

public class BpoBase {

	public Properties prop;
	public static WebDriver driver;
	BpoWebEventListener eventlistner;
	EventFiringWebDriver e_driver;
	
	public BpoBase()
	{
		prop=new Properties();
		try {
			FileInputStream file = new FileInputStream("D:\\Eclipse\\workspace\\BPOV4\\src\\main\\java\\bpo\\config\\BpoConfig.properties");
			prop.load(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initialisation()
	{
		String browsername=prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Brinder\\BrowserDrivers\\chromedriver.exe");
			driver=new ChromeDriver();			
			
		}
		if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Brinder\\BrowserDrivers\\geckodriver.exe");
			driver=new FirefoxDriver();			
			
		}
		
		eventlistner=new BpoWebEventListener();
		e_driver=new EventFiringWebDriver(driver);
		driver=e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(BpoUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(BpoUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("baseurl"));
		System.out.println("Url entered");
	}
	
}
