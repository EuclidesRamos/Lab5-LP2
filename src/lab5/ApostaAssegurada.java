package lab5;

/**
 * Classe responsavel pelas apostas que sao asseguradas.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class ApostaAssegurada extends Aposta {

	/**
	 * Atributo que armazena o seguro da aposta.
	 */
	private Seguro seguro;

	/**
	 * Construtor responsavel por construir as apostas asseguradas por valor.
	 * 
	 * @param apostador
	 * @param valor
	 * @param previsao
	 * @param valorAssegurado
	 */
	public ApostaAssegurada(String apostador, int valor, String previsao, int valorAssegurado) {
		super(apostador, valor, previsao);
		if (apostador.trim().equals("") || apostador.equals(null)) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		} else if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		} else if (previsao.trim().equals("") || previsao.equals(null)) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		} else if (!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		} 
		this.seguro = new SeguroPorValor(valorAssegurado);
	}
	
	/**
	 * Construtor responsavel por construir as apostas asseguradas por taxa.
	 * 
	 * @param apostador
	 * @param valor
	 * @param previsao
	 * @param taxa
	 */
	public ApostaAssegurada(String apostador, int valor, String previsao, double taxa) {
		super(apostador, valor, previsao);
		if (apostador.trim().equals("") || apostador.equals(null)) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		} else if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		} else if (previsao.trim().equals("") || previsao.equals(null)) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		} else if (!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		} 
		this.seguro = new SeguroPorTaxa(taxa);
	}
	
	/**
	 * Metodo que sobrescreve o metodo da classe pai. Retorna uma representacao em String da aposta.
	 */
	@Override
	public String toString() {
		return super.toString() + seguro.toString();
	}
	
	/**
	 * Metodo que sobrescreve o metodo da classe pai. Altera o seguro da aposta (De seguro por taxa para seguro por valor).
	 */
	@Override
	public void setSeguroPorValor(int valor) {
		this.seguro = new SeguroPorValor(valor);
	}
	
	/**
	 * Metodo que sobrescreve o metodo da classe pai. Altera o seguro da aposta (De seguro por valor para seguro por taxa).
	 */
	@Override
	public void setSeguroPorTaxa(double taxa) {
		this.seguro = new SeguroPorTaxa(taxa);
	}
	
	/**
	 * Metodo que sobrescreve o metodo da classe pai. Calcula os gastos com seguro da aposta.
	 */
	@Override
	public int gastosSeguro() {
		if (this.seguro.toString().endsWith("%")) {
			return (int) (this.seguro.getTaxa() * super.getValor());
		} else {
			return this.seguro.getValorAssegurado();
		}
	}
}
