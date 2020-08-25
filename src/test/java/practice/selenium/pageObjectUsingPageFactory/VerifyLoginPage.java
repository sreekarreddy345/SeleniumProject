package practice.selenium.pageObjectUsingPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import practice.selenium.BrowserFactory;

public class VerifyLoginPage {

    @Test(enabled = true, priority = 1)
    public void checkLoginPage() {

        //this will launch the browser and open the url
        WebDriver webDriver = BrowserFactory.startBrowser("chrome", "https://www.facebook.com");

        // Created Page Object using Page Factory
        LoginPage loginPageObj = PageFactory.initElements(webDriver, LoginPage.class);

        // Calling the method
        loginPageObj.loginToThePage("sreekarreddy345@gmail.com", "SuShm@91939193@");

//        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(webDriver,100);
//        PageFactory.initElements(factory,this);
    }

}
