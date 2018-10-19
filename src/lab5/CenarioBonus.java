package lab5;

import java.text.DecimalFormat;

/**
 * Classe responsavel pelo gerenciamento dos cenarios que possuem bonus.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class CenarioBonus extends Cenario{

	/**
	 * Atributo que armazena o valor do bonus do cenario.
	 */
	private double bonus;
	
	/**
	 * Construtor responsavel por construir um cenario que possui bonus.
	 * 
	 * @param descricao
	 * @param identificacao
	 * @param bonus
	 */
	public CenarioBonus(String descricao, int identificacao, int bonus) {
		super(descricao, identificacao);
		if (bonus <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
		this.bonus = (double)bonus / 100;		
	}
	
	/**
	 * Metodo que sobrescreve o da classe pai. Retorna uma representacao em String do cenario que possui bonus.
	 */
	@Override
	public String toString() {
		DecimalFormat formato = new DecimalFormat("0.00");
		return super.toString() + " - R$ " + formato.format(this.bonus);
	}
	
	/**
	 * Metodo que sobrescreve o da classe pai. Retorna o bonus do cenario.
	 */
	@Override
	public double getBonus() {
		return this.bonus;
	}
}
