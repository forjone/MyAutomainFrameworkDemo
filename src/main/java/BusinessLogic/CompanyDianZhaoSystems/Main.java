package BusinessLogic.CompanyDianZhaoSystems;

import BaseFramework.BroswerInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * Created by thinkpad on 2017/2/13.
 */
public class Main {
    String serialNo = null;

    @DataProvider(name = "loginAccount")
    public Object[][] data() {
        return new Object[][]{
/*
                {"outNet","cst010106","a123456789"},    //新增申请
                {"innerNet","cstp06165","cstp06165"},   //同意申请并传到上级
                {"innerNet","csta931","csta931"},       //经理审批
                {"outNet","cst010106","a123456789"},    //资料回传
                {"innerNet","cstp06165","cstp06165"},   //资料回传确认
                {"innerNet","cstp06165","cstp06165"},   //经办人装修测量
                {"outNet","cst030001","cst030001"},   //装修公司成本报价
                {"innerNet","cstp06165","cstp06165"},   //经办人成本审批
                {"innerNet","csta931","csta931"},       //经理审批
                {"outNet","cst040001","cst040001"},   //广告公司字体报价
                {"outNet","cst010106","a123456789"},    //经销商版面确认
                {"innerNet","cstp06165","cstp06165"},   //经办人字体报价审批
                {"innerNet","csta931","csta931"},       //经理审批
                {"innerNet","cstp06165","cstp06165"},   //经办人呈核审批
                {"innerNet","cst0001","cst0001"},       //总经理审批
                {"innerNet","cstp06165","cstp06165"},   //经办人施工通知
                {"outNet","cst040001","cst040001"},   //广告公司发货
                {"outNet","cst030001","cst030001"},   //装修公司确认收货
                {"outNet","cst030001","cst030001"},   //装修公司完工审核
                {"innerNet","cstp06165","cstp06165"},   //经办人完工审核
                {"innerNet","cst0001","cst0001"},       //总经理完工审核
                {"innerNet","cstp06165","cstp06165"},   //经办人报核完成
                */
                {"1", "outNet", "cst010106", "a123456789"}/*,    //新增申请
                {"2", "innerNet", "cstp06165", "cstp06165"},   //同意申请并传到上级
                {"3", "innerNet", "csta931", "csta931"},       //经理审批
                {"4", "outNet", "cst010106", "a123456789"},    //资料回传
                {"5", "innerNet", "cstp06165", "cstp06165"},   //资料回传确认
                {"6", "innerNet", "cstp06165", "cstp06165"},   //经办人装修测量
                {"7", "outNet", "cst030001", "cst030001"},   //装修公司成本报价
                {"8", "innerNet", "cstp06165", "cstp06165"},   //经办人成本审批
                {"9", "innerNet", "csta931", "csta931"},       //经理审批
                {"10", "outNet", "cst040001", "cst040001"},   //广告公司字体报价
                {"11", "outNet", "cst010106", "a123456789"},    //经销商版面确认
                {"12", "innerNet", "cstp06165", "cstp06165"},   //经办人字体报价审批
                {"13", "innerNet", "csta931", "csta931"},       //经理审批
                {"14", "innerNet", "cstp06165", "cstp06165"},   //经办人呈核审批
                {"15", "innerNet", "cst0001", "cst0001"},       //总经理审批
                {"16", "innerNet", "cstp06165", "cstp06165"},   //经办人施工通知
                {"17", "outNet", "cst040001", "cst040001"},   //广告公司发货
                {"18", "outNet", "cst030001", "cst030001"},   //装修公司确认收货
                {"19", "outNet", "cst030001", "cst030001"},   //装修公司完工审核
                {"20", "innerNet", "cstp06165", "cstp06165"},   //经办人完工审核
                {"21", "innerNet", "cst0001", "cst0001"},       //总经理完工审核
                {"22", "innerNet", "cstp06165", "cstp06165"},   //经办人报核完成*/

        };
    }

    //    @BeforeMethod
//    public  void loginSystems(){
//        Login login = new Login();
////        login.login();
//    }
    @Test(dataProvider = "loginAccount")
    public void mainTest(String step, String netType, String username, String password) throws InterruptedException, AWTException {
        Login login = new Login();
        BesinessLogic besinessLogic = new BesinessLogic();
        if (step.equals("1")){
            login.login(netType,username,password);
            serialNo = besinessLogic.channelApplyAdd();
//            besinessLogic.Test();
        }else if (step.equals("2")){

        }


    }
    @AfterTest
    public void close() throws InterruptedException {
        BroswerInit.closeBroswer();
    }
}
