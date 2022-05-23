package com.tu.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tu.demo.entity.Room;
import com.tu.demo.mapper.RoomDao;
import com.tu.demo.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl extends ServiceImpl<RoomDao, Room> implements RoomService {
}
