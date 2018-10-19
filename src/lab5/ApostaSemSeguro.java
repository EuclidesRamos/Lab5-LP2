package lab5;

/**
 * Classe responsavel pelas aposta que nao possuem seguro.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class ApostaSemSeguro extends Aposta {

	/**
	 * Construtor reponsavel pela construcao de novas apostas que nao possuem seguro.
	 * 
	 * @param apostador
	 * @param valor
	 * @param previsao
	 */
	public ApostaSemSeguro(String apostador, int valor, String previsao) {
		super(apostador, valor, previsao);
		if (apostador.trim().equals("") || apostador.equals(null)) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		} else if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		} else if (previsao.trim().equals("") || previsao.equals(null)) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		} else if (!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
	}
	
	/**
	 * Metodo que sobrescreve o metodo da classe pai. Calcula os gastos com seguro da aposta.
	 */
	@Override
	public int gastosSeguro() {
		return 0;
	}
}
