package com.bdpatron;

public class Proyecto {
    String pname, desc;
    double pres;
    int deptno, pcode;


    public String getPname() {
        return this.pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPres() {
        return this.pres;
    }

    public void setPres(double pres) {
        this.pres = pres;
    }

    public int getDeptno() {
        return this.deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public int getPcode() {
        return this.pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    @Override
    public String toString() {
        return "{" +
            " pname='" + getPname() + "'" +
            ", desc='" + getDesc() + "'" +
            ", pres='" + getPres() + "'" +
            ", deptno='" + getDeptno() + "'" +
            ", pcode='" + getPcode() + "'" +
            "}";
    }
    

}
