package BaseFramework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by thinkpad on 2017/1/11.
 */
public class CrossManage {
    WebDriver driverChrome = BroswerInit.getDriverBroswer();

    public void crossOption(String crossType, String crossValue,String iframeElementLocationType) throws InterruptedException {
//        1.弹框：Alert
//        2.确认窗：comfirm
//        3.iframe
//        4.iframeReturn主动权归还
//        5.窗口：window
//        6.关闭当前页面页签：close
        if (crossType.equals("alert")) {
            Thread.sleep(3000);
//            定义一个Alert，并把控制权移交给Alert弹窗
            Alert alert = driverChrome.switchTo().alert();
//            点击“确定”
            alert.accept();
        } else if (crossType.equals("confirm")) {
            Thread.sleep(3000);
//            如果crossValue为“save”，点击“保存”、“确定”
//            crossValue为“cancel”，点击“取消”
//            new WebDriverWait(driverChrome,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));      //等待弹窗的出现
            Alert confirm = driverChrome.switchTo().alert();
            if (crossValue.equals("save")){
                confirm.accept();       //点击“保存”、“确定”
            }else if (crossValue.equals("cancel")){
                confirm.dismiss();      //点击“取消”
            }
        }else if (crossType.equals("iframe")){
            ElementFindLocation iframeElementFindLocation = new ElementFindLocation();
            WebElement iframeElement = iframeElementFindLocation.locationElement(iframeElementLocationType, crossValue);
            driverChrome.switchTo().frame(iframeElement);   //主动权交接到iframe

        }else if (crossType.equals("iframeReturn")){
            driverChrome.switchTo().defaultContent();       //主动权交换到源界面
        }else if (crossType.equals("window")){
            Thread.sleep(3000);
            String currentWindowHandle = driverChrome.getWindowHandle();
            System.out.println(currentWindowHandle);
        //获取所有的窗口句柄，并逐个与currentWindowHandle匹配
            for (String handls :driverChrome.getWindowHandles()){
                if (handls.equals(currentWindowHandle)) {
                    continue;
                }
                else {
                    driverChrome.switchTo().window(handls);
                }
            }
        }



    }




}
