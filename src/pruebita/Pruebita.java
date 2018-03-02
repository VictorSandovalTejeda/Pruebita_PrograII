/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebita;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Alumnos
 */
public class Pruebita {

    /**
     * @param args the command line arguments
     */
    
    public static String completarMes (String mes){
        String nuevoMes = null;
        
        if (mes.equalsIgnoreCase("Ene")) nuevoMes = "Enero";
        else if (mes.equalsIgnoreCase("Feb")) nuevoMes = "Febrero";
        else if (mes.equalsIgnoreCase("Mar")) nuevoMes = "Marzo";
        else if (mes.equalsIgnoreCase("Abr")) nuevoMes = "Abril";
        else if (mes.equalsIgnoreCase("May")) nuevoMes = "Mayo";
        else if (mes.equalsIgnoreCase("Jun")) nuevoMes = "Junio";
        else if (mes.equalsIgnoreCase("Jul")) nuevoMes = "Julio";
        else if (mes.equalsIgnoreCase("Ago")) nuevoMes = "Agosto";
        else if (mes.equalsIgnoreCase("Sep")) nuevoMes = "Septiembre";
        else if (mes.equalsIgnoreCase("Oct")) nuevoMes = "Octubre";
        else if (mes.equalsIgnoreCase("Nov")) nuevoMes = "Noviembre";
        else if (mes.equalsIgnoreCase("Dic")) nuevoMes = "Diciembre";
        
        return nuevoMes;
    }
    
    public static boolean esNacional (char origen){
        if (origen == 'V') {
            return false;
        }
        else if (Character.isLetter(origen) && Character.isUpperCase(origen)) {
            return true;
        }
        else{
            return false;
        }
    }
    
    public static String formatearFecha (String fecha) {
        GregorianCalendar calendar = new GregorianCalendar();
        int year = Integer.parseInt(fecha.subSequence(0, 4).toString());
        String mes = fecha.subSequence(5, 8).toString();
        int dia = Integer.parseInt(fecha.subSequence(9, 11).toString());
        
        if (mes.equalsIgnoreCase("Ene") || mes.equalsIgnoreCase("Mar") || mes.equalsIgnoreCase("May") 
                || mes.equalsIgnoreCase("Jul") || mes.equalsIgnoreCase("Ago") || mes.equalsIgnoreCase("Oct")
                || mes.equalsIgnoreCase("Dic")) {
            if (dia < 1 || dia > 31) {
                return "No hay " + dia + " dias en el mes de " + completarMes(mes);
            }
        }else if (mes.equalsIgnoreCase("Feb")) {
            if (dia == 29) {
                if (calendar.isLeapYear(year) == false) {
                    return "El año " + year + " NO es bisiesto";
                }
            }else if (dia > 29) {
                return "No hay " + dia + " dias en el mes de " + completarMes(mes);
            }
        }else if (mes.equalsIgnoreCase("Abr") || mes.equalsIgnoreCase("Jun") || mes.equalsIgnoreCase("Sep")
                || mes.equalsIgnoreCase("Nov")) {
            if (dia < 1 || dia > 30) {
                return "No hay " + dia + " dias en el mes de " + completarMes(mes);
            }
        }
        return year + "-" + completarMes(mes) + "-" + dia;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Funcion esNacional
        System.out.println("FUNCION ES NACIONAL");
        System.out.println(esNacional('V'));
        System.out.println(esNacional('a'));
        System.out.println(esNacional('A'));
        System.out.println(esNacional('#'));
        System.out.println(esNacional('X'));
        
        //Funcion formatearFecha
        System.out.println();
        System.out.println("FUNCION FORMATEAR FECHA");
        System.out.println(formatearFecha("2018-Mar-01"));
        System.out.println(formatearFecha("2019-Feb-29"));
        System.out.println(formatearFecha("2020-Feb-29"));
        System.out.println(formatearFecha("1993-Dic-50"));
        System.out.println(formatearFecha("1995-Dic-31"));
        
        
        
        /*Scanner sc = new Scanner(System.in);
        int option = 0;
        char origen;
        String fecha;
                
        do{
            System.out.println("MENU:");
            System.out.println("_________________");
            System.out.println("1). Productos");
            System.out.println("2). Salir");
            System.out.println("_________________");
            System.out.print(">>");
            option = sc.nextInt();
            
            switch (option) {
                case 1:
                    System.out.println("Ingrese origin de producto");
                    origen = sc.nextLine().charAt(0);
                    if (esNacional(origen) == true) {
                            System.out.println("Ingrese Fecha  ---  2018-MES-DIA <2018-Mar-01>");
                            fecha = sc.nextLine();
                            boolean a = fecha.matches("\\d{4}-[A-Z][a-z]{3}-\\d{2}");
                            if(a){
                                System.out.println(formatearFecha(fecha));
                            }
                    }else{
                        System.out.println("Compre la version Gold");
                    }
                    break;
            }
        }while (option != 2);*/
        
    }
    
}
