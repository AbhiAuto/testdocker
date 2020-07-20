package testDock.docker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    	ChromeOptions chromeOptionsObj = new ChromeOptions();
    	Map<String, Object> chromePrefs = new HashMap<String, Object>();
    	List<String> chromeOptions = new ArrayList<>();
    	chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1);
		chromePrefs.put("download.prompt_for_download", false);
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("password_manager_enabled", false);
		chromeOptions.add("disable-plugins");
		chromeOptions.add("--headless");
		chromeOptions.add("--no-sandbox");
		chromeOptions.add("--disable-dev-shm-usage");
		chromeOptions.add("disable-extensions");
		chromeOptions.add("allow-running-insecure-content");
		chromeOptions.add("ignore-certificate-errors");
		chromeOptions.add("--always-authorize-plugins");
		chromeOptions.add("--disable-notifications");
		chromeOptions.add("disable-infobars");
		chromeOptions.add("--test-type");
		chromeOptionsObj.addArguments(chromeOptions);
		chromeOptionsObj.setExperimentalOption("prefs", chromePrefs);
		
		
    	WebDriver driver = new ChromeDriver(chromeOptionsObj);
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
