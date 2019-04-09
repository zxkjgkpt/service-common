package com.yfny.utilscommon.generator.utils;

import com.yfny.utilscommon.generator.entity.ColumnInfo;
import com.yfny.utilscommon.generator.invoker.RelationInvoker;
import com.yfny.utilscommon.generator.task.*;
import com.yfny.utilscommon.generator.task.base.AbstractTask;
import com.yfny.utilscommon.generator.task.consumer.*;
import com.yfny.utilscommon.generator.task.producer.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器任务执行
 * Created by jisongZhou on 2019/3/5.
 **/
public class TaskQueue {

    private LinkedList<AbstractTask> taskQueue = new LinkedList<>();

    /******************************************************此下方法为改造新增开始*****************************************************************/

    public void initSingleTasks(String className, String tableName, String description, List<ColumnInfo> tableInfos, boolean isFirst) {
        if (isFirst) {
            taskQueue.add(new BaseEntityTask(className));
        }
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getEntity())) {
            taskQueue.add(new EntityTask(className, tableName, description, tableInfos));
        }
    }

    private void initProducerBaseTasks(String className) {
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getMapper())) {
            taskQueue.add(new ProducerBaseMapperTask(className));
        }
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getService())) {
            taskQueue.add(new ProducerBaseServiceImplTask(className));
        }
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getController())) {
            taskQueue.add(new ProducerBaseControllerTask(className));
        }
        taskQueue.add(new ExceptionHandlerTask(className));
    }

    public void initProducerTasks(String className, String tableName, String description, List<ColumnInfo> tableInfos, boolean isFirst) {
        if (isFirst) {
            initProducerBaseTasks(className);
        }
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getSqlbuilder())) {
            taskQueue.add(new ProducerSqlBuilderTask(className, tableName, description, tableInfos));
        }
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getMapper())) {
            taskQueue.add(new ProducerMapperTask(className, description));
        }
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getService())) {
            taskQueue.add(new ProducerServiceImplTask(className, description));
        }
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getController())) {
            taskQueue.add(new ProducerControllerTask(className, description));
        }
    }

    private void initConsumerBaseTasks(String className) {
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getService())) {
            taskQueue.add(new ConsumerBaseServiceTask(className));
        }
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getHystrix())) {
            taskQueue.add(new ConsumerBaseHystrixTask(className));
        }
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getController())) {
            taskQueue.add(new ConsumerBaseControllerTask(className));
        }
        taskQueue.add(new ExceptionHandlerTask(className));
    }

    public void initConsumerTasks(String className, String description, String applicationName, boolean isFirst) {
        if (isFirst) {
            initConsumerBaseTasks(className);
        }
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getService())) {
            taskQueue.add(new ConsumerServiceTask(className, description, applicationName));
        }
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getHystrix())) {
            taskQueue.add(new ConsumerHystrixTask(className, description));
        }
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getController())) {
            taskQueue.add(new ConsumerControllerTask(className, description));
        }
    }

    public void initRelationTasks(String className, String foreignKey, Map<String, String> relationClassNameMap, String writeType) {
        if (RelationInvoker.Builder.ENTITY_FILE.equals(writeType)) {
            if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getEntity())) {
                taskQueue.add(new EntityAddTask(className, relationClassNameMap));
            }
        } else if (RelationInvoker.Builder.PRODUCER_FILE.equals(writeType)) {
            if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getMapper())) {
                taskQueue.add(new ProducerMapperAddTask(className, foreignKey, relationClassNameMap));
            }
        } else if (RelationInvoker.Builder.CONSUMER_FILE.equals(writeType)) {

        }
    }

    public void initTestTasks(String className) {
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getBasetest())) {
            taskQueue.add(new APIBaseTestTask(className));
        }
        if (!StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getUnittest())) {
            taskQueue.add(new APIUnitTestTask(className));
        }
    }

    /******************************************************此下方法为改造新增结束*****************************************************************/

    public boolean isEmpty() {
        return taskQueue.isEmpty();
    }

    public AbstractTask poll() {
        return taskQueue.poll();
    }

}
