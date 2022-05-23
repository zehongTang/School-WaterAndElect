package com.paydemo1.demo.service.serviceImpl;

import com.paydemo1.demo.mapper.PocketMapper;
import com.paydemo1.demo.pojo.Pocket;
import com.paydemo1.demo.service.PocketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PocketServiceImpl implements PocketService{
    @Resource
    private PocketMapper pocketMapper;

    @Override
    public List<Pocket> findAll() {
        return pocketMapper.findAll();
    }

    @Override
    public void save(Pocket pocket) {
        pocketMapper.save(pocket);
    }

    @Override
    public void delete(String room_ID) {
        pocketMapper.delete(room_ID);
    }

    @Override
    public Pocket get(String room_ID) {
        return pocketMapper.get(room_ID);
    }

    @Override
    public void update(Pocket pocket) {
        pocketMapper.update(pocket);
    }
}
