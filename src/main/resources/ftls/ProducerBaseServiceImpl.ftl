package ${BasePackageName}${ServicePackageName};

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.github.pagehelper.PageHelper;
import tk.mybatis.mapper.common.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 微服务通用ServiceImpl
 * Author ${Author}
 * Date  ${Date}
 */
public abstract class BaseServiceImpl<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    public BaseMapper<T> getBaseMapper() {
        return this.baseMapper;
    }


    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int insert(T entity) {
        return getBaseMapper().insert(entity);
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int insertSelective(T entity) {
        return getBaseMapper().insertSelective(entity);
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int update(T entity) {
        return getBaseMapper().updateByPrimaryKey(entity);
    }

    /**
     * 根据主键更新属性不为null的值
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int updateSelective(T entity) {
        return getBaseMapper().updateByPrimaryKeySelective(entity);
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int delete(T entity) {
        return getBaseMapper().delete(entity);
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param   key  主键
     * @return  返回0为失败，返回1为成功
     */
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int deleteByPrimaryKey(Object key) {
        return getBaseMapper().deleteByPrimaryKey(key);
    }

    /**
    * 根据主键字段进行删除，方法参数必须包含完整的主键属性
    * @param   key  主键
    * @return  返回false为不存在，返回true为存在
    */
    public boolean existsWithPrimaryKey(Object key) {
        return getBaseMapper().existsWithPrimaryKey(key);
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param   entity  对象实体
     * @return  返回null为未查询到结果，返回对象为查询结果，返回多个结果则抛出异常
     */
    public T selectOne(T entity) {
        return getBaseMapper().selectOne(entity);
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param   key  主键
     * @return  返回null为未查询到结果，返回对象为查询结果
     */
    public T selectByPrimaryKey(Object key) {
        return getBaseMapper().selectByPrimaryKey(key);
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param   entity  对象实体
     * @return  返回查询结果数量
     */
    public int selectCount(T entity) {
        return getBaseMapper().selectCount(entity);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param   entity  对象实体
     * @return  返回null为未查询到结果，返回对象列表为查询结果
     */
    public List<T> findList(T entity) {
        return getBaseMapper().select(entity);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号，分页返回
     * @param   entity  对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  返回null为未查询到结果，返回对象列表为查询结果
     */
    public List<T> findList(T entity, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return getBaseMapper().select(entity);
    }

    /**
     * 查询全部结果
     * @return  返回对象列表为查询结果
     */
    public List<T> findAllList() {
        return getBaseMapper().selectAll();
    }

    /**
     * 查询全部结果分页返回
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  返回对象列表为查询结果
     */
    public List<T> findAllList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return getBaseMapper().selectAll();
    }

}
