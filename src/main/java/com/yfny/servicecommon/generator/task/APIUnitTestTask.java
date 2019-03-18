package com.yfny.servicecommon.generator.task;

import com.yfny.servicecommon.generator.task.base.AbstractTask;
import com.yfny.servicecommon.generator.utils.ConfigUtil;
import com.yfny.servicecommon.generator.utils.FileUtil;
import com.yfny.servicecommon.generator.utils.FreemarketConfigUtils;
import com.yfny.servicecommon.generator.utils.StringUtil;
import com.yfny.servicecommon.util.CodeInfoUtils;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成器API单元测试任务
 * Created by jisongZhou on 2019/3/7.
 **/
public class APIUnitTestTask extends AbstractTask {

    public APIUnitTestTask(String className) {
        super(className);
    }

    @Override
    public void run() throws IOException, TemplateException {
        // 生成APIUnitTest填充数据
        System.out.println("Generating APIUnitTest.java");
        Map<String, Object> testData = new HashMap<>();
        testData.put("BasePackageName", ConfigUtil.getConfiguration().getPackageName());
        testData.put("APIUnitTestPackageName", ConfigUtil.getConfiguration().getPath().getUnittest());
        testData.put("APIBaseTestPackageName", ConfigUtil.getConfiguration().getPath().getBasetest());
        testData.put("Author", ConfigUtil.getConfiguration().getAuthor());
        testData.put("Date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        testData.put("RequestInfoList", CodeInfoUtils.getRequestInfos());
        String filePath = FileUtil.getTestPath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) + StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getUnittest());
        String fileName = "APIUnitTest.java";
        // 生成Controller文件
        FileUtil.generateToJava(FreemarketConfigUtils.TYPE_API_UNIT_TEST, testData, filePath + fileName);
    }
}
