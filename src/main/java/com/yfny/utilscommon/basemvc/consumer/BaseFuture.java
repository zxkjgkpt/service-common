package com.yfny.utilscommon.basemvc.consumer;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 服务消费者通用Future
 * Author jisongZhou
 * Date  2019-04-03
 */
public abstract class BaseFuture<T> {

    @Autowired
    private BaseClient<T> baseClient;

    public BaseClient<T> getBaseClient() {
        return this.baseClient;
    }

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * @param entity 对象实体
     * @return 返回0为失败，返回1为成功
     */
    public CompletableFuture<Integer> insert(T entity) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().insert(entity));
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param entity 对象实体
     * @return 返回0为失败，返回1为成功
     */
    public CompletableFuture<Integer> insertSelective(T entity) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().insertSelective(entity));
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     *
     * @param entity 对象实体
     * @return 返回0为失败，返回1为成功
     */
    public CompletableFuture<Integer> update(T entity) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().update(entity));
    }

    /**
     * 根据主键更新属性不为null的值
     *
     * @param entity 对象实体
     * @return 返回0为失败，返回1为成功
     */
    public CompletableFuture<Integer> updateSelective(T entity) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().updateSelective(entity));
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param entity 对象实体
     * @return 返回0为失败，返回1为成功
     */
    public CompletableFuture<Integer> delete(T entity) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().delete(entity));
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param key 主键
     * @return 返回0为失败，返回1为成功
     */
    public CompletableFuture<Integer> deleteByPrimaryKey(Object key) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().deleteByPrimaryKey(key));
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param key 主键
     * @return 返回false为不存在，返回true为存在
     */
    public CompletableFuture<Boolean> existsWithPrimaryKey(Object key) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().existsWithPrimaryKey(key));
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param entity 对象实体
     * @return 返回null为未查询到结果，返回对象为查询结果，返回多个结果则抛出异常
     */
    public CompletableFuture<T> selectOne(T entity) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().selectOne(entity));
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key 主键
     * @return 返回null为未查询到结果，返回对象为查询结果
     */
    public CompletableFuture<T> selectByPrimaryKey(Object key) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().selectByPrimaryKey(key));
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     *
     * @param entity 对象实体
     * @return 返回查询结果数量
     */
    public CompletableFuture<Integer> selectCount(T entity) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().selectCount(entity));
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号，分页返回
     *
     * @param entity   对象实体
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 返回null为未查询到结果，返回对象列表为查询结果
     */
    public CompletableFuture<List<T>> findList(T entity, String pageNum, String pageSize) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().findList(entity, pageNum, pageSize));
    }

    /**
     * 查询全部结果分页返回
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 返回对象列表为查询结果
     */
    public CompletableFuture<List<T>> findAllList(String pageNum, String pageSize) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().findAllList(pageNum, pageSize));
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集，分页返回
     *
     * @param entity   对象实体
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 返回对象列表为查询结果
     */
    public CompletableFuture<List<T>> findSimpleListByAndCondition(T entity, String pageNum, String pageSize) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().findSimpleListByAndCondition(entity, pageNum, pageSize));
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集，分页返回
     *
     * @param entity   对象实体
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 返回对象列表为查询结果
     */
    public CompletableFuture<List<T>> findListByAndCondition(T entity, String pageNum, String pageSize) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().findListByAndCondition(entity, pageNum, pageSize));
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集，分页返回
     *
     * @param entity   对象实体
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 返回对象列表为查询结果
     */
    public CompletableFuture<List<T>> findSimpleListByORCondition(T entity, String pageNum, String pageSize) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().findSimpleListByORCondition(entity, pageNum, pageSize));
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集，分页返回
     *
     * @param entity   对象实体
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 返回对象列表为查询结果
     */
    public CompletableFuture<List<T>> findListByORCondition(T entity, String pageNum, String pageSize) {
        return CompletableFuture.supplyAsync(() -> getBaseClient().findListByORCondition(entity, pageNum, pageSize));
    }

}
