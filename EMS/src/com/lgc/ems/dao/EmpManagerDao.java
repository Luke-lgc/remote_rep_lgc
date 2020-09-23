package com.lgc.ems.dao;

import com.lgc.ems.entity.EmpManager;

public interface EmpManagerDao {
    public EmpManager select(String username);
}
