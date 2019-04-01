package ${BasePackageName}${ServicePackageName};

import ${BaseEntityPackageName}${ClassName}Entity;
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

}
