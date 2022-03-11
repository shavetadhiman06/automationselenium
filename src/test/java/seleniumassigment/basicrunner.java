package seleniumassigment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assignment.pages.loginpage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basicrunner {
	public static WebDriver driver;
	

	public basicrunner(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	public static WebDriver launchbrowser(String browserName,String url)
	
	{
		
	//	extent.attachReporter(spark);
		
		String operatingSystem = System.getProperty("os.name");
		System.out.println("OS name =================" + System.getProperty("os.name"));
		
		if (operatingSystem.startsWith("Window")) {
			try {
				switch (browserName) {
				case "google chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "internet explorer":
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
					break;
				default:
					System.out.println("Browser not found");
				}
			
				driver.manage().window().maximize();
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
		}
		else if (operatingSystem.startsWith("Mac")) {
			try {
				switch (browserName) {
				case "google chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "internet explorer":
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
					break;
				default:
					System.out.println("Browser not found");
				}
				
				driver.manage().window().maximize();
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
		}
		driver.get(url);
		return driver;
		
		
	

	}
	

	

}
