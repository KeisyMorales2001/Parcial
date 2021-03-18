package com.company;
import java.util.Date;
import java.util.ArrayList;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        //declaración de variables
        int o, n;
        String u;
        String c;
        boolean ingreso = false;

        // Colocar fecha y hora
        Date fecha = new Date();
        //invocar las clases
        Scanner s = new Scanner(System.in);
        ArrayList<cuenta> cuentas = new ArrayList<cuenta>();
        //añadir cuentas
        cuentas.add(new cuenta("Keisy Morales", "1001", 10500));
        cuentas.add(new cuenta("Rosa Nuñez", "2001", 17500));
        cuentas.add(new cuenta("Jeffry Morales", "3001", 4500));
        cuentas.add(new cuenta("Marcos Fuentes", "4001", 1000));

        //realizando un historial de movimientos para el informe de balance
        cuentas.get(0).setMovimientos(10500);
        cuentas.get(0).setMovimientos(-500);
        cuentas.get(0).setMovimientos(130);
        cuentas.get(1).setMovimientos(17500);
        cuentas.get(1).setMovimientos(-450);
        cuentas.get(1).setMovimientos(150);
        cuentas.get(2).setMovimientos(4500);
        cuentas.get(2).setMovimientos(-600);
        cuentas.get(2).setMovimientos(200);
        cuentas.get(3).setMovimientos(1000);
        cuentas.get(3).setMovimientos(300);
        cuentas.get(3).setMovimientos(-50);

        //Bienvenida
        System.out.println("\n \t  --------[  BIENVENIDO AL BANCO XYZ  ]------- \n");

        //menu para iniciar o cerrar la sesión
        do{
        System.out.println(
                "\n 1 INICIAR SESIÓN \n 2 SALIR \n");
        o = s.nextInt();
        s.nextLine();

        switch (o){
            case 1:
                //se ingresan los valores de usuario y su contraseña
                System.out.println("\n  Ingrese su Usuario");
                u= s.nextLine();
                System.out.println("\n Ingrese su Contraseña");
                c = s.nextLine();

                // se crea un variable para almacenar la posicion del objeto en la array list
                int objposicion=0;

                //se verifica si los valores ingresados anteriormente son correctos y se recorre el for
                for (int i=0; i< cuentas.size();i++){
                    cuentas.get(objposicion).totalMovi();
                    if (cuentas.get(i).getNombre_usuario().contains(u) && cuentas.get(i).getPassword().contains(c)){
                        objposicion=i;
                        cuentas.get(objposicion).getNombre_usuario();
                        ingreso= true;
                    };
                }

                //se inspecciona si la cuenta posee un monto inicial >1500 para poder entrar
                cuentas.get(objposicion).totalMovi();
                if (cuentas.get(objposicion).ingreso(u,c) && cuentas.get(objposicion).inspeccionar()) {
                    System.out.println("\n Bienvenido al sistema " + cuentas.get(objposicion).getNombre_usuario() + " a la hora: " + fecha.toString());

                    //se crea para el registro del primer ingreso
                    if (cuentas.get(objposicion).getPrimerIngreso()) {
                        System.out.print("Al ser su primer ingreso a la plataforma, le pedimos que cambie la contraseña para guardar su seguridad\n");
                        c = s.nextLine();
                        s.nextLine();
                        cuentas.get(objposicion).setPassword(c);
                        cuentas.get(objposicion).setPrimerIngreso(false);
                    }

                    ingreso = false;

                    do {
                        System.out.println(
                                "\n Menu\n 1 Ver Estado de Cuenta \n 2 Solicitar un credito \n 3 Cambiar la contraseña \n 4 Salir \n");
                        n = s.nextInt();
                        s.nextLine();
                        switch (n) {

                            case 1:
                                System.out.println("-----------ESTADO DE CUENTA-----------:");
                                cuentas.get(objposicion).totalMovi();
                                System.out.println("Su monto inicial es: " + cuentas.get(objposicion).getMontoInicial());
                                cuentas.get(objposicion).movi();
                                System.out.println("---------------------------------");
                                System.out.println("Su monto final es: " + cuentas.get(objposicion).getDeposito());
                                break;

                            case 2:
                                System.out.println("Ingrese el monto que desea solicitar");
                                double dinerito = s.nextDouble();
                                boolean credito = false;

                                System.out.println("Dinero " + dinerito);

                                for (int i = 0; i < cuentas.size(); i++) {

                                    if (cuentas.get(objposicion).getDeposito() * 0.90 >= dinerito && i != objposicion) {
                                        cuentas.get(objposicion).setMovimientos(dinerito);
                                        System.out.println("El préstamo ha sido aprobado \n Dinero solicitado: "
                                                + dinerito + "\n Comisión a pagar: " + (dinerito * 0.30)
                                                + "\n Total a pagar: " + dinerito * 1.30);
                                        credito = true;
                                        break;
                                    }
                                }
                                if (credito == false) {
                                    System.out.println("Lo sentimos, no podemos procesar su préstamo");
                                }


                                break;

                            case 3:
                                System.out.println("\n Ingrese su nueva contraseña: ");
                                c = s.nextLine();
                                cuentas.get(objposicion).setPassword(c);
                                System.out.println("\n  Su nueva contraseña es: " + cuentas.get(objposicion).getPassword());
                                break;

                            case 4:
                                System.out.println("Ha cerrado sesión a la hora: "+fecha.toString());
                                break;
                            default:
                                System.out.println("Ingrese un valor válido, por favor");

                        }

                    } while (n != 4);
                }

                //si el cliente no tiene un monto inicial> 1500, entonces no puede iniciar sesión
                 else if  (ingreso == false) {
                    System.out.println("Usuario o contraseña incorrectos, volver a intentarlo");
                }

                 // si es una cantidad mayor a la de las cuentas del banco entonces no se puede realizar el préstamo
                else {
                    System.out.println("Lo sentimos, no cuenta con el monto requrido para mantener el sistema online activo");
                }

            case 2:;
                break;
            default: System.out.println("Ingrese un valor válido, por favor");
        }
        }while (o !=2 );
    }

}
