package lab5;

import java.util.ArrayList;

/**
 * Classe responsavel pelo cenario, armazenando e gerenciando as informacoes relacionadas ao mesmo.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class Cenario {

	/**
	 * Atributo responsavel por armazenar a descricao do cenario.
	 */
	private String descricao;
	
	/**
	 * Atributo responsavel por armazenar o estado do cenario (se foi finaizado ou nao).
	 */
	private String estado;
	
	/**
	 * Atributo responsavel por armazenar a identificacao do cenario.
	 */
	private int identificacao;
	
	/**
	 * Atributo responsavel por armazenar um objeto do tipo Aposta.
	 */
	private Aposta aposta;
	
	/**
	 * ArrayList responsavel por armazenar as apostas associadas ao determinado cenario.
	 */
	private ArrayList<Aposta> apostas;
	
	/**
	 * Construtor responsavel por constuir o objeto do tipo Cenario.
	 * 
	 * @param descricao
	 * @param identificacao
	 */
	public Cenario(String descricao, int identificacao) {
		if (descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		this.descricao = descricao;
		this.estado = "Nao finalizado";
		this.identificacao = identificacao;
		this.apostas = new ArrayList<>();
	}

	/**
	 * Metodo responsavel por retornar as informacoes detalhadas acerca do cenario.
	 */
	public String toString() {
		return this.identificacao + " - " + this.descricao + " - " + this.estado;
	}
	
	/**
	 * Metodo responsavel por pegar a identificacao do cenario.
	 * 
	 * @return
	 */
	public int getIdentificacao() {
		return identificacao;
	}
	
	/**
	 * Metodo responsavel por retornar o estado que o cenario se encontra (Finalizado/Nao Finalizado)
	 * 
	 * @return
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Metodo responsavel por cadastrar uma nova aposta no sistema.
	 * 
	 * @param apostador
	 * @param valor
	 * @param previsao
	 * @return
	 */
	public void cadastraAposta(String apostador, int valor, String previsao) {
		this.aposta = new ApostaSemSeguro(apostador, valor, previsao);
		this.apostas.add(aposta);
	}

	/**
	 * Metodo responsavel por calcular o total de apostar, em reais, que um cenario possui.
	 * 
	 * @return
	 */
	public int totalDeApostas() {
		int total = 0;
		for (Aposta aposta : apostas) {
			total += aposta.getValor();
		}
		return total;
	}

	/**
	 * Metodo responsavel por gerar as informacoes de todas as apostas pertencentes a um determinado cenario.
	 * 
	 * @return
	 */
	public String getApostas() {
		String apostasStr = "";
		for (Aposta aposta : apostas) {
			apostasStr += aposta.toString() + System.lineSeparator();
		}
		return apostasStr;
	}
	
	/**
	 * Metodo responsavel por retornar a quantidade de apostas que ja foram submetidas em um determinado cenario.
	 * @return
	 */
	public int quantidadeDeApostas() {
		return this.apostas.size();
	}
	
	/**
	 * Metodo responsavel por finalizar um cenario, informando se ele ocorreu ou nao.
	 * 
	 * @param ocorreu
	 */
	public void encerraCenario(boolean ocorreu) {
		if (this.estado.equals("Finalizado (ocorreu)") || this.estado.equals("Finalizado (n ocorreu)")) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		if (ocorreu) {
			this.estado = "Finalizado (ocorreu)";
		} else {
			this.estado = "Finalizado (n ocorreu)";
		}
	}

	/**
	 * Metodo responsavel por calcular a quantidade de valores das apostas que perderam.
	 * 
	 * @return
	 */
	public int getCaixa() {
		int caixaCenario = 0;
		for (Aposta verificaAposta : apostas) {
			if (this.estado.equals("Finalizado (ocorreu)") && verificaAposta.getPrevisao().equals("N VAI ACONTECER")) {
				caixaCenario += verificaAposta.getValor();
			} else if (this.estado.equals("Finalizado (n ocorreu)") && verificaAposta.getPrevisao().equals("VAI ACONTECER")) {
				caixaCenario += verificaAposta.getValor();
			}
		}
		return caixaCenario;
	}

	/**
	 * Metodo responsavel por retornar o valor bonus do cenario.
	 * 
	 * @return
	 */
	public double getBonus() {
		return 0;
	}
	
	/**
	 * Metodo responsavel por retornar a descricao do cenario.
	 * 
	 * @return
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Metodo responsavel por cadastrar uma nova aposta assegurada por valor no sistema.
	 * 
	 * @param apostador
	 * @param valor
	 * @param previsao
	 * @param valorAssegurado
	 * @return
	 */
	public int cadastraApostaSeguraValor(String apostador, int valor, String previsao, int valorAssegurado) {
		this.apostas.add(new ApostaAssegurada(apostador, valor, previsao, valorAssegurado));
		return this.apostas.size();
	}

	/**
	 * Metodo responsavel por cadastrar uma nova aposta assegurada por taxa no sistema.
	 * 
	 * @param apostador
	 * @param valor
	 * @param previsao
	 * @param taxa
	 * @return
	 */
	public int cadastraApostaSeguraTaxa(String apostador, int valor, String previsao, double taxa) {
		this.apostas.add(new ApostaAssegurada(apostador, valor, previsao, taxa));
		return this.apostas.size();
	}

	/**
	 * Metodo responsavel por alterar o seguro da aposta (altera de seguro por taxa para seguro por valor) no sistema.
	 * 
	 * @param apostaAssegurada
	 * @param valor
	 * @return
	 */
	public int alteraSeguroValor(int apostaAssegurada, int valor) {
		this.apostas.get(apostaAssegurada - 1).setSeguroPorValor(valor);
		return apostaAssegurada;
	}

	/**
	 * Metodo responsavel por alterar o seguro da aposta (altera de seguro por taxa para seguro por valor) no sistema.
	 * 
	 * @param apostaAssegurada
	 * @param taxa
	 * @return
	 */
	public int alteraSeguroTaxa(int apostaAssegurada, double taxa) {
		this.apostas.get(apostaAssegurada - 1).setSeguroPorTaxa(taxa);
		return apostaAssegurada;
	}

	/**
	 * Metodo responsavel por calcular os gastos que houve com relacao aos seguros das apostas.
	 * 
	 * @return
	 */
	public int gastosSeguroAposta() {
		int seguros = 0;
		for (Aposta aposta : this.apostas) {
			seguros += aposta.gastosSeguro();
		}
		return seguros;
	}
}