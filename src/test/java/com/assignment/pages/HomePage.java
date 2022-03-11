package com.assignment.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(linkText = "Account Summary")
	WebElement AccountSummary;
	
	@FindBy(linkText = "Account Activity")
	WebElement AccountActivity;
	
	
	
	@FindBy(xpath="//form[@id='loginForm']/button(contains(., 'Login')") 
    WebElement loginButton;
	
	@FindBy(linkText = "My Money Mas")
	WebElement MoneyMap;
	
	@FindBy(linkText="My Money Map")
	public WebElement MoneyMaplst;
	
	@FindBy(xpath = "//*[@id=\"ui-tabs-1\"]/h2")
	WebElement showtransactions;
	
	@FindBy(xpath = "//*[@id=\"gridcolumn-1029-textEl\"]")
	WebElement category;
	
	
	@FindBy(xpath="//*[@id=\"gridview-1021-hd-Spendings\"]/td/div/div")
	WebElement spendingdone;
	
	@FindBy(xpath="//*[@id=\"gridview-1015-hd-Deposits\"]/td/div/div")
	WebElement deposit;
	
	@FindBy(xpath="//*[@id=\"gridview-1015-bd-Deposits\"]/td/table/tbody/tr[2]/td[2]/div")
	WebElement directdeposit;
	
	@FindBy(xpath="//*[@id=\"gridview-1015-bd-Deposits\"]/td/table/tbody/tr[3]/td[2]/div")
	WebElement Otherdeposit;
	
	@FindBy(xpath="//*[@id=\"gridview-1015-bd-Deposits\"]/td/table/tbody/tr[4]/td[2]/div")
	WebElement Transferfrombank;
	
	@FindBy(xpath="//*[@id=\"gridview-1015\"]/table/tbody/tr[4]/td[2]/div/b")
	WebElement deposittotal;
	
	@FindBy(xpath="//*[@id=\"gridview-1021\"]/table/tbody/tr[4]/td[2]/div/b")
	WebElement spending_total;
	
	@FindBy(xpath="//*[@id=\"gridview-1031\"]/table/tbody/tr[2]/td[2]/div")
	WebElement totalinflowamount;
	
	@FindBy(xpath="//*[@id=\"gridview-1031\"]/table/tbody/tr[3]/td[2]/div")
	WebElement totaloutflowamount;
	@FindBy(xpath="//*[@id=\"gridview-1031\"]/table/tbody/tr[4]/td[2]/div/b")
	public WebElement whatsleft;
	
	
	@FindBy(xpath="//*[@id=\"settingsBox\"]/ul/li[3]/a/text()")
	WebElement ussername;
	
	public String expectedtitle="Zero - Account Summary";
	
	//Constructor to initialize object
	
	public HomePage(WebDriver dr)
	{
		this.driver=dr;
		 PageFactory.initElements(driver, this);
	}
	
	
	public String ActualTitle()
	{
		return this.driver.getTitle();
	}
	
	public void ClickAccountActivity()    //click on Account Activity link 
	{
		this.AccountActivity.click();
	}
	
	
	public void ClickAccountSummary()    //click on Account Summary link 
	{
		this.AccountSummary.click();
	}
	
	public String AccountActivitytitle()
	{
		return this.AccountActivity.getText();
	}
	
	public String showtransactionstitle()
	{
		return this.showtransactions.getText();
	}
	
	public String MoneyMaptitle()
	{
		return this.MoneyMap.getText();	
	}
	
	public void ClickMoneyMap()
	{
		this.MoneyMap.click();
	}
	
	public void ClickMoneyMaplatest() {
		this.MoneyMaplst.click();
	}
	public String getcategorytext()
	{
		return this.category.getText();
	}
	
	public String getspeingdone()
	{
		return this.spendingdone.getText();
	}
	
	public String getdeposittext()
	{
		return this.deposit.getText();
		
	}
	public void clickusername()
	{
		 this.clickusername();
	}
	
	
	public int totaldeposit()
	{
		String depototal=deposittotal.getText();
		depototal=depototal.replaceAll("[^a-zA-Z0-9]", "");
		int totalval=Integer.parseInt(depototal);
		return totalval;
	}
	
	public int totalspending()
	{
		String depototal=spending_total.getText();
		depototal=depototal.replaceAll("[^a-zA-Z0-9]", "");
		int deptotalval=Integer.parseInt(depototal);
		return deptotalval;
	}
	
	
	public int left()
	{
		String finalleft=whatsleft.getText();
		finalleft=finalleft.replaceAll("[^a-zA-Z0-9]", "");
		int finalleftamount=Integer.parseInt(finalleft);
		return finalleftamount;
	}
	
	
	public int deposittotal()
	{
		String sValue = null;
		int total = 0;
		ArrayList<String>depositval=new ArrayList<String>();
		for(int i=2;i<=4;i++)
		{
		
	 sValue = driver.findElement(By.xpath("//*[@id=\"gridview-1015-bd-Deposits\"]/td/table/tbody/tr[" + i + "]/td[2]/div")).getText();
	
			depositval.add(sValue);
		System.out.println(sValue);
		}
		for (String str : depositval) {
			 str = str.replaceAll(
			          "[^a-zA-Z0-9]", "");
			 int num = Integer.parseInt(str); 
			total += num;
	       
	      }  
	
		 return total;
}
	public int spendingtotal()
	{
		String sValue = null;
		int total = 0;
		ArrayList<String>depositval=new ArrayList<String>();
		for(int i=2;i<=11;i++)
		{
		
	 sValue = driver.findElement(By.xpath("//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[" + i + "]/td[2]/div]")).getText();
	
			depositval.add(sValue);
		System.out.println(sValue);
		}
		for (String str : depositval) {
			 str = str.replaceAll(
			          "[^a-zA-Z0-9]", "");
			 int num = Integer.parseInt(str); 
			total += num;
	       
	      }  
	
		 return total;
}
	
	
	public int leftamount()
	{
		int whtsleft=0;
		String total_inflow=totalinflowamount.getText();
		String total_outflow=totaloutflowamount.getText();
		total_inflow=total_inflow.replaceAll("[^a-zA-Z0-9]", "");
		total_outflow=total_outflow.replaceAll("[^a-zA-Z0-9]", "");
		int inflowamount=Integer.parseInt(total_inflow);
		int outflowamounnt=Integer.parseInt(total_outflow);
		whtsleft=inflowamount-outflowamounnt;
		
		return whtsleft;
		
	}
}