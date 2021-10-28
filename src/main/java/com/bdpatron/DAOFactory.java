package com.bdpatron;

import java.sql.Connection;

public abstract class DAOFactory {
    public static final int MYSQL = 1;
    public abstract Connection getConnection() throws Exception;
    public abstract EmpleadoDAO getEmpleadoDAO();
    public abstract DepartamentoDAO getDepartamentoDAO();
    public abstract ProyectoDAO getProyectoDAO();
    public abstract FamiliarDAO getFamiliarDAO();
    public static DAOFactory getDAOFactory(
    int whichFactory) {
        switch (whichFactory) {
            case MYSQL:
                return new MySQLDAOFactory();
            default :
                return null;
        }
    }

    public boolean releaseConnection(Connection connection) {
        return false;
    }
    
    public int getSize() {
        return 0;
    }

    public void shutdown() throws Exception {
    }
}
