package bpo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
			 String current = new java.io.File( "." ).getCanonicalPath();
//			FileInputStream file = new FileInputStream("D:\\Eclipse\\workspace\\BPOV4\\src\\main\\java\\bpo\\config\\BpoConfig.properties");
			FileInputStream file = new FileInputStream(current+"\\src\\main\\java\\bpo\\config\\BpoConfig.properties");
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
	
	public void initialisation() throws InterruptedException 
	{
		String browsername=prop.getProperty("browser");
		String url=prop.getProperty("baseurl");
		System.out.println("done");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Brinder\\BrowserDrivers\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--profile-directory=Default");
			options.addArguments("user-data-dir=C:\\Users\\brinderjeet.singh\\Desktop\\WebDriver - Chrome");
			driver=new ChromeDriver(options);			
			
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
//		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(BpoUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(BpoUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("baseurl"));
		Thread.sleep(1000);
		
				
	}
	
}
