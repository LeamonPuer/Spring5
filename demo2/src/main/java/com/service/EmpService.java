package com.service;

import com.pojo.Emp;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-11-24-15:27
 */
public interface EmpService {
    //查询所有员工
    List<Emp> getAll();
    //删除员工
    int deleteById(int id);
}
