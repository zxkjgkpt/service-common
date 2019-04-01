package ${BasePackageName}${ControllerPackageName};

import ${BaseEntityPackageName}${ClassName}Entity;
import ${BasePackageName}${ServicePackageName}.BaseService;
import ${BasePackageName}${ServicePackageName}.${ClassName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
