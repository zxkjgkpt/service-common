<#if ClassType == "VICE">
    <#if RelationType == "ONE2ONE">
    /**
     * 根据外键查询相应对象（一对一关系）
     *
     * @param   ${ForeignKeyPropertyName}    外键
     * @return  返回对象列表为查询结果
     */
    @Select("select * from ${ClassName?uncap_first} where ${ForeignKeyColumnName} = <#noparse>#{</#noparse>${ForeignKeyPropertyName}<#noparse>}</#noparse>")
    ${ClassName}Entity find${ClassName}By${ForeignKeyPropertyName?cap_first}(String ${ForeignKeyPropertyName});

    <#elseif RelationType == "ONE2MANY">
    /**
     * 根据外键查询相应对象（一对多关系）
     *
     * @param   ${ForeignKeyPropertyName}    外键
     * @return  返回对象列表为查询结果
     */
    @Select("select * from ${ClassName?uncap_first} where ${ForeignKeyColumnName} = <#noparse>#{</#noparse>${ForeignKeyPropertyName}<#noparse>}</#noparse>")
    List<${ClassName}Entity> find${ClassName}By${ForeignKeyPropertyName?cap_first}(String ${ForeignKeyPropertyName});

    </#if>
<#elseif ClassType == "MAIN">

</#if>
