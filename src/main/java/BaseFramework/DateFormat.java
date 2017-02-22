package BaseFramework;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thinkpad on 2017/2/21.
 */
public class DateFormat {

    /*
        //获取时间戳
        public static String getTime() {
            Date dateTime = new Date();
            System.out.println(dateTime);

            java.text.DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd-HHmmss");  //设置时间格式，MM代表月份，mm代表分钟，HH代表以24小时制的小时，hh代表12小时制的小时
            java.text.DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd-hhmmss");
            String date24Hour = dateFormat1.format(dateTime);
            String date12Hour = dateFormat2.format(dateTime);
            System.out.println(date24Hour);//以设置的时间格式设定日期（24小时制度）
    //        System.out.println(date12Hour);//以设置的时间格式设定日期（12小时制度）
            return date24Hour;




        }*/
    final static Logger logger = Logger.getLogger(ElementFindLocation.class);



    public static final String COMMON_DATE_FORMAT = "yyyy-MM-dd";

    public static final String SHORT_DATE_FORMAT = "yy-MM-dd HH:mm";

    public static final String SMALL_DATE_FORMAT = "MM-dd";

    public static final String ABC_ORDER_DATE_FORMAT = "yyyy/MM/dd";

    public static final String ABC_ORDER_TIME_FORMAT = "HH:mm:ss";

    public static final String LOTTERY_PRINTING_TIME_FORMAT = "HH_mm_ss";

    public static final String CHECK_LOG_FORMAT = "yyyyMMdd";

    public static final String TEN_PAY_DATE_STRING_FORMAT = "yyMMdd";

    public static final String REPORT_CSV_FORMAT = "yyyyMMdd_HHmmss";

    public static final String ZH_DATE_FORMAT = "yyyy年MM月dd日 HH:mm:ss";

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT = "yyyy-MM-dd HH-mm-ss";

    //	引入SimpleDateFormat类处理时间
    private static SimpleDateFormat simpleDateFormat;

    public static String format(String type) {
        simpleDateFormat = new SimpleDateFormat(type);
        String s = simpleDateFormat.format(new Date());
        logger.info(s);
        return s;
    }


    public static long time() {
        long t = System.currentTimeMillis();
        logger.info(String.valueOf(t));
        return t;
    }


}
