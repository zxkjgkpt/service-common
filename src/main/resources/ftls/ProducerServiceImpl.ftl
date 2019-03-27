package ${BasePackageName}${ServicePackageName};

import ${BaseEntityPackageName}${ClassName}Entity;
import ${BasePackageName}${MapperPackageName}.${ClassName}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.BaseMapper;

/**
* ${Description}ServiceImpl
* Author ${Author}
* Date  ${Date}
*/
@Service
public class ${ClassName}ServiceImpl extends BaseServiceImpl<${ClassName}Entity> {

    @Autowired
    private ${ClassName}Mapper ${EntityName}Mapper;

    @Override
    public BaseMapper<${ClassName}Entity> getBaseMapper() {
        return this.${EntityName}Mapper;
    }

}
