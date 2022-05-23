package com.tu.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tu.demo.entity.Electricity;
import com.tu.demo.mapper.ElectricityDao;
import com.tu.demo.service.ElectricityService;
import org.springframework.stereotype.Service;

@Service
public class ElectricityServiceImpl extends ServiceImpl<ElectricityDao, Electricity> implements ElectricityService {
}
