package com.jgranados.cuentasbancarias;

/**
 * CuentasBancarias
 * @author jose - 11.03.2020 
 * @Title: Monetaria
 * @Description: description
 *
 * Changes History
 */
public class Monetaria extends Cuenta {
    
    public Monetaria(int numeroCuenta,
            double saldo,
            Cliente cliente) {
        super(numeroCuenta, saldo, cliente);
    }
    
}