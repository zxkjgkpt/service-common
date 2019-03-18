package com.yfny.servicecommon.generator.invoker;

import com.yfny.servicecommon.generator.invoker.base.AbstractBuilder;
import com.yfny.servicecommon.generator.invoker.base.AbstractInvoker;
import com.yfny.servicecommon.generator.invoker.base.Invoker;
import com.yfny.servicecommon.generator.utils.GeneratorUtil;
import com.yfny.servicecommon.generator.utils.StringUtil;

import java.sql.SQLException;

/**
 * 代码生成器单体调度器
 * Created by jisongZhou on 2019/3/5.
 **/
public class SingleInvoker extends AbstractInvoker {

    @Override
    protected void getTableInfos() throws SQLException {
        tableInfos = connectionUtil.getMetaData(tableName);
    }

    @Override
    protected void initTasks() {
        taskQueue.initSingleTasks(className, tableName, tableInfos);
    }

    public static class Builder extends AbstractBuilder {
        private SingleInvoker invoker = new SingleInvoker();

        public Builder setTableName(String tableName) {
            invoker.setTableName(tableName);
            return this;
        }

        public Builder setClassName(String className) {
            invoker.setClassName(className);
            return this;
        }

        @Override
        public Invoker build() {
            if (!isParamtersValid()) {
                return null;
            }
            return invoker;
        }

        @Override
        public void checkBeforeBuild() throws Exception {
            if (StringUtil.isBlank(invoker.getTableName())) {
                throw new Exception("Expect table's name, but get a blank String.");
            }
            if (StringUtil.isBlank(invoker.getClassName())) {
                invoker.setClassName(GeneratorUtil.generateClassName(invoker.getTableName()));
            }
        }
    }

}
