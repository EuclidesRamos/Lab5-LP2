package lab5;

import java.util.Comparator;

/**
 * Classe responsavel por definir a comparacao entre cenarios atraves da quantidade de apostas dos cenarios. Ela implementa metodos da classe Comparator.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class ApostasComparator implements Comparator<Cenario> {

	/**
	 * Metodo que verifica qual cenario vem primeiro na ordenacao, por meio da quantidade de apostas de cada cenario.
	 */
	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		if (cenario1.quantidadeDeApostas() == cenario2.quantidadeDeApostas()) {
			return cenario1.getIdentificacao() - cenario2.getIdentificacao();
		}
		return cenario2.quantidadeDeApostas() - cenario1.quantidadeDeApostas();
	}

}
