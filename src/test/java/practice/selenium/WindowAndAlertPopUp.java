package practice.selenium;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Lib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowAndAlertPopUp {

    public static void main(String[] args) {

        System.setProperty("web.chrome.driver", Lib.getChromeDriverLocation());
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.popuptest.com/");
//      below is example of absolute xpath
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]/font[3]/b/a")).click();
        // todo to handle window popup - getWindowHandles (to handles multiple windows and
        //  It returns a set of handles of the all the pages available.)
        // todo to handle window popup - getWindowHandle (It returns a string id of the current page.)

        Set<String> windowHandles = driver.getWindowHandles();

        String windowHandle = driver.getWindowHandle();

        Iterator<String> iterator = windowHandles.iterator();

        while (iterator.hasNext()) {
            String parentWindowId = iterator.next();
            System.out.println("parentWindowId - " + parentWindowId);
        }

        String childWindowId = iterator.next();
        System.out.println("childWindowId - " + childWindowId);


//       todo to  handle web based popup alerts
        Alert alert = driver.switchTo().alert();
        alert.getText();
        alert.accept();
        alert.dismiss();
        alert.sendKeys("value");

        // todo to change the frames window
        WebDriver frame = driver.switchTo().frame(1);

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        WebDriver window = driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));

//        todo to send a command through keyboard
        driver.findElement(By.xpath("xpath")).sendKeys(Keys.ENTER);

    }

    /*todo mouse  hose over*/
    public static void mouseHoseOverMethod(WebDriver driver) {

        WebElement elementId = driver.findElement(By.xpath("//input[@id='u_0_b']"));
        WebElement sourceElement = driver.findElement(By.xpath("//input[@id='u_0_b']"));
        WebElement targetElement = driver.findElement(By.xpath("//input[@id='u_0_b']"));

        Actions action = new Actions(driver);

        action.moveToElement(elementId).build().perform();// move element

        action.contextClick(elementId);//right click

        action.doubleClick();//double click

        // drag and drop accepts two arguments source web element and target webelement
        action.dragAndDrop(sourceElement, targetElement);

    }
}
