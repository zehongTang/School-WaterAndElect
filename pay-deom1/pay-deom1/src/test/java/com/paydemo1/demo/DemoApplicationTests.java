package com.paydemo1.demo;

import com.paydemo1.demo.pojo.Pocket;
import com.paydemo1.demo.service.PocketService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Resource
    private PocketService pocketService;

    //删除钱包用户
    @Test
    public void delete() {
        pocketService.delete("1");
    }
    //根据id查询钱包用户
    @Test
    public void get(){
        System.out.println(pocketService.get("2").toString());
    }
    //查询整个表
    @Test
    public void userList(){
        List<Pocket> pocket = pocketService.findAll();
        System.out.println(pocket.toString());
    }
    //增加钱包用户
    @Test
    public void save(){
        Pocket pocket = new Pocket("8","8","8") ;
        pocketService.save(pocket);
        List<Pocket> pocket1 = pocketService.findAll();
        System.out.println(pocket1.toString());
    }

//    根据id修改
    @Test
    public void update(){
        String room_ID =pocketService.get("2").getRoom_ID();
        String balance =pocketService.get("2").getBalance();
        String recharge =pocketService.get("2").getRecharge();
        double balance1 = Double.parseDouble(balance)+Double.parseDouble((recharge));
        String balance2 = ""+balance1;
        Pocket pocket = new Pocket(room_ID,balance2,recharge);
        pocketService.update(pocket);
        System.out.println(pocketService.get(room_ID).toString());

    }
}
