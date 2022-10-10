package com.chowyijiu.boot.service;

import com.chowyijiu.boot.bean.City;
import com.chowyijiu.boot.mapper.CityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CityService {

    @Resource
    CityMapper cityMapper;

    public City getCityById(Long id) {
        return cityMapper.getCityById(id);
    }

    public void saveCity(City city) {
        cityMapper.insert(city);
    }
}
