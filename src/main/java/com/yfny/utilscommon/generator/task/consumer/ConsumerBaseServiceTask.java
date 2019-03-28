package com.yfny.utilscommon.generator.task.consumer;

import com.yfny.utilscommon.generator.task.base.AbstractTask;
import com.yfny.utilscommon.generator.utils.ConfigUtil;
import com.yfny.utilscommon.generator.utils.FileUtil;
import com.yfny.utilscommon.generator.utils.FreemarketConfigUtils;
import com.yfny.utilscommon.generator.utils.StringUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成器消费者服务层基类任务
 * Created by jisongZhou on 2019/3/27.
 **/
public class ConsumerBaseServiceTask extends AbstractTask {

    public ConsumerBaseServiceTask(String className) {
        super(className);
    }

    @Override
    public void run() throws IOException, TemplateException {
        // 生成BaseService填充数据
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("BasePackageName", ConfigUtil.getConfiguration().getPackageName());
        dataMap.put("ServicePackageName", ConfigUtil.getConfiguration().getPath().getService());
        dataMap.put("Author", ConfigUtil.getConfiguration().getAuthor());
        dataMap.put("Date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) + StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getService());
        String fileName = "BaseService.java";
        // 生成BaseService文件
        System.out.println("Generating " + fileName);
        FileUtil.generateToJava(FreemarketConfigUtils.TYPE_CONSUMER_BASE_SERVICE, dataMap, filePath + fileName);
    }
}
