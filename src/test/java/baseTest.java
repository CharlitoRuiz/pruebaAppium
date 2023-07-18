import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.URL;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class baseTest {
    public AndroidDriver<MobileElement> driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void getDriver()
    {
        driver = setup();
    }
    public AndroidDriver<MobileElement> setup()
    {

        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability("deviceName", "CharlitoTest");
            caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "11.0");
            caps.setCapability("appPackage", "cr.fi.bncr.bnmovil.bncr");
            caps.setCapability("appActivity", "cr.fi.bncr.bnmovil.bncr.SplashScreenActivity");

            driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);


        } catch (Exception e) {

        }
        return driver;
    }

    @BeforeSuite
    public void startReport() {
        // initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");

        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        //configuration items to change the look and feel
        htmlReporter.config().setDocumentTitle("Test - practica BN Movil");
        htmlReporter.config().setReportName("Test Demo App BN Movil");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    @AfterTest
    public void teardown() {
        driver.quit();
        System.out.println("========= Todos las pruebas se ejecutaron correctamente =========");
        extent.flush();
    }

    @AfterMethod
    public void getTestsResults(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL,result.getThrowable());
            String photo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
            test.log(Status.FAIL, (Markup) test.addScreenCaptureFromBase64String(photo));
        }
    }
}
