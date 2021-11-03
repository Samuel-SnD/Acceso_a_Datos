package com.bdpatron;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProyectoDAO implements DAO <Proyecto> {
    
    static Scanner teclado = new Scanner (System.in);

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

    public void insertarLote (Connection con) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO proyectos (pcode, pname, descp, pres, deptno) VALUES (?, ?, ?, ?, ?);" , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            for (int i = 0; i < 3; i++) {
                System.out.println("Inserte número proyecto: ");
                ps.setInt(1, Integer.parseInt(teclado.nextLine()));
                System.out.println("Inserte nombre proyecto: ");
                ps.setString(2, teclado.nextLine());
                System.out.println("Inserte descripción proyecto: ");
                ps.setString(3, teclado.nextLine());
                System.out.println("Inserte presupuesto proyecto: ");
                ps.setFloat(4, Float.parseFloat(teclado.nextLine()));
                System.out.println("Inserte número departamento: ");
                ps.setInt(5, Integer.parseInt(teclado.nextLine()));
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
