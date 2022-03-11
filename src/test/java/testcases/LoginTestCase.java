package testcases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assignment.pages.HomePage;
import com.assignment.pages.loginpage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import seleniumassigment.ScreenShot;
import seleniumassigment.basicrunner;

public class LoginTestCase {

	
public	WebDriver driver;

	loginpage lp;
	//basicrunner basic;
	HomePage hp;
	  int i = 0;
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
	//Launch of the given browser
	//@Parameters({"browserName"})
	@BeforeTest	
	public void StartBrowser()
	{
		extent.attachReporter(spark);
		Reporter.log("Launching Google Chrome Driver version for this test"); 
		driver=basicrunner.launchbrowser("google chrome","http://zero.webappsecurity.com/login.html");
		lp=new loginpage(driver);
		lp.loginTosite("username","password");

		
	}
	
	
	
	@Test
	public void HomePageVerify() throws InterruptedException
	{
		
		ExtentTest test=extent.createTest("Verify the homepage is opened After Login ").assignAuthor("shaveta Dhiman")
				.assignCategory("smoke test")
				.assignDevice("chrome");
		String expected_title=driver.getTitle();
	String Actual_title="Zero - Account Summary";
	if(driver.getTitle().equals("Zero - Account Summary")) {
		test.pass("testcase passed"+Actual_title);
	}
	else
	{
		test.fail("testcase failed");
	}
	Assert.assertEquals(expected_title, Actual_title);
	}
	
	
	@Test
	public void verifyAccountAcctivity() throws InterruptedException
	{
		
		hp=new HomePage(driver);
		Thread.sleep(2000);
		ExtentTest test=extent.createTest("Verify Account Activity exist  ").assignAuthor("shaveta Dhiman")
				.assignCategory("smoke test")
				.assignDevice("chrome");
		try {
		hp.ClickAccountActivity();
		Thread.sleep(1000);
	String showtxntitle=hp.showtransactionstitle();
	if(showtxntitle.equals("Show Transactions"))
	{
		test.pass("show txn summary is visible when clicked ");
	}
	else
	{
		test.fail("show txn summary is not visible hence testcase is failed");
		
	}}
	catch(Exception e)
{
	test.fail(e);
	Assert.fail();
}
	}
	
	
	@Test
	public void verifyMoneyMap()
	{
		hp=new HomePage(driver);
		ExtentTest test=extent.createTest("verify MoneyMap Tab exist ").assignAuthor("shaveta Dhiman")
				.assignCategory("smoke test")
				.assignDevice("chrome");
		try {
			hp.ClickMoneyMap();
			test.pass("MoneyMap tab exist on the device");
			
			
		}
		catch(Exception e)
		{
			test.fail(e);
			Assert.fail();
		}
	}
		
		
	
	
	@Test
	public void Moneymap()
	{
		hp=new HomePage(driver);
		ExtentTest test=extent.createTest("verify current MoneyMap tab").assignAuthor("shaveta Dhiman")
				.assignCategory("smoke test")
				.assignDevice("chrome");
		try {
			hp.ClickMoneyMaplatest();
			test.pass("latestMoneyMap is clicked");
		}
		catch(Exception e)
		{
			test.fail(e);
			Assert.fail();
		}
	}
	
	
	
	@Test
	public void verifycategoryonVerifyMoneyMap()
	{
		hp=new HomePage(driver);
		ExtentTest test=extent.createTest("verify current MoneyMap tab").assignAuthor("shaveta Dhiman")
				.assignCategory("smoke test")
				.assignDevice("chrome");
		try {
			hp.ClickMoneyMaplatest();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			
			if(hp.getcategorytext().equals("Category"))
			{
				test.pass("category is visible when scrolled down");
			
			}
		
		}
		catch(Exception e)
		{
			test.fail(e);
			Assert.fail();
		}
	}
		
	
	@Test
	
	public void verifydeposittotal()
	{
		hp=new HomePage(driver);
	ExtentTest test=extent.createTest("verify deposit total").assignAuthor("shaveta Dhiman")
			.assignCategory("smoke test")
			.assignDevice("chrome");
	try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", hp.MoneyMaplst);
		Thread.sleep(3000);
		
		int expectdepositcist=hp.deposittotal();
		int actualdepositcost=hp.totaldeposit();
		if(expectdepositcist==actualdepositcost)
		{
			test.pass("total deposit is coorect");
		}
	
	}
	catch(Exception e)
	{
		test.fail(e);
		Assert.fail();
	}
		
	}
	
@Test
	
	public void verifyspendingtotal()
	{
		hp=new HomePage(driver);
	ExtentTest test=extent.createTest("verify Spending total").assignAuthor("shaveta Dhiman")
			.assignCategory("smoke test")
			.assignDevice("chrome");
	try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", hp.MoneyMaplst);
		Thread.sleep(3000);
		
		int expectdepositcist=hp.totalspending();
		int actualdepositcost=hp.totaldeposit();
		if(expectdepositcist==actualdepositcost)
		{
			test.pass("total deposit is coorect");
		}
	
	}
	catch(Exception e)
	{
		test.fail(e);
		Assert.fail();
	}
		
	}

@Test

public void whatslefttotall()
{
	hp=new HomePage(driver);
ExtentTest test=extent.createTest("verify whatsleft").assignAuthor("shaveta Dhiman")
		.assignCategory("smoke test")
		.assignDevice("chrome");
try {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", hp.whatsleft);
	Thread.sleep(3000);
	
	int Actuawhatsleft=hp.leftamount();
	int ExpectedWhatsleft=hp.left();
	if(Actuawhatsleft==ExpectedWhatsleft)
	{
		test.pass("total whatsleft value is ");
	}

}
catch(Exception e)
{
	test.fail(e);
	Assert.fail();
}
	
}



	 @AfterMethod
     public void screenshot(ITestResult result)
     {
                i = i+1;
                String name = "ScreenShot";
                String x = name+String.valueOf(i);
               if(ITestResult.FAILURE == result.getStatus())
                 {
                                ScreenShot.captureScreenShot(driver, x);
                  }
}
	@AfterTest
	public void afterTest()
	{
		extent.flush();
		driver.close();
	}

	
	
}
