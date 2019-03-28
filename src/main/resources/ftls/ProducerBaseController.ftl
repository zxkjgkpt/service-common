package ${BasePackageName}${ControllerPackageName};

import ${BasePackageName}${ServicePackageName}.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 微服务通用Controller
 * Author ${Author}
 * Date  ${Date}
 */
public abstract class BaseController<T> {

    @Autowired
    private BaseServiceImpl<T> baseService;

    public BaseServiceImpl<T> getBaseService() {
        return this.baseService;
    }

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @PostMapping(value = "/insert")
    @ResponseBody
    public int insert(@RequestBody T entity) throws Exception {
        return getBaseService().insert(entity);
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @PostMapping(value = "/insertSelective")
    @ResponseBody
    public int insertSelective(@RequestBody T entity) throws Exception {
        return getBaseService().insertSelective(entity);
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public int update(@RequestBody T entity) throws Exception {
        return getBaseService().update(entity);
    }

    /**
     * 根据主键更新属性不为null的值
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @PostMapping(value = "/updateSelective")
    @ResponseBody
    public int updateSelective(@RequestBody T entity) throws Exception {
        return getBaseService().updateSelective(entity);
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @PostMapping(value = "/delete")
    @ResponseBody
    public int delete(@RequestBody T entity) throws Exception {
        return getBaseService().delete(entity);
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param   key  主键
     * @return  返回0为失败，返回1为成功
     */
    @PostMapping(value = "/deleteByPrimaryKey")
    @ResponseBody
    public int deleteByPrimaryKey(@RequestParam(value = "key") Object key) throws Exception {
        return getBaseService().deleteByPrimaryKey(key);
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param   key  主键
     * @return  返回false为不存在，返回true为存在
     */
    @GetMapping(value = "/existsWithPrimaryKey")
    @ResponseBody
    public boolean existsWithPrimaryKey(@RequestParam(value = "key") Object key) throws Exception {
        return getBaseService().existsWithPrimaryKey(key);
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param   entity  对象实体
     * @return  返回null为未查询到结果，返回对象为查询结果，返回多个结果则抛出异常
     */
    @PostMapping(value = "/selectOne")
    @ResponseBody
    public T selectOne(T entity) throws Exception {
        T result = getBaseService().selectOne(entity);
        return result;
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param   key  主键
     * @return  返回null为未查询到结果，返回对象为查询结果
     */
    @GetMapping(value = "/selectByPrimaryKey")
    @ResponseBody
    public T selectByPrimaryKey(@RequestParam(value = "key") Object key) throws Exception {
        T result = getBaseService().selectByPrimaryKey(key);
        return result;
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param   entity  对象实体
     * @return  返回查询结果数量
     */
    @PostMapping(value = "/selectCount")
    @ResponseBody
    public int selectCount(T entity) throws Exception {
        return getBaseService().selectCount(entity);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param   entity  对象实体
     * @return  返回null为未查询到结果，返回对象列表为查询结果
     */
    @PostMapping(value = "/findList")
    @ResponseBody
    public List<T> findList1(T entity) throws Exception {
        List<T> result = getBaseService().findList(entity);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号，分页返回
     * @param   entity    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  返回null为未查询到结果，返回对象列表为查询结果
     */
    @PostMapping(value = "/findList/{pageNum}/{pageSize}")
    @ResponseBody
    public List<T> findList2(T entity, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) throws Exception {
        List<T> result = getBaseService().findList(entity, pageNum, pageSize);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * 查询全部结果
     * @return  返回对象列表为查询结果
     */
    @GetMapping(value = "/findAllList")
    @ResponseBody
    public List<T> findAllList1() throws Exception {
        List<T> result = getBaseService().findAllList();
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * 查询全部结果分页返回
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  返回对象列表为查询结果
     */
    @GetMapping(value = "/findAllList/{pageNum}/{pageSize}")
    @ResponseBody
    public List<T> findAllList2(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) throws Exception {
        List<T> result = getBaseService().findAllList(pageNum, pageSize);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

}
