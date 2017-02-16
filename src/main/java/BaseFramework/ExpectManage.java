package BaseFramework;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExpectManage {
    WebDriver driverChrome = BroswerInit.getDriverBroswer();
    ElementFindLocation elementFindLocation = new ElementFindLocation();

    //初始化log4j的logger,做初始化功能
    private static Logger logger = Logger.getLogger(ExpectManage.class);

    public void expectManage(String checkElementType, String expectResult, String locationType, String locationValue) {
        try{
            if (checkElementType.equals("title")) {
                String actualTitle = driverChrome.getTitle();
                System.out.println("实际标题为：" + actualTitle);
                Assert.assertEquals(actualTitle, expectResult);

            } else if (checkElementType.equals("inputBox")) {
                WebElement checkElement = elementFindLocation.locationElement(locationType, locationValue);
                String actualText = checkElement.getText();
                System.out.println("实际校验结果为：" + actualText);
                Assert.assertEquals(actualText, expectResult);
            } else if (checkElementType.equals("exist")) {
                WebElement checkExist = elementFindLocation.locationElement(locationType, locationValue);
                boolean exist = checkExist.isDisplayed();
                if (exist) {
                    System.out.println("该对象不存在");
                } else {
                    ReoprtManage.photoScreenSave();
                }
                Assert.assertTrue(exist, "该对象不存在！！！！！！");
            }
        }catch (AssertionError checkError){
            logger.error("结果“" + checkElementType + "”校验失败");
            logger.error( checkError.getMessage());
//                throw new AssertionError("此对象不支持“" + operation + "”操作方法");
            throw checkError;
        }



    }


}
