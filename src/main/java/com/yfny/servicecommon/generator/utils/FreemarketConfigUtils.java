package com.yfny.servicecommon.generator.utils;

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
    public final static int TYPE_ENTITY = 0;
    public final static int TYPE_DAO = 1;
    public final static int TYPE_SERVICE = 2;
    public final static int TYPE_CONTROLLER = 3;
    public final static int TYPE_MAPPER = 4;
    public final static int TYPE_INTERFACE = 5;
    public final static int TYPE_API_BASE_TEST = 6;
    public final static int TYPE_API_UNIT_TEST = 7;
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
