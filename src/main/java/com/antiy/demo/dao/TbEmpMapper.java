package com.antiy.demo.dao;

import com.antiy.demo.entiy.TbEmp;

public interface TbEmpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbEmp record);

    int insertSelective(TbEmp record);

    TbEmp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbEmp record);

    int updateByPrimaryKey(TbEmp record);
}