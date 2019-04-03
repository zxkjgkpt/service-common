package ${BasePackageName}${HystrixPackageName};

import ${BaseEntityPackageName}${EntityPackageName}.${ClassName}Entity;
import ${BasePackageName}${ServicePackageName}.${ClassName}Service;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ${Description}Hystrix
 * Author ${Author}
 * Date  ${Date}
 */
@Component
public class ${ClassName}Hystrix extends BaseHystrix<${ClassName}Entity> implements ${ClassName}Service {

    @Override
    public List<${ClassName}Entity> find${ClassName}ByAndCondition(${ClassName}Entity ${ClassName?uncap_first}) {
        return null;
    }

    @Override
    public List<${ClassName}Entity> find${ClassName}ByAndCondition(${ClassName}Entity ${ClassName?uncap_first}, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public List<${ClassName}Entity> find${ClassName}ByORCondition(${ClassName}Entity ${ClassName?uncap_first}) {
        return null;
    }

    @Override
    public List<${ClassName}Entity> find${ClassName}ByORCondition(${ClassName}Entity ${ClassName?uncap_first}, int pageNum, int pageSize) {
        return null;
    }

}
