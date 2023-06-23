package com.dt.utils;

import com.dt.constants.StringConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.InputStream;
import java.text.MessageFormat;

@Slf4j
public class HtmlReportsUtils {

    private static final String TMPL_PATH = "classpath:/tmpl_html/<FILE_NAME>";

    public static String createDocument() {
        return ReportBundles.getProperty("html.element.document");
    }

    public static String addTD(String content) {
        return MessageFormat.format(EmailBundles.getProperty("html.element.td"),
                        Utils.getValidString(content));
    }

    public static String addTR(String content) {
        return MessageFormat.format(EmailBundles.getProperty("html.element.tr"),
                        Utils.getValidString(content));
    }

    public static InputStream inputStream(String fileName) {

        if (log.isDebugEnabled()) {
            log.debug("Executing inputStream(fileName) ->");
        }

        try {
            if (Utils.isEmpty(fileName)) {
                log.error("fileName IS EMPTY--->");
                return null;
            }
            PathMatchingResourcePatternResolver resolver =
                            new PathMatchingResourcePatternResolver();
            Resource resource = resolver.getResource(TMPL_PATH.replace("<FILE_NAME>", fileName));
            return resource.getInputStream();

        } catch (Exception e) {
            log.error("Exception in inputStream(fileName) - " + e);
            return null;
        }
    }

    public static String template(String fileName) {

        if (log.isDebugEnabled()) {
            log.debug("Executing template(fileName) ->");
        }

        try {
            if (Utils.isEmpty(fileName)) {
                log.error("fileName IS EMPTY--->");
                return StringConstants.EMPTY;
            }
            InputStream ins = HtmlReportsUtils.inputStream(fileName);
            if (ins == null) {
                return StringConstants.EMPTY;
            }
            return IOUtils.toString(ins);
        } catch (Exception e) {
            log.error("Exception in template(fileName) - " + e);
            return StringConstants.EMPTY;
        }
    }

}
