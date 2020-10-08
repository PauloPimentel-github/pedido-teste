package com.phpimentel;

import com.phpimentel.chain.CalculaDescontoPrimeiraFaixa;
import com.phpimentel.chain.CalculaDescontoSegundaFaixa;
import com.phpimentel.chain.CalculaDescontoTerceiraFaixa;
import com.phpimentel.chain.CalculaFaixaDescontoChain;
import com.phpimentel.chain.CalculaSemDesconto;

/**
 * Test Data Builders
 * @author phpimentel
 *
 */
public class PedidoBuilder {

	private Pedido instancia;
	
	public PedidoBuilder() {
		CalculaFaixaDescontoChain calculaFaixaDescontoChain =
				new CalculaDescontoTerceiraFaixa(
					new CalculaDescontoSegundaFaixa(
						new CalculaDescontoPrimeiraFaixa(
							new CalculaSemDesconto(null))));
		
		this.instancia = new Pedido(calculaFaixaDescontoChain);
	}
	
	public PedidoBuilder comItem(double valorUnitario, int quantidade) {
		this.instancia.adicionarItem(new ItemPedido("Gerado", valorUnitario, quantidade));
		return this;
	}
	
	public Pedido construir() {
		return this.instancia;
	}
}
