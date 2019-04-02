package ${BasePackageName}${ControllerPackageName};

import ${BaseEntityPackageName}${EntityPackageName}.${ClassName}Entity;
import ${BasePackageName}${ServicePackageName}.BaseServiceImpl;
import ${BasePackageName}${ServicePackageName}.${ClassName}ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private ${ClassName}ServiceImpl ${ClassName?uncap_first}Service;

    @Override
    public BaseServiceImpl<${ClassName}Entity> getBaseService() {
        return this.${ClassName?uncap_first}Service;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param   ${ClassName?uncap_first}    对象实体
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/find${ClassName}ByCondition")
    @ResponseBody
    public List<${ClassName}Entity> find${ClassName}ByCondition1(@RequestBody ${ClassName}Entity ${ClassName?uncap_first}) throws Exception {
        List<${ClassName}Entity> result = ${ClassName?uncap_first}Service.find${ClassName}ByCondition(${ClassName?uncap_first});
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号，分页返回
     *
     * @param   ${ClassName?uncap_first}    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/find${ClassName}ByCondition/{pageNum}/{pageSize}")
    @ResponseBody
    public List<${ClassName}Entity> find${ClassName}ByCondition2(@RequestBody ${ClassName}Entity ${ClassName?uncap_first},
                @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) throws Exception {
        List<${ClassName}Entity> result = ${ClassName?uncap_first}Service.find${ClassName}ByCondition(${ClassName?uncap_first}, pageNum, pageSize);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

}
