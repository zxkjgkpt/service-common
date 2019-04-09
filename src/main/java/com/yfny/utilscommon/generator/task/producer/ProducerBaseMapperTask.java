package com.yfny.utilscommon.generator.task.producer;

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
 * 代码生成器生产者（微服务）数据交互层基类任务
 * Created by jisongZhou on 2019/4/9.
 **/
public class ProducerBaseMapperTask extends AbstractTask {

    public ProducerBaseMapperTask(String className) {
        super(className);
    }

    @Override
    public void run() throws IOException, TemplateException {
        // 生成BaseMapper填充数据
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("BasePackageName", ConfigUtil.getConfiguration().getPackageName());
        dataMap.put("MapperPackageName", ConfigUtil.getConfiguration().getPath().getMapper());
        dataMap.put("Author", ConfigUtil.getConfiguration().getAuthor());
        dataMap.put("Date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) + StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getMapper());
        String fileName = "BaseMapper.java";
        // 生成BaseMapper文件
        System.out.println("Generating " + fileName);
        FileUtil.generateToJava(FreemarketConfigUtils.TYPE_PRODUCER_BASE_MAPPER, dataMap, filePath + fileName);
    }
}
