package ${BasePackageName}${ControllerPackageName};

import com.yfny.utilscommon.util.InvokeResult;
import ${BasePackageName}${ServicePackageName}.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 消费者通用Controller
 * Author ${Author}
 * Date  ${Date}
 */
public class BaseController<T> {

    @Autowired
    private BaseService<T> baseService;

    public BaseService<T> getBaseService() {
        return this.baseService;
    }

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @PostMapping(value = "/insert")
    @ResponseBody
    public InvokeResult insert(@RequestBody T entity) throws Exception {
        int result = getBaseService().insert(entity);
        if (result == 1) {
            return InvokeResult.success("20001", result);
        }else if (result == -1) {
            return InvokeResult.failure("10003", "网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure("20002");
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @PostMapping(value = "/insertSelective")
    @ResponseBody
    public InvokeResult insertSelective(@RequestBody T entity) throws Exception {
        int result = getBaseService().insertSelective(entity);
        if (result == 1) {
            return InvokeResult.success("20001", result);
        }else if (result == -1) {
            return InvokeResult.failure("10003", "网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure("20002");
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public InvokeResult update(@RequestBody T entity) throws Exception {
        int result = getBaseService().update(entity);
        if (result == 1) {
            return InvokeResult.success("20001", result);
        }else if (result == -1) {
            return InvokeResult.failure("10003", "网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure("20002");
    }

    /**
     * 根据主键更新属性不为null的值
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @PostMapping(value = "/updateSelective")
    @ResponseBody
    public InvokeResult updateSelective(@RequestBody T entity) throws Exception {
        int result = getBaseService().updateSelective(entity);
        if (result == 1) {
            return InvokeResult.success("20001", result);
        }else if (result == -1) {
            return InvokeResult.failure("10003", "网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure("20002");
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @param   entity  对象实体
     * @return  返回0为失败，返回1为成功
     */
    @PostMapping(value = "/delete")
    @ResponseBody
    public InvokeResult delete(@RequestBody T entity) throws Exception {
        int result = getBaseService().delete(entity);
        if (result == 1) {
            return InvokeResult.success("20003", result);
        }else if (result == -1) {
            return InvokeResult.failure("10003", "网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure("20004");
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param   key  主键
     * @return  返回0为失败，返回1为成功
     */
    @PostMapping(value = "/deleteByPrimaryKey")
    @ResponseBody
    public InvokeResult deleteByPrimaryKey(@RequestParam(value = "key") Object key) throws Exception {
        int result = getBaseService().deleteByPrimaryKey(key);
        if (result == 1) {
            return InvokeResult.success("20003", result);
        }else if (result == -1) {
            return InvokeResult.failure("10003", "网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure("20004");
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param   entity  对象实体
     * @return  返回null为未查询到结果，返回对象为查询结果，返回多个结果则抛出异常
     */
    @PostMapping(value = "/selectOne")
    @ResponseBody
    public InvokeResult selectOne(@RequestBody T entity) throws Exception {
        T result = getBaseService().selectOne(entity);
        if (result != null) {
            return InvokeResult.success(result);
        }else if (result == null) {
            return InvokeResult.failure("10003", "网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure();
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param   key  主键
     * @return  返回null为未查询到结果，返回对象为查询结果
     */
    @GetMapping(value = "/selectByPrimaryKey")
    @ResponseBody
    public InvokeResult selectByPrimaryKey(@RequestParam(value = "key") Object key) throws Exception {
        T result = getBaseService().selectByPrimaryKey(key);
        if (result != null) {
            return InvokeResult.success(result);
        }else if (result == null) {
            return InvokeResult.failure("10003", "数据不存在或网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure();
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param   entity  对象实体
     * @return  返回查询结果数量
     */
    @PostMapping(value = "/selectCount")
    @ResponseBody
    public InvokeResult selectCount(@RequestBody T entity) throws Exception {
        int result = getBaseService().selectCount(entity);
        if (result >= 0) {
            return InvokeResult.success("20003", result);
        }else if (result == -1) {
            return InvokeResult.failure("10003", "网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure("20004");
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param   entity  对象实体
     * @return  返回null为未查询到结果，返回对象列表为查询结果
     */
    @PostMapping(value = "/findList")
    @ResponseBody
    public InvokeResult findList1(@RequestBody T entity) throws Exception {
        List<T> result = getBaseService().findList(entity);
        if (result != null) {
            return InvokeResult.success(result);
        }else if (result == null) {
            return InvokeResult.failure("10003", "网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure();
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
    public InvokeResult findList2(@RequestBody T entity, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) throws Exception {
        List<T> result = getBaseService().findList(entity, pageNum, pageSize);
        if (result != null) {
            return InvokeResult.success(result);
        }else if (result == null) {
            return InvokeResult.failure("10003", "网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure();
    }

    /**
     * 查询全部结果
     * @return  返回对象列表为查询结果
     */
    @GetMapping(value = "/findAllList")
    @ResponseBody
    public InvokeResult findAllList1() throws Exception {
        List<T> result = getBaseService().findAllList();
        if (result != null) {
            return InvokeResult.success(result);
        }else if (result == null) {
            return InvokeResult.failure("10003", "网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure();
    }

    /**
     * 查询全部结果分页返回
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  返回对象列表为查询结果
     */
    @GetMapping(value = "/findAllList/{pageNum}/{pageSize}")
    @ResponseBody
    public InvokeResult findAllList2(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) throws Exception {
        List<T> result = getBaseService().findAllList(pageNum, pageSize);
        if (result != null) {
            return InvokeResult.success(result);
        }else if (result == null) {
            return InvokeResult.failure("10003", "网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure();
    }

}
