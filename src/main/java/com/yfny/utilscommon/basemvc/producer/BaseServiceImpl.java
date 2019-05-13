package com.yfny.utilscommon.basemvc.producer;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yfny.utilscommon.basemvc.common.BaseEntity;
import com.yfny.utilscommon.strategy.PageResultStrategy;
import com.yfny.utilscommon.util.ReflectUtils;
import com.yfny.utilscommon.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * 微服务通用ServiceImpl
 * Author jisongZhou
 * Date  2019-04-03
 */
public abstract class BaseServiceImpl<T extends BaseEntity> {

    @Autowired
    private BaseComponent<T> baseComponent;

    public BaseComponent<T> getBaseComponent() {
        return this.baseComponent;
    }

    @Autowired
    private BaseMapper<T> baseMapper;

    public BaseMapper<T> getBaseMapper() {
        return this.baseMapper;
    }

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * @param entity 对象实体
     * @return 返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int insert(T entity) {
        setPKValue(entity);
        return getBaseMapper().insert(entity);
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param entity 对象实体
     * @return 返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int insertSelective(T entity) {
        setPKValue(entity);
        if (getBaseComponent().list != null && getBaseComponent().list.size() > 0) {
            for (Object composite : getBaseComponent().list) {
                setPKValue((T)(((AbstractComponent) composite).getParam()));
                ((AbstractComponent) composite).insertSelective();
            }
        }
        return getBaseMapper().insertSelective(entity);
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     *
     * @param entity 对象实体
     * @return 返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int update(T entity) {
        return getBaseMapper().updateByPrimaryKey(entity);
    }

    /**
     * 根据主键更新属性不为null的值
     *
     * @param entity 对象实体
     * @return 返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int updateSelective(T entity) {
        return getBaseMapper().updateByPrimaryKeySelective(entity);
    }

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * @param entity 对象实体
     * @return 返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int save(T entity) {
        int result;
        Object pkValue = getPKValue(entity);
        if (!existsWithPrimaryKey(pkValue)) {
            result = insert(entity);
        } else {
            result = update(entity);
        }
        return result;
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param entity 对象实体
     * @return 返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int saveSelective(T entity) {
        int result;
        Object pkValue = getPKValue(entity);
        if (!existsWithPrimaryKey(pkValue)) {
            result = insertSelective(entity);
        } else {
            result = updateSelective(entity);
        }
        return result;
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param entity 对象实体
     * @return 返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int delete(T entity) {
        return getBaseMapper().delete(entity);
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param key 主键
     * @return 返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int deleteByPrimaryKey(Object key) {
        return getBaseMapper().deleteByPrimaryKey(key);
    }

    /**
     * 根据主键字段进行批量删除，方法参数必须包含完整的主键属性
     *
     * @param ids 主键，示例"1,2,3,4"
     * @return 返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int deleteByIds(String ids) {
        return getBaseMapper().deleteByIds(ids);
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param key 主键
     * @return 返回false为不存在，返回true为存在
     */
    public boolean existsWithPrimaryKey(Object key) {
        return getBaseMapper().existsWithPrimaryKey(key);
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param entity 对象实体
     * @return 返回null为未查询到结果，返回对象为查询结果，返回多个结果则抛出异常
     */
    public T selectOne(T entity) {
        return getBaseMapper().selectOne(entity);
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key 主键
     * @return 返回null为未查询到结果，返回对象为查询结果
     */
    public T selectByPrimaryKey(Object key) {
        return getBaseMapper().selectByPrimaryKey(key);
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     *
     * @param entity 对象实体
     * @return 返回查询结果数量
     */
    public int selectCount(T entity) {
        return getBaseMapper().selectCount(entity);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号，分页返回
     *
     * @param entity   对象实体
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 返回对象列表为查询结果
     */
    public List<T> findList(T entity, String pageNum, String pageSize) {
        PageResultStrategy pageResultStrategy = () -> getBaseMapper().select(entity);
        return findPageResultList(pageResultStrategy, pageNum, pageSize);
    }

    /**
     * 查询全部结果分页返回
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 返回对象列表为查询结果
     */
    public List<T> findAllList(String pageNum, String pageSize) {
        PageResultStrategy pageResultStrategy = () -> getBaseMapper().selectAll();
        return findPageResultList(pageResultStrategy, pageNum, pageSize);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集，分页返回
     *
     * @param entity   对象实体
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 返回对象列表为查询结果
     */
    public List<T> findSimpleListByAndCondition(T entity, String pageNum, String pageSize) {
        PageResultStrategy pageResultStrategy = () -> getBaseMapper().findSimpleListByAndCondition(entity);
        return findPageResultList(pageResultStrategy, pageNum, pageSize);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集，分页返回
     *
     * @param entity   对象实体
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 返回对象列表为查询结果
     */
    public List<T> findListByAndCondition(T entity, String pageNum, String pageSize) {
        PageResultStrategy pageResultStrategy = () -> getBaseMapper().findListByAndCondition(entity);
        return findPageResultList(pageResultStrategy, pageNum, pageSize);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集，分页返回
     *
     * @param entity   对象实体
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 返回对象列表为查询结果
     */
    public List<T> findSimpleListByORCondition(T entity, String pageNum, String pageSize) {
        PageResultStrategy pageResultStrategy = () -> getBaseMapper().findSimpleListByORCondition(entity);
        return findPageResultList(pageResultStrategy, pageNum, pageSize);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集，分页返回
     *
     * @param entity   对象实体
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 返回对象列表为查询结果
     */
    public List<T> findListByORCondition(T entity, String pageNum, String pageSize) {
        PageResultStrategy pageResultStrategy = () -> getBaseMapper().findListByORCondition(entity);
        return findPageResultList(pageResultStrategy, pageNum, pageSize);
    }

    /**
     * 获取主键取值
     *
     * @param entity 对象实体
     * @return 主键
     */
    public Object getPKValue(T entity) {
        Set<EntityColumn> columnList = EntityHelper.getPKColumns(entity.getClass());
        EntityColumn column = columnList.iterator().next();
        Object pkValue = null;
        try {
            pkValue = column.getEntityField().getValue(entity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return pkValue;
    }

    /**
     * 设置主键取值
     *
     * @param entity 对象实体
     */
    public void setPKValue(T entity) {
        Set<EntityColumn> columnList = EntityHelper.getPKColumns(entity.getClass());
        EntityColumn column = columnList.iterator().next();
        String pkName = column.getEntityField().getName();
        try {
            Object pkValue = column.getEntityField().getValue(entity);
            if (pkValue != null) {
                if (pkValue instanceof String) {
                    if (StringUtils.isBlank((String) pkValue)) {
                        pkValue = generatorPkValue(entity);
                        ReflectUtils.setFieldValue(entity, pkName, pkValue);
                    }
                }
            } else {
                pkValue = generatorPkValue(entity);
                ReflectUtils.setFieldValue(entity, pkName, pkValue);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成主键
     *
     * @param entity 对象实体
     * @return 主键
     */
    public Object generatorPkValue(T entity) {
        return uuid();
    }

    /**
     * uuid生成方法
     *
     * @return uuid
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取分页相关数据，分页参数不合法时获取全部列表数据
     *
     * @param pageResultStrategy 对象列表结果
     * @param pageNum            页数
     * @param pageSize           每页数量
     * @return 返回对象列表为查询结果
     */
    public List<T> findPageResultList(PageResultStrategy pageResultStrategy, String pageNum, String pageSize) {
        List<T> resultList = new ArrayList<>();
        if (StringUtils.isNumeric(pageNum) && StringUtils.isNumeric(pageSize)) {
            int pageNumInteger = Integer.parseInt(pageNum);
            int pageSizeInteger = Integer.parseInt(pageSize);
            if (pageNumInteger > 0 && pageSizeInteger > 0) {
                Page<T> resultPage = PageHelper.startPage(pageNumInteger, pageSizeInteger);
                resultList = pageResultStrategy.pageResult();
                if (resultList != null) {
                    for (T result : resultList) {
                        result.setPageNum(resultPage.getPageNum());
                        result.setPageSize(resultPage.getPageSize());
                        result.setPageCount(resultPage.getPages());
                        result.setTotal(resultPage.getTotal());
                    }
                }
            }
        } else {
            resultList = pageResultStrategy.pageResult();
        }
        return resultList != null ? resultList : new ArrayList<>();
    }

}
