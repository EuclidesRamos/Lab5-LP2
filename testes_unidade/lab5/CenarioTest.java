package lab5;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class CenarioTest {

	private Cenario cenario1, cenario2;
	
	@Before
	public void exemploCenario() {
		this.cenario1 = new Cenario("A maioria irá tirar mais do que 7 na prova!", 1);
		this.cenario2 = new Cenario("O professor irá para a aula sobre GRASP com um café!", 2);
		this.cenario1.cadastraAposta("Matheus", 100, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCenarioDescricaoVazia() {
		cenario1 = new Cenario("", 1);
	}
	
	@Test(expected=NullPointerException.class)
	public void testCenarioDescricaoNula() {
		cenario1 = new Cenario(null, 1);
	}

	@Test
	public void testToString() {
		assertEquals("1 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado", this.cenario1.toString());
	}

	@Test
	public void testGetIdentificacao() {
		assertEquals(1, this.cenario1.getIdentificacao());
	}

	@Test
	public void testGetEstado() {
		assertEquals("Nao finalizado", this.cenario1.getEstado());
	}

	@Test
	public void testCadastraAposta() {
		this.cenario1.cadastraAposta("Matheus", 100, "N VAI ACONTECER");
	}

	@Test
	public void testTotalDeApostas() {
		assertEquals(100, this.cenario1.totalDeApostas());
	}
	
	@Test
	public void testTotalDeApostasVazio() {
		assertEquals(0, this.cenario2.totalDeApostas());
	}

	@Test
	public void testGetApostas() {
		assertEquals("Matheus - R$100,00 - VAI ACONTECER" + System.lineSeparator(), this.cenario1.getApostas());
	}
	
	@Test
	public void testGetApostasVazia() {
		assertEquals("", this.cenario2.getApostas());
	}

	@Test
	public void testQuantidadeDeApostas() {
		assertEquals(1, this.cenario1.quantidadeDeApostas());
	}
	
	@Test
	public void testQuantidadeDeApostasVazia() {
		assertEquals(0, this.cenario2.quantidadeDeApostas());
	}

	@Test
	public void testEncerraCenario() {
		cenario2.encerraCenario(true);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEncerraCenarioJaEncerrado() {
		cenario2.encerraCenario(true);
		cenario2.encerraCenario(false);
	}

	@Test
	public void testGetCaixa() {
		cenario1.encerraCenario(false);
		assertEquals(100, this.cenario1.getCaixa());
	}
	
	@Test
	public void testGetCaixaZerado() {
		cenario2.encerraCenario(false);
		assertEquals(0, this.cenario2.getCaixa());
	}
	
	@Test
	public void testCadastraApostaAsseguradaSeguraValor() {
		assertEquals(2, this.cenario1.cadastraApostaSeguraValor("Matheus", 500, "N VAI ACONTECER", 70));
	}
	
	@Test
	public void testCadastraApostaAsseguradaSeguraTaxa() {
		assertEquals(2, this.cenario1.cadastraApostaSeguraTaxa("Matheus", 500, "N VAI ACONTECER", 0.2));
	}
}
