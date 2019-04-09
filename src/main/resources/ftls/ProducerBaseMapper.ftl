package ${BasePackageName}${MapperPackageName};

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 微服务通用Mapper
 * Author ${Author}
 * Date  ${Date}
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface BaseMapper<T> extends tk.mybatis.mapper.common.BaseMapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T>, ExampleMapper<T> {

}
