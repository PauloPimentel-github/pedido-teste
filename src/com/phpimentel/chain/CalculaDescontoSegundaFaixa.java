package com.phpimentel.chain;

/**
 * Design Pattern - Chain of Responsibility
 * @author phpimentel
 *
 */
public class CalculaDescontoSegundaFaixa extends CalculaFaixaDescontoChain {

	public CalculaDescontoSegundaFaixa(CalculaFaixaDescontoChain proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if (valorTotal > 800.0 && valorTotal <= 1000.0)
			return valorTotal * 0.06;
		
		return -1;
	}

}
