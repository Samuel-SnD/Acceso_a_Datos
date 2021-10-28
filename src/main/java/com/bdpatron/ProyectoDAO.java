package com.bdpatron;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO implements DAO <Proyecto> {
    
    @Override
    public Proyecto get (long id, Connection con) {
        Proyecto proy = new Proyecto();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM proyectos where pcode = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                proy.setDeptno(rs.getInt("deptno"));
                proy.setPcode(rs.getInt("pcode"));
                proy.setDesc(rs.getString("descp"));
                proy.setPres(rs.getDouble("pres"));
                proy.setPname(rs.getString("pname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proy;
    }

    @Override
    public List <Proyecto> getAll (Connection conn) {
        List <Proyecto> lista = null;
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery("SELECT * FROM Proyectos;");
            int totalRows = 0;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            lista = new ArrayList <Proyecto> (totalRows);
            while(rs.next()) {
                Proyecto proy = new Proyecto();
                proy.setDeptno(rs.getInt("deptno"));
                proy.setPcode(rs.getInt("pcode"));
                proy.setDesc(rs.getString("descp"));
                proy.setPres(rs.getDouble("pres"));
                proy.setPname(rs.getString("pname"));
                lista.add(proy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
