package BusinessLogic;

import BaseFramework.BroswerInit;
import BaseFramework.CrossManage;
import BaseFramework.ElementFindLocation;
import BaseFramework.ElementOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;


/**
 * Created by thinkpad on 2017/2/7.
 */
public class TestClass {
    WebDriver driverChrome;

    @BeforeMethod
    public void Brosweropen() throws FileNotFoundException {
/*

//        讲控制台输出信息导出到文件
        FileOutputStream bos = new FileOutputStream("output.txt");
        System.setOut(new PrintStream(bos));
        System.out.println("output to output.txt");
*/

        driverChrome = BroswerInit.getDriverBroswer();
    }


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
        ElementOption elementOption = new ElementOption();
        elementOption.elementOption("id", "kw", "inputBox", "dreaming");
        elementOption.elementOption("xpath", ".//*[@id='su']", "click", null);
        Thread.sleep(5000);
    }

    @Test
    public void Test3() throws InterruptedException, FileNotFoundException {
        driverChrome.get("file:///E:/selenium_test/selenium_html/index.html");
        ElementOption elementOption = new ElementOption();
        CrossManage crossManage = new CrossManage();
        elementOption.elementOption("xpath", ".//*[@id='user']", "sendKeys", "跨域");
        elementOption.elementOption("xpath", ".//*[@id='alert']/input", "click", null);
        crossManage.crossOption("alert", null, null);
//        elementOption.elementOption("xpath",".//*[@id='confirm']/input","click",null);
//        crossManage.crossOption("confirm","save",null);
        elementOption.elementOption("xpath", ".//*[@id='open']/a", "click", null);
        crossManage.crossOption("window", null, null);
        elementOption.elementOption("xpath", ".//*[@id='link']/a", "click", null);
        BroswerInit.closePage();


    }


    @AfterTest
    public void close() throws InterruptedException {
        BroswerInit.closeBroswer();
    }
}
