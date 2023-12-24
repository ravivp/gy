package core.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

    public static WebDriver driver;
    public static final ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();
    public static WebDriver init(String browserName){

        if(browserName.equals("chrome")){
            ChromeOptions option= new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");
            option.addArguments("incognito");
            option.addArguments("--headless");
            option.addArguments("--no-sandbox");
            option.addArguments("--disable-dev-shm-usage");
            WebDriverManager.chromedriver().clearDriverCache().setup();

            driver=new ChromeDriver(option);
            tdriver.set(driver);
        }else if (browserName.equals("edg")){
            EdgeOptions edOption=new EdgeOptions();
            edOption.addArguments("--remote-allow-origins=*");
            WebDriverManager.edgedriver().clearDriverCache().setup();
            driver=new EdgeDriver(edOption);
            tdriver.set(driver);

        }else if(browserName.equals("firefox")){

            FirefoxOptions frOption=new FirefoxOptions();
            frOption.addArguments("");
            WebDriverManager.firefoxdriver().clearDriverCache().setup();
            tdriver.set(new FirefoxDriver(frOption));
        } else if (browserName.equalsIgnoreCase("HtmlUnit")) {

            HtmlUnitDriver unitDriver = new HtmlUnitDriver();
             tdriver.set(unitDriver);
            
        } else {

            throw new RuntimeException("Invalid browser type");
        }

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        getDriver().manage().deleteAllCookies();

        return getDriver();


    }

    public static synchronized WebDriver getDriver(){

        return tdriver.get();

    }
    public static void closeDriver(){

        tdriver.get().quit();
    }
}
