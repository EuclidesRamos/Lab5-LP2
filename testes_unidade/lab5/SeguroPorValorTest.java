package lab5;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class SeguroPorValorTest {

	private SeguroPorValor seguro;

	@Before
	public void exemploSeguroPorValor() {
		this.seguro = new SeguroPorValor(20);
	}
	
	@Test
	public void testToString() {
		assertEquals(" - ASSEGURADA (VALOR) - R$20,00", this.seguro.toString());
	}

	@Test
	public void testGetValorAssegurado() {
		assertEquals(20, this.seguro.getValorAssegurado());
	}

	@Test
	public void testGetTaxa() {
		assertEquals(0, (int) (this.seguro.getTaxa()));
	}

}
