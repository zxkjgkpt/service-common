package ${BasePackageName}${ControllerPackageName};

import ${BaseEntityPackageName}${ClassName}Entity;
import ${BasePackageName}${ServicePackageName}.BaseService;
import ${BasePackageName}${ServicePackageName}.${ClassName}Service;
import com.yfny.utilscommon.util.InvokeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ${Description}Controller
 * Author ${Author}
 * Date  ${Date}
 */
@RestController
@RequestMapping(value = "/${ClassName?uncap_first}")
public class ${ClassName}Controller extends BaseController<${ClassName}Entity> {

    @Autowired
    private ${ClassName}Service ${ClassName?uncap_first}Service;

    @Override
    public BaseService<${ClassName}Entity> getBaseService() {
        return this.${ClassName?uncap_first}Service;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param   ${ClassName?uncap_first}    对象实体
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/find${ClassName}ByCondition")
    @ResponseBody
    public InvokeResult find${ClassName}ByCondition1(${ClassName}Entity ${ClassName?uncap_first}) throws Exception {
        List<${ClassName}Entity> result = ${ClassName?uncap_first}Service.find${ClassName}ByCondition(${ClassName?uncap_first});
        if (result != null) {
            return InvokeResult.success(result);
        }else if (result == null) {
            return InvokeResult.failure("10003", "网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure();
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号，分页返回
     * @param   ${ClassName?uncap_first}    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/find${ClassName}ByCondition/{pageNum}/{pageSize}")
    @ResponseBody
    public InvokeResult find${ClassName}ByCondition2(${ClassName}Entity ${ClassName?uncap_first},
                @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) throws Exception {
        List<${ClassName}Entity> result = ${ClassName?uncap_first}Service.find${ClassName}ByCondition(${ClassName?uncap_first}, pageNum, pageSize);
        if (result != null) {
            return InvokeResult.success(result);
        }else if (result == null) {
            return InvokeResult.failure("10003", "网络请求超时或服务器崩溃");
        }
        return InvokeResult.failure();
    }

}
