package com.lgc.ems.service;

import com.lgc.ems.entity.Emp;
import com.lgc.ems.entity.Page;
import java.util.List;

public interface EmpService {
    public int addEmp(Emp emp);
    public int modifyEmp(Emp emp);
    public int removeEmp(int id);
    public Emp selectEmpById(int id);
    public List<Emp> showAllEmp();
    public List<Emp> showAllEmpByPage(Page page);
}
