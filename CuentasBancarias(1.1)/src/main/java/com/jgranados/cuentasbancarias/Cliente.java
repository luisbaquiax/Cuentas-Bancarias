package com.jgranados.cuentasbancarias;

/**
 * CuentasBancarias
 *
 * @author jose - 11.03.2020
 * @Title: Cliente
 * @Description: description
 *
 * Changes History
 */
public class Cliente extends Persona {

    private Cuenta[] cuentas;

    public void mostrarDatos() {
        super.mostrarDatos();
        for (Cuenta cuenta : cuentas) {
            if (cuenta != null) {
                cuenta.mostrarDatos();
            }
        }
    }

    @Override
    public String toString() {
        return "toString sobreescrito!!!!!!";
    }

    /**
     * Ordena la cuentas del cliente en base al numero de cuenta, METODO BURBUJA
     *
     * @param cuentas
     * @param client
     */
    public void metodoBurbuja(Cuenta[] cuentas, Cliente client) {
        Cuenta auxiliar;

        for (int i = 0; i < (cuentas.length - 1); i++) {
            for (int j = 0; j < (cuentas.length - 1); j++) {
                if (cuentas[j].obtenerNumeroCuenta() > cuentas[j + 1].obtenerNumeroCuenta()) {
                    //se cambian de posicion las cuentas
                    auxiliar = cuentas[j];
                    cuentas[j] = cuentas[j + 1];
                    cuentas[j + 1] = auxiliar;
                }
            }
        }
        System.out.println("Cuentas ordenadas con el método burbuja.");
        client.mostrarDatos();
    }

    /**
     * Ordena las cuentas del cliente enbas al numero de cuenta por el método
     * Por Selección
     *
     * @param cuentas
     * @param cliente
     */
    public void metodPorSeleccion(Cuenta[] cuentas, Cliente cliente) {
        int posicionMinima;
        Cuenta cuentaAuxiliar;//ayudará a realizar el cambio
        for (int i = 0; i < cuentas.length - 1; i++) {
            posicionMinima = i;//posicion del numero mas pequeño

            for (int j = i + 1; j < cuentas.length; j++) {
                //se compara el valor actual en j con el valor en la posicionMinima
                if (cuentas[j].obtenerNumeroCuenta() < cuentas[posicionMinima].obtenerNumeroCuenta()) {
                    //el valor mas pequeño se encuentra en la posicion nueva (j) en este caso, se hace el cambio de posición
                    posicionMinima = j;
                }
            }
            //se realiza el cambio de las cuentas
            cuentaAuxiliar = cuentas[i];
            cuentas[i] = cuentas[posicionMinima];
            cuentas[posicionMinima] = cuentaAuxiliar;
        }
        System.out.println("Ordenado por método por selección: ");
        cliente.mostrarDatos();
    }

    /**
     * METODO POR INSERCION
     *
     * @param cuentas
     * @param cliente
     */
    public void metodoPorInsercion(Cuenta[] cuentas, Cliente cliente) {
        int posicion;
        Cuenta auxiliar;
        for (int i = 0; i < cuentas.length; i++) {
            posicion = i;
            auxiliar = cuentas[i];
            while (posicion > 0 && (cuentas[posicion - 1].obtenerNumeroCuenta() > auxiliar.obtenerNumeroCuenta())) {
                cuentas[posicion] = cuentas[posicion - 1];
                posicion--;
            }
            //
            cuentas[posicion] = auxiliar;
        }
        System.out.println("Ordenado por el método de Insercion");
        cliente.mostrarDatos();

    }

    /**
     * Ordena las cuentas del cliente en base al número de cuenta por el MÉTODO
     * DE QUICK SORT
     *
     * @param cuentas
     * @param cliente
     * @param primeraPosicion
     * @param ultimaPosicion
     */
    public void metodoQuickSort(Cuenta[] cuentas, Cliente cliente, int primeraPosicion, int ultimaPosicion) {

        Cuenta auxiliar; //variable auxiliar con el que aydudará a realizar el cambio
        int i = primeraPosicion;
        int j = ultimaPosicion;
        Cuenta cuentaPivote = cuentas[(primeraPosicion + ultimaPosicion) / 2];

        do {
            while (cuentas[i].obtenerNumeroCuenta() < cuentaPivote.obtenerNumeroCuenta()) {
                i++;
            }
            while (cuentas[j].obtenerNumeroCuenta() > cuentaPivote.obtenerNumeroCuenta()) {
                j--;
            }
            //En esta parte haremos el cambio de los valores con la ayuda de la variable auxiliar
            if (i <= j) {
                auxiliar = cuentas[i];
                cuentas[i] = cuentas[j];
                cuentas[j] = auxiliar;
                //incrementamos los valores de i y j
                i++;
                j--;
            }
        } while (i <= j);

        //aplicamos la recursividad, para ordenar lo que podría faltar
        //en las sublistas, tanto izquierda como derecha
        if (primeraPosicion < j) {
            metodoQuickSort(cuentas, cliente, primeraPosicion, j);
        }
        if (i < ultimaPosicion) {
            //metodoQuickSort(cuentas, cliente, i, ultimaPosicion);
        }
//        System.out.println("ORDENADO POR EL METODO DE QUICK SORT");
//        cliente.mostrarDatos();
    }

    /**
     * Va ha mostrar todo lo que hace el metodo de ordenamiento QUICK SORT
     *
     * @param cuentas
     * @param cliente
     * @param primeraPosicion
     * @param ultimaPosicion
     */
    public void mostrarConMetodoQuisck(Cuenta[] cuentas, Cliente cliente, int primeraPosicion, int ultimaPosicion) {
        System.out.println("Ordenado con el método QUICK SORT");
        metodoQuickSort(cuentas, cliente, primeraPosicion, ultimaPosicion);
        cliente.mostrarDatos();
    }
}
