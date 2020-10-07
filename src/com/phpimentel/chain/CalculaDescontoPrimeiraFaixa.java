package com.phpimentel.chain;

/**
 * Design Pattern - Chain of Responsibility
 * @author phpimentel
 *
 */
public class CalculaDescontoPrimeiraFaixa extends CalculaFaixaDescontoChain {

	public CalculaDescontoPrimeiraFaixa(CalculaFaixaDescontoChain proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if (valorTotal > 300.0 && valorTotal <= 800.0)
			return valorTotal * 0.04;
		
		return -1;
	}

}
