package com.tu.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tu.demo.entity.VO.RallVo;
import com.tu.demo.entity.Water;
import com.tu.demo.mapper.WaterDao;
import com.tu.demo.service.WaterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WaterServiceImpl extends ServiceImpl<WaterDao, Water> implements WaterService {
    @Resource
    private WaterDao waterDao;
    @Override
    public RallVo getRall(String date) {
        return waterDao.getRall(date);
    }
}
