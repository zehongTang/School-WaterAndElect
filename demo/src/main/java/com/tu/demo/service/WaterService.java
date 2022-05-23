package com.tu.demo.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tu.demo.entity.VO.RallVo;
import com.tu.demo.entity.Water;


import java.util.List;

public interface WaterService extends IService<Water>{
    RallVo getRall(String date);
}
