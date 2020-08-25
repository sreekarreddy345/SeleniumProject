package practice;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCheck {
    public static void main(String[] args) {


        String a = "abbcddeeff";
        char[] chars = a.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();


        for (Character c : chars) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                map.put(c, 1);
            }
        }


        for (Character c : chars) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                map.put(c, 1);
            }
        }

        for (Map.Entry jj : map.entrySet()) {
            System.out.println(jj.getKey() + " - " + jj.getValue());
        }
        for (Character c : map.keySet()) {
            System.out.println("key - " + c + " value - " + map.get(c));
        }

        System.out.println(map);

//        WebDriver webDriver = new ChromeDriver();
//
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//
//        WebDriverWait wait = new WebDriverWait(webDriver, 20);
//        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(webDriver.findElement(By.className("eesfc")))));

    }

}

