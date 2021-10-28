package com.bdpatron;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO implements DAO <Departamento> {
    
    @Override
    public Departamento get (long id, Connection con) {
        Departamento dept = new Departamento();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM dept where deptno = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dept.setDeptno(rs.getInt(1));
                dept.setDname(rs.getString(2));
                dept.setLoc(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dept;
    }

    @Override
    public List <Departamento> getAll (Connection conn) {
        List <Departamento> lista = null;
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery("SELECT * FROM DEPT;");
            int totalRows = 0;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            lista = new ArrayList <Departamento> (totalRows);
            while(rs.next()) {
                Departamento dept = new Departamento();
                dept.setDeptno(rs.getInt(1));
                dept.setDname(rs.getString(2));
                dept.setLoc(rs.getString(3));
                lista.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
