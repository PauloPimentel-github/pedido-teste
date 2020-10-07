package com.phpimentel.chain;

/**
 * Design Pattern - Chain of Responsibility
 * @author phpimentel
 *
 */
public class CalculaDescontoTerceiraFaixa extends CalculaFaixaDescontoChain {

	public CalculaDescontoTerceiraFaixa(CalculaFaixaDescontoChain proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if (valorTotal > 1000.0) 
			return valorTotal * 0.08;
		
		return -1;
	}

}
