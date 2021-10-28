package com.bdpatron;

import java.util.ArrayList;

public class Departamento {
    int deptno;
    String dname, loc;
    ArrayList <Empleado> empleados = new ArrayList <Empleado>();
    ArrayList <Proyecto> proyectos = new ArrayList <Proyecto>();


    public int getDeptno() {
        return this.deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return this.dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return this.loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public ArrayList<Empleado> getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Proyecto> getProyectos() {
        return this.proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
    

    @Override
    public String toString() {
        return "{" +
            " deptno='" + getDeptno() + "'" +
            ", dname='" + getDname() + "'" +
            ", loc='" + getLoc() + "'" +
            ", empleados='" + getEmpleados() + "'" +
            ", proyectos='" + getProyectos() + "'" +
            "}";
    }


}
