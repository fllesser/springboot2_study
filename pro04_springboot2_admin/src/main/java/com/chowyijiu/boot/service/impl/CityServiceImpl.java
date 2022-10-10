package com.chowyijiu.boot.service.impl;

import com.chowyijiu.boot.bean.City;
import com.chowyijiu.boot.mapper.CityMapper;
import com.chowyijiu.boot.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CityServiceImpl implements CityService {

    @Resource
    CityMapper cityMapper;

    @Override
    public City getCityById(Long id) {
        return cityMapper.getCityById(id);
    }

    @Override
    public void saveCity(City city) {
        cityMapper.insert(city);
    }
}
