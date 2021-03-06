package com.bdpatron;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Controller {
    
    static Scanner teclado = new Scanner (System.in);
    static List <Empleado> empleado;
    static List <Departamento> departamento;
    static List <Proyecto> proyecto;
    static List <Familiar> familiar;
    static DAOFactory mySQLFactory;
    static EmpleadoDAO empDAO;
    static DepartamentoDAO deptDAO;
    static ProyectoDAO proyDAO;
    static FamiliarDAO famDAO;
    public static void main(String[] args) {
        try {
            mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            empDAO = mySQLFactory.getEmpleadoDAO();
            deptDAO = mySQLFactory.getDepartamentoDAO();
            proyDAO = mySQLFactory.getProyectoDAO();
            famDAO = mySQLFactory.getFamiliarDAO();
        } catch (Exception e) {
                e.printStackTrace();
        }
        boolean salir = false;
        while (!salir) {
            View v = new View();
            int opcion = v.mostrarMenu();
            switch (opcion) {
                case 1: verEmpleados(); break;
                case 2: verDepartamentos(); break;
                case 3: verProyectos(); break;
                case 4: verFamiliares(); break;
                case 5: verEmpleado(); break;
                case 6: verDepartamento(); break;
                case 7: verProyecto(); break;
                case 8: verFamiliar(); break;
                case 9: verEmpleadoDept();; break;
                case 10: verEmpleadosFecha(); break;
                case 11: verEmpleadosJob(); break;
                case 12: verFamiliaresEmp(); break;
                case 13: verEmpleadoSalDept(); break;
                case 14: verEmpleadosMinus(); break;
                case 15: insertarFamiliares(); break;
                case 16: actualizarComisiones(); break;
                case 17: crearVistasDept(); break;
                case 18: mostrarVistasDept(); break;
                case 19: crearVistasJefes(); break;
                case 20: mostrarVistasJefes(); break;
                case 21: mostrarNumJefes(); break;
                case 22: mostrarNombreEmp(); break;
                case 23: a??adirTresEmp(); break;
                case 24: a??adirTresDept(); break;
                case 25: a??adirTresProy(); break;
                case 26: a??adirTresFam(); break;
                case 27: salir = true; break;
                default: System.out.println("Opci??n no v??lida"); break;
            }
        }
    }

    public static void verEmpleados() {
        try {
            empleado = empDAO.getAll(mySQLFactory.getConnection());
            for (int i = 0; i < empleado.size(); i++) {
                System.out.println(empleado.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void verDepartamentos() {
        try {
            departamento = deptDAO.getAll(mySQLFactory.getConnection());
            for (int i = 0; i < departamento.size(); i++) {
                System.out.println(departamento.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verProyectos() {
        try {
            proyecto = proyDAO.getAll(mySQLFactory.getConnection());
            for (int i = 0; i < proyecto.size(); i++) {
                System.out.println(proyecto.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verFamiliares() {
        try {
            familiar = famDAO.getAll(mySQLFactory.getConnection());
            for (int i = 0; i < familiar.size(); i++) {
                System.out.println(familiar.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verEmpleado() {
        System.out.println("Introduce el id del empleado: ");
        long id = Long.parseLong(teclado.nextLine());
        try {
            Empleado emp = empDAO.get(id, mySQLFactory.getConnection());
            System.out.println(emp.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verDepartamento() {
        System.out.println("Introduce el id del departamento: ");
        long id = Long.parseLong(teclado.nextLine());
        try {
            Departamento dept = deptDAO.get(id, mySQLFactory.getConnection());
            System.out.println(dept.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verProyecto() {
        System.out.println("Introduce el id del proyecto: ");
        long id = Long.parseLong(teclado.nextLine());
        try {
            Proyecto proy = proyDAO.get(id, mySQLFactory.getConnection());
            System.out.println(proy.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verFamiliar() {
        System.out.println("Introduce el id del familiar: ");
        long id = Long.parseLong(teclado.nextLine());
        try {
            Familiar fam = famDAO.get(id, mySQLFactory.getConnection());
            System.out.println(fam.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verEmpleadoDept () {
        System.out.println("Introduce el id del departamento: ");
        long deptno = Long.parseLong(teclado.nextLine());
        try {
            List <Empleado> emp = empDAO.getByDept(deptno, mySQLFactory.getConnection());
            for (int i = 0; i < emp.size(); i++) {
                System.out.println(emp.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verEmpleadosFecha () {
        System.out.println("Introduce un d??a: ");
        int dia = Integer.parseInt(teclado.nextLine());
        System.out.println("Introduce un mes: ");
        int mes = Integer.parseInt(teclado.nextLine());
        System.out.println("Introduce un a??o: ");
        int a??o = Integer.parseInt(teclado.nextLine());
        LocalDate date = LocalDate.of(a??o, mes, dia);
        try {
            List <Empleado> emp = empDAO.getByDate(date, mySQLFactory.getConnection());
            for (int i = 0; i < emp.size(); i++) {
                System.out.println(emp.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verEmpleadosJob () {
        System.out.println("Introduce un empleo: ");
        String job = teclado.nextLine();
        try {
            List <Empleado> emp = empDAO.getByJob(job, mySQLFactory.getConnection());
            for (int i = 0; i < emp.size(); i++) {
                System.out.println(emp.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verFamiliaresEmp () {
        System.out.println("Introduce el c??digo del empleado: ");
        int cod = Integer.parseInt(teclado.nextLine());
        try {
            List <Familiar> fam = famDAO.getByEmp(cod, mySQLFactory.getConnection());
            for (int i = 0; i < fam.size(); i++) {
                System.out.println(fam.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verEmpleadoSalDept () {
        System.out.println("Introduce el salario: ");
        Float sal = Float.parseFloat(teclado.nextLine());
        System.out.println("Introduce el departamento: ");
        int dept = Integer.parseInt(teclado.nextLine());
        try {
            List <Empleado> emp = empDAO.getBySalDept(sal, dept, mySQLFactory.getConnection());
            for (int i = 0; i < emp.size(); i++) {
                System.out.println(emp.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verEmpleadosMinus () {
        try {
            empleado = empDAO.getAllToLowerCase(mySQLFactory.getConnection());
            for (int i = 0; i < empleado.size(); i++) {
                System.out.println(empleado.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertarFamiliares () {
        System.out.println("Introduce el c??digo del empleado al que quieres insertar: ");
        int cod1 = Integer.parseInt(teclado.nextLine());
        System.out.println("Introduce el c??digo del empleado del que quieres insertar: ");
        int cod2 = Integer.parseInt(teclado.nextLine());
        try {
            famDAO.insertFam(cod1, cod2, mySQLFactory.getConnection());
            List <Familiar> fam = famDAO.getByEmp(cod1, mySQLFactory.getConnection());
            for (int i = 0; i < fam.size(); i++) {
                System.out.println(fam.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizarComisiones () {
        try {
            List <Empleado> emp = empDAO.actualizarComisiones(mySQLFactory.getConnection());
            for (int i = 0; i < emp.size(); i++) {
                System.out.println(emp.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void crearVistasDept () {
        try {
            empDAO.crearVistaDepts(mySQLFactory.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarVistasDept () {
        try {
            empDAO.verVistas(mySQLFactory.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void crearVistasJefes () {
        try {
            empDAO.crearVistasJefes(mySQLFactory.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void mostrarVistasJefes () {
        try {
            empDAO.verVistasJefes(mySQLFactory.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarNumJefes () {
        try {
            empDAO.getNumJefes(mySQLFactory.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarNombreEmp () {
        try {
            System.out.println("Indica el n??mero del empleado: ");
            int num = Integer.parseInt(teclado.nextLine());
            empDAO.getNombreEmp(num, mySQLFactory.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a??adirTresEmp () {
        try {
            empDAO.insertarLote(mySQLFactory.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a??adirTresDept () {
        try {
            deptDAO.insertarLote(mySQLFactory.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a??adirTresProy () {
        try {
            proyDAO.insertarLote(mySQLFactory.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a??adirTresFam () {
        try {
            famDAO.insertarLote(mySQLFactory.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}