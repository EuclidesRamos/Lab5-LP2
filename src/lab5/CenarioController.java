package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsavel por controlar a classe Cenario, realizando algumas funcoes.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class CenarioController {

	/**
	 * Atributo responsavel por armazenar o objeto cenario.
	 */
	private Cenario cenario;
	
	/**
	 * ArrayList responsavel por armazenar todos os cenarios do sistema.
	 */
	private Map<Integer,Cenario> cenarios;
	
	/**
	 * Atributo responsavel por guardar os valores do caixa do sistema.
	 */
	private int caixa;
	
	/**
	 * Atributo responsavel por armazenar a taxa instanciada pelo usuario.
	 */
	private double taxa;

	/**
	 * Atributo responsável por informar a ordem em que os cenarios serao expressos.
	 */
	private Comparator<Cenario> estrategiaOrdenacao;
	
	/**
	 * Metodo responsavel por gerar a identificacao para cada cenario.
	 * 
	 * @return
	 */
	private int Identificacao() {
		int id = 1;
		if (this.cenarios.size() >= 1) {
			for (int cenario : this.cenarios.keySet()) {
				id = cenario + 1;
			}
		}
		return id;
	}
	
	/**
	 * Construtor responsavel por construir o controller, instanciando o valor inicial do caixa e a taxa do sistema. Alï¿½m disso, cria um ArrayList, para armazenar os cenï¿½rios.
	 * 
	 * @param caixa
	 * @param taxa
	 */
	public CenarioController(int caixa, double taxa) {
		if (caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		} else if (taxa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		this.cenarios = new HashMap<>();
		this.caixa = caixa;
		this.taxa = taxa;
		this.estrategiaOrdenacao = new CadastroComparator();
	}
	
	/**
	 * Metodo responsavel por cadastrar um novo cenario no sistema.
	 * 
	 * @param descricao
	 * @return
	 */
	public int cadastraCenario(String descricao) {
		int identificacao = Identificacao();
		cenario = new Cenario(descricao, identificacao);
		this.cenarios.put(identificacao, cenario);
		return identificacao;
	}

	/**
	 * Metodo responsavel por cadastrar um cenario que possui valor bonus para os apostadores.
	 * 
	 * @param descricao
	 * @param bonus
	 * @return
	 */
	public int cadastraCenario(String descricao, int bonus) {
		int identificacao = Identificacao();
		cenario = new CenarioBonus(descricao, identificacao, bonus);
		this.cenarios.put(identificacao, cenario);
		this.caixa -= bonus;
		return identificacao;
	}
	
	/**
	 * Metodo responsavel por exibir as informacoes de um cenario, em forma de String.
	 * 
	 * @param identificacao
	 * @return
	 */
	public String exibeCenario(int identificacao) {
		if (identificacao <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		} else if (!this.cenarios.containsKey(identificacao)) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return this.cenarios.get(identificacao).toString();
	}
	
	/**
	 * Metodo responsavel por exibir informacoes detalhadas de cada cenario cadastrado no sistema.
	 * 
	 * @return
	 */
	public String exibeCenarios() {
		String saida = "";
		for (Cenario cenario : this.cenarios.values()) {
			saida += cenario.toString() + System.lineSeparator();
		}
		return saida;
	}
	
	/**
	 * Metodo responsavel por cadastrar uma nova aposta e aloca-la em um cenario, de acordo com a entrada do usuario.
	 * 
	 * @param cenario
	 * @param apostador
	 * @param valor
	 * @param previsao
	 */
	public void cadastraAposta(int cenario, String apostador, int valor, String previsao) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		} else if (!this.cenarios.containsKey(cenario)) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		this.cenarios.get(cenario).cadastraAposta(apostador, valor, previsao);
	}

	/**
	 * Metodo responsavel por calcular o valor total, em reais, de apostas de um determinado cenario.
	 * 
	 * @param identificacao
	 * @return
	 */
	public int valorTotalDeApostas(int identificacao) {
		if (identificacao <= 0) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		} else if (!this.cenarios.containsKey(identificacao)) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return this.cenarios.get(identificacao).totalDeApostas();
	}
	
	/**
	 * Metodo responsavel por calcular a quantidade de apostas que foram cadastradas no sistema.
	 * 
	 * @param identificacao
	 * @return
	 */
	public int totalDeApostas(int identificacao) {
		if (identificacao <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		} else if (!this.cenarios.containsKey(identificacao)) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		return this.cenarios.get(identificacao).quantidadeDeApostas();
	}

	/**
	 * Metodo responsavel por exibir as informacoes detalhadas das apostas de um determinado cenario.
	 * 
	 * @param identificacao
	 * @return
	 */
	public String exibeApostas(int identificacao) {
		return this.cenarios.get(identificacao).getApostas();
	}
	
	/**
	 * Metodo responsavel por finalizar um cenario, informando se ele ocorreu ou nï¿½o ocorreu.
	 * 
	 * @param identificacao
	 * @param ocorreu
	 */
	public void fecharAposta(int identificacao, boolean ocorreu) {
		if (identificacao <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		} else if (!this.cenarios.containsKey(identificacao)) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		this.cenarios.get(identificacao).encerraCenario(ocorreu);
	}

	/**
	 * Metodo responsavel por pegar o caixa do cenario, verificando quanto que foi apurado naquele cenario especifico.
	 * 
	 * @param identificacao
	 * @return
	 */
	public int getCaixaCenario(int identificacao) {
		if (identificacao <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		} else if (!this.cenarios.containsKey(identificacao)) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		} else if (this.cenarios.get(identificacao).getEstado().equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		int caixaCenario = this.cenarios.get(identificacao).getCaixa();
		this.caixa += caixaCenario * this.taxa;
		return (int) (caixaCenario * this.taxa);
	}

	/**
	 * Metodo responsavel por chamar o metodo de cenario que calcula a quantidade do rateio que sera dividido entre os ganhadores.
	 * 
	 * @param identificacao
	 * @return
	 */
	public int getRateioTotal(int identificacao) {
		if (identificacao <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		} else if (!this.cenarios.containsKey(identificacao)) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		} else if (this.cenarios.get(identificacao).getEstado().equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		int caixaCenario = this.cenarios.get(identificacao).getCaixa();
		int rateio = (int) (caixaCenario * this.taxa);
		rateio = caixaCenario - rateio;
		this.caixa -= this.cenarios.get(identificacao).gastosSeguroAposta();
		rateio += this.cenarios.get(identificacao).getBonus() * 100;
		return rateio;
	}

	/**
	 * Metodo responsavel por pegar a quantidade, em reais, que o sistema possui no caixa.
	 * 
	 * @return
	 */
	public int getCaixa() {
		return this.caixa;
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
	public int cadastraApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorAssegurado, int custo) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		} else if (!this.cenarios.containsKey(cenario)) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");
		}
		this.caixa += custo;
		return this.cenarios.get(cenario).cadastraApostaSeguraValor(apostador, valor, previsao, valorAssegurado);
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
	public int cadastraApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa, int custo) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		} else if (!this.cenarios.containsKey(cenario)) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");
		}
		this.caixa += custo;
		return this.cenarios.get(cenario).cadastraApostaSeguraTaxa(apostador, valor, previsao, taxa);
	}

	/**
	 * Metodo responsavel por alterar o seguro da aposta (altera de seguro por taxa para seguro por valor) no sistema.
	 * 
	 * @param cenario
	 * @param apostaAssegurada
	 * @param valor
	 * @return
	 */
	public int alteraSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return this.cenarios.get(cenario).alteraSeguroValor(apostaAssegurada, valor);
	}

	/**
	 * Metodo responsavel por alterar o seguro da aposta (altera de seguro por taxa para seguro por valor) no sistema.
	 * 
	 * @param cenario
	 * @param apostaAssegurada
	 * @param taxa
	 * @return
	 */
	public int alteraSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return this.cenarios.get(cenario).alteraSeguroTaxa(apostaAssegurada, taxa);
	}

	/**
	 * Metodo responsavel por alterar a ordem de exibicao dos cenarios.
	 * 
	 * @param ordem
	 */
	public void alteraOrdem(String ordem) {
		if (ordem.trim().equals("") || ordem == null) {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		} else if (ordem.equals("nome")) {
			this.estrategiaOrdenacao = new DescricaoComparator();
		} else if (ordem.equals("apostas")) {
			this.estrategiaOrdenacao = new ApostasComparator();
		} else if (ordem.equals("cadastro")) {
			this.estrategiaOrdenacao = new CadastroComparator();
		} else {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
		}
	}

	/**
	 * Metodo responsavel por exibir o cenario ordenado.
	 * 
	 * @param cenario
	 * @return
	 */
	public String exibirCenarioOrdenado(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario invalido");
		} else if (!this.cenarios.containsKey(cenario)) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario nao cadastrado");
		}
		List<Cenario> listaCenarios = new ArrayList<>(cenarios.values());
		Collections.sort(listaCenarios, this.estrategiaOrdenacao);
		return listaCenarios.get(cenario - 1).toString();
	}
}
