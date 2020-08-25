package practice.selenium.pageObjectUsingPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    WebDriver driver;

    @FindBy(how = How.NAME, using = "email")
    @CacheLookup
    WebElement username;

    @FindBy(how = How.NAME, using = "pass")
    @CacheLookup
    WebElement password;

    @FindBy(how = How.ID, using = "u_0_b")
    @CacheLookup
    WebElement loginButton;

    LoginPage(WebDriver driverValue) {
        this.driver = driverValue;
    }

    public void loginToThePage(String uname, String pwd) {

        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginButton.click();
    }
}
