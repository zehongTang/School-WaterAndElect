package com.tu.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tu.demo.entity.Room;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomDao extends BaseMapper<Room> {
}
