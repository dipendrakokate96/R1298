package BaseStudy;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Base 
{   
	public static  WebDriver driver;
   public void lanchBrowser() 
   {
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		//ChromeOptions opt = new ChromeOptions();
		//opt.addArguments("--disable-notifications");
		//driver = new ChromeDriver(opt);
	   //WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		Reporter.log("lanching browser...."+true);
   }
   public  void takeScreenShot(String TCname) throws IOException 
   {
	   File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   File dest = new File("C:\\Selenium\\Screenshot\\Tc"+TCname+"Screenshot.png");
	   FileHandler.copy(src, dest);
	   Reporter.log("ScreenShot Taken for TC "+TCname,true);
   }
   
    public void CloseBrowser() 
    {
    	driver.close();
    	Reporter.log("Browser Closed success...",true);
    }
}
