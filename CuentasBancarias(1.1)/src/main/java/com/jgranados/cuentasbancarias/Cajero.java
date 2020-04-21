package com.jgranados.cuentasbancarias;

/**
 * CuentasBancarias
 *
 * @author jose - 11.03.2020
 * @Title: Cajero
 * @Description: description
 *
 * Changes History
 */
public class Cajero extends Persona {

    public Cajero(String nombre,
            String cui) {
        super(nombre, cui);
    }

    public void registrarRetiro(int numeroCuenta,
            Cliente cliente,
            double cantidad) {
        Cuenta cuentaEncontrada = encontrarCuenta(numeroCuenta, cliente);

        /*for (int i = 0; i < 5; i++) {

            if (cuentasDeCliente[i] != null
                    && cuentasDeCliente[i].esNumeroCuentaValido(numeroCuenta)) {
                cuentaEncontrada = cuentasDeCliente[i];
                break;
            }

        }*/
        if (cuentaEncontrada == null) {
            System.out.printf("No existe cuenta con el numero %d\n", numeroCuenta);
        } else {
            cuentaEncontrada.retirar(cantidad);
        }
        // buscar que el num cuenta exista
        // si existe entonces registro retiro
        // sino
        //  imprimo que no existe cuenta

    }

    public void registrarDeposito(int numeroCuenta,
            Cliente cliente,
            double cantidad) {
        // algoritmo
    }

    public void acreditarIntereses(int numeroCuenta,
            Cliente cliente) {
        Cuenta cuentaEncontrada = encontrarCuenta(numeroCuenta, cliente);
        if (cuentaEncontrada == null) {
            System.out.printf("No existe cuenta con el numero %d\n", numeroCuenta);
        } else if (cuentaEncontrada instanceof Ahorro) {
            ((Ahorro) cuentaEncontrada).generarIntereses();
            System.out.printf("La cuenta con número %d existe", cuentaEncontrada.obtenerNumeroCuenta());
        } else {
            System.out.printf("La cuenta No. %d no es de ahorro\n", numeroCuenta);
        }
    }

    private Cuenta encontrarCuenta(int numeroCuenta,
            Cliente cliente) {
        Cuenta[] cuentasDeCliente = cliente.obtenerCuentas();
        // busqueda secuencial
        /*Cuenta cuentaEncontrada = null;

        for (Cuenta cuenta : cuentasDeCliente) {
            if (cuenta != null
                    && cuenta.esNumeroCuentaValido(numeroCuenta)) {
                cuentaEncontrada = cuenta;
                break;
            }
        }*/
        int indiceBajo = 0;
        int indiceAlto = cuentasDeCliente.length - 1;
        int indiceCentro;
        //busqueda binaria
        while (indiceBajo <= indiceAlto) {
            indiceCentro = (indiceBajo + indiceAlto) / 2;
            Cuenta central = cuentasDeCliente[indiceCentro];
            if (central == null) {
                return null;
            }

            if (central.esNumeroCuentaValido(numeroCuenta)) {
                return central;
            } else if (numeroCuenta < central.obtenerNumeroCuenta()) {
                indiceAlto = indiceCentro - 1;
            } else {
                indiceBajo = indiceCentro + 1;
            }
        }

        return null;
    }

}
