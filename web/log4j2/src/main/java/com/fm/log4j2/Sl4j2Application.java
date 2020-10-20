package com.fm.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Sl4j2Application {
    private static Logger logger = LogManager.getLogger(Sl4j2Application.class);

    public static void main(String[] args) {

        logger.trace("this is a TRACE message");
        logger.debug("this is a DEBUG message");
        logger.info("this is an INFO message");
        logger.warn("this is a WARN message");
        logger.error("this is an ERROR message");
        logger.fatal("this is a FATAL message");

    }
}

