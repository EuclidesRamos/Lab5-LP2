package lab5;

import java.util.Comparator;

/**
 * Classe reponsavel por comparar dois cenarios atraves da sequencia de cadastro. Ela implementa metodos da classe Comparator.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class CadastroComparator implements Comparator<Cenario> {

	/**
	 * Metodo que compara dois cenarios atraves de seu identificador.
	 */
	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		return cenario1.getIdentificacao() - cenario2.getIdentificacao();
	}

}
