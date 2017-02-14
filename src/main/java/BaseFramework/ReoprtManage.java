package BaseFramework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thinkpad on 2017/1/11.
 */
public  class ReoprtManage {

    //    错误截图保存功能

    public static void photoScreenSave() {
        WebDriver driverChrome = BroswerInit.getDriverBroswer();
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
