package com.bdpatron;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartamentoDAO implements DAO <Departamento> {
    
    static Scanner teclado = new Scanner (System.in);

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

    public void insertarLote (Connection con) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO dept (deptno, dname, loc) VALUES (?, ?, ?);" , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            for (int i = 0; i < 3; i++) {
                System.out.println("Inserte número departamento: ");
                ps.setInt(1, Integer.parseInt(teclado.nextLine()));
                System.out.println("Inserte nombre departamento: ");
                ps.setString(2, teclado.nextLine());
                System.out.println("Inserte localidad departamento: ");
                ps.setString(3, teclado.nextLine());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
