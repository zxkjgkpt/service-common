package ${BasePackageName}${EntityPackageName};

import ${BasePackageName}base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * ${Description}Entity
 * Author ${Author}
 * Date  ${Date}
 */
@Table(name = "${TableName}")
public class ${ClassName}Entity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    <#list ColumnInfoList as ColumnInfo>
        <#if ColumnInfo.primaryKey>
    @Id
        </#if>
    @Column(name = "${ColumnInfo.columnName}")
    private ${ColumnInfo.typeName} ${ColumnInfo.propertyName};

    </#list>

    public ${ClassName}Entity(){
    }

    <#list ColumnInfoList as ColumnInfo>
    public ${ColumnInfo.typeName} get${ColumnInfo.propertyName?cap_first}() {
        return ${ColumnInfo.propertyName};
    }

    public void set${ColumnInfo.propertyName?cap_first}(${ColumnInfo.typeName} ${ColumnInfo.propertyName}) {
        this.${ColumnInfo.propertyName} = ${ColumnInfo.propertyName};
    }

    </#list>
}
