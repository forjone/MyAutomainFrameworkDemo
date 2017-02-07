package BaseFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
            }
            else {
                System.out.println("此操作对象不支持，请确认操作方式是否正确，或完善代码");

            }






    }

}
