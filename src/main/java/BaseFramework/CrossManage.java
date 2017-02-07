package BaseFramework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by thinkpad on 2017/1/11.
 */
public class CrossManage  {
    @Test
    public void test(WebDriver driverChrome)   {


         driverChrome = BroswerInit.getDriverBroswer();

//        driverChrome.get("http://www.baidu.com");

    }

}
