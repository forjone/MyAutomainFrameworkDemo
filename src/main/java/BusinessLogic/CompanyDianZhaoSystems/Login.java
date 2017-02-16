package BusinessLogic.CompanyDianZhaoSystems;

import BaseFramework.BroswerInit;
import BaseFramework.ElementFindLocation;
import BaseFramework.ElementOperation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by thinkpad on 2017/2/13.
 */
public class Login {
    WebDriver driverChrome = BroswerInit.getDriverBroswer();
//    ElementOperation elementOperation = new ElementOperation();

    public void login(String netType, String username, String password) {
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        ElementFindLocation elementFindLocation = new ElementFindLocation();

        if (netType.equals("innerNet")) {
            driverChrome.get("http://192.168.1.4:7070/cas/login?service=http://192.168.1.4:8090/dzsq/cas");
            ElementOperation.elementOperation("xpath", ".//*[@id='username']", "sendKeys", username);
            ElementOperation.elementOperation("xpath", ".//*[@id='password']", "sendKeys", password);
            ElementOperation.elementOperation("xpath", ".//*[@id='login']/div[3]/input[3]", "click", null);
        } else if (netType.equals("outNet")) {
            driverChrome.get("http://172.16.1.251:8081/dzsqout/dzsq/login");
            ElementOperation.elementOperation("xpath", ".//*[@id='userName']", "sendKeys", username);
            ElementOperation.elementOperation("xpath", ".//*[@id='password']", "sendKeys", password);
            ElementOperation.elementOperation("xpath", ".//*[@id='login']/ul/li[3]/button", "click", null);
        }


    }
    public void loginOut(){
        //        退出登录
        Actions actions = new Actions(driverChrome);
        WebElement loginOutElement = ElementFindLocation.locationElement("xpath", ".//*[@id='leftMenuUl']/li[1]/a");
        actions.moveToElement(loginOutElement).perform();
        ElementOperation.elementOperation("xpath", ".//*[@id='leftMenuUl']/li[1]/ul/li[2]/a", "click", null);
    }

}
