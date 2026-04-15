package org.tester.l_ioExel;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @created : 30/03/2026,16:05,lun.
 **/
public class LoggerTest {
    static Logger logg= LogManager.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        logg.info(" Enfin");
    }

}
