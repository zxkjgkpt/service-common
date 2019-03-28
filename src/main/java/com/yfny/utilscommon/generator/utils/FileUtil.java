package com.yfny.utilscommon.generator.utils;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;

/**
 * 代码生成器文件生成
 * Created by jisongZhou on 2019/3/5.
 **/
public class FileUtil {

    /**
     * @param type     使用模板类型
     * @param data     填充数据
     * @param filePath 输出文件
     * @throws IOException
     * @throws TemplateException
     */
    public static void generateToJava(int type, Object data, String filePath) throws IOException, TemplateException {
        File file = new File(filePath);
        if (file.exists()) {
            System.err.println("ERROR: " + file.getPath().substring(file.getPath().lastIndexOf("\\") + 1, file.getPath().length()) + " 已存在，请手动修改");
            return;
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Template tpl = getTemplate(type); // 获取模板文件
        // 填充数据
        StringWriter writer = new StringWriter();
        tpl.process(data, writer);
        writer.flush();
        // 写入文件
        FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw, 1024);
        tpl.process(data, bw);
        fos.close();
    }

    /**
     * 获取模板
     *
     * @param type 模板类型
     * @return
     * @throws IOException
     */
    private static Template getTemplate(int type) throws IOException {
        switch (type) {
            case FreemarketConfigUtils.TYPE_ENTITY:
                return FreemarketConfigUtils.getInstance().getTemplate("Entity.ftl");
            case FreemarketConfigUtils.TYPE_PRODUCER_MAPPER:
                return FreemarketConfigUtils.getInstance().getTemplate("ProducerMapper.ftl");
            case FreemarketConfigUtils.TYPE_PRODUCER_BASE_SERVICE:
                return FreemarketConfigUtils.getInstance().getTemplate("ProducerBaseServiceImpl.ftl");
            case FreemarketConfigUtils.TYPE_PRODUCER_SERVICE:
                return FreemarketConfigUtils.getInstance().getTemplate("ProducerServiceImpl.ftl");
            case FreemarketConfigUtils.TYPE_PRODUCER_BASE_CONTROLLER:
                return FreemarketConfigUtils.getInstance().getTemplate("ProducerBaseController.ftl");
            case FreemarketConfigUtils.TYPE_PRODUCER_CONTROLLER:
                return FreemarketConfigUtils.getInstance().getTemplate("ProducerController.ftl");
            case FreemarketConfigUtils.TYPE_CONSUMER_BASE_SERVICE:
                return FreemarketConfigUtils.getInstance().getTemplate("ConsumerBaseService.ftl");
            case FreemarketConfigUtils.TYPE_CONSUMER_SERVICE:
                return FreemarketConfigUtils.getInstance().getTemplate("ConsumerService.ftl");
            case FreemarketConfigUtils.TYPE_CONSUMER_BASE_HYSTRIX:
                return FreemarketConfigUtils.getInstance().getTemplate("ConsumerBaseHystrix.ftl");
            case FreemarketConfigUtils.TYPE_CONSUMER_HYSTRIX:
                return FreemarketConfigUtils.getInstance().getTemplate("ConsumerHystrix.ftl");
            case FreemarketConfigUtils.TYPE_CONSUMER_BASE_CONTROLLER:
                return FreemarketConfigUtils.getInstance().getTemplate("ConsumerBaseController.ftl");
            case FreemarketConfigUtils.TYPE_CONSUMER_CONTROLLER:
                return FreemarketConfigUtils.getInstance().getTemplate("ConsumerController.ftl");
            case FreemarketConfigUtils.TYPE_API_BASE_TEST:
                return FreemarketConfigUtils.getInstance().getTemplate("APIBaseTest.ftl");
            case FreemarketConfigUtils.TYPE_API_UNIT_TEST:
                return FreemarketConfigUtils.getInstance().getTemplate("APIUnitTest.ftl");
            default:
                return null;
        }
    }

    private static String getBasicProjectPath() {
        String path = new File(FileUtil.class.getClassLoader().getResource("").getFile()).getPath() + File.separator;
        StringBuilder sb = new StringBuilder();
        sb.append(path.substring(0, path.indexOf("target"))).append("src").append(File.separator).append("main").append(File.separator);
        return sb.toString();
    }

    private static String getTestProjectPath() {
        String path = new File(FileUtil.class.getClassLoader().getResource("").getFile()).getPath() + File.separator;
        StringBuilder sb = new StringBuilder();
        sb.append(path.substring(0, path.indexOf("target"))).append("src").append(File.separator).append("test").append(File.separator);
        return sb.toString();
    }

    /**
     * 获取源码路径
     *
     * @return
     */
    public static String getSourcePath() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBasicProjectPath()).append("java").append(File.separator);
        return sb.toString();
    }

    /**
     * 获取资源文件路径
     *
     * @return
     */
    public static String getResourcePath() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBasicProjectPath()).append("resources").append(File.separator);
        return sb.toString();
    }

    /**
     * 获取单元测试路径
     *
     * @return
     */
    public static String getTestPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTestProjectPath()).append("java").append(File.separator);
        return sb.toString();
    }

}
