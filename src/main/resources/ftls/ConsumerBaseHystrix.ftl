package ${BasePackageName}${HystrixPackageName};

import ${BasePackageName}${ServicePackageName}.BaseService;

import java.util.List;

/**
 * 服务消费者通用Hystrix
 * Author ${Author}
 * Date  ${Date}
 */
public class BaseHystrix<T> implements BaseService<T> {

    @Override
    public int insert(T entity) { return -1; }

    @Override
    public int insertSelective(T entity) { return -1; }

    @Override
    public int update(T entity) { return -1; }

    @Override
    public int updateSelective(T entity) { return -1; }

    @Override
    public int delete(T entity) { return -1; }

    @Override
    public int deleteByPrimaryKey(Object key) { return -1; }

    @Override
    public boolean existsWithPrimaryKey(Object key) { return false; }

    @Override
    public T selectOne(T entity) { return null; }

    @Override
    public T selectByPrimaryKey(Object key) { return null; }

    @Override
    public int selectCount(T entity) { return -1; }

    @Override
    public List<T> findList(T entity) { return null; }

    @Override
    public List<T> findList(T entity, int pageNum, int pageSize) { return null; }

    @Override
    public List<T> findAllList() { return null; }

    @Override
    public List<T> findAllList(int pageNum, int pageSize) { return null; }

}
