package BaseFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class ExpectManage {
    WebDriver driverChrome = BroswerInit.getDriverBroswer();
    ElementFindLocation elementFindLocation = new ElementFindLocation();
    public void expectManage(String checkElementType, String expectResult,String locationType, String locationValue) {
        if (checkElementType.equals("title")) {
            String actualTitle = driverChrome.getTitle();
            System.out.println("实际标题为：" + actualTitle);
            Assert.assertEquals(actualTitle, expectResult);

        }else if(checkElementType.equals("inputBox")){
            WebElement checkElement = elementFindLocation.locationElement(locationType, locationValue);
            String actualText = checkElement.getText();
            System.out.println("实际校验结果为：" + actualText);
            Assert.assertEquals(actualText, expectResult);
        }


    }
}
