package core.utils;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;


public class Utilities {

    public static Select select;
    public static Actions actions;
    public static JavascriptExecutor executor;
    public static FluentWait wait;
    public static WebDriverWait webDriverWait;
    public static void selectDropDownOption(WebElement element, Object value){

        select =new Select(element);
        if(value instanceof String){
            select.selectByVisibleText((String) value);
        }else if(value instanceof Integer){
            select.selectByIndex((Integer) value);
        }else {

            throw new NoSuchContextException("Looking text is not available in dropdown option");
        }



    }

    public static List<WebElement> getDropDownOption(WebElement element){
         select=new Select(element);
         return select.getOptions();

    }
    public static List<Object> getDropDownOptionText(WebElement element){
        select=new Select(element);
        return Collections.singletonList(select.getOptions().stream().map(WebElement::getText));
    }

    public static boolean isDropDownOptionSorted(WebElement element){

        select=new Select(element);
        return select.getOptions().stream().map(WebElement::getText)
                .equals(select.getOptions().stream().map(WebElement::getText).sorted());

    }
    public static List<String> getDropDownOptionSorted(WebElement element){

        select=new Select(element);
        return select.getOptions().stream().map(WebElement::getText).sorted().collect(Collectors.toList());

    }
    public static void verifyDropDownOptionSorted(WebElement element){

        select=new Select(element);
        Assert.assertEquals("DropDown Options not sorted",
                select.getOptions().stream().map(WebElement::getText),
                select.getOptions().stream().map(WebElement::getText).sorted());

    }

    public static void moveToElement(WebDriver driver, WebElement element){

     actions=new Actions(driver);
     actions.moveToElement(element).perform();
    }
    public static void moveToElementAndClickOn(WebDriver driver, WebElement element){

        actions=new Actions(driver);
        actions.moveToElement(element).click();
//        actions.scrollToElement(element).click();
    }

    public static void javaScriptExecutor(WebDriver driver,WebElement element){

        executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);",element);
        executor.executeScript("arguments[0].click();", element);

    }

    public static void javaScript(WebDriver driver,WebElement element){

        executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

    }
    public static void scrollElementIntoView(WebDriver driver,WebElement element){
        executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);

    }


    public static FluentWait fluentWait(WebDriver driver){

        wait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class);
        return wait;
    }

    public static boolean elementVisible(WebDriver driver,WebElement element){

        wait=fluentWait(driver);
        return (boolean) wait.until(ExpectedConditions.invisibilityOfAllElements(element));

    }

    public static WebDriverWait explicitlyWait(WebDriver driver){

       return webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public static void elementToBeClickable(WebDriver driver, WebElement element){

        webDriverWait= explicitlyWait(driver);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public static boolean elementVisibility(WebDriver driver,WebElement element){

        return explicitlyWait(driver).until(ExpectedConditions.invisibilityOfAllElements(element));

    }
    public static void verifyElementVisibility(WebDriver driver,WebElement element){

         Assert.assertEquals("Element is not located page or in dom",
                 true,
                 explicitlyWait(driver).until(ExpectedConditions.invisibilityOfAllElements(element)));
    }

    public static void verifyIsDisplayed(WebElement element){

        Assert.assertTrue("Element is not displayed",element.isDisplayed());

    }
    public static boolean clickOnElement(WebElement element){

        element.click();
        return true;
    }
    public static void TypeInField(WebElement element, String value){
        String val = value;

        element.clear();
        for (int i = 0; i < val.length(); i++){
            char c = val.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }
    }
    public static void verifyText(WebElement element, String text){
       Assert.assertEquals("Text is not matching", text,element.getText());
    }

    public static void verifyTrimText(WebElement element, String text){
        Assert.assertEquals("Text is not matching", text,element.getText().trim());
    }

    public static void WindowsHandler(WebDriver driver, WebElement element){



        String parentWindow=driver.getWindowHandle();
        element.click();
        Set<String> windows=driver.getWindowHandles();

        for(String window:windows){

            if(!window.equals(parentWindow)){
                driver.switchTo().window(window);
                driver.findElement(By.xpath("")).click();
            }

            // check the below line
            driver.findElement(By.xpath("")).sendKeys(Keys.END);
            driver.close();
        }

        driver.switchTo().parentFrame();


    }

    public static void searchKey(WebElement element,String searchKey){

        element.sendKeys(searchKey);
    }
    public static String getText(WebElement element){

        return   element.getText();
    }
    public static List<String> getText(List<WebElement> element){

        return   element.stream().map(names->names.getText().trim()).collect(Collectors.toList());
    }


    public static List<String> getSplitText(WebElement element){

        List<String > vehicle;
        String[] listString=element.getText().trim().split("\\s+");

        // Tires for your 2020 Honda Accord EX
        return vehicle=  Arrays.stream(listString).filter(p->!(p.equals("Tires")|| p.equals("for")||p.equals("your"))).collect(Collectors.toList());


    }

    public static Object getPlaceholderText(WebElement element, String attributeName){

       return element.getAttribute(attributeName);
    }
    public static void staticWait(String waitIme){

        try {
//            int seconds=Integer.parseInt(waitIme)+0;
//            Thread.sleep(Duration.ofMillis(seconds));
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String searchOptionMatching(WebElement element, String searchedValue){
       String optionMatching=null;
        if(element.getText().equals(searchedValue)) {
            element.click();
           return optionMatching="Searched is "+searchedValue+" and actual is :"+element.getText();
        }else {

           return optionMatching="Search Data is"+searchedValue+ " and actual is :"+element.getText();
        }

    }

    public static boolean elementIsPresent(List<WebElement> elementPresence){


        if(elementPresence.size()>0){
            return true;
        }else {
            return false;
        }

    }

    public static boolean elementIsPresent(WebElement element){

        try {
            return element.isDisplayed();

        }catch (NoSuchElementException e){

           return false;
        }

    }
    public static boolean elementIsPresent(WebDriver driver, WebElement element){

        try {
            scrollElementIntoView(driver,element);
            return element.isDisplayed();

        }catch (NoSuchElementException e){

            return false;
        }

    }

    public static float getFloatValueFromString(WebElement element){

        float floatPrice= Float.parseFloat(element.getText().trim().replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
        return floatPrice;
    }

  public static int getIntValueFromString(WebElement element){

    int value= Integer.parseInt(element.getText().trim().replaceAll("[\\D]", ""));

    return  value;

  }
  public static Map<String,Integer> verifyLink(List<WebElement> linkItem){

      Map<String,Integer> linksStatus=new HashMap<>();
        for(WebElement link:linkItem){
//            String url=link.getAttribute("href");
            linksStatus =verifyLink(link);
//           if(statusCode!=200){
////
//               linksStatus.put(link.getText()+": href="+url,statusCode);
//           }

        }
        return  linksStatus;
  }

  public static  Map<String,Integer> verifyLink(WebElement linkItem){

      Map<String,Integer> linksStatus=new HashMap<>();
      String linkName=linkItem.getText();
      String url=linkItem.getAttribute("href");
        try {

            URL link=new URL(url);
            HttpURLConnection httpURLConnection=(HttpURLConnection)link.openConnection();
            httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode()==200){

                 linksStatus.put("link Name : "+linkName+"\n"+
                         "href= "+url+"\n"+
                         "Message : "+httpURLConnection.getResponseMessage(),
                         200);

            }else {

                 linksStatus.put("link Name : "+linkName+"\n"+
                                 "href= "+url+"\n"+
                                 "Message : "+
                         httpURLConnection.getResponseMessage(),
                         httpURLConnection.getResponseCode());
            }
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
      return linksStatus;

  }
  public static HashMap<String, Integer> brokenLinksStatus(HashMap<String, Integer> statusCode){

      HashMap<String, Integer> brokenLinks= (HashMap<String, Integer>) statusCode.entrySet().stream().
              filter(code->code.getValue()!=200).
              collect(Collectors.toMap(keyValue->keyValue.getKey(),keyValue->keyValue.getValue()));


      return brokenLinks;
  }

  public static String getFirstIndexText(String str){

      int newLineIndex = str.indexOf("\n");

      String first = str.substring(0, newLineIndex);

      return first;
  }

}
