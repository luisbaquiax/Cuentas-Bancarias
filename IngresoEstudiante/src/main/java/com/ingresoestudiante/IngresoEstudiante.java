package com.ingresoestudiante;

import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class IngresoEstudiante {

    static Scanner scaner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombreEstudiante;
        String[] estudinatesA = new String[5];
        String[] estudiantesB = new String[5];
        String[] estudiantesC = new String[5];
        

        while (((contador1 <= estudinatesA.length) && (contador2 <= estudiantesB.length)) || ingresar == true || decision) {

            contador++;
            System.out.println(contador + " Estudiante, ingrses su nombre: ");
            nombreEstudiante = scaner.next();
            System.out.println("Elige tu seccion: 1. A   2. B");
            seccion = scaner.nextInt();
            if (seccion == 1) {
                estudinatesA[contador1] = nombreEstudiante;
                contador1++;
                //contador2 -= 1;
                if (contador1 == (estudinatesA.length)) {
                    System.out.println("la seccion A esta llena");

                }
            } else if (seccion == 2) {
                estudiantesB[contador2] = nombreEstudiante;
                contador2++;
                //contador1 -= 1;
                if (contador2 == (estudiantesB.length)) {
                    System.out.println("la seccion B esta llena");
                }
            }
            System.out.println("Desea ingresar otro estudiante");
            decision2 = scaner.nextInt();
            if (decision2 == 1) {
                decision = true;
            } else {
                decision = false;
            }

            if (contador1 == (estudinatesA.length) && contador2 == (estudiantesB.length)) {
                System.out.println("Las dos secciones estan llenas");

                System.out.println("Deseas abrir otra seccion pule (1)Si, pulse (2)No");
                abrir = scaner.nextInt();
                if (abrir == 1) {
                    break;
                } else if (abrir == 2) {
                    System.exit(0);
                }
            }

        }
        if (abrir == 1) {
            for (int i = 0; i < estudiantesC.length; i++) {
                System.out.println(i + " Estudiante, ingrese tu nombre");
                nombreEstudiante = scaner.next();
                estudiantesC[i] = nombreEstudiante;
                System.out.println("¿Desea ingresar otro estudiantes? 1. Si  2. No");
            }
        } else {
            System.exit(0);
        }

    }
}
