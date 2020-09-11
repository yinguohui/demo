package com.antiy.demo.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.antiy.demo.dao.TbDeptMapper;
import com.antiy.demo.entiy.TbDept;
//@Service
public class TbDeptService{

    @Resource
    private TbDeptMapper tbDeptMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return tbDeptMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(TbDept record) {
        return tbDeptMapper.insert(record);
    }

    
    public int insertSelective(TbDept record) {
        return tbDeptMapper.insertSelective(record);
    }

    
    public TbDept selectByPrimaryKey(Integer id) {
        return tbDeptMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(TbDept record) {
        return tbDeptMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(TbDept record) {
        return tbDeptMapper.updateByPrimaryKey(record);
    }

}
