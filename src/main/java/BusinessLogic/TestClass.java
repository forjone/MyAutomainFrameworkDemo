package BusinessLogic;

import BaseFramework.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoSuchElementException;
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
    //初始化log4j的logger,做初始化功能
    private static Logger logger = Logger.getLogger(TestClass.class);
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
        PropertyConfigurator.configure("D:\\MyDesign\\AutomationFrameworkDesign\\src\\main\\resources\\log4j.properties");
        Logger logger = Logger.getLogger(TestLog4j.class);

        driverChrome.get("https://www.baidu.com/");
        ElementFindLocation elementFindLocation = new ElementFindLocation();
        WebElement webElement = elementFindLocation.locationElement(/*driverChrome,*/"id1", "kw");
        webElement.sendKeys("selenium");
        WebElement webElement2 = elementFindLocation.locationElement(/*driverChrome,*/"xpath", ".//*[@id='su']");
        webElement2.click();

    }

    @Test
    public void functionTest1() throws InterruptedException {
        ExpectManage expectManage = new ExpectManage();
        driverChrome.get("https://www.baidu.com/");
        expectManage.expectManage("title", "百度一下，你就知道", null, null);
        ElementOperation elementOperation = new ElementOperation();
        elementOperation.elementOperation("id", "kw", "sendKeys", "百度");
        Thread.sleep(2000);
        expectManage.expectManage("title", "百度_百度搜索", null, null);
        elementOperation.elementOperation("xpath", ".//*[@id='su']", "click", null);
        Thread.sleep(5000);

    }


    @Test
    public void Test3() throws InterruptedException {
        driverChrome.get("file:///E:/selenium_test/selenium_html/index.html");
        ElementOperation elementOperation = new ElementOperation();
        CrossManage crossManage = new CrossManage();
        elementOperation.elementOperation("xpath", ".//*[@id='user']", "sendKys", "跨域");
        elementOperation.elementOperation("xpath", ".//*[@id='alert']/input", "click", null);
        crossManage.crossOperation("alert", null, null);
//        elementOperation.elementOperation("xpath",".//*[@id='confirm']/input","click",null);
//        crossManage.crossOperation("confirm","save",null);
        elementOperation.elementOperation("xpath", ".//*[@id='open']/a", "click", null);
        crossManage.crossOperation("window", null, null);
        elementOperation.elementOperation("xpath", ".//*[@id='link']/a", "click", null);
        BroswerInit.closePage();
/*
        try{

        }catch (){

        }*/
    }


    @AfterTest
    public void close() throws InterruptedException {
        BroswerInit.closeBroswer();
    }
}
