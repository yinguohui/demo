package com.antiy.demo.controller;

import com.antiy.demo.other.ZkApi;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/4
 */
@Controller
public class ZooKeeperController {
   @Autowired
    private ZkApi zkApi;


    @RequestMapping("/create")
    @ResponseBody
    private boolean isExist(String path){
        boolean b =zkApi.createNode(path,null);
        return b;
    }
}
