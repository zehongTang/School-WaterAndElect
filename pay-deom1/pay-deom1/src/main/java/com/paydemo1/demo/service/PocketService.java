package com.paydemo1.demo.service;


import com.paydemo1.demo.pojo.Pocket;

import java.util.List;

public interface PocketService  {


    List<Pocket> findAll();


    void save(Pocket pocket) ;


    void delete(String room_ID);

    Pocket get(String room_ID) ;

    void update(Pocket pocket);
}
