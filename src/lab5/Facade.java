package lab5;

import easyaccept.EasyAccept;

/**
 * Classe de fachada. Responsavel pela "comunicacao" entre a interface e o codigo em si.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class Facade {

	/**
	 * Atributo responsavel por armazenar o controlador da classe Cenario.
	 */
	private CenarioController cenarioController;
	
	/**
	 * Metodo main, responsï¿½vel por executar os testes de aceitacao.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		args = new String[] {"lab5.Facade", "testes/us1_test.txt", "testes/us2_test.txt", "testes/us3_test.txt", "testes/us4_test.txt", "testes/us5_test.txt", "testes/us6_test.txt", "testes/us7_test.txt"};
		EasyAccept.main(args);
	}
	
	/**
	 * Metodo responsavel por inicializar o sistema de apostas, instanciando um caia inicial e uma taxa para o devido sistema.
	 * 
	 * @param caixa
	 * @param taxa
	 */
	public void inicializa(int caixa, double taxa) {
		this.cenarioController = new CenarioController(caixa, taxa);
	}
	
	/**
	 * Metodo responsavel por pegar o valor do caixa do sistema. O restorno ï¿½ do tipo inteiro, representando a quantidade em reais.
	 * 
	 * @return
	 */
	public int getCaixa() {
		return this.cenarioController.getCaixa();
	}
	
	/**
	 * Metodo responsavel por delegar, ao controller, o cadastro de novos cenarios de apostas.
	 * 
	 * @param descricao
	 * @return
	 */
	public int cadastrarCenario(String descricao) {
		return cenarioController.cadastraCenario(descricao);
	}
	
	/**
	 * Metodo responsavel por delegar, ao controller, o cadastro de novos cenarios com bonus.
	 * 
	 * @param descricao
	 * @param bonus
	 * @return
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		return cenarioController.cadastraCenario(descricao, bonus);
	}
	/**
	 * Metodo responsavel por atribuir ao controller, a funcao de exibir um determinado cenario, atraves de sua identificacao.
	 * 
	 * @param cenario
	 * @return
	 */
	public String exibirCenario(int cenario) {
		return this.cenarioController.exibeCenario(cenario);
	}
	
	/**
	 * Metodo responsavel por exibir todos os cenarios cadastrados no sistema.
	 * 
	 * @return
	 */
	public String exibirCenarios() {
		return this.cenarioController.exibeCenarios();
	}
	
	/**
	 * Metodo responsavel por delegar ao controller a funcao de cadastrar uma nova aposta no sistema.
	 * 
	 * @param cenario
	 * @param apostador
	 * @param valor
	 * @param previsao
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.cenarioController.cadastraAposta(cenario, apostador, valor, previsao);
	}
	
	/**
	 * Metodo responsavel por exibir ao usuario a quantidade total, em reais, das apostas realizadas para um determinado cenario..
	 * 
	 * @param cenario
	 * @return
	 */
	public int valorTotalDeApostas(int cenario) {
		return this.cenarioController.valorTotalDeApostas(cenario);
	}
	
	/**
	 * Metodo responsavel por informar a quantidade de apostas realizadas no sistema para um determinado cenario.
	 * 
	 * @param cenario
	 * @return
	 */
	public int totalDeApostas(int cenario) {
		return this.cenarioController.totalDeApostas(cenario);
	}
	
	/**
	 * Metodo responsavel por exibir as informacoes das apostas de um determinado cenario (usuario, valor e previsao).
	 * 
	 * @param cenario
	 * @return
	 */
	public String exibeApostas(int cenario) {
		return this.cenarioController.exibeApostas(cenario);
	}
	
	/**
	 * Metodo responsavel por finalizar um cenario, informando se ele ocorreu ou nï¿½o.
	 * 
	 * @param cenario
	 * @param ocorreu
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.cenarioController.fecharAposta(cenario, ocorreu);
	}
	
	/**
	 * Metodo responsavel por capturar o caixa de apenas um cenario especifico.
	 * 
	 * @param cenario
	 * @return
	 */
	public int getCaixaCenario(int cenario) {
		return this.cenarioController.getCaixaCenario(cenario);
	}
	
	/**
	 * Metodo responsavel por verificar a quantiade do rateio a ser distribuido pelos vencedores em um deteminado cenario.
	 * 
	 * @param cenario
	 * @return
	 */
	public int getTotalRateioCenario(int cenario) {
		return this.cenarioController.getRateioTotal(cenario);
	}
	
	/**
	 * Metodo responsavel por cadastrar uma nova aposta assegurada por valor no sistema.
	 * 
	 * @param cenario
	 * @param apostador
	 * @param valor
	 * @param previsao
	 * @param valorAssegurado
	 * @param custo
	 * @return
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorAssegurado, int custo) {
		return this.cenarioController.cadastraApostaSeguraValor(cenario, apostador, valor, previsao, valorAssegurado, custo);
	}
	
	/**
	 * Metodo responsavel por cadastrar uma nova aposta assegurada por taxa no sistema.
	 * 
	 * @param cenario
	 * @param apostador
	 * @param valor
	 * @param previsao
	 * @param taxa
	 * @param custo
	 * @return
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa, int custo) {
		return this.cenarioController.cadastraApostaSeguraTaxa(cenario, apostador, valor, previsao, taxa, custo);
	}
	
	/**
	 * Metodo responsavel por alterar o seguro da aposta (altera de seguro por taxa para seguro por valor) no sistema.
	 * 
	 * @param cenario
	 * @param apostaAssegurada
	 * @param valor
	 * @return
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return this.cenarioController.alteraSeguroValor(cenario, apostaAssegurada, valor);
	}
	
	/**
	 * Metodo responsavel por alterar o seguro da aposta (altera de seguro por taxa para seguro por valor) no sistema.
	 * 
	 * @param cenario
	 * @param apostaAssegurada
	 * @param taxa
	 * @return
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return this.cenarioController.alteraSeguroTaxa(cenario, apostaAssegurada, taxa);
	}
	
	/**
	 * Metodo responsavel por alterar a ordem de exibição do cenario.
	 * 
	 * @param ordem
	 */
	public void alterarOrdem(String ordem) {
		this.cenarioController.alteraOrdem(ordem);
	}
	
	/**
	 * Metodo responsavel por exibir um cenario ordenado.
	 * 
	 * @param cenario
	 * @return
	 */
	public String exibirCenarioOrdenado(int cenario) {
		return this.cenarioController.exibirCenarioOrdenado(cenario);
	}
}
