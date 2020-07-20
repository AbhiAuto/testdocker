package testDock.docker;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class App 
{
	@Test
    public static void test()
    {	
    	String cdir = System.getProperty("user.dir");
    	System.setProperty("webdriver.chrome.driver", cdir + "/drivers/chromedriver");
    	WebDriver driver = new ChromeDriver();
    	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

    	driver.get("https://www.google.com");
    	String strUrl= driver.getCurrentUrl();
        System.out.println( "Current URL : "+ strUrl );
        driver.quit();
    }
}
