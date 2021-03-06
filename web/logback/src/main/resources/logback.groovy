def LOG_PATH = "web/logback/logs"
def LOG_PATTERN = "%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"

appender("Console-Appender", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = LOG_PATTERN
    }
}

appender("File-Appender", FileAppender) {
    file = "${LOG_PATH}/application.log"
    encoder(PatternLayoutEncoder) {
        pattern = LOG_PATTERN
        outputPatternAsHeader = true
    }
}

logger("com.fm.logback", INFO, ["File-Appender"])

root(INFO, ["Console-Appender"])