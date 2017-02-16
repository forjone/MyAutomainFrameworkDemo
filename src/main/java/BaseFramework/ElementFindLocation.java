package BaseFramework;

import BusinessLogic.BrowerClass;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by thinkpad on 2017/1/11.
 * 本文件功能是为了元素定位而设计，涵盖了所有的定位方法和无法定位的定位方法
 * 如果遇到没有办法定位的，做异常处理，抛错
 */
public class ElementFindLocation {
    //初始化log4j的logger,做初始化功能
    private static Logger logger = Logger.getLogger(ElementFindLocation.class);

    public WebElement locationElement(/*WebDriver driverChrome,*/String locationType, String locationValue) {

        WebElement element = null;   //定义并初始化元素对象
        WebDriver driverChrome = BroswerInit.getDriverBroswer();

   /*
        方法一：采用if和switch来区分各种定位方法
        优点：通过配置条件，可以实现不区分大小写，甚至模糊匹配
        缺点：代码太长，可读性差
     */


        try {
            boolean tureLocation = true;
            if (locationType.equals("id")) {
                element = driverChrome.findElement(By.id(locationValue));
            } else if (locationType.equals("name")) {
                element = driverChrome.findElement(By.name(locationValue));
            } else if (locationType.equals("className")) {
                element = driverChrome.findElement(By.className(locationValue));
            } else if (locationType.equals("linkText")) {
                element = driverChrome.findElement(By.linkText(locationValue));
            } else if (locationType.equals("partialLinkText")) {
                element = driverChrome.findElement(By.partialLinkText(locationValue));
            } else if (locationType.equals("cssSelector")) {
                element = driverChrome.findElement(By.cssSelector(locationValue));
            } else if (locationType.equals("tagName")) {
                element = driverChrome.findElement(By.tagName(locationValue));
            } else if (locationType.equals("xpath")) {
                element = driverChrome.findElement(By.xpath(locationValue));
            } else {
                System.out.println("未存在" + locationType + "该定位方法");
                tureLocation = false;
            }
            Assert.assertTrue("", tureLocation);
        }
            //通过Try catch和log4j两个方式结合，输出错误日志

         catch (AssertionError assertionError) {
//            logger.error("未存在" + locationType + "该定位方法，无法定位元素！！！" + assertionError.getMessage());
            logger.error("未存在“" + locationType + "”该定位方法，无法定位元素！！！");
            logger.error( assertionError.getMessage());
            throw new AssertionError("未存在“" + locationType + "”该定位方法，无法定位元素！！！");


        } catch (NoSuchElementException noFindElementError) {
            logger.error("无法通过“" + locationValue + "”查找到该元素！！！");
            logger.error(noFindElementError.getMessage());
            throw new NoSuchElementException("无法通过“" + locationValue + "”查找到该元素！！！");
        }

        return element;


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
/*        switch (lType) {
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
        }*/



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
