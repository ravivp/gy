package jt.steps;

import core.browser.Browser;
import core.browser.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;

    @Before(order = 0)
    public void launchBrowser(){

      driver=  Browser.init(PropertyReader.get("browser"));


    }

    @After(order = 0)
    public void closeBrowser(){

      Browser.closeDriver();
    }



    @After(order = 1)
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){

            String screenshotName=scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath= ((TakesScreenshot)Browser.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }
  /*public void acceptCookies() {

    //If cokkies are already accepted then go back
    if (isAcceptedCookies) {
      return;
    }

    if (!WebDriverRunner.hasWebDriverStarted())
      return;
    try {
      Log.info("----------------Accept cookies--------------");
      $("#_evidon-decline-button")
              .waitUntil(Condition.visible, Browser.MAX_WAIT)
              .click();
      isAcceptedCookies = true;
    } catch (Throwable th) {
    }
  }
*/

}
