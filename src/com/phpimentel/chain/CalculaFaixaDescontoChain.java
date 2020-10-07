package com.phpimentel.chain;

/**
 * Design Pattern - Chain of Responsibility
 * @author phpimentel
 *
 */
public abstract class CalculaFaixaDescontoChain {
	
	private CalculaFaixaDescontoChain proximo;

	public CalculaFaixaDescontoChain(CalculaFaixaDescontoChain proximo) {
		super();
		this.proximo = proximo;
	}
	
	public double desconto(double valorTotal) {
		double desconto = calcular(valorTotal);
		
		if (desconto == -1) 
			return this.proximo.desconto(valorTotal);
			
		return desconto;
	}
	
	protected abstract double calcular(double valorTotal);

}
