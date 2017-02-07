package BaseFramework;

import BusinessLogic.BrowerClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by thinkpad on 2017/1/11.
 */
public class ElementFindLocation  {
/*
    WebDriver driverChrome;

    public  WebDriver BroswerInit1() {

        //指定Chrome 安装路径
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        //启动Firefox浏览器
        driverChrome = new ChromeDriver();
        System.out.println("打开firefox浏览器成功");
        return driverChrome;
    }
*/

    public  WebElement locationElement(/*WebDriver driverChrome,*/String locationType, String locationValue) {
        WebElement element = null;   //定义并初始化元素对象
        WebDriver driverChrome = BroswerInit.getDriverBroswer();

   /*
        方法一：采用if和switch来区分各种定位方法
        优点：通过配置条件，可以实现不区分大小写，甚至模糊匹配
        缺点：代码太长，可读性差
     */
        int lType = 0;
        if (locationType == "id") {
            lType = 1;
        } else {
            if (locationType == "name") {
                lType = 2;
            } else {
                if (locationType == "className") {
                    lType = 3;
                } else {
                    if (locationType == "linkText") {
                        lType = 4;
                    } else {
                        if (locationType == "partialLinkText") {
                            lType = 5;
                        } else {
                            if (locationType == "cssSelector") {
                                lType = 6;
                            } else {
                                if (locationType == "tagName") {
                                    lType = 7;
                                } else {
                                    if (locationType == "xpath") {
                                        lType = 8;
                                    } else {
                                        System.out.println("无法选择已有方法定位元素");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        /*
        * 定位方法对应关系
        * id===============1
         name=============2
         className========3
         linkText ========4
         partialLinkText==5
         cssSelector======6
         tagName==========7
         xPath============8
        *
        * */
        switch (lType) {
            case 1:
                element = driverChrome.findElement(By.id(locationValue));
                break;
            case 2:
                element = driverChrome.findElement(By.name(locationValue));
                break;
            case 3:
                element = driverChrome.findElement(By.className(locationValue));
                break;
            case 4:
                element = driverChrome.findElement(By.linkText(locationValue));
                break;
            case 5:
                element = driverChrome.findElement(By.partialLinkText(locationValue));
                break;
            case 6:
                element = driverChrome.findElement(By.cssSelector(locationValue));
                break;
            case 7:
                element = driverChrome.findElement(By.tagName(locationValue));
                break;
            case 8:
                element = driverChrome.findElement(By.xpath(locationValue));
                break;
        }


    return element;

/*
* 元素定位方法2
* 直接使用传入的定位类型，拼接到元素定位里面
* 优点：代码可读性强，执行效率搞
* 缺点：对输入的参数类型需要做到严格的限制，一旦传入出错，代码运行势必报错
*
* 先情况无法实现
*
* */
//    element = driverChrome.findElement(By+"."+locationType(locationValue));





    }


}
