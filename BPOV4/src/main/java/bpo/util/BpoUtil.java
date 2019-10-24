package bpo.util;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BpoUtil {

	public static long PAGE_LOAD_TIMEOUT=40;
	public static long IMPLICIT_WAIT=20;
	
	public static void webdriverwait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
				
	}
	
	public static String Dropdown(List<WebElement> element,String name)
	{String value = "";
		for(WebElement ele:element)
		{
				value=ele.getText();
				if(value.equals(name))
				{
					ele.click();
					break;
				}
		}
		return value;
	}
	
}
