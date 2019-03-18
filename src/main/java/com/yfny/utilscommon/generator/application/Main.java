package com.yfny.utilscommon.generator.application;

import com.yfny.utilscommon.generator.invoker.Many2ManyInvoker;
import com.yfny.utilscommon.generator.invoker.One2ManyInvoker;
import com.yfny.utilscommon.generator.invoker.SingleInvoker;
import com.yfny.utilscommon.generator.invoker.TestInvoker;
import com.yfny.utilscommon.generator.invoker.base.Invoker;

/**
 * 代码生成器测试主类
 * Created by jisongZhou on 2019/3/5.
 **/
public class Main {

    public static void main(String[] args) {
        test();
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

    public static void single() {
        Invoker invoker = new SingleInvoker.Builder()
                .setTableName("user")
                .setClassName("User")
                .build();
        invoker.execute();
    }

    public static void test() {
        Invoker invoker = new TestInvoker.Builder()
                .build();
        invoker.execute();
    }

}
