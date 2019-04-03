package ${BasePackageName}${ServicePackageName};

import ${BaseEntityPackageName}${EntityPackageName}.${ClassName}Entity;
import ${BasePackageName}${HystricPackageName}.${ClassName}Hystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ${Description}Service
 * Author ${Author}
 * Date  ${Date}
 */
@FeignClient(value = "${ApplicationName}", path = "/${ClassName?uncap_first}", fallback = ${ClassName}Hystrix.class)
public interface ${ClassName}Service extends BaseService<${ClassName}Entity> {

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   ${ClassName?uncap_first}    对象实体
     * @return  对象列表
     */
    @PostMapping(value = "/find${ClassName}ByAndCondition")
    List<${ClassName}Entity> find${ClassName}ByAndCondition(@RequestBody ${ClassName}Entity ${ClassName?uncap_first});

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集，分页返回
     *
     * @param   ${ClassName?uncap_first}    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  对象列表
     */
    @PostMapping(value = "/find${ClassName}ByAndCondition/{pageNum}/{pageSize}")
    List<${ClassName}Entity> find${ClassName}ByAndCondition(@RequestBody ${ClassName}Entity ${ClassName?uncap_first}, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize);

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   ${ClassName?uncap_first}    对象实体
     * @return  对象列表
     */
    @PostMapping(value = "/find${ClassName}ByORCondition")
    List<${ClassName}Entity> find${ClassName}ByORCondition(@RequestBody ${ClassName}Entity ${ClassName?uncap_first});

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集，分页返回
     *
     * @param   ${ClassName?uncap_first}    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  对象列表
     */
    @PostMapping(value = "/find${ClassName}ByORCondition/{pageNum}/{pageSize}")
    List<${ClassName}Entity> find${ClassName}ByORCondition(@RequestBody ${ClassName}Entity ${ClassName?uncap_first}, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize);

}
