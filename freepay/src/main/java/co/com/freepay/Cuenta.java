package co.com.freepay;

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
	 * @param numeroCuenta
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
	 * @param monto
	 * @throws Exception
	 */
	public final void retirar(long monto) throws Exception {
		if(monto < 0) {
			throw new Exception("El monto a retirar no puede ser negativo.");
		}
		if(monto < saldo) {
			saldo = saldo - monto;
		} else {
			throw new Exception("Saldo insuficiente para realizar el retiro.");
		}
	}

	/**
	 * @param monto
	 * @throws Exception
	 */
	public final void consignar(long monto) throws Exception {
		if(monto < 0) {
			throw new Exception("El monto a consignar no puede ser negativo.");
		}
		saldo = saldo + monto;
	}
}
