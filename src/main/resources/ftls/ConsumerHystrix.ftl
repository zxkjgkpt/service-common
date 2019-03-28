package ${BasePackageName}${HystrixPackageName};

import ${BaseEntityPackageName}${ClassName}Entity;
import ${BasePackageName}${ServicePackageName}.${ClassName}Service;
import org.springframework.stereotype.Component;

/**
 * ${Description}Hystrix
 * Author ${Author}
 * Date  ${Date}
 */
@Component
public class ${ClassName}Hystrix extends BaseHystrix<${ClassName}Entity> implements ${ClassName}Service {

}
