package lab5;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class ApostaAsseguradaTest {

	private ApostaAssegurada aposta1, aposta2;

	@Before
	public void exemploApostaAssegurada() {
		this.aposta1 = new ApostaAssegurada("Matheus", 300, "VAI ACONTECER", 50);
		this.aposta2 = new ApostaAssegurada("Matheus", 100, "N VAI ACONTECER", 0.1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaAsseguradaValorApostadorVazio() {
		new ApostaAssegurada(" ", 300, "VAI ACONTECER", 50);
	}
	
	@Test(expected=NullPointerException.class)
	public void testApostaAsseguradaValorApostadorNulo() {
		new ApostaAssegurada(null, 300, "VAI ACONTECER", 50);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaAsseguradaValorInvalido() {
		new ApostaAssegurada("Matheus", 0, "VAI ACONTECER", 50);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaAsseguradaValorPrevisaoVazia() {
		new ApostaAssegurada("Matheus", 1300, "", 50);
	}
	
	@Test(expected=NullPointerException.class)
	public void testApostaAsseguradaValorPrevisaoNula() {
		new ApostaAssegurada("Matheus", 300, null, 50);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaAsseguradaValorPrevisaoInvalida() {
		new ApostaAssegurada("Matheus", 1300, "ACONTECER", 50);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaApostadorVazio() {
		new ApostaAssegurada(" ", 300, "VAI ACONTECER", 0.1);
	}
	
	@Test(expected=NullPointerException.class)
	public void testApostaAsseguradaTaxaApostadorNulo() {
		new ApostaAssegurada(null, 300, "VAI ACONTECER", 0.1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaInvalida() {
		new ApostaAssegurada("Matheus", 0, "VAI ACONTECER", 0.1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaPrevisaoVazia() {
		new ApostaAssegurada("Matheus", 1300, "", 0.1);
	}
	
	@Test(expected=NullPointerException.class)
	public void testApostaAsseguradaTaxaPrevisaoNula() {
		new ApostaAssegurada("Matheus", 300, null, 0.1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaPrevisaoInvalida() {
		new ApostaAssegurada("Matheus", 1300, "ACONTECER", 0.1);
	}
	
	@Test
	public void testToStringAsseguradoValor() {
		assertEquals("Matheus - R$300,00 - VAI ACONTECER - ASSEGURADA (VALOR) - R$50,00", this.aposta1.toString());
	}
	
	@Test
	public void testToStringAsseguradoTaxa() {
		assertEquals("Matheus - R$100,00 - N VAI ACONTECER - ASSEGURADA (TAXA) - 10%", this.aposta2.toString());
	}

	@Test
	public void testGastosSeguroValor() {
		assertEquals(50, this.aposta1.gastosSeguro());
	}
	
	@Test
	public void testGastosSeguroTaxa() {
		assertEquals(10, this.aposta2.gastosSeguro());
	}

	@Test
	public void testSetSeguroPorValor() {
		this.aposta1.setSeguroPorTaxa(0.1);
		assertEquals(30, this.aposta1.gastosSeguro());
	}

	@Test
	public void testSetSeguroPorTaxa() {
		this.aposta2.setSeguroPorValor(50);
		assertEquals(50, this.aposta2.gastosSeguro());
	}

	@Test
	public void testGetValorApostaAsseguradaPorValor() {
		assertEquals(300, this.aposta1.getValor());
	}
	
	@Test
	public void testGetValorApostaAsseguradaPorTaxa() {
		assertEquals(100, this.aposta2.getValor());
	}

	@Test
	public void testGetPrevisaoApostaAsseguradaPorValor() {
		assertEquals("VAI ACONTECER", this.aposta1.getPrevisao());
	}
	
	@Test
	public void testGetPrevisaoApostaAsseguradaPorTaxa() {
		assertEquals("N VAI ACONTECER", this.aposta2.getPrevisao());
	}
}
