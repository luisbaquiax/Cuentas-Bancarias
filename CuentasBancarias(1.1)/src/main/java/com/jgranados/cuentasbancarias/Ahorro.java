package com.jgranados.cuentasbancarias;

/**
 * CuentasBancarias
 *
 * @author jose - 11.03.2020
 * @Title: Ahorro
 * @Description: description
 *
 * Changes History
 */
public class Ahorro extends Cuenta {

    double tasaInteres;

    public Ahorro(int numeroCuenta,
            double saldo,
            Cliente cliente) {
        super(numeroCuenta, saldo, cliente);
    }

    public void generarIntereses() {
        double intereses = saldo * tasaInteres;
        saldo += intereses;
    }

    public void establecerTasaInteres(double valor) {
        tasaInteres = valor;
    }

    @Override
    public void mostrarDatos() {
        // algoritmo
        System.out.printf("Datos -> Numero: %d, saldo: %f, Tasa Interes: %f\n",
                obtenerNumeroCuenta(),
                this.saldo,
                this.tasaInteres);
    }
}
