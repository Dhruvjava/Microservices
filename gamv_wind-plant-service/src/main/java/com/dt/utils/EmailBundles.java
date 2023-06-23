package com.dt.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class EmailBundles {

    private static final Properties appErrors = new Properties();

    private static final String EMAIL_PROP_FILE = "classpath:/bundles/email_templates.properties";

    private static final String EMAIL_FILE_LOAD_FAILED =
                    "Unable to load email_templates.properties file.";

    static {
        // CLEAR PROPERTIES
        appErrors.clear();

        loadApplicationErrors();

    }

    public static void loadApplicationErrors() {

        try {
            PathMatchingResourcePatternResolver resolver =
                            new PathMatchingResourcePatternResolver();
            Resource resource = resolver.getResource(EMAIL_PROP_FILE);
            appErrors.load(resource.getInputStream());
        } catch (IOException ex) {
            log.error(EMAIL_FILE_LOAD_FAILED);
            throw new RuntimeException(EMAIL_FILE_LOAD_FAILED, ex);
        }
    }

    public static String getProperty(String propertyName) {
        return appErrors.getProperty(propertyName);
    }

}
