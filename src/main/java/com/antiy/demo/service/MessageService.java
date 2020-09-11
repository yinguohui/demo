package com.antiy.demo.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.antiy.demo.entiy.Message;
import com.antiy.demo.dao.MessageMapper;
//@Service
public class MessageService{

    @Resource
    private MessageMapper messageMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return messageMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Message record) {
        return messageMapper.insert(record);
    }

    
    public int insertSelective(Message record) {
        return messageMapper.insertSelective(record);
    }

    
    public Message selectByPrimaryKey(Integer id) {
        return messageMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Message record) {
        return messageMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Message record) {
        return messageMapper.updateByPrimaryKey(record);
    }

}
