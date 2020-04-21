package com.jgranados.cuentasbancarias;

/**
 * CuentasBancarias
 * @author jose - 11.03.2020 
 * @Title: PlazoFijo
 * @Description: description
 *
 * Changes History
 */
public class PlazoFijo extends Ahorro {
    int plazo; // 3 meses, 6 meses, 9 meses
    
    public PlazoFijo(int numeroCuenta,
            double saldo,
            Cliente cliente) {
        super(numeroCuenta, saldo, cliente);
    }
}