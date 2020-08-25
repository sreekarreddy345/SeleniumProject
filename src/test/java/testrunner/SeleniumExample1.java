package testrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Lib;


public class SeleniumExample1 {

    public static void main(String[] args) throws Exception {
        int count = 0;
        postTweet(count);
//        postTweet(count);
//        postTweet(count);
//        postTweet(count);
//        postTweet(count);
//        postTweet(count);
    }

    private static void postTweet(int count) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", Lib.getChromeDriverLocation());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        String uri = "https://twitter.com/login?lang=en";
//        WebDriver driver = createInstance(uri);
        driver.get(uri);


        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='session[username_or_email]']")).sendKeys("dummy");

        WebElement passElement = driver.findElement(By.xpath("//input[@name='session[password]']"));
        WebElement loginElement = driver.findElement(
                By.xpath("//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-vw2c0b r-1777fci r-eljoum r-dnmrzs r-bcqeeo r-q4m81j r-qvutc0']"));

//        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div")).click();

//        driver.findElement(By.xpath("//div[@name='session[password]']")).click();
//
//        driver.findElement(By.xpath("//div[@name='session[password]']"));


        passElement.sendKeys("dummy");
        loginElement.click();

        /*for (int i = 1; i < 100; i++) {
            TimeUnit.SECONDS.sleep(6);
            try {

                driver.manage().deleteAllCookies();
                WebElement element = driver.findElement(By.xpath("//div[contains(@class, 'public-DraftStyleDefault-block public-DraftStyleDefault-ltr')]"));
//                WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div")).click();

                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

                element.sendKeys(timeStamp + "\n" + "#1YearForYSJaganAneNenu\n" + timeStamp + "\n" + "sreekar");
                Thread.sleep(1000);
                TimeUnit.SECONDS.sleep(2);

                WebElement element1 = driver.findElement(By.xpath("//span[text()='Tweet']"));
//                element1.click();
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", element1);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }*/

//        if (count == 12) {
//            System.out.println("Close your browser");
//            driver.quit();
//        }
    }

    public static WebDriver createInstance(String url) {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver", Lib.getChromeDriverLocation());
        WebDriver driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}





