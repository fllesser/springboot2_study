package com.chowyijiu.boot.service;

import com.chowyijiu.boot.bean.City;

public interface CityService {

    City getCityById(Long id);

    void saveCity(City city);
}
