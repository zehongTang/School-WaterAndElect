package com.tu.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tu.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao extends BaseMapper<Student> {
}
