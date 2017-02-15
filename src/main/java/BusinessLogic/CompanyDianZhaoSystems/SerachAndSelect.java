package BusinessLogic.CompanyDianZhaoSystems;

import BaseFramework.ElementOperation;

/**
 * Created by thinkpad on 2017/2/14.
 */
public class SerachAndSelect {
    public static void searchSelect(String serialNo) throws InterruptedException {
        //选择待审核记录
        ElementOperation.elementOperation("xpath", ".//*[@id='queryApplyNo']", "sendKeys", serialNo);
        ElementOperation.elementOperation("xpath", "html/body/div[1]/div[2]/div/div/div[1]/div/div[2]/ul/li[6]/a[1]/span/span[1]", "click", null);
        Thread.sleep(2000);
        ElementOperation.elementOperation("xpath", "html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div[1]/div[2]/div/table/tbody/tr/td[12]/div","click",null);

    }
}
