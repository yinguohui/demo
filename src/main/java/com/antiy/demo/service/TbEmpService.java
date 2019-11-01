package com.antiy.demo.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.antiy.demo.entiy.TbEmp;
import com.antiy.demo.dao.TbEmpMapper;
@Service
public class TbEmpService{

    @Resource
    private TbEmpMapper tbEmpMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return tbEmpMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(TbEmp record) {
        return tbEmpMapper.insert(record);
    }

    
    public int insertSelective(TbEmp record) {
        return tbEmpMapper.insertSelective(record);
    }

    
    public TbEmp selectByPrimaryKey(Integer id) {
        return tbEmpMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(TbEmp record) {
        return tbEmpMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(TbEmp record) {
        return tbEmpMapper.updateByPrimaryKey(record);
    }

}
