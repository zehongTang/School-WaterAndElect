package com.paydemo1.demo.mapper;

import com.paydemo1.demo.pojo.Pocket;

import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface PocketMapper {
    //查询全部
    @Select("select * from pocket")
    List<Pocket> findAll();
    //新增数据
    @Insert(" insert into  pocket( room_ID,balance,recharge ) values (#{room_ID},#{balance},#{recharge}) ")
    void save(Pocket pocket);

    //删除数据
    @Delete(" delete from pocket where room_ID= #{room_ID} ")
    void delete(String room_ID);

    //根据id查找
    @Select("select room_ID,balance,recharge from pocket where room_ID= #{room_ID} ")
    Pocket get(String room_ID);

    //更新数据
    @Update("update pocket set balance=#{balance},recharge=#{recharge} where room_ID=#{room_ID} ")
    void update(Pocket pocket);

}
