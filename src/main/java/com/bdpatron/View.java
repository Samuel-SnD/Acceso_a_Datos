package com.bdpatron;

import java.util.Scanner;

public class View {
    static Scanner teclado = new Scanner (System.in);
    
    public int mostrarMenu () {
        System.out.println("1) Mostrar empleados");
        System.out.println("2) Mostrar departamentos");
        System.out.println("3) Mostrar proyectos");
        System.out.println("4) Mostrar familiares");
        System.out.println("5) Mostrar x empleado");
        System.out.println("6) Mostrar x departamento");
        System.out.println("7) Mostrar x proyecto");
        System.out.println("8) Mostrar x familiar");
        System.out.println("9) Buscar empleado por departamento");
        System.out.println("10) Buscar empleados por hiredate");
        System.out.println("11) Buscar empleados por trabajo");
        System.out.println("12) Buscar familiares por empleado");
        System.out.println("13) Buscar empleado por salario y departamento");
        System.out.println("14) Mostrar empleados en minúsculas");
        System.out.println("15) Insertar familiares empleados");
        System.out.println("16) Actualizar comisiones");
        System.out.println("17) Crear vistas departamentos");
        System.out.println("18) Mostrar vistas departamentos");
        System.out.println("19) Crear vistas jefes");
        System.out.println("20) Mostrar vistas jefes");
        System.out.println("21) Mostrar número de jefes");
        System.out.println("22) Mostrar nombre de empleado por empno");
        System.out.println("23) Salir");
        int opc = Integer.parseInt(teclado.nextLine());
        return opc;
    }
    
    public boolean showMessage(String message) {
        System.out.println(message);
        return true;
    }
}
