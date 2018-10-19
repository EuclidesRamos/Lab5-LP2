package lab5;

/**
 * Interface responsavel pelos seguros das apostas.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public interface Seguro {

	/**
	 * Metodo abstrato que retorna uma representacao em String do seguro.
	 */
	public String toString();
	
	/**
	 * Metodo abstrato que retorna o valor assegurado da aposta.
	 * 
	 * @return
	 */
	public int getValorAssegurado();
	
	/**
	 * Metodo abstrato que retonar a taxa assegurada da aposta.
	 * @return
	 */
	public double getTaxa();
}
