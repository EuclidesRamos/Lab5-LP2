package lab5;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class CenarioBonusTest {

	private CenarioBonus cenario;

	@Before
	public void exemploCenarioBonus() {
		this.cenario = new CenarioBonus("Teste", 1, 1000);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCenarioBonusInvalido() {
		new CenarioBonus("Exemplo", 2, 0);
	}
	
	@Test
	public void testToString() {
		assertEquals("1 - Teste - Nao finalizado - R$ 10,00", this.cenario.toString());
	}

	@Test
	public void testGetBonus() {
		assertEquals(10, (int) this.cenario.getBonus());
	}
}
