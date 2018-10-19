package lab5;

import java.util.Comparator;

/**
 * Classe responsavel por definir a comparacao entre cenarios por meio da descricao do cenario. Ela implementa metodos da classe Comparator.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class DescricaoComparator implements Comparator<Cenario>{
	
	/**
	 * Metodo que compara a descricao de dois cenarios.
	 */
	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		if (cenario1.getDescricao().equals(cenario2.getDescricao())) {
			return cenario1.getIdentificacao() - cenario2.getIdentificacao();
		}
		return cenario1.getDescricao().compareTo(cenario2.getDescricao());
	}

}
