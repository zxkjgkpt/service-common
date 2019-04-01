package ${BasePackageName}${MapperPackageName};

import ${BaseEntityPackageName}${ClassName}Entity;
import ${BasePackageName}${SqlBuilderPackageName}.${ClassName}SqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * ${Description}Mapper
 * Author ${Author}
 * Date  ${Date}
 */
public interface ${ClassName}Mapper extends BaseMapper<${ClassName}Entity> {

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param   ${ClassName?uncap_first}    对象实体
     * @param   orders   排序字段
     * @return  对象列表
     */
    @SelectProvider(type = ${ClassName}SqlBuilder.class, method = "buildFind${ClassName}ByCondition")
    List<${ClassName}Entity> find${ClassName}ByCondition(@Param("${ClassName?uncap_first}") ${ClassName}Entity ${ClassName?uncap_first}, @Param("orders") String[] orders);

}
