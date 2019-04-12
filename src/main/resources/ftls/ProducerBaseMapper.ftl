package ${BasePackageName}${MapperPackageName};

import tk.mybatis.mapper.common.*;

/**
 * 微服务通用Mapper
 * Author ${Author}
 * Date  ${Date}
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T> {

}
