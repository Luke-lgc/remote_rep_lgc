package com.lgc.ems.service.impl;

import com.lgc.ems.dao.EmpDao;
import com.lgc.ems.dao.impl.EmpDaoImpl;
import com.lgc.ems.entity.Emp;
import com.lgc.ems.entity.Page;
import com.lgc.ems.service.EmpService;
import com.lgc.ems.utils.DbUtils;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao =new EmpDaoImpl();

    @Override
    public int addEmp(Emp emp) {
        int result = 0;
        try {
            DbUtils.begin();
            result = empDao.insert(emp);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modifyEmp(Emp emp) {
        int result = 0;
        try {
            DbUtils.begin();
            result = empDao.update(emp);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int removeEmp(int id) {
        int result = 0;
        try {
            DbUtils.begin();
            result = empDao.delete(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Emp selectEmpById(int id) {
        Emp emp = null;
        try {
            DbUtils.begin();
            emp = empDao.select(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public List<Emp> showAllEmp() {
        List<Emp> empList = null;
        try {
            DbUtils.begin();
            List<Emp> temp = empDao.selectAll();
            if(temp != null){
                empList = temp;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return empList;
    }

    @Override
    public List<Emp> showAllEmpByPage(Page page) {
        List<Emp> empList = null;
        try {
            DbUtils.begin();
            long count = empDao.selectCount();
            page.setTotalCounts((int)count);//赋值总条数，计算总页数
            empList = empDao.selectAll(page);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return empList;
    }
}
