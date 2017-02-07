package BaseFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by thinkpad on 2017/1/11.
 */
public class BroswerInit {
    public static WebDriver driverBroswer;
    static {
        //指定Firefox 安装路径
        System.setProperty("webdriver.firefox.bin","D:\\Software\\FireFox\\firefox.exe");    //setProperty相当于设置为静态变量，存在于内存里面
        //指定Chrome 安装路径
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driverBroswer = new ChromeDriver();
        System.out.println("打开Chrome浏览器成功");
    }

    public static  WebDriver getDriverBroswer(){
        return driverBroswer ;
    }

    public static void  close() throws InterruptedException {
        Thread.sleep(4000);
//        driver.quit();
//        System.out.println("关闭firefox浏览器成功");
        driverBroswer.quit();
        System.out.println("关闭Chrome浏览器成功");
    }

/*
//    伟东代码


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

    */

}
