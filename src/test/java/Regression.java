import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Regression {

    public static WebDriver driver;
    @Parameters("browser")
    @BeforeMethod

    public void beforeTest(@Optional String browser) {
        if(browser == null) {
            System.out.println("null");
//            ChromeOptions options = new ChromeOptions();
//            Map<String, Object> prefs = new HashMap<String, Object>();
//            Map<String, Object> profile = new HashMap<String, Object>();
//            Map<String, Integer> contentSettings = new HashMap<String, Integer>();
//
//            // SET CHROME OPTIONS
//            // 0 - Default, 1 - Allow, 2 - Block
//            contentSettings.put("notifications", 2);
//            contentSettings.put("geolocation", 2);
//            profile.put("managed_default_content_settings", contentSettings);
//            prefs.put("profile", profile);
//            options.setExperimentalOption("prefs", prefs);
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver(options);


        }
        // If the browser is Firefox, then do this

        if (browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(new FirefoxProfile());
            options.addPreference("dom.webnotifications.enabled", false);
            options.addPreference("geo.enabled", true);
            options.addPreference("geo.prompt.testing",true);
            options.addPreference("geo.prompt.testing.allow",true);
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);

        } else if (browser.equalsIgnoreCase("chrome")) {

            //Initialize the chrome driver
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            Map<String, Object> profile = new HashMap<String, Object>();
            Map<String, Integer> contentSettings = new HashMap<String, Integer>();

            // SET CHROME OPTIONS
            // 0 - Default, 1 - Allow, 2 - Block
            contentSettings.put("notifications", 2);
            contentSettings.put("geolocation", 2);
            profile.put("managed_default_content_settings", contentSettings);
            prefs.put("profile", profile);
            options.setExperimentalOption("prefs", prefs);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);


        }
    }

//    @DataProvider(name = "data-provider")
//    public Object[][] foodName(){
//        return new Object[][]{{"egg"}};
//    }

    @Test
    public  void test() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://chaldal.com/");
        driver.manage().window().maximize();



    }




}
