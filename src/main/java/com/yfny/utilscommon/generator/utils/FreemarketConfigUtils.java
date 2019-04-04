package com.yfny.utilscommon.generator.utils;

import freemarker.template.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

/**
 * 代码生成器配置获取工具
 * Created by jisongZhou on 2019/3/5.
 **/
public class FreemarketConfigUtils {
    private static String path = new File(FreemarketConfigUtils.class.getClassLoader().getResource("ftls").getFile()).getPath();
    public final static int TYPE_BASE_ENTITY = 0;
    public final static int TYPE_ENTITY = 1;
    public final static int TYPE_PRODUCER_SQL_BUILDER = 2;
    public final static int TYPE_PRODUCER_MAPPER = 3;
    public final static int TYPE_PRODUCER_BASE_SERVICE = 4;
    public final static int TYPE_PRODUCER_SERVICE = 5;
    public final static int TYPE_PRODUCER_BASE_CONTROLLER = 6;
    public final static int TYPE_PRODUCER_CONTROLLER = 7;
    public final static int TYPE_CONSUMER_BASE_SERVICE = 8;
    public final static int TYPE_CONSUMER_SERVICE = 9;
    public final static int TYPE_CONSUMER_BASE_HYSTRIX = 10;
    public final static int TYPE_CONSUMER_HYSTRIX = 11;
    public final static int TYPE_CONSUMER_BASE_CONTROLLER = 12;
    public final static int TYPE_CONSUMER_CONTROLLER = 13;
    public final static int TYPE_EXCEPTION_HANDLER = 14;
    public final static int TYPE_ADD_ENTITY = 15;
    public final static int TYPE_ADD_PRODUCER_MAPPER = 16;
    public final static int TYPE_API_BASE_TEST = 17;
    public final static int TYPE_API_UNIT_TEST = 18;

    private static Configuration configuration;

    public static synchronized Configuration getInstance() {
        if (null == configuration) {
            configuration = new Configuration(Configuration.VERSION_2_3_28);
            try {
                if (path.contains("jar")) {
                    configuration.setClassForTemplateLoading(FreemarketConfigUtils.class, "/ftls");
                } else {
                    configuration.setDirectoryForTemplateLoading(new File(path));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            configuration.setEncoding(Locale.CHINA, "utf-8");
        }
        return configuration;
    }
}
