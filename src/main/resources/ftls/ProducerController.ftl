package ${BasePackageName}${ControllerPackageName};

import ${BaseEntityPackageName}${ClassName}Entity;
import com.yfny.servicedemandform.service.BaseServiceImpl;
import ${BasePackageName}${ServicePackageName}.${ClassName}ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* ${Description}Controller
* Author ${Author}
* Date  ${Date}
*/
@RestController
@RequestMapping(value = "/${EntityName}")
public class ${ClassName}Controller extends BaseController<${ClassName}Entity> {

    @Autowired
    private ${ClassName}ServiceImpl ${EntityName}Service;

    @Override
    public BaseServiceImpl<${ClassName}Entity> getBaseService() {
        return this.${EntityName}Service;
    }

}
