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
    
    //****-***-**
    //012345678910
    public static String formatearFecha (String fecha) {
        GregorianCalendar calendar = new GregorianCalendar();
        int year = Integer.parseInt(fecha.subSequence(0, 4).toString());
        String mes = fecha.subSequence(5, 8).toString();
        int dia = Integer.parseInt(fecha.subSequence(9, 11).toString());
        
        if (mes.equalsIgnoreCase("Ene")) {
            if (dia <=0 || dia > 31) {
                return "No hay " + dia + " dias en el mes de " + completarMes(mes);
            }
        }else if (mes.equalsIgnoreCase("Feb")) {
            if (dia == 29) {
                if (calendar.isLeapYear(year) == false) {
                    return year + "no es bisiesto";
                }
                
            }
        }
        
        
        
        return year + "-" + completarMes(mes) + "-" + dia;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
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
        }while (option != 2);
        
    }
    
}
