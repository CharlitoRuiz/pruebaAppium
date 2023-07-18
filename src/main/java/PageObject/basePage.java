package PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class basePage
{
   public static AndroidDriver<MobileElement> driver;

   public  basePage(AndroidDriver<MobileElement> _driver)
   {
     basePage.driver=_driver;
       PageFactory.initElements(driver,this);
   }
    public void waitUntilElementExists(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}



