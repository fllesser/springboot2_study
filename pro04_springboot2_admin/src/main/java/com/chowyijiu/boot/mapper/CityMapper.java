package com.chowyijiu.boot.mapper;

import com.chowyijiu.boot.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("SELECT * FROM city WHERE id=#{id}")
    City getCityById(Long id);

    @Insert("INSERT INTO city(name, state, country) VALUE (#{name}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(City city);
}
