package com.tu.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tu.demo.entity.VO.RallVo;
import com.tu.demo.entity.Water;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WaterDao extends BaseMapper<Water> {
    RallVo getRall(String date);
}
