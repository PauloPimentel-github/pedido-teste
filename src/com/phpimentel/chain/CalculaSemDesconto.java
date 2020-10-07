package com.phpimentel.chain;

/**
 * Design Pattern - Chain of Responsibility
 * @author phpimentel
 *
 */
public class CalculaSemDesconto extends CalculaFaixaDescontoChain {

	public CalculaSemDesconto(CalculaFaixaDescontoChain proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		return 0;
	}

}
