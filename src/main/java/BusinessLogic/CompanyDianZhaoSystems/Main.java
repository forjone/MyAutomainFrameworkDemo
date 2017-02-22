package BusinessLogic.CompanyDianZhaoSystems;

import BaseFramework.BroswerInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.awt.*;

/**
 * Created by thinkpad on 2017/2/13.
 */
public class Main {
    String serialNo = "201702221422274";

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

//                {"1", "outNet", "cst010106", "a123456789"},    //新增申请
//                {"2", "innerNet", "cstp06165", "cstp06165"},   //同意申请并传到上级
//                {"3", "innerNet", "csta931", "csta931"},       //经理审批
//                {"4", "outNet", "cst010106", "a123456789"},    //资料回传
//                {"5", "innerNet", "cstp06165", "cstp06165"},   //资料回传确认
//                {"6", "innerNet", "cstp06165", "cstp06165"},   //经办人装修测量
//                {"7", "outNet", "cst030001", "cst030001"},   //装修公司成本报价
//                {"8", "innerNet", "cstp06165", "cstp06165"},   //经办人成本审批
//                {"9", "innerNet", "csta931", "csta931"},       //经理审批
                {"10", "outNet", "cst040002", "a111111"},   //特殊广告公司字体报价
//                {"11", "outNet", "cst040001", "cst040001"},   //广告公司字体报价
//                {"12", "outNet", "cst010106", "a123456789"},    //经销商版面确认
//                {"13", "innerNet", "cstp06165", "cstp06165"},   //经办人字体报价审批
//                {"14", "innerNet", "csta931", "csta931"},       //经理审批
//                {"15", "innerNet", "cstp06165", "cstp06165"},   //经办人呈核审批
//                {"16", "innerNet", "cst0001", "cst0001"},       //总经理审批
//                {"17", "innerNet", "cstp06165", "cstp06165"},   //经办人施工通知
//                {"18", "outNet", "cst040001", "cst040001"},   //广告公司发货
//                {"19", "outNet", "cst030001", "cst030001"},   //装修公司确认收货
//                {"20", "outNet", "cst030001", "cst030001"},   //装修公司完工审核
//                {"21", "innerNet", "cstp06165", "cstp06165"},   //经办人完工审核
//                {"22", "innerNet", "cst0001", "cst0001"},       //总经理完工审核
//                {"23", "innerNet", "cstp06165", "cstp06165"},   //经办人报核完成

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
        if (step.equals("1")) {
            login.login(netType, username, password);
            serialNo = besinessLogic.channelApplyAdd();
            login.loginOut();
//            besinessLogic.Test();
        } else if (step.equals("2")) {
            login.login(netType, username, password);
            besinessLogic.channelApplyTranscactor(serialNo);
            login.loginOut();

        } else if (step.equals("3")) {
            login.login(netType, username, password);
            besinessLogic.channelApplyManageCheck(serialNo);
            login.loginOut();

        } else if (step.equals("4")) {
            login.login(netType, username, password);
            besinessLogic.infoConfirm(serialNo);
            login.loginOut();

        } else if (step.equals("5")) {
            login.login(netType, username, password);
            besinessLogic.infoTranscactorCheck(serialNo);
            login.loginOut();

        } else if (step.equals("6")) {
            login.login(netType, username, password);
            besinessLogic.decorationMeter(serialNo);
            login.loginOut();

        } else if (step.equals("7")) {
            login.login(netType, username, password);
            besinessLogic.costOffer(serialNo);
            login.loginOut();
        } else if (step.equals("8")) {
            login.login(netType, username, password);
            besinessLogic.costOfferCheck(serialNo);
            login.loginOut();
        } else if (step.equals("9")) {
            login.login(netType, username, password);
            besinessLogic.costOfferManageCheck(serialNo);
            login.loginOut();
        } else if (step.equals("10")) {
            login.login(netType, username, password);
            besinessLogic.fontCostSpecialAD(serialNo);
            login.loginOut();
        } else if (step.equals("11")) {
            login.login(netType, username, password);
            besinessLogic.costOffer(serialNo);
            login.loginOut();
        } else if (step.equals("12")) {
            login.login(netType, username, password);
            besinessLogic.costOffer(serialNo);
            login.loginOut();
        } else if (step.equals("13")) {
            login.login(netType, username, password);
            besinessLogic.costOffer(serialNo);
            login.loginOut();
        } else if (step.equals("14")) {
            login.login(netType, username, password);
            besinessLogic.costOffer(serialNo);
            login.loginOut();
        } else if (step.equals("15")) {
            login.login(netType, username, password);
            besinessLogic.costOffer(serialNo);
            login.loginOut();
        } else if (step.equals("16")) {
            login.login(netType, username, password);
            besinessLogic.costOffer(serialNo);
            login.loginOut();
        } else if (step.equals("17")) {
            login.login(netType, username, password);
            besinessLogic.costOffer(serialNo);
            login.loginOut();
        } else if (step.equals("18")) {
            login.login(netType, username, password);
            besinessLogic.costOffer(serialNo);
            login.loginOut();
        } else if (step.equals("19")) {
            login.login(netType, username, password);
            besinessLogic.costOffer(serialNo);
            login.loginOut();
        }


    }

    @AfterTest
    public void close() throws InterruptedException {
        BroswerInit.closeBroswer();
    }
}
