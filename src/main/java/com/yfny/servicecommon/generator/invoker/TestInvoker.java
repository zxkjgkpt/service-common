package com.yfny.servicecommon.generator.invoker;

import com.yfny.servicecommon.generator.invoker.base.AbstractBuilder;
import com.yfny.servicecommon.generator.invoker.base.AbstractInvoker;
import com.yfny.servicecommon.generator.invoker.base.Invoker;

import java.sql.SQLException;

/**
 * 代码生成器单元测试调度器
 * Created by jisongZhou on 2019/3/7.
 **/
public class TestInvoker extends AbstractInvoker {
    @Override
    protected void getTableInfos() throws SQLException {

    }

    @Override
    protected void initTasks() {
        taskQueue.initTestTasks(className);
    }

    public static class Builder extends AbstractBuilder {

        private TestInvoker invoker = new TestInvoker();

        @Override
        public Invoker build() {
            if (!isParamtersValid()) {
                return null;
            }
            return invoker;
        }

        @Override
        public void checkBeforeBuild() throws Exception {

        }
    }
}
