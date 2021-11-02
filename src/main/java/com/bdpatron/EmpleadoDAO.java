package com.bdpatron;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements DAO <Empleado> {
    
    @Override
    public Empleado get (long id, Connection con) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM EMP where empno = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Empleado emp = new Empleado();
                emp.setEmpno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));
                emp.setHiredate(LocalDate.parse(rs.getString(5)));
                emp.setSal(rs.getFloat(6));
                emp.setComm(rs.getFloat(7));
                emp.setDeptno(rs.getInt(8));
                return emp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Empleado();
    }

    @Override
    public List <Empleado> getAll (Connection conn) {
        List <Empleado> lista = null;
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery("SELECT * FROM EMP;");
            int totalRows = 0;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            lista = new ArrayList<Empleado>(totalRows);
            while(rs.next()) {
                Empleado emp = new Empleado();
                emp.setEmpno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));
                emp.setHiredate(LocalDate.parse(rs.getString(5)));
                emp.setSal(rs.getFloat(6));
                emp.setComm(rs.getFloat(7));
                emp.setDeptno(rs.getInt(8));
                lista.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List <Empleado> getByDept (long deptno, Connection con) {
        List <Empleado> lista = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM EMP where deptno = ? order by empno asc;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setLong(1, deptno);
            ResultSet rs = ps.executeQuery();
            int totalRows = 0;
            rs.last();
            totalRows = rs.getRow();
            rs.afterLast();
            lista = new ArrayList <Empleado> (totalRows);
            while(rs.previous()) {
                Empleado emp = new Empleado();
                emp.setEmpno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));
                emp.setHiredate(LocalDate.parse(rs.getString(5)));
                emp.setSal(rs.getFloat(6));
                emp.setComm(rs.getFloat(7));
                emp.setDeptno(rs.getInt(8));
                lista.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List <Empleado> getByDate (LocalDate date, Connection con) {
        List <Empleado> lista = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM EMP where hiredate = ?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, date.toString());
            ResultSet rs = ps.executeQuery();
            int totalRows = 0;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            lista = new ArrayList <Empleado> (totalRows);
            while(rs.next()) {
                Empleado emp = new Empleado();
                emp.setEmpno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));
                emp.setHiredate(LocalDate.parse(rs.getString(5)));
                emp.setSal(rs.getFloat(6));
                emp.setComm(rs.getFloat(7));
                emp.setDeptno(rs.getInt(8));
                lista.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List <Empleado> getByJob (String job, Connection con) {
        List <Empleado> lista = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM EMP where job = ?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, job);
            ResultSet rs = ps.executeQuery();
            int totalRows = 0;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            lista = new ArrayList <Empleado> (totalRows);
            while(rs.next()) {
                Empleado emp = new Empleado();
                emp.setEmpno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));
                emp.setHiredate(LocalDate.parse(rs.getString(5)));
                emp.setSal(rs.getFloat(6));
                emp.setComm(rs.getFloat(7));
                emp.setDeptno(rs.getInt(8));
                lista.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List <Empleado> getBySalDept (Float sal, int dept, Connection con) {
        List <Empleado> lista = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM EMP where sal = ? and deptno = ?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setFloat(1, sal);
            ps.setInt(2, dept);
            ResultSet rs = ps.executeQuery();
            int totalRows = 0;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            lista = new ArrayList <Empleado> (totalRows);
            while(rs.next()) {
                Empleado emp = new Empleado();
                emp.setEmpno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));
                emp.setHiredate(LocalDate.parse(rs.getString(5)));
                emp.setSal(rs.getFloat(6));
                emp.setComm(rs.getFloat(7));
                emp.setDeptno(rs.getInt(8));
                lista.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List <Empleado> getAllToLowerCase (Connection conn) {
        List <Empleado> lista = null;
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = s.executeQuery("SELECT * FROM EMP;");
            rs.beforeFirst();
            while (rs.next()) {
                rs.updateString("ENAME", rs.getString(2).toLowerCase());
                rs.updateRow();
            }
            int totalRows = 0;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            lista = new ArrayList<Empleado>(totalRows);
            while(rs.next()) {
                Empleado emp = new Empleado();
                emp.setEmpno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));
                emp.setHiredate(LocalDate.parse(rs.getString(5)));
                emp.setSal(rs.getFloat(6));
                emp.setComm(rs.getFloat(7));
                emp.setDeptno(rs.getInt(8));
                lista.add(emp);
            }
            rs.beforeFirst();
            while (rs.next()) {
                rs.updateString("ENAME", rs.getString(2).toUpperCase());
                rs.updateRow();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List <Empleado> actualizarComisiones (Connection con) {
        List <Empleado> lista = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * from EMP where EMPNO in (SELECT mgr FROM emp where mgr is not null);", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            List <Empleado> emps = getByMgr(con);
            while (rs.next()) {
                for (int i = 0; i < emps.size(); i++ ) {
                    if (emps.get(i).getMgr() == rs.getInt(1)) {
                        rs.updateFloat("COMM", emps.get(i).getComm() * 2);
                        rs.updateRow();
                    }
                }
            }
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs2 = s.executeQuery("SELECT * from EMP where EMPNO in (SELECT mgr FROM emp where mgr is not null);");
            int totalRows = 0;
            rs2.last();
            totalRows = rs2.getRow();
            rs2.beforeFirst();
            lista = new ArrayList<Empleado>(totalRows);
            while(rs2.next()) {
                Empleado emp = new Empleado();
                emp.setEmpno(rs2.getInt(1));
                emp.setEname(rs2.getString(2));
                emp.setJob(rs2.getString(3));
                emp.setMgr(rs2.getInt(4));
                emp.setHiredate(LocalDate.parse(rs2.getString(5)));
                emp.setSal(rs2.getFloat(6));
                emp.setComm(rs2.getFloat(7));
                emp.setDeptno(rs2.getInt(8));
                lista.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List <Empleado> getByMgr (Connection con) {
        List <Empleado> lista = null;
        try {
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = s.executeQuery("SELECT * FROM EMP where mgr is not null;");
            int totalRows = 0;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            lista = new ArrayList<Empleado>(totalRows);
            while(rs.next()) {
                Empleado emp = new Empleado();
                emp.setEmpno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));
                emp.setHiredate(LocalDate.parse(rs.getString(5)));
                emp.setSal(rs.getFloat(6));
                emp.setComm(rs.getFloat(7));
                emp.setDeptno(rs.getInt(8));
                lista.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

}