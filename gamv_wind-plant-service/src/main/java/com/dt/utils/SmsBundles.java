package com.dt.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class SmsBundles {

    private static final Properties smsTemplates = new Properties();

    private static final String ERR_PROP_FILE = "classpath:/bundles/sms_templates.properties";

    private static final String ERR_FILE_LOAD_FAILED =
                    "Unable to load sms_templates.properties file.";

    static {
        // CLEAR PROPERTIES
        smsTemplates.clear();

        loadSmsTemplates();

    }

    public static void loadSmsTemplates() {

        try {
            PathMatchingResourcePatternResolver resolver =
                            new PathMatchingResourcePatternResolver();
            Resource resource = resolver.getResource(ERR_PROP_FILE);
            smsTemplates.load(resource.getInputStream());
        } catch (IOException ex) {
            log.error(ERR_FILE_LOAD_FAILED);
            throw new RuntimeException(ERR_FILE_LOAD_FAILED, ex);
        }
    }

    public static String getProperty(String propertyName) {
        return smsTemplates.getProperty(propertyName);
    }
}
