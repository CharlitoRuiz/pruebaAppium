package PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mainPage extends basePage {

    public mainPage(AndroidDriver<MobileElement> driver) { super(driver); PageFactory.initElements(driver,this);}

    @FindBy (id ="cr.fi.bncr.bnmovil.bncr:id/action_menu_hamburguesa")
    public WebElement menuHamburguesa;

    @FindBy (xpath ="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    public WebElement btnSalirApp;

    @FindBy (id ="cr.fi.bncr.bnmovil.bncr:id/imv_consultas")
    public WebElement btnConsultasApp;

    public void ingresarMenuHamburguesa() {
        menuHamburguesa.click();
    }
    public void salirApp() {
        btnSalirApp.click();
    }
}
