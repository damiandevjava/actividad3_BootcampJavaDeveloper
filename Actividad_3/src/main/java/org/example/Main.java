package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;
        int intentosPermitidos = 3;
        int intentoUsuario = 1;
        int password = 1234;
        int entradaPasswordUsuario = 1111;

        double saldoCuenta = 100000;
        double retiro = 0;
        double deposito = 0;

        while(intentoUsuario<=intentosPermitidos && entradaPasswordUsuario!=password){
            System.out.println("Para operar ingrese su clave de cajero automático, recuerde que la misma es de 4 digitos númericos");
            entradaPasswordUsuario = sc.nextInt();

            if(entradaPasswordUsuario!=password && intentoUsuario<intentosPermitidos){
                System.out.println("Intento N°" + intentoUsuario + " fallido,por favor, tenga en cuenta que al tercer intento incorrecto se bloqueará su tarjeta");
                System.out.println();
            }
            intentoUsuario++;
        }

        if(intentoUsuario>intentosPermitidos){
            System.out.println("Tarjeta bloqueada");
        }
        else{

            do{
                System.out.println("Ingrese por favor el número para la operación que desea realizar");
                System.out.println("1- Consulta de Saldo");
                System.out.println("2- Retiro Efectivo");
                System.out.println("3- Depósito");
                System.out.println("0- Salir");
                System.out.println();
                System.out.print("opción: ");
                opcion = sc.nextInt();

                switch (opcion){
                    case 0:
                        System.out.println("Finalizada la sesión retire tu tarjeta por favor");
                    case 1:
                        System.out.println("Su saldo es de: " + saldoCuenta);
                        break;
                    case 2:
                        System.out.print("Ingrese el monto a retirar: ");
                        retiro = sc.nextDouble();
                        if(saldoCuenta>=retiro){
                            saldoCuenta -= retiro;
                        }
                        else{
                            System.out.println("No posee suficiente saldo para el retiro");
                        }
                        System.out.println("Su saldo es de: " + saldoCuenta);
                        break;
                    case 3:
                        System.out.println("Ingrese el monto a depositar: ");
                        deposito = sc.nextDouble();
                        saldoCuenta += deposito;
                        System.out.println("Su saldo es de: " + saldoCuenta);
                        break;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }
            } while(opcion!= 0);


        }

    }
}