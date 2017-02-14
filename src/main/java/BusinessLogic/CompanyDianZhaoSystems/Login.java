package BusinessLogic.CompanyDianZhaoSystems;

import BaseFramework.BroswerInit;
import BaseFramework.ElementFindLocation;
import BaseFramework.ElementOperation;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by thinkpad on 2017/2/13.
 */
public class Login {
    WebDriver driverChrome = BroswerInit.getDriverBroswer();
    public void login(String netType, String username, String password) {
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ElementOperation elementOperation = new ElementOperation();
        if (netType.equals("innerNet")) {
            driverChrome.get("http://192.168.1.4:7070/cas/login?service=http://192.168.1.4:8090/dzsq/cas");
            elementOperation.elementOperation("xpath", ".//*[@id='userName']", "sendKeys", username);
            elementOperation.elementOperation("xpath", ".//*[@id='password']", "sendKeys", password);
            elementOperation.elementOperation("xpath", ".//*[@id='login']/div[3]/input[3]", "click", null);
        } else if (netType.equals("outNet")) {
            driverChrome.get("http://172.16.1.251:8081/dzsqout/dzsq/login");
            elementOperation.elementOperation("xpath", ".//*[@id='userName']", "sendKeys", username);
            elementOperation.elementOperation("xpath", ".//*[@id='password']", "sendKeys", password);
            elementOperation.elementOperation("xpath", ".//*[@id='login']/ul/li[3]/button", "click", null);
        }


    }
}
