package com.bdpatron;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory {
    final static String url = "jdbc:mysql:///sales";
    final static String user = "admin";
    final static String password = "abc123.";
    static BasicConnectionPool bcp;
    
    public MySQLDAOFactory(){
        try {
            bcp = BasicConnectionPool.create(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return bcp.getConnection();
    }

    @Override
    public boolean releaseConnection (Connection connection){
        return bcp.releaseConnection(connection);
    }

    @Override
    public int getSize() {
        return bcp.getSize();
    }

    @Override
    public void shutdown() throws SQLException {
        bcp.shutdown();
    }

    @Override
    public EmpleadoDAO getEmpleadoDAO() {
        return new EmpleadoDAO();
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        return new DepartamentoDAO();
    }

    @Override
    public ProyectoDAO getProyectoDAO() {
        return new ProyectoDAO();
    }

    @Override
    public FamiliarDAO getFamiliarDAO() {
        return new FamiliarDAO();
    }
}
