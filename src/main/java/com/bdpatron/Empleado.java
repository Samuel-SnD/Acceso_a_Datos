package com.bdpatron;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empleado {
    int empno, mgr, deptno;
    float sal, comm;
    String ename, job;
    LocalDate hiredate;
    ArrayList <Familiar> familiares = new ArrayList <Familiar>();


    public int getEmpno() {
        return this.empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public int getMgr() {
        return this.mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public int getDeptno() {
        return this.deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public float getSal() {
        return this.sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

    public float getComm() {
        return this.comm;
    }

    public void setComm(float comm) {
        this.comm = comm;
    }

    public String getEname() {
        return this.ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public LocalDate getHiredate() {
        return this.hiredate;
    }

    public void setHiredate(LocalDate hiredate) {
        this.hiredate = hiredate;
    }

    public ArrayList<Familiar> getFamiliares() {
        return this.familiares;
    }

    public void setFamiliares(ArrayList<Familiar> familiares) {
        this.familiares = familiares;
    }
    
    

    @Override
    public String toString() {
        return "{" +
            " empno='" + getEmpno() + "'" +
            ", mgr='" + getMgr() + "'" +
            ", deptno='" + getDeptno() + "'" +
            ", sal='" + getSal() + "'" +
            ", comm='" + getComm() + "'" +
            ", ename='" + getEname() + "'" +
            ", job='" + getJob() + "'" +
            ", hiredate='" + getHiredate() + "'" +
            ", familiares='" + getFamiliares() + "'" +
            "}";
    }
    
}
