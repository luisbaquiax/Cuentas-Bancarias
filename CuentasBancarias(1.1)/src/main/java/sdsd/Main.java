/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdsd;

import com.jgranados.cuentasbancarias.Ahorro;
import com.jgranados.cuentasbancarias.Cajero;
import com.jgranados.cuentasbancarias.Cliente;
import com.jgranados.cuentasbancarias.Cuenta;
import com.jgranados.cuentasbancarias.Monetaria;
import com.jgranados.cuentasbancarias.PlazoFijo;
import java.util.Scanner;

/**
 *
 * @author jose
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Cajero c1 = new Cajero("c1", "444");
        Cajero c2 = new Cajero("c2", "555");

        Cliente cliente1 = new Cliente("Valeria", "111");
        Cliente cliente2 = new Cliente("Jose", "222");
        Cliente cliente3 = new Cliente("Juan", "333");

        cliente1.mostrarDatos();
        cliente2.mostrarDatos();
        cliente3.mostrarDatos();

        // Cliente mismoCliente1 = cliente1;
        // mismoCliente1.mostrarDatos();
        System.out.println(cliente1.obtenerNombre());

        // Cuentas para el cliente 1
        Monetaria m1 = new Monetaria(1, 250, cliente1);
        Ahorro m2 = new Ahorro(2, 300, cliente1);

        cliente1.obtenerCuentas()[0] = m1;
        cliente1.obtenerCuentas()[1] = m2;
        cliente1.obtenerCuentas()[2] = new Ahorro(13, 400, cliente1); //numero de cuenta, saldo, cliente
        cliente1.obtenerCuentas()[3] = new Ahorro(4, 500, cliente1);
        cliente1.obtenerCuentas()[4] = new Ahorro(5, 600, cliente1);
        cliente1.obtenerCuentas()[5] = new Ahorro(26, 700, cliente1);
        cliente1.obtenerCuentas()[6] = new Ahorro(7, 800, cliente1);
        cliente1.obtenerCuentas()[7] = new Ahorro(80, 900, cliente1);
        cliente1.obtenerCuentas()[8] = new Ahorro(999, 1000, cliente1);
        cliente1.obtenerCuentas()[9] = new Ahorro(100, 1100, cliente1);
        m2.establecerTasaInteres(0.1);
        ((Ahorro) cliente1.obtenerCuentas()[9]).establecerTasaInteres(0.5);

        //cliente1.obtenerCuentas()[0].depositar(0);

        /*Cuenta xx = cliente1.obtenerCuentas()[0];
        Ahorro XAhorror = (Ahorro) cliente1.obtenerCuentas()[0];*/
        // Cuentas para el cliente 2
        PlazoFijo p1 = new PlazoFijo(3, 5000, cliente2);
        cliente2.obtenerCuentas()[0] = p1;

        // Cajeros
        /*c1.registrarRetiro(1, cliente1, 200);
        c1.registrarRetiro(1, cliente1, 200);

        c2.registrarRetiro(25, cliente2, 200);*/

 /*
        cliente1 = new Cliente("Alvaro", "555");
        cliente1.mostrarDatos();
        cliente1 = new Cliente("Maria", "6666");
        cliente1.mostrarDatos();
         */
        m1.mostrarDatos();
        m2.mostrarDatos();
        c1.acreditarIntereses(2, cliente1);
        c1.acreditarIntereses(7, cliente1);
        ((Cuenta) m2).mostrarDatos();
        c1.acreditarIntereses(1, cliente1);
        System.out.println("LISTADO CUENTAS C1");
        cliente1.mostrarDatos();

        System.out.println(cliente1.toString());

        m2.establecerValorSaldo(500000);
        System.out.println();

        //se obtiene las cuentas del cliente1, y se envía de parámetro al cliente1
        int opcion = 0;
        System.out.println("¿Por cuál método desea ordenar las cuentas? \n[1]METODO BURBUJA\n[2]METODO DE SELECCION\n[3]METODO POR INSERCION"
                + "\n[4]Quick Sort\n[5]MOSTRAR TODO");
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                //por el metod burbuja
                cliente1.metodoBurbuja(cliente1.obtenerCuentas(), cliente1);
                break;
            case 2:
                //por el metodo por selecion
                cliente1.metodPorSeleccion(cliente1.obtenerCuentas(), cliente1);
                break;
            case 3:
                //por el metodo por inserccion
                cliente1.metodoPorInsercion(cliente1.obtenerCuentas(), cliente1);
                break;
            case 4:
                //por el metodo Quick Sort
                cliente1.metodoQuickSort(cliente1.obtenerCuentas(), cliente1, 0, cliente1.obtenerCuentas().length - 1);
                break;
            case 5:
                System.out.println("---------------------------------------");
                cliente1.metodoBurbuja(cliente1.obtenerCuentas(), cliente1);
                System.out.println("---------------------------------------");
                cliente1.metodPorSeleccion(cliente1.obtenerCuentas(), cliente1);
                System.out.println("---------------------------------------");
                cliente1.metodoPorInsercion(cliente1.obtenerCuentas(), cliente1);
                System.out.println("---------------------------------------");
                cliente1.mostrarConMetodoQuisck(cliente1.obtenerCuentas(), cliente1, 0, cliente1.obtenerCuentas().length - 1);
//                cliente1.metodoQuickSort(cliente1.obtenerCuentas(), cliente1, 0, cliente1.obtenerCuentas().length - 1);
//                System.out.println("");
//                cliente1.mostrarDatos();
                break;
        }
        int numeroCuenta;
        System.out.printf("\nEscribe el número de la cuenta de %s que quieres buscar: ", cliente1.obtenerNombre());
        numeroCuenta = scanner.nextInt();
        c1.acreditarIntereses(numeroCuenta, cliente1);
    }

}
