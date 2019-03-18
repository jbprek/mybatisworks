package com.foo.db2.db2batis.model;


import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.LocalDateTimeTypeHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface AddressLogMapper {

    @Select("select * from addr_log")
    @Results(id="AddressLogMapping", value= {
            @Result(property = "name", column = "person_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "time", column = "tm",  jdbcType = JdbcType.TIMESTAMP,  typeHandler = LocalDateTimeTypeHandler.class),
            @Result(property = "line1", column = "line1", jdbcType = JdbcType.VARCHAR),
            @Result(property = "line2", column = "line2", jdbcType = JdbcType.VARCHAR),
            @Result(property = "zip", column = "zip", jdbcType = JdbcType.VARCHAR),
            @Result(property = "country", column = "country", jdbcType = JdbcType.VARCHAR),
    })
    List<AddressLog> findAll();


    @Select("select * from addr_log where person_name = #{name}")
    @ResultMap("AddressLogMapping")
    List<AddressLog> findByName(@Param("name") String name);


    @Options(statementType = StatementType.CALLABLE)
    @Select("{ CALL ff(#{name, mode=IN, javaType=java.lang.String, jdbcType=VARCHAR})}")
    @ResultMap("AddressLogMapping")
    List<AddressLog> findLastUpdateByName(@Param("name") String name);
}
