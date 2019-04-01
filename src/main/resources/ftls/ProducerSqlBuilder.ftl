package ${BasePackageName}${SqlBuilderPackageName};

import ${BaseEntityPackageName}${ClassName}Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * ${Description}SqlBuilder
 * Author ${Author}
 * Date  ${Date}
 */
public class ${ClassName}SqlBuilder {

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param   ${ClassName?uncap_first}    对象实体
     * @param   orders   排序字段
     * @return  Sql语句
     */
    public String buildFind${ClassName}ByCondition(final ${ClassName}Entity ${ClassName?uncap_first}, final String[] orders) {
        return new SQL(){{
            SELECT("*");
            FROM("${TableName}");
        <#list ColumnInfoList as ColumnInfo>
            <#if ColumnInfo.typeName == "String">
            if (${ClassName?uncap_first}.get${ColumnInfo.propertyName?cap_first}() != null && !${ClassName?uncap_first}.get${ColumnInfo.propertyName?cap_first}().equals("")) {
                WHERE("${ColumnInfo.columnName} like <#noparse>#{</#noparse>${ClassName?uncap_first}.${ColumnInfo.propertyName}<#noparse>}</#noparse> || '%'");
            }
            <#else>
            if (${ClassName?uncap_first}.get${ColumnInfo.propertyName?cap_first}() != null) {
                WHERE("${ColumnInfo.columnName} like <#noparse>#{</#noparse>${ClassName?uncap_first}.${ColumnInfo.propertyName}<#noparse>}</#noparse> || '%'");
            }
            </#if>
        </#list>
            if (orders != null && orders.length > 0) {
                ORDER_BY(orders);
            }
        }}.toString();
    }
}
