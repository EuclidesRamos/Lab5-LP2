package lab5;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class CenarioControllerTest {

	private CenarioController controller;
	
	@Before
	public void exemploController() {
		this.controller = new CenarioController(0, 0.01);
		this.controller.cadastraCenario("A maioria irá tirar mais do que 7 na prova!");
		this.controller.cadastraCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastraCenario("Teste");
		this.controller.cadastraCenario("Mais um teste");
		this.controller.cadastraAposta(1, "Matheus", 1000, "VAI ACONTECER");
		this.controller.cadastraAposta(1, "Matheus", 1000, "N VAI ACONTECER");
		this.controller.cadastraAposta(3, "Matheus", 300, "N VAI ACONTECER");
		this.controller.cadastraAposta(3, "Matheus", 300, "VAI ACONTECER");
		this.controller.fecharAposta(3, true);
		this.controller.fecharAposta(4, false);
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCenarioControllerCaixaInvalido() {
		controller = new CenarioController(-1, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCenarioControllerTaxaInvalida() {
		controller = new CenarioController(0, -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCenarioControllerInvalido() {
		controller = new CenarioController(-1, -1);
	}
	
	@Test
	public void testCadastraCenario() {
		assertEquals(5, controller.cadastraCenario("Teste"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraCenarioVazio() {
		controller.cadastraCenario("");
	}
	
	@Test 
	public void testCadastraCenarioBonus() {
		assertEquals(5, controller.cadastraCenario("Cenario Bonus", 1000));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraCenarioBonusInvalido() {
		controller.cadastraCenario("Cenario Bonus", 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraCenarioBonusDescricaoVazia() {
		controller.cadastraCenario("   ", 1000);
	}

	@Test
	public void testExibeCenario() {
		assertEquals("1 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado", controller.exibeCenario(1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExibeCenarioIdentificacaoInvalida() {
		controller.exibeCenario(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExibeCenarioInexistente() {
		controller.exibeCenario(10);
	}

	@Test
	public void testExibeCenarios() {
		assertEquals("1 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado" + System.lineSeparator() + "2 - O professor irá para a aula sobre GRASP com um café! - Nao finalizado" + System.lineSeparator() + "3 - Teste - Finalizado (ocorreu)" + System.lineSeparator() + "4 - Mais um teste - Finalizado (n ocorreu)" + System.lineSeparator(), controller.exibeCenarios());
	}

	@Test
	public void testCadastraAposta() {
		controller.cadastraAposta(1, "Matheus", 100, "N VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaCenarioInvalido() {
		controller.cadastraAposta(0, "Matheus", 100, "N VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaCenarioInexistente() {
		controller.cadastraAposta(10, "Matheus", 100, "N VAI ACONTECER");
	}

	@Test
	public void testValorTotalDeApostas() {
		assertEquals(2000, controller.valorTotalDeApostas(1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorTotalDeApostasCenarioInvalido() {
		controller.valorTotalDeApostas(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorTotalDeApostasCenarioInexistente() {
		controller.valorTotalDeApostas(10);
	}

	@Test
	public void testTotalDeApostas() {
		assertEquals(2, controller.totalDeApostas(1));
	}
	
	@Test
	public void testTotalDeApostasZerado() {
		assertEquals(0, controller.totalDeApostas(2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalDeApostasCenarioInvalido() {
		controller.totalDeApostas(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalDeApostasCenarioInexistente() {
		controller.totalDeApostas(10);
	}

	@Test
	public void testExibeApostas() {
		assertEquals("Matheus - R$1000,00 - VAI ACONTECER" + System.lineSeparator() + "Matheus - R$1000,00 - N VAI ACONTECER" + System.lineSeparator(), controller.exibeApostas(1));
	}
	
	@Test
	public void testExibeApostasZerado() {
		assertEquals("", controller.exibeApostas(2));
	}
	
	@Test
	public void testFecharAposta() {
		controller.fecharAposta(1, true);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFecharApostaCenarioInvalido() {
		controller.fecharAposta(0, true);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFecharApostaCenarioInexistente() {
		controller.fecharAposta(10, true);
	}
	
	@Test
	public void testGetCaixaCenario() {
		assertEquals(3, controller.getCaixaCenario(3));
	}
	
	@Test
	public void testGetCaixaCenarioVazio() {
		assertEquals(0, controller.getCaixaCenario(4));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetCaixaCenarioAberto() {
		controller.getCaixaCenario(1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetCaixaCenarioInvalido() {
		controller.getCaixaCenario(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetCaixaCenarioInexistente() {
		controller.getCaixaCenario(10);
	}
	
	@Test
	public void testGetRateioTotal() {
		assertEquals(297, controller.getRateioTotal(3));
	}
	
	@Test
	public void testGetRateioTotalVazio() {
		assertEquals(0, controller.getRateioTotal(4));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetRateioTotalCenarioInvalido() {
		controller.getRateioTotal(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetRateioTotalCenarioInexistente() {
		controller.getRateioTotal(10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetRateioTotalCenarioAberto() {
		controller.getRateioTotal(1);
	}
	
	@Test
	public void testGetCaixa() {
		this.controller.getCaixaCenario(3);
		assertEquals(3, this.controller.getCaixa());
	}
	
	@Test
	public void testCadastraApostaSeguraValor() {
		assertEquals(3, this.controller.cadastraApostaSeguraValor(1, "Matheus", 100, "N VAI ACONTECER", 20, 10));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaSeguraValorCenarioInvalido() {
		this.controller.cadastraApostaSeguraValor(0, "Matheus", 100, "N VAI ACONTECER", 20, 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaSeguraValorCenarioNaoCadastrado() {
		this.controller.cadastraApostaSeguraValor(10, "Matheus", 100, "N VAI ACONTECER", 20, 10);
	}
	
	@Test
	public void testCadastraApostaSeguraTaxa() {
		this.controller.cadastraApostaSeguraTaxa(1, "Matheus", 100, "N VAI ACONTECER", 0.2, 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaSeguraTaxaCenarioInvalido() {
		this.controller.cadastraApostaSeguraTaxa(0, "Matheus", 100, "N VAI ACONTECER", 0.2, 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaSeguraTaxaCenarioNaoCadastrado() {
		this.controller.cadastraApostaSeguraTaxa(10, "Matheus", 100, "N VAI ACONTECER", 0.2, 10);
	}
	
	@Test
	public void testAlteraSeguroValor() {
		this.controller.cadastraApostaSeguraTaxa(1, "Matheus", 100, "N VAI ACONTECER", 0.3, 10);
		assertEquals(3, this.controller.alteraSeguroValor(1, 3, 20));
	}
	
	@Test
	public void testAlteraSeguroTaxa() {
		this.controller.cadastraApostaSeguraValor(1, "Matheus", 100, "N VAI ACONTECER", 20, 10);
		assertEquals(3, this.controller.alteraSeguroTaxa(1, 3, 0.3));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAlteraOrdem() {
		this.controller.alteraOrdem("aleatorio");
	}
	
	@Test
	public void testExibeCenarioOrdenadoPorNome() {
		this.controller.alteraOrdem("nome");
		assertEquals("4 - Mais um teste - Finalizado (n ocorreu)", this.controller.exibirCenarioOrdenado(2));
	}
	
	@Test
	public void testExibeCenarioOrdenadoPorApostas() {
		this.controller.alteraOrdem("apostas");
		assertEquals("1 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado", this.controller.exibirCenarioOrdenado(1));
	}
	
	@Test
	public void testExibeCenarioOrdenadoPorCadastro() {
		this.controller.alteraOrdem("cadastro");
		assertEquals("4 - Mais um teste - Finalizado (n ocorreu)", this.controller.exibirCenarioOrdenado(4));
	}
}
