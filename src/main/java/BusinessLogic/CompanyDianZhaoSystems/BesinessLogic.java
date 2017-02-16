package BusinessLogic.CompanyDianZhaoSystems;

import BaseFramework.BroswerInit;
import BaseFramework.ElementFindLocation;
import BaseFramework.ElementOperation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by thinkpad on 2017/2/14.
 */
public class BesinessLogic {
    WebDriver driverChrome = BroswerInit.getDriverBroswer();

    //获取时间戳
    public static String getTime() {
        Date dateTime = new Date();
        System.out.println(dateTime);

        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd-HHmmss");  //设置时间格式，MM代表月份，mm代表分钟，HH代表以24小时制的小时，hh代表12小时制的小时
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd-hhmmss");
        String date24Hour = dateFormat1.format(dateTime);
        String date12Hour = dateFormat2.format(dateTime);
        System.out.println(date24Hour);//以设置的时间格式设定日期（24小时制度）
        System.out.println(date12Hour);//以设置的时间格式设定日期（12小时制度）
        return date24Hour;
    }



    public String channelApplyAdd() throws InterruptedException, AWTException {
        ElementFindLocation elementFindLocation = new ElementFindLocation();
        String timeChar = getTime();
        String shopName = "发哥的店铺" + timeChar;

        ElementOperation.elementOperation("xpath", ".//*[@id='qdManage']/a", "click", null);//点击渠道申请
        Thread.sleep(1000);
        ElementOperation.elementOperation("xpath", ".//*[@id='centerBtn']/a[1]/span/span[1]", "click", null);//点击新增

        ElementOperation.elementOperation("xpath", ".//*[@id='shopName']", "sendKeys", shopName);
        ElementOperation.elementOperation("xpath", ".//*[@id='chargeMan_SHOP']", "sendKeys", "就是我");
        ElementOperation.elementOperation("xpath", ".//*[@id='phone_SHOP']", "sendKeys", "12313132");
        //选择申请类型为新店申请
        ElementOperation.elementOperation("xpath", ".//*[@id='shopInfoUl']/form[1]/li[4]/span/span/span", "click", null);
        ElementOperation.elementOperation("xpath", "html/body/div[34]/div/div[1]", "click", null);
        //选择省
        ElementOperation.elementOperation("xpath", ".//*[@id='shopInfoUl']/form[1]/li[5]/span[1]/span/span", "click", null);
        ElementOperation.elementOperation("xpath", "html/body/div[20]/div/div[3]", "click", null);
        //选择市
        ElementOperation.elementOperation("xpath", ".//*[@id='shopInfoUl']/form[1]/li[5]/span[2]/span/span", "click", null);
        ElementOperation.elementOperation("xpath", "html/body/div[21]/div/div[1]", "click", null);
        //选择市
        ElementOperation.elementOperation("xpath", ".//*[@id='shopInfoUl']/form[1]/li[5]/span[3]/span/span", "click", null);
        ElementOperation.elementOperation("xpath", "html/body/div[22]/div/div[1]", "click", null);
        //具体地址
        ElementOperation.elementOperation("xpath", ".//*[@id='addressDetail']", "sendKeys", "随便路");

        ElementOperation.elementOperation("xpath", ".//*[@id='salesSeniority']", "sendKeys", "1");
        ElementOperation.elementOperation("xpath", ".//*[@id='salesPercent']", "sendKeys", "50");
        ElementOperation.elementOperation("xpath", ".//*[@id='wholesalePercent']", "sendKeys", "50");
        ElementOperation.elementOperation("xpath", ".//*[@id='preSignNum']", "sendKeys", "10");
        ElementOperation.elementOperation("xpath", ".//*[@id='planSignNum']", "sendKeys", "20");
        ElementOperation.elementOperation("xpath", ".//*[@id='salesSize14']", "sendKeys", "10");
        ElementOperation.elementOperation("xpath", "html/body/div[16]/div[2]/div/div/div/div[3]/div/ul/form[3]/li[4]/label[1]/input", "sendKeys", "樱花");
        ElementOperation.elementOperation("xpath", "html/body/div[16]/div[2]/div/div/div/div[3]/div/ul/form[3]/li[4]/label[2]/input", "sendKeys", "10");
        //面积
        ElementOperation.elementOperation("xpath", ".//*[@id='length_0']", "sendKeys", "10");
        ElementOperation.elementOperation("xpath", ".//*[@id='height_0']", "sendKeys", "10");
        ElementOperation.elementOperation("xpath", ".//*[@id='shopCount']", "sendKeys", "1");

        //现有设备
        ElementOperation.elementOperation("xpath", ".//*[@id='subCurDivs']/input[1]", "click", null);

        //装修项目
        ElementOperation.elementOperation("xpath", ".//*[@id='LEDWord']", "click", null);
        //其他
        ElementOperation.elementOperation("xpath", ".//*[@id='divPCRClothesInfo']/form/ul[2]/li/input", "sendKeys", "1");
        ElementOperation.elementOperation("xpath", ".//*[@id='clothesL']", "sendKeys", "1");
        ElementOperation.elementOperation("xpath", ".//*[@id='shortL']", "sendKeys", "1");
        //备注
        ElementOperation.elementOperation("xpath", ".//*[@id='shopRequire']", "sendKeys", "这厮是备注");
        //上传附件
        ElementOperation.elementOperation("xpath", ".//*[@id='upLoadBtn']/span/span", "click", null);
        Thread.sleep(1000);
//        ElementOperation.elementOperation("xpath","//*[@id=\"SWFUpload_0\"]","sendKeys","C:\\Users\\thinkpad\\Pictures\\5.jpg");
        ElementOperation.elementOperation("xpath", "//*[@id=\"SWFUpload_0\"]", "click", null);


/*
        /////图片上传功能（不能用）
        String url = "C:\\Users\\thinkpad\\Pictures\\5.jpg";
        String[] split = url.split("");
        Robot robot = new Robot();
        int length = split.length;
        System.out.println("字符串长度为：" + length);
        for (int j = 0; j < length; j++) {
            int urlInt = Integer.parseInt(split[j]);
            robot.keyPress(urlInt);


        }
*/


        Thread.sleep(5000);
        //开始上传
        ElementOperation.elementOperation("xpath", "//*[@id=\"upload_dialog\"]/div/div/center/ul/li[3]/a/span/span[1]", "click", null);
        Thread.sleep(1000);
        //上传成功-确定按钮
        ElementOperation.elementOperation("xpath", "/html/body/div[52]/div[2]/div[4]/a/span/span", "click", null);
//        //保存功能
//        ElementOperation.elementOperation("xpath", ".//*[@id='save']/span", "click", null);
        //提交功能
        ElementOperation.elementOperation("xpath", ".//*[@id='submit']/span/span[1]", "click", null);
        ElementOperation.elementOperation("xpath", "html/body/div[52]/div[2]/div[4]/a/span/span", "click", null);

        //获取编号
        ElementOperation.elementOperation("xpath", ".//*[@id='queryShopName']", "sendKeys", shopName);
        ElementOperation.elementOperation("xpath", "html/body/div[1]/div[2]/div/div/div[1]/div/div[2]/ul/li[6]/a[1]/span/span[1]", "click", null);
        Thread.sleep(2000);
        WebElement element = elementFindLocation.locationElement("xpath", "html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div[1]/div[2]/div/table/tbody/tr/td[12]/div");
        String serialNo = element.getText();
        System.out.println("编号为：" + serialNo);
        Thread.sleep(2000);

        return serialNo;

    }
/*
//测试获得编号的用例
    public void Test() throws InterruptedException {
        ElementFindLocation elementFindLocation = new ElementFindLocation();

        ElementOperation.elementOperation("xpath", "./*//*[@id='queryShopName']", "sendKeys", "发哥的店铺1");
        ElementOperation.elementOperation("xpath", "html/body/div[1]/div[2]/div/div/div[1]/div/div[2]/ul/li[6]/a[1]/span/span[1]", "click", null);
        Thread.sleep(2000);
        WebElement element = elementFindLocation.locationElement("xpath", "./*//*[@id='datagrid-row-r2-1-0']/td[12]/div");
        String serialNo = element.getText();
        System.out.println("编号为：" + serialNo);

        Thread.sleep(2000);
    }*/

    //    经办人渠道申请审核
    public void channelApplyTranscactor(String serialNo) throws InterruptedException {
        ElementOperation.elementOperation("xpath", ".//*[@id='qdManage']/a", "click", null);//点击渠道申请
        Thread.sleep(1000);
        SerachAndSelect.searchSelect(serialNo);
        //点击“申请审核”
        ElementOperation.elementOperation("xpath", ".//*[@id='centerBtn']/a[2]/span/span[1]", "click", null);
        //下级审批人
        ElementOperation.elementOperation("xpath", ".//*[@id='nextApproverLable']/span/span/span", "click", null);
        ElementOperation.elementOperation("xpath", "html/body/div[35]/div/div[3]", "click", null);

        ElementOperation.elementOperation("xpath", ".//*[@id='reviewMark']", "sendKeys", "这胚子是备注");
        //提交
        ElementOperation.elementOperation("xpath", ".//*[@id='applyReviewResoult']/form/a/span", "click", null);
        ElementOperation.elementOperation("xpath", "html/body/div[19]/div[2]/div[4]/a/span", "click", null);

        Thread.sleep(2000);

    }
    //经理审核
    public void channelApplyManageCheck(String serialNo) throws InterruptedException {
        ElementOperation.elementOperation("xpath", ".//*[@id='qdManage']/a", "click", null);//点击渠道申请
        Thread.sleep(1000);
        SerachAndSelect.searchSelect(serialNo);

        //点击“申请审核”
        ElementOperation.elementOperation("xpath", ".//*[@id='centerBtn']/a[1]/span/span[1]", "click", null);
        ElementOperation.elementOperation("xpath", ".//*[@id='reviewMark']", "sendKeys", "这胚子是备注");

        //提交
        ElementOperation.elementOperation("xpath", ".//*[@id='applyReviewResoult']/form/a/span/span[1]", "click", null);
        ElementOperation.elementOperation("xpath", "html/body/div[19]/div[2]/div[4]/a/span/span", "click", null);

        Thread.sleep(2000);
    }




}
