package bpo.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bpo.base.BpoBase;
import bpo.util.BpoUtil;

public class BpoQuotationPage extends BpoBase {

	@FindBy(xpath="//div[@class='white box clearfix pad30 searchAction customBox open']")
	WebElement searchpanel;
	
	@FindBy(xpath="//a[@class='toglerBtn selAction']")
	WebElement morefilter;
	
	@FindBy(xpath="//span[@class='k-dropdown-wrap k-state-default k-state-hover k-state-focused']")
	WebElement clientfield;
	
	@FindBy(xpath="(//span[@class='k-icon k-i-arrow-60-down'])[2]")
	WebElement clientDDArrow;
	
	@FindBy(xpath="//ul[@id='ddlClient_listbox']/li")
	List<WebElement> clientDDList;
	
	@FindBy(xpath="(//span[@class='k-input'])[2]")
	WebElement getclientname;
	
	@FindBy(id="txtJobId")
	WebElement jobId;
	
	@FindBy(xpath="(//span[@class='k-dropdown-wrap k-state-default'])[3]")
	WebElement jobNamefield;
	
	@FindBy(xpath="(//span[@class='k-icon k-i-arrow-60-down'])[3]")
	WebElement jobNameDDArrow;
	
	@FindBy(xpath="//ul[@id='ddlJobName_listbox']/li")
	List<WebElement> jobNameDdList;
	
	
	@FindBy(id="txtVariation")
	WebElement variation;
	
	@FindBy(xpath="(//span[@class='k-dropdown-wrap k-state-default'])[4]")
	WebElement clientDepartmentfield;
	
	@FindBy(xpath="(//span[@class='k-dropdown-wrap k-state-default'])[5]")
	WebElement productionCountryfield;
	
	@FindBy(id="txtProductRef")
	WebElement InternalRef;
	
	@FindBy(xpath="(//span[@class='k-dropdown-wrap k-state-default'])[6]")
	WebElement dateRangefield;
	
	@FindBy(id="btnSearch")
	WebElement searchButton;
	
	
	public BpoQuotationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	 public void SearchPanel()
	{
		 
		 BpoUtil.webdriverwait(driver, morefilter);
		 morefilter.click();
		boolean a=searchpanel.isDisplayed();
		
		clientfield.isDisplayed();
		jobId.isDisplayed();
		jobNamefield.isDisplayed();
		variation.isDisplayed();
		clientDepartmentfield.isDisplayed();
		productionCountryfield.isDisplayed();
		InternalRef.isDisplayed();
		dateRangefield.isDisplayed();
		
		
	}
	 
	 public void SelectClient() throws InterruptedException
	 {
		 clientDDArrow.click();
		 Thread.sleep(2000);
		 BpoUtil.Dropdown(clientDDList, prop.getProperty("clientname"));		 
	 }
	 public String GetClient()
	 {
		 String ClientName=getclientname.getText();
		 return ClientName;
	 }
	 
	 public void SelectJobName() throws InterruptedException
	 {
		 jobNameDDArrow.click();
		 Thread.sleep(1000);
		 BpoUtil.Dropdown(jobNameDdList, prop.getProperty("jobname"));
		 
	 }
	 
	 public void SearchJob() throws InterruptedException
	 {
		 SelectClient();
		 SelectJobName();
	 }
}
