package com.spring.task.springbucks.mapper;

import com.spring.task.springbucks.model.Coffee;
import org.apache.ibatis.annotations.*;
import org.joda.money.Money;

import java.util.List;

@Mapper
public interface CoffeeMapper {
    @Select("select * from t_coffee order by id")
    List<Coffee>findAllWithParam(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

    @Insert("insert into t_coffee (name, price, create_time, update_time)"
            + "values (#{name}, #{price}, now(), now())")
    @Options(useGeneratedKeys = true)
    int save(Coffee coffee);

    @Select("select * from t_coffee where id = #{id}")
//    @Results({
//            @Result(id = true, column = "id", property = "id"),
//            @Result(column = "create_time", property = "createTime"),
//            // map-underscore-to-camel-case = true 可以实现一样的效果
//            // @Result(column = "update_time", property = "updateTime"),
//    })
    Coffee findById(@Param("id") Long id);

    @Update("update t_coffee set price = #{price}  where id = #{id}")
    int updateById(@Param("id") Long id, Money price);

    @Delete("delete from t_coffee where id = #{id}")
    int deleteById(@Param("id") Long id);
}
