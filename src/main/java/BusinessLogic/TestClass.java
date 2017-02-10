package BusinessLogic;

import BaseFramework.BroswerInit;
import BaseFramework.CrossManage;
import BaseFramework.ElementFindLocation;
import BaseFramework.ElementOperation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
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
    public void functionTest1() throws InterruptedException {
        driverChrome.get("https://www.baidu.com/");
        ElementOperation elementOperation = new ElementOperation();
        elementOperation.elementOperation("id","kw","click","子君");
        elementOperation.elementOperation("xpath",".//*[@id='su']","click",null);
        Thread.sleep(5000);
    }
    @Test
    public void Test3() throws InterruptedException {
        driverChrome.get("file:///C:/users/xuanyu/documents/%E4%BA%91%E5%B1%82%E5%9F%B9%E8%AE%AD/webdriver/selenium_html/index.html");
        ElementOperation elementOperation = new ElementOperation();
        CrossManage crossManage = new CrossManage();
        elementOperation.elementOperation("xpath",".//*[@id='user']","sendKeys","跨域");
        elementOperation.elementOperation("xpath",".//*[@id='alert']/input","click",null);
        crossManage.crossOperation("alert",null,null);
//        elementOperation.elementOperation("xpath",".//*[@id='confirm']/input","click",null);
//        crossManage.crossoperation("confirm","save",null);
        elementOperation.elementOperation("xpath",".//*[@id='open']/a","click",null);
        crossManage.crossOperation("window",null,null);
        elementOperation.elementOperation("xpath",".//*[@id='link']/a","click",null);
        BroswerInit.closePage();

    }


    @AfterTest
    public void close() throws InterruptedException {
        BroswerInit.closeBroswer();
    }
}
