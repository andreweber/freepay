package co.com.freepay;

import java.util.Date;

/**
 * @author ANDRES
 */
public class Cuenta {

    /**
     * numero de la cuenta.
     */
    private long numero;
    /**
     * saldo disponible en la cuenta.
     */
    private long saldo;
    /**
     * fecha de apertura de la cuenta.
     */
    private Date fechaApertura;

    /**
     * @param numeroCuenta numero de la cuenta.
     */
    public Cuenta(final long numeroCuenta) {
        numero = numeroCuenta;
    }

    /**
     * @return numero de la cuenta.
     */
    public final long getNumero() {
        return numero;
    }

    /**
     * @return saldo de la cuenta.
     */
    public final long getSaldo() {
        return saldo;
    }

    /**
     * @param monto valor a retirar.
     * @throws Exception en caso de no poder hacer el retiro.
     */
    public final void retirar(final long monto) throws Exception {
        if (monto < 0) {
            throw new Exception("El monto a retirar no puede ser negativo.");
        }
        if (monto < saldo) {
            saldo = saldo - monto;
        } else {
            throw new Exception("Saldo insuficiente para realizar el retiro.");
        }
    }

    /**
     * @param monto valor a consignar.
     * @throws Exception en caso de no poder hacer la consignación.
     */
    public final void consignar(final long monto) throws Exception {
        if (monto < 0) {
            throw new Exception("El monto a consignar no puede ser negativo.");
        }
        saldo = saldo + monto;
    }
}
