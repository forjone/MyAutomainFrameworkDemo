package BaseFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by thinkpad on 2017/1/11.
 */
public class ElementOption {
    WebDriver driverChrome = BroswerInit.getDriverBroswer();
    WebElement element = null;

    public  void elementOption(WebElement element,/*String expectedType,*/ String option, String optionValue) {
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
            if(option.equals("click")){
//            如果操作是“点击”的话，元素执行点击操作
                element.click();
            }else if (option.equals("sendKeys")){
//            如果操作是“输入”，元素执行赋值操作
                element.sendKeys(optionValue);
            }else if (option.equals("select")){
                Select select = new Select(element);
                //        使用属性值选择下拉框
                select.selectByValue(optionValue);
            }else if (option.equals("doubleClick")){
//            如果操作是“双击”，元素执行赋值操作
                Actions actions = new Actions(driverChrome);
                actions.doubleClick(element).perform();
            }else if (option.equals("contextClick")){
//            如果操作是“右击”，元素执行赋值操作
                Actions actions = new Actions(driverChrome);
                actions.contextClick(element).perform();
            }
            else {
                System.out.println("此操作对象不支持，请确认操作方式是否正确，或完善代码");

            }






    }

}
