package BusinessLogic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Created by thinkpad on 2017/2/7.
 */
public class BrowerClass {
    public static WebDriver driverBrower;

    static {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driverBrower = new ChromeDriver();
    }

    public static WebDriver getBrower() {
//        if (driverBrower == null) {
//            driverBrower = new ChromeDriver();
//        }
        return  driverBrower;
    }
}
