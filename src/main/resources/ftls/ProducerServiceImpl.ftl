package ${BasePackageName}${ServicePackageName};

import ${BaseEntityPackageName}${EntityPackageName}.${ClassName}Entity;
import ${BasePackageName}${MapperPackageName}.BaseMapper;
import ${BasePackageName}${MapperPackageName}.${ClassName}Mapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${Description}ServiceImpl
 * Author ${Author}
 * Date  ${Date}
 */
@Service
public class ${ClassName}ServiceImpl extends BaseServiceImpl<${ClassName}Entity> {

    @Autowired
    private ${ClassName}Mapper ${ClassName?uncap_first}Mapper;

    @Override
    public BaseMapper<${ClassName}Entity> getBaseMapper() {
        return this.${ClassName?uncap_first}Mapper;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   ${ClassName?uncap_first}    对象实体
     * @return  返回对象列表为查询结果
     */
    public List<${ClassName}Entity> find${ClassName}ByAndCondition(${ClassName}Entity ${ClassName?uncap_first}) {
        return ${ClassName?uncap_first}Mapper.find${ClassName}ByAndCondition(${ClassName?uncap_first});
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集，分页返回
     *
     * @param   ${ClassName?uncap_first}    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  对象列表
     */
    public List<${ClassName}Entity> find${ClassName}ByAndCondition(${ClassName}Entity ${ClassName?uncap_first}, int pageNum, int pageSize) {
        Page<${ClassName}Entity> resultPage = PageHelper.startPage(pageNum, pageSize);
        List<${ClassName}Entity> resultList = ${ClassName?uncap_first}Mapper.find${ClassName}ByAndCondition(${ClassName?uncap_first});
        setResultPage(resultPage, resultList);
        return resultList;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   ${ClassName?uncap_first}    对象实体
     * @return  返回对象列表为查询结果
     */
    public List<${ClassName}Entity> find${ClassName}ByORCondition(${ClassName}Entity ${ClassName?uncap_first}) {
        return ${ClassName?uncap_first}Mapper.find${ClassName}ByORCondition(${ClassName?uncap_first});
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集，分页返回
     *
     * @param   ${ClassName?uncap_first}    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  对象列表
     */
    public List<${ClassName}Entity> find${ClassName}ByORCondition(${ClassName}Entity ${ClassName?uncap_first}, int pageNum, int pageSize) {
        Page<${ClassName}Entity> resultPage = PageHelper.startPage(pageNum, pageSize);
        List<${ClassName}Entity> resultList = ${ClassName?uncap_first}Mapper.find${ClassName}ByORCondition(${ClassName?uncap_first});
        setResultPage(resultPage, resultList);
        return resultList;
    }

}
