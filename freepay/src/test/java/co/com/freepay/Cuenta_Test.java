package co.com.freepay;

import static org.junit.Assert.*;

import org.junit.Test;

public class Cuenta_Test {

	@Test
	public void saldo_0_retiro_1000_excepcion() {
		boolean resultado;
		Cuenta cuenta = new Cuenta(15263424548l);
		
		try {
			cuenta.retirar(1000);
			resultado = false;
		} catch (Exception e) {
			resultado = true;
		}
		
		assertTrue(resultado);
	}
	
	@Test
	public void saldo_0_consigno_10000_saldo_10000() throws Exception {
		Cuenta cuenta = new Cuenta(15263424548l);
		
		cuenta.consignar(10000);
		
		assertEquals(10000, cuenta.getSaldo());
	}
	
	@Test
	public void saldo_0_consigno_menos10000_excepcion() throws Exception {
		boolean resultado;
		Cuenta cuenta = new Cuenta(15263424548l);
		
		try {
			cuenta.consignar(-10000);
			resultado = false;
		} catch (Exception e) {
			resultado = true;
		}
		
		assertTrue(resultado);
	}
	
	@Test
	public void saldo_10000_retiro_1000_saldo_9000() throws Exception {
		Cuenta cuenta = new Cuenta(15263424548l);
		
		cuenta.consignar(10000);
		cuenta.retirar(1000);
		
		assertEquals(9000, cuenta.getSaldo());
	}
	
	@Test
	public void saldo_10000_retiro_menos1000_excepcion() throws Exception {
		boolean resultado;
		Cuenta cuenta = new Cuenta(15263424548l);
		
		try {
			cuenta.consignar(10000);
			cuenta.retirar(-1000);
			resultado = false;
		} catch (Exception e) {
			resultado = true;
		}
		
		assertTrue(resultado);
	}
}
