package lab5;

/**
 * Classe responsavel pelos seguros por valor das apostas.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class SeguroPorValor implements Seguro {
	
	/**
	 * Atributo que armazena o valor assegurado da aposta.
	 */
	private int valor;
	
	/**
	 * Construtor responsavel por construir o seguro por valor da aposta.
	 * 
	 * @param valor
	 */
	public SeguroPorValor(int valor) {
		this.valor = valor;
	}
	
	/**
	 * Metodo que sobrescreve o metodo da classe pai. Retorna o valor assegurado.
	 */
	@Override
	public int getValorAssegurado() {
		return this.valor;
	}
	
	/**
	 * Metodo que sobrescreve o metodo da classe pai. Retorna o seguro por taxa. Sempre será 0, para esse tipo.
	 */
	@Override
	public double getTaxa() {
		return 0;
	}
	
	/**
	 * Metodo que sobrescreve o metodo da classe pai. Retorna uma representacao em String do seguro.
	 */
	@Override
	public String toString() {
		return " - ASSEGURADA (VALOR) - R$" + this.valor + ",00";
	}
}
