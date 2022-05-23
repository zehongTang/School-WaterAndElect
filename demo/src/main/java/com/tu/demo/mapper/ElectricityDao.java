package com.tu.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tu.demo.entity.Electricity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ElectricityDao extends BaseMapper<Electricity> {
}
