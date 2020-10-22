# Objectives

- write in the console (error) and in a file by appending (info) using log4j2 
- use yml configuration (optionally xml configuration)
- use all logging levels

# Concepts

Slf4j is a wrapper on top of other logging frameworks.

Log4j2 is the real logging framework.

Slf4j makes the code framework agnostic.

## Logging levels

    OFF
    FATAL
    ERROR
    WARN
    INFO
    DEBUG
    TRACE
    ALL

## Configuration
 
Log4j will inspect the "log4j.configurationFile" system property and, if set, will attempt to load the 
configuration using the ConfigurationFactory that matches the file extension. Note that this is 
not restricted to a location on the local file system and may contain a URL.

If no system property is set the properties ConfigurationFactory will look for log4j2-test.properties in the classpath.

If no such file is found the YAML ConfigurationFactory will look for log4j2-test.yaml or log4j2-test.yml

If no such file is found the JSON ConfigurationFactory will look for log4j2-test.json or log4j2-test.jsn

If no such file is found the XML ConfigurationFactory will look for log4j2-test.xml

If a test file cannot be located the properties ConfigurationFactory will look for log4j2.properties 

If a properties file cannot be located the YAML ConfigurationFactory will look for log4j2.yaml or log4j2.yml 

If a YAML file cannot be located the JSON ConfigurationFactory will look for log4j2.json or log4j2.jsn 

If a JSON file cannot be located the XML ConfigurationFactory will try to locate log4j2.xml

If no configuration file could be located the DefaultConfiguration will be used. 
This will cause logging output to go to the console.

# Research

- https://www.scalyr.com/blog/log4j2-configuration-detailed-guide/
- https://www.itersdesktop.com/2019/01/28/getting-started-with-log4j2/
- https://stackify.com/log4j2-java/
- https://springframework.guru/log4j-2-configuration-using-yaml/

