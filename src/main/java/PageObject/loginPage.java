package PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends basePage {

    basePage basepage= new basePage(driver);

    public loginPage(AndroidDriver<MobileElement> driver) { super(driver); PageFactory.initElements(driver,this);}

    @FindBy(id ="cr.fi.bncr.bnmovil.bncr:id/textIdentification1")
    private WebElement txtCedula;
    @FindBy (id ="cr.fi.bncr.bnmovil.bncr:id/ButtonLogIn1")
    private WebElement btnSiguiente;

    @FindBy(id ="cr.fi.bncr.bnmovil.bncr:id/loginUsuario_et_passwd2")
    private WebElement txtContrasenna;

    @FindBy (id ="cr.fi.bncr.bnmovil.bncr:id/loginUsuario_btn_login2")
    public WebElement btnIngresar;

    @FindBy (id ="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public WebElement btnPermission;

    @FindBy (id ="com.android.permissioncontroller:id/permission_allow_button")
    public WebElement btnAllow;

    @FindBy (id ="cr.fi.bncr.bnmovil.bncr:id/btn_salir")
    public WebElement btnCancelarRegistroDispo;

    public void ingresarCedula(String username) {
        txtCedula.sendKeys(username);
        btnSiguiente.click();
    }
    public void ingresarContrasenna(String pass) {
        txtContrasenna.sendKeys(pass);
        btnIngresar.click();
    }

    public void aceptarPermisosApp(){
        basepage.waitUntilElementExists(btnPermission);
        btnPermission.click();
        basepage.waitUntilElementExists(btnAllow);
        btnAllow.click();
        basepage.waitUntilElementExists(btnAllow);
        btnAllow.click();
        basepage.waitUntilElementExists(btnCancelarRegistroDispo);
        btnCancelarRegistroDispo.click();
    }
}
