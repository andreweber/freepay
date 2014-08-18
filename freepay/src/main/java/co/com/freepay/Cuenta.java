package co.com.freepay;

public class Cuenta {
	
	private long numero;
	private long saldo;
	
	public Cuenta(long numero) {
		this.numero = numero;
	}
	
	public long getNumero() {
		return numero;
	}
	
	public long getSaldo() {
		return saldo;
	}
	
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
	
	public void consignar(long monto) throws Exception {
		if(monto < 0) {
			throw new Exception("El monto a consignar no puede ser negativo.");
		}
		
		saldo = saldo + monto;
	}
}
