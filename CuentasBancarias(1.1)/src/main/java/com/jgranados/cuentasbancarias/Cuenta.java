package com.jgranados.cuentasbancarias;

/**
 * CuentasBancarias
 * @author jose - 11.03.2020 
 * @Title: Cuenta
 * @Description: description
 *
 * Changes History
 */
public class Cuenta {

    private Cliente propietario;
    private int numeroCuenta;
    protected double saldo;

    public Cuenta(int numeroCuenta,
            double saldo,
            Cliente cliente) {
        this.propietario = cliente;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void establecerValorSaldo(double nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }

    public void mostrarDatos() {
        // algoritmo
        System.out.printf("Datos -> Numero: %d, saldo: %f\n", this.numeroCuenta, this.saldo);
    }

    public double retirar(double cantidad) {
        // si cantidad > saldo
        // imprimir("No hay saldo")
        // sino
        //  saldo -= cantidad;
        if (cantidad > this.saldo) {
            System.out.println("No hay saldo");
        } else {
            this.saldo -= cantidad;
        }
        return cantidad;
    }

    public boolean depositar(double cantidad) {
        // algoritmo
        this.saldo += cantidad;
        return true;
    }

    public boolean esNumeroCuentaValido(int numero) {
        return this.numeroCuenta == numero;
    }

    public int obtenerNumeroCuenta() {
        return this.numeroCuenta;
    }
}