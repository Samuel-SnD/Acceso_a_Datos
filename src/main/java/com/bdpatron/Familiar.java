package com.bdpatron;

public class Familiar {
    String fname, fpar;
    int edad, pariente, fcode;

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFpar() {
        return this.fpar;
    }

    public void setFpar(String fpar) {
        this.fpar = fpar;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPariente() {
        return this.pariente;
    }

    public void setPariente(int pariente) {
        this.pariente = pariente;
    }

    public int getFcode() {
        return this.fcode;
    }

    public void setFcode(int fcode) {
        this.fcode = fcode;
    }

    @Override
    public String toString() {
        return "{" +
            " fname='" + getFname() + "'" +
            ", fpar='" + getFpar() + "'" +
            ", edad='" + getEdad() + "'" +
            ", pariente='" + getPariente() + "'" +
            ", fcode='" + getFcode() + "'" +
            "}";
    }

    

}
