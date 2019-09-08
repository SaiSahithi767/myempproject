package TestNGTC;
import org.openqa.selenium.Alert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class AdminLogin extends commonDriver {
	/* static WebDriver driver;
	
	@Parameters({"myName"})
	@Test
	 public void parameterTest(String myName) {
	      System.out.println("Parameterized value is : " + myName);
	   }
	
	  @BeforeClass
	  public static void setup() {
			driver= Commons.getChrome();
	  }
	  
	  
	  @BeforeMethod
	  public void everyTest(){
		  driver.get(Commons.BASE_URL);
	  }
	  
	  
	  @Test
	  public void validLogIn() throws InterruptedException
	  {
	      login("admin","admin");

	      System.out.println(driver.getTitle());
	      Assert.assertEquals("Employee Profile", driver.getTitle() , "Expected Employee Profile page");
	      driver.findElement(By.name("logoutLink")).click();
	      Assert.assertEquals("Welcome to Online Registration", driver.getTitle() , "Expected Employee Profile page");
	  }

*/
	  @Test
	  public void invalidUserName() throws InterruptedException
	  {
	      login("sahithi","admin");
	      Assert.assertEquals("Welcome to Online Registration", driver.getTitle() , "expected Employee Profile page");
	      Assert.assertEquals("Invalid Login", driver.findElement(By.id("errormsg")).getText() , "expected Invalid error message");
	  }
	  
	  @Test
	  public void invalidUserAndPwd() throws InterruptedException
	  {
		  login("sahithi","sahi11");
	      Assert.assertEquals("Welcome to Online Registration", driver.getTitle() , "expected Employee Profile page");
	      Assert.assertEquals("Invalid Login", driver.findElement(By.id("errormsg")).getText() , "expected Invalid error message");
	  }
	  
	  @Test
	  public void pwdCheck() throws InterruptedException
	  {
		  login("sahithi","sa1");
		  Alert alert = driver.switchTo().alert();
		  Assert.assertEquals("password has to be minimum 5 chars and max 10 chars!",driver.switchTo().alert().getText(), "expected Employee Profile page");
		  alert.accept();	
	      //Assert.assertEquals("Invalid Login", driver.findElement(By.id("errormsg")).getText() , "expected Invalid error message");
	  }

	  static void login(String un , String pwd) throws InterruptedException {
			driver.findElement(By.id("loginName")).sendKeys(un);
		      driver.findElement(By.name("password")).sendKeys(pwd);
		      Thread.sleep(2000);
		      driver.findElement(By.xpath("//tr[3]/td/input")).click();
		      Thread.sleep(4000);
		}
	  
	  public void update(){
		  driver.findElement(By.id("updateProfile")).click();
		  driver.findElement(By.name("addresses[0].addrLine1")).sendKeys("187");
		  driver.findElement(By.xpath("//input[@value='Update']")).click();
		  
		  
	  }
	  
	  public void changePassword(){
		  driver.findElement(By.id("changePwd")).click();
		  driver.findElement(By.name("currPass")).sendKeys("admin123");
		  driver.findElement(By.name("newPass")).sendKeys("admin");
		  driver.findElement(By.name("confirmPass")).sendKeys("admin");
		  driver.findElement(By.name("Change Password")).click();
		  
		  
	  }
}
