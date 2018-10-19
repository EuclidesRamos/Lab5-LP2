package lab5;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class ApostaSemSeguroTest {

	private Aposta aposta;
	
	@Before
	public void exemploAposta() {
		this.aposta = new ApostaSemSeguro("Matheus", 1000, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaApostadorVazio() {
		new ApostaSemSeguro("", 100, "VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void testApostaApostadorNulo() {
		new ApostaSemSeguro(null, 100, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaValorInvalido() {
		new ApostaSemSeguro("Matheus", -10, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaPrevisaoVazia() {
		new ApostaSemSeguro("Matheus", 1000, "  ");
	}
	
	@Test(expected=NullPointerException.class)
	public void testApostaPrevisaoNula() {
		new ApostaSemSeguro("Matheus", 1000, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaPrevisaoInvalida() {
		new ApostaSemSeguro("Matheus", 1000, "ACONTECER");
	}

	@Test
	public void testToString() {
		assertEquals("Matheus - R$1000,00 - VAI ACONTECER", this.aposta.toString());
	}

	@Test
	public void testGetValor() {
		assertEquals(1000, this.aposta.getValor());
	}

	@Test
	public void testGetPrevisao() {
		assertEquals("VAI ACONTECER", this.aposta.getPrevisao());
	}
}
