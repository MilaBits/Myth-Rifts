package milly.mythrifts.common.Util;

import milly.mythrifts.MythRifts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {

    private static Logger logger;

    public static Logger getLogger() {
        if (logger == null){
            logger = LogManager.getFormatterLogger(MythRifts.MODID);
        }
        return logger;
    }
}
