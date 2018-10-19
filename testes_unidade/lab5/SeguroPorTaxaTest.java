package lab5;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class SeguroPorTaxaTest {

	private SeguroPorTaxa seguro;

	@Before
	public void exemploSeguroPorTaxa() {
		this.seguro = new SeguroPorTaxa(0.25);
	}
	@Test
	public void testToString() {
		assertEquals(" - ASSEGURADA (TAXA) - 25%", this.seguro.toString());
	}

	@Test
	public void testGetValorAssegurado() {
		assertEquals(0, this.seguro.getValorAssegurado());
	}

	@Test
	public void testGetTaxa() {
		assertEquals((int) (0.25 * 100),(int) (this.seguro.getTaxa() * 100));
	}
}
