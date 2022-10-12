package com.chowyijiu.boot.service.impl;

import com.chowyijiu.boot.bean.City;
import com.chowyijiu.boot.mapper.CityMapper;
import com.chowyijiu.boot.service.CityService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CityServiceImpl implements CityService {

    @Resource
    CityMapper cityMapper;

    Counter counter;


    public CityServiceImpl(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("cityService.saveCity.count");
    }

    @Override
    public City getCityById(Long id) {
        return cityMapper.getCityById(id);
    }

    @Override
    public void saveCity(City city) {
        counter.increment();
        cityMapper.insert(city);
    }
}
