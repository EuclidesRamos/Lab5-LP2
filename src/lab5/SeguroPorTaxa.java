package lab5;

/**
 * Classe responsavel pelos seguros por taxa das apostas.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class SeguroPorTaxa implements Seguro {
	
	/**
	 * Atributo que armazena a taxa assegurada da aposta.
	 */
	private double taxa;

	/**
	 * Construtor responsavel por construir o seguro por taxa da aposta.
	 * 
	 * @param taxa
	 */
	public SeguroPorTaxa(double taxa) {
		this.taxa = taxa;
	}
	
	/**
	 * Metodo que sobrescreve o metodo da classe pai. Retorna uma representacao em String do seguro.
	 */
	@Override
	public String toString() {
		return " - ASSEGURADA (TAXA) - " + (int) (this.taxa * 100) + "%";
	}

	/**
	 * Metodo que sobrescreve o metodo da classe pai. Retorna o seguro por valor. Sempre será 0, para esse tipo.
	 */
	@Override
	public int getValorAssegurado() {
		return 0;
	}

	/**
	 * Metodo que sobrescreve o metodo da classe pai. Retorna a taxa assegurada.
	 */
	@Override
	public double getTaxa() {
		return this.taxa;
	}

}
