package com.lgc.ems.service;

import com.lgc.ems.entity.EmpManager;

public interface EmpManagerService {
    public EmpManager login(String username, String password);
}
