package practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {

//dont run this
    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "pathh");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        String uri = "https:///";
//        WebDriver driver = createInstance(uri);
        driver.get(uri);
        System.out.println(" ----- " + driver.getTitle());
//       WebElement login =  driver.findElement(By.xpath("//a[text()='Log in']"));
//        login.click();

        WebElement element = driver.findElement(By.id("small-searchterms"));
        element.sendKeys("Equity & ETF Quotes Intervals");
        element.submit();
        driver.findElement(By.xpath("//a[.='Equity & ETF Quotes Intervals']")).click();


    }

}
