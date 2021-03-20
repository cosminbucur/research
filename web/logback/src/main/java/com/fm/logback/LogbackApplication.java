package com.fm.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackApplication {

    private static final Logger logger = LoggerFactory.getLogger(LogbackApplication.class);

    public static void main(String[] args) {
        logger.trace("this is a TRACE message");
        logger.debug("this is a DEBUG message");
        logger.info("this is an INFO message");
        logger.warn("this is a WARN message");
        logger.error("this is an ERROR message");
    }
}

