package BusinessLogic;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;


/**
 * Created by thinkpad on 2017/2/13.
 */
public class TestLog4j {

/*
    private static Logger logger = Logger.getLogger(TestLog4j.class);


    public static void main(String[] args) {
        // System.out.println("This is println message.");

        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }

*/
public static  Logger m_log = null;

    public static void main( String[] args )

    {

        PropertyConfigurator.configure("E://work//workspace//MyPro//log4j.properties");

        m_log = Logger.getLogger(TestLog4j.class);

        m_log.debug("debug test...........");

        System.out.println( "OK" );

    }

}




