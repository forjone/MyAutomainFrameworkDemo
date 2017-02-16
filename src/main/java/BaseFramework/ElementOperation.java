package BaseFramework;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by thinkpad on 2017/1/11.
 */
public class ElementOperation {
    static WebDriver driverChrome = BroswerInit.getDriverBroswer();
//    WebElement element = null;

    //初始化log4j的logger,做初始化功能
    private static Logger logger = Logger.getLogger(ElementOperation.class);

    public static void elementOperation(String locationType, String locationValue, String operation, String operationValue/*,String expectedType*/) {
        ElementFindLocation elementFindLocation = new ElementFindLocation();
        WebElement element = elementFindLocation.locationElement(locationType, locationValue);





       /* //用来校验运行中的对象是否和对象库中的对象类型一致
        String actualType = element.getAttribute("type");
        if (actualType.equals(expectedType))
         */

/*       操作类型：
                  click：单击
                  sendKeys：赋值
                  select：下拉框选择
                  doubleClick：双击
                  contextClick：右击

       */
        try{
            boolean turnOperation = true;

            if (operation.equals("click")) {
//            如果操作是“点击”的话，元素执行点击操作
                element.click();
            } else if (operation.equals("sendKeys")) {
//            如果操作是“输入”，元素执行赋值操作
                element.sendKeys(operationValue);
            } else if (operation.equals("select")) {
                Select select = new Select(element);
                //        使用属性值选择下拉框
                select.selectByValue(operationValue);//根据属性值
            } else if (operation.equals("doubleClick")) {
//            如果操作是“双击”，元素执行赋值操作
                Actions actions = new Actions(driverChrome);
                actions.doubleClick(element).perform();
            } else if (operation.equals("contextClick")) {
//            如果操作是“右击”，元素执行赋值操作
                Actions actions = new Actions(driverChrome);
                actions.contextClick(element).perform();
            } else {
                System.out.println("此对象不支持“" + operation + "”操作方法，请确认操作方式是否正确，或完善代码");
                turnOperation = false;
            }
            Assert.assertTrue("", turnOperation);
        } catch (AssertionError assertionError) {
//            logger.error("未存在" + locationType + "该定位方法，无法定位元素！！！" + assertionError.getMessage());
                logger.error("此对象不支持“" + operation + "”操作方法");
                logger.error( assertionError.getMessage());
//                throw new AssertionError("此对象不支持“" + operation + "”操作方法");
                throw assertionError;


        }




    }

}
