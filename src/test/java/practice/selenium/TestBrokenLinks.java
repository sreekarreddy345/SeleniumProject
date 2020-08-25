package practice.selenium;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.Lib;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBrokenLinks {
    @Test
    public static void test() throws IOException {
        System.setProperty("webdriver.chrome.driver", Lib.getChromeDriverLocation());
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       /* implicitlyWait  - Specifies the amount of time the driver should wait when searching for an element
                          if it is not immediately present.
        pageLoadTimeout - Sets the amount of time to wait for a page load to complete before throwing an error.
        setScriptTimeout - Sets the amount of time to wait for an asynchronous script to finish execution before throwing an error.*/


        driver.get("https://www.amazon.com/");
        List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));// // adding links with tag name a
        listOfLinks.addAll(driver.findElements(By.tagName("img")));// adding links with tag name img
        int listOfLinksSize = listOfLinks.size();
        System.out.println("listOfLinks size - " + listOfLinksSize);

        List<String> activeLinks = new ArrayList<>();

        for (int i = 0; i < listOfLinksSize; i++) {
            WebElement webElement = listOfLinks.get(i);

            String href = webElement.getAttribute("href");
            //wremoving href with null,href which contains javascript links and empty hrefs
            if (href != null && (!href.contains("javascript")) && StringUtils.isNotEmpty(href)) {
                activeLinks.add(href);
            }
        }
        System.out.println("activeLinks size - " + activeLinks.size());
        int count = 0;
        try {
            for (String a : activeLinks) {
                // creating new HttpURL connection with link and opening connection
                HttpURLConnection connection = (HttpURLConnection) new URL(a).openConnection();

                connection.connect();
                String responseMessage = connection.getResponseMessage();
                if ("OK".contains(responseMessage))
                    count++;
                connection.disconnect();
                System.out.println(a + " ----------> " + responseMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Number of OK responses - " + count);
        driver.close();
    }
}
//    Service Unavailable - 173
// ok - 23
