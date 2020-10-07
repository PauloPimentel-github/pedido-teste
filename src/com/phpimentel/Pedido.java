package com.phpimentel;

import java.util.ArrayList;
import java.util.List;

import com.phpimentel.chain.CalculaFaixaDescontoChain;

/**
 * Classe - Pedido
 * @author phpimentel
 *
 */
public class Pedido {
	
	/* Atributos da classe */
	private List<ItemPedido> itens = new ArrayList<>();
	
	private CalculaFaixaDescontoChain calculaFaixaDescontoChain;

	/* Construtor da classe */
	public Pedido(CalculaFaixaDescontoChain calculaFaixaDescontoChain) {
		this.calculaFaixaDescontoChain = calculaFaixaDescontoChain;
	}

	
	/***** PUBLIC METHODS *****/
	
	public void adicionarItem(ItemPedido itemPedido) {
		this.itens.add(itemPedido);
	}
	
	public ResumoPedido resumo() {
		double valorTotal = itens.stream().mapToDouble(item -> item.getValorUnitario() * item.getQuantidade()).sum();
		double desconto = this.calculaFaixaDescontoChain.desconto(valorTotal);
		
		return new ResumoPedido(valorTotal, desconto);
	}
}
