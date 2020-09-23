package com.lgc.ems.dao;

import com.lgc.ems.entity.Emp;
import com.lgc.ems.entity.Page;
import java.util.List;

public interface EmpDao {
    public int insert(Emp emp);
    public int update(Emp emp);
    public int delete(int id);
    public Emp select(int id);
    public List<Emp> selectAll();
    public List<Emp> selectAll(Page page);//用于分页查询,两个参数pageIndex 起始位置，pageSize查询条数
    public long selectCount();  //查询总行数，员工总数量

}
