package com.yfny.utilscommon.generator.application;

import com.yfny.utilscommon.generator.invoker.*;
import com.yfny.utilscommon.generator.invoker.base.Invoker;

/**
 * 代码生成器测试主类
 * Created by jisongZhou on 2019/3/5.
 **/
public class Main {

    public static void main(String[] args) {
        singleInvokerTest();
    }

    public static void many2many() {
        Invoker invoker = new Many2ManyInvoker.Builder()
                .setTableName("user")
                .setClassName("User")
                .setParentTableName("role")
                .setParentClassName("Role")
                .setRelationTableName("user_role")
                .setForeignKey("userId")
                .setParentForeignKey("roleId")
                .build();
        invoker.execute();
    }

    public static void one2many() {
        Invoker invoker = new One2ManyInvoker.Builder()
                .setTableName("user")
                .setClassName("User")
                .setParentTableName("office")
                .setParentClassName("Office")
                .setForeignKey("officeId")
                .build();
        invoker.execute();
    }

    public static void singleInvokerTest() {
        Invoker invoker = new SingleInvoker.Builder()
                .setTableName("user")
                .setClassName("User")
                .setDescription("用户")
                .build();
        invoker.execute();
    }

    public static void producerInvokerTest() {
        Invoker invoker = new ProducerInvoker.Builder()
                .setClassName("User")
                .setDescription("用户")
                .setFirst(true)
                .build();
        invoker.execute();
    }

    public void consumerInvokerTest() {
        Invoker invoker = new ConsumerInvoker.Builder()
                .setClassName("User")
                .setDescription("用户")
                .setApplicationName("service-user")
                .setFirst(true)
                .build();
        invoker.execute();
    }

    public static void apiTestInvokerTest() {
        Invoker invoker = new TestInvoker.Builder()
                .build();
        invoker.execute();
    }

}
