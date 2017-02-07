package BusinessLogic;

import BaseFramework.BroswerInit;
import BaseFramework.ElementFindLocation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by thinkpad on 2017/2/7.
 */
public class TestClass {
    WebDriver driverChrome = BroswerInit.getDriverBroswer();

//    static WebDriver driverChrome;
//    static {
//        //driverChrome = new ChromeDriver();
//    }
/*

    @BeforeMethod
    public void BroswerInit1() {

        //指定Chrome 安装路径
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        //启动Firefox浏览器
        driverChrome = new ChromeDriver();
        System.out.println("打开firefox浏览器成功");
    }
*/

    @Test
    public void functionTest() {

        driverChrome.get("https://www.baidu.com/");
        ElementFindLocation elementFindLocation = new ElementFindLocation();
        WebElement webElement = elementFindLocation.locationElement(/*driverChrome,*/"id", "kw");
        webElement.sendKeys("selenium");
        WebElement webElement2 = elementFindLocation.locationElement(/*driverChrome,*/"xpath", ".//*[@id='su']");
        webElement2.click();

    }

    @Test
    public void functionTest1() {
        ElementFindLocation elementFindLocation = new ElementFindLocation();
        WebElement webElement3 = elementFindLocation.locationElement(/*driverChrome,*/"linkText", "贴吧");
        webElement3.click();
        String title = driverChrome.getTitle();
        System.out.println("标题是：" + title);
        Assert.assertEquals(title, "selenium吧_百度贴吧");
    }


    @AfterTest
    public void close() throws InterruptedException {
        BroswerInit.close();
    }
}
