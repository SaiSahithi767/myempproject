package TestNGTC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Commons {
	
 public static final String BASE_URL = "http://localhost:9080/EmpDemo/";
 
  public static WebDriver getChrome(){
	  String driverpath;
	  WebDriver driver;
	  driverpath="E:\\vijay testing classes\\SeliniumsupportFiles\\chromedriver.exe";
	  System.setProperty("webdriver.chrome.driver", driverpath);
		driver= new ChromeDriver();
		return driver;
  }
  public static WebDriver getFirefox(){
	  String driverpath;
	  WebDriver driver;
	  driverpath="E:\\vijay testing classes\\SeliniumsupportFiles\\geckodriver.exe";
	  System.setProperty("webdriver.firefox.marionette", driverpath);
		driver= new FirefoxDriver();
		return driver;
  }
}
