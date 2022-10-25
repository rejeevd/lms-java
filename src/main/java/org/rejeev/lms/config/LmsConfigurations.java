package org.rejeev.lms.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class LmsConfigurations {
    private static LmsConfigurations instance;
    private static final Logger log = LoggerFactory.getLogger(LmsConfigurations.class);
    private Properties properties;
    private List<String> authExcludedUris;
    private List<String> authWhitelist;

    public static LmsConfigurations getInstance(){
        if(instance == null){
            synchronized (LmsConfigurations.class){
                if(instance == null){
                    instance = new LmsConfigurations();
                }
            }
        }
        return instance;
    }
    private LmsConfigurations(){
        try {
            log.info("Loading application.properties");
            InputStream is = getClass().getClassLoader().getResourceAsStream("application.properties");
            properties = new Properties();
            properties.load(is);
            log.info("Loaded application.properties");
        }catch (Exception e){
            log.error("Exception during reading configuration file");
        }
    }

    public String getStringValue(String key){
        return properties.getProperty(key);
    }

    public String getStringValue(String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }

    public List<String> getStringList(String key){
        String valueStr = properties.getProperty(key);
        if(StringUtils.isEmpty(valueStr)) return Collections.emptyList();
        String[] tokens = valueStr.split(",");
        List<String> tokenList = Arrays.<String>asList(tokens);
        return Collections.unmodifiableList(tokenList);
    }
}
