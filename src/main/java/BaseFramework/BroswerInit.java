package BaseFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by thinkpad on 2017/1/11.
 */
public class BroswerInit {
    static {
        //指定Firefox 安装路径
        System.setProperty("webdriver.firefox.bin","D:\\Software\\FireFox\\firefox.exe");    //setProperty相当于设置为静态变量，存在于内存里面
        //指定Chrome 安装路径
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
    }



//    public WebDriver driver;
    private static WebDriver driverChrome = new  ChromeDriver();

    @BeforeTest

    public static  WebDriver getInstans(){

/*
        //启动Firefox浏览器
        driver = new FirefoxDriver();
        System.out.println("打开firefox浏览器成功");
        */

//        driverChrome = new  ChromeDriver();

//        driverChrome.manage().window().maximize();
//        System.out.println ("打开chrome浏览器成功");

        return driverChrome ;


    }




    @AfterTest
    public static void  close() throws InterruptedException {
        Thread.sleep(4000);
//        driver.quit();
//        System.out.println("关闭firefox浏览器成功");
        driverChrome.quit();
        System.out.println("关闭Chrome浏览器成功");
    }
}
