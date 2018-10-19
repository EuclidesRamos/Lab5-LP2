package lab5;

/**
 * Classe responsavel pelas apostas, armazenando e gerenciando as informacoes relacionadas a ela.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public abstract class Aposta {

	/**
	 * Atributo que armazena o nome do apostador.
	 */
	private String apostador;
	
	/**
	 * Atributo responsavel por armazenar o valor a ser apostado pe apostador.
	 */
	private int valor;
	
	/**
	 * Atributo responsavel por armazenar a previsao do usuario acerca de um determinado cenario.
	 */
	private String previsao;
	
	/**
	 * Construtor responsavel por construir o objeto do tipo Aposta, com seus atributos.
	 * 
	 * @param apostador
	 * @param valor
	 * @param previsao
	 */
	public Aposta(String apostador, int valor, String previsao) {
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
	}
	
	/**
	 * Metodo que retorna as informacoes detalhadas de uma determinada aposta.
	 */
	public String toString() {
		return this.apostador + " - " + "R$" + this.valor + ",00 - " + this.previsao; 
	}

	/**
	 * Metodo responsavel por retornar o valor que foi apostado.
	 * 
	 * @return
	 */
	public int getValor() {
		return this.valor;
	}
	
	/**
	 * Metodo responsavel por retornar a previsao que o apostador apostou.
	 * 
	 * @return
	 */
	public String getPrevisao() {
		return this.previsao;
	}
	
	/**
	 * Metodo abstrato que retorna os gasto com seguro de uma determinada aposta.
	 * 
	 * @return
	 */
	public abstract int gastosSeguro();
	
	/**
	 * Metodo que altera o seguro da aposta (De seguro por taxa para seguro por valor).
	 * @param valor
	 */
	public void setSeguroPorValor(int valor) {
		
	}
	
	/**
	 * Metodo que altera o seguro da aposta (De seguro por valor para seguro por taxa).
	 * @param taxa
	 */
	public void setSeguroPorTaxa(double taxa) {
		
	}
}
