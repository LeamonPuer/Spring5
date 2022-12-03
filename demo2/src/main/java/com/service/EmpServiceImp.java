package com.service;

import com.mapper.EmpMapper;
import com.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-11-24-15:28
 */
@Service
public class EmpServiceImp implements EmpService{
    @Autowired
    EmpMapper empMapper;
    @Override
    public List<Emp> getAll() {
        return empMapper.selectByExample(null);
    }

    @Override
    public int deleteById(int id) {
        return empMapper.deleteByPrimaryKey(id);
    }
}
