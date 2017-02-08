package BaseFramework;

import org.apache.commons.io.FileUtils;
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

    public void expectManage(String checkElementType, String expectResult, String locationType, String locationValue) {
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
                photoScreenSave();
            }
            Assert.assertTrue(exist, "该对象不存在！！！！！！");
        }


    }

//    错误截图保存功能

    public void photoScreenSave() {
        Date dateTime = new Date();
        System.out.println(dateTime);

        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd-HHmmss");  //设置时间格式，MM代表月份，mm代表分钟，HH代表以24小时制的小时，hh代表12小时制的小时
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd-hhmmss");
        String date24Hour = dateFormat1.format(dateTime);
        String date12Hour = dateFormat2.format(dateTime);
        System.out.println(date24Hour);//以设置的时间格式设定日期（24小时制度）
        System.out.println(date12Hour);//以设置的时间格式设定日期（12小时制度）
        File screenWindows = ((TakesScreenshot) driverChrome).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenWindows, new File(".//logs/screenshots/Error" + date24Hour + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
