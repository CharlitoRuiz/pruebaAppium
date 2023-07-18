import DataProviders.LoginProvider;
import POJO.LoginData;
import PageObject.basePage;
import PageObject.mainPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObject.loginPage;


public class bnmTest extends baseTest
{
        @Test (priority=1, dataProvider = "getLoginCredentials", dataProviderClass = LoginProvider.class)
        @Parameters({"username, password"})
        public void EnterAppCredentials(LoginData _loginData) throws InterruptedException {
            test = extent.createTest("Valid Login APP", "Login con las credenciales correctas a BN Movil");

            loginPage login = new loginPage(driver);
            mainPage main = new mainPage(driver);
            basePage basepage= new basePage(driver);

            /* Variables */
            String userName = _loginData.getUsername();
            String pass = _loginData.getPassword();

            //Click and pass Splash
            Thread.sleep(2000);
            login.ingresarCedula(userName);
            basepage.waitUntilElementExists(login.btnIngresar);
            test.log(Status.PASS,"Se ingreso el numero de cedula");

            login.ingresarContrasenna(pass);
            test.log(Status.PASS,"Se ingreso la contraseña");

            login.aceptarPermisosApp();
            test.log(Status.PASS,"Se aceptaron los permisos del app");
            Assert.assertTrue(main.btnConsultasApp.isDisplayed());

            basepage.waitUntilElementExists(main.menuHamburguesa);
            main.ingresarMenuHamburguesa();
            basepage.waitUntilElementExists(main.btnSalirApp);
            test.log(Status.PASS,"Salir del app correctamente");
            main.salirApp();

        }
}

