package com.lgc.ems.service.impl;


import com.lgc.ems.dao.EmpManagerDao;
import com.lgc.ems.dao.impl.EmpManagerDaoImpl;
import com.lgc.ems.entity.EmpManager;
import com.lgc.ems.service.EmpManagerService;
import com.lgc.ems.utils.DbUtils;

public class EmpManagerServiceImpl implements EmpManagerService {
    private EmpManagerDao empManagerDao = new EmpManagerDaoImpl();
    @Override
    public EmpManager login(String username, String password) {
        EmpManager empManager = null;
        try {
            DbUtils.begin();
            EmpManager temp = empManagerDao.select(username);
            if(temp != null){
                if(temp.getPassword().equals(password)){
                    empManager = temp;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return empManager;

    }
}
