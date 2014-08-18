package co.com.freepay;

/**
 * @author ANDRES
 */
public class Cuenta {

	/**
	 * numero de la cuenta
	 */
	private long numero;
	/**
	 * saldo disponible en la cuenta
	 */
    private long saldo;

	/**
	 * @param numero
	 */
	public Cuenta(long numero) {
		this.numero = numero;
	}

	/**
	 * @return
	 */
	public long getNumero() {
		return numero;
	}

	/**
	 * @return
	 */
	public long getSaldo() {
		return saldo;
	}

	/**
	 * @param monto
	 * @throws Exception
	 */
	public void retirar(long monto) throws Exception {
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
	public void consignar(long monto) throws Exception {
		if(monto < 0) {
			throw new Exception("El monto a consignar no puede ser negativo.");
		}
		saldo = saldo + monto;
	}
}
