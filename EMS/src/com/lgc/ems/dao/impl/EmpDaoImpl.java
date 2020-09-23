package com.lgc.ems.dao.impl;


import com.lgc.ems.dao.EmpDao;
import com.lgc.ems.entity.Emp;
import com.lgc.ems.entity.Page;
import com.lgc.ems.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public int insert(Emp emp) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(),"insert into emp(name,salary,age) values(?,?,?)",emp.getName(),emp.getSalary(),emp.getAge());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Emp emp) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(),"update emp set name=?,salary=?,age=? where id=?;",emp.getName(),emp.getSalary(),emp.getAge(),emp.getId());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(),"delete from emp where id=?;",id);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Emp select(int id) {
        try {
            Emp emp = queryRunner.query(DbUtils.getConnection(),"select * from emp where id=?;",new BeanHandler<Emp>(Emp.class),id);
            return emp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Emp> selectAll() {
        try {
            List<Emp> empList = queryRunner.query(DbUtils.getConnection(),"select * from emp;",new BeanListHandler<Emp>(Emp.class));
            return empList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Emp> selectAll(Page page) {
        try {
            List<Emp> empList = queryRunner.query(DbUtils.getConnection(),"select * from emp limit ?,?;",new BeanListHandler<Emp>(Emp.class),page.getStartRows(),page.getPageSize());
            return empList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long selectCount() {
        try {
            long count = queryRunner.query(DbUtils.getConnection(),"select count(*) from emp;",new ScalarHandler<>());
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
