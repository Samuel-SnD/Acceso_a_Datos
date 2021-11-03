package com.bdpatron;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FamiliarDAO implements DAO<Familiar> {

    static Scanner teclado = new Scanner (System.in);

    @Override
    public Familiar get(long id, Connection con) {
        Familiar fam = new Familiar();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM familiares where fcode = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fam.setFcode(rs.getInt("fcode"));
                fam.setFname(rs.getString("fname"));
                fam.setFpar(rs.getString("fpar"));
                fam.setEdad(rs.getInt("edad"));
                fam.setPariente(rs.getInt("pariente"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fam;
    }

    @Override
    public List<Familiar> getAll(Connection conn) {
        List<Familiar> lista = null;
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery("SELECT * FROM Familiares;");
            int totalRows = 0;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            lista = new ArrayList<Familiar>(totalRows);
            while (rs.next()) {
                Familiar fam = new Familiar();
                fam.setFcode(rs.getInt("fcode"));
                fam.setFname(rs.getString("fname"));
                fam.setFpar(rs.getString("fpar"));
                fam.setEdad(rs.getInt("edad"));
                fam.setPariente(rs.getInt("pariente"));
                lista.add(fam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Familiar> getByEmp(int emp, Connection con) {
        List<Familiar> lista = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM familiares where pariente = ?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setInt(1, emp);
            ResultSet rs = ps.executeQuery();
            int totalRows = 0;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            lista = new ArrayList<Familiar>(totalRows);
            while (rs.next()) {
                Familiar fam = new Familiar();
                fam.setFcode(rs.getInt("fcode"));
                fam.setFname(rs.getString("fname"));
                fam.setFpar(rs.getString("fpar"));
                fam.setEdad(rs.getInt("edad"));
                fam.setPariente(rs.getInt("pariente"));
                lista.add(fam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insertFam(int emp, int emp2, Connection con) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM familiares where pariente = ?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1, emp);
            ResultSet rs = ps.executeQuery();
            List<Familiar> fams = getByEmp(emp2, con);
            for (int i = 0; i < fams.size(); i++) {
                rs.moveToInsertRow();
                rs.updateInt("fcode", fams.size() + fams.get(i).getFcode());
                rs.updateString("fname", fams.get(i).getFname());
                rs.updateString("fpar", fams.get(i).getFpar());
                rs.updateInt("edad", fams.get(i).getEdad());
                rs.updateInt("pariente", emp);
                rs.insertRow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertarLote (Connection con) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO proyectos (fcode, fname, fpar, edad, pariente) VALUES (?, ?, ?, ?, ?);" , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            for (int i = 0; i < 3; i++) {
                System.out.println("Inserte número familiar: ");
                ps.setInt(1, Integer.parseInt(teclado.nextLine()));
                System.out.println("Inserte nombre familiar: ");
                ps.setString(2, teclado.nextLine());
                System.out.println("Inserte parentesco familiar: ");
                ps.setString(3, teclado.nextLine());
                System.out.println("Inserte edad familiar: ");
                ps.setInt(4, Integer.parseInt(teclado.nextLine()));
                System.out.println("Inserte número pariente: ");
                ps.setInt(5, Integer.parseInt(teclado.nextLine()));
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
