package com.phpimentel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.phpimentel.chain.CalculaDescontoPrimeiraFaixa;
import com.phpimentel.chain.CalculaDescontoSegundaFaixa;
import com.phpimentel.chain.CalculaDescontoTerceiraFaixa;
import com.phpimentel.chain.CalculaFaixaDescontoChain;
import com.phpimentel.chain.CalculaSemDesconto;

public class PedidoTest {
	
	private Pedido pedido;
	
	@Before
	public void setup() {
		CalculaFaixaDescontoChain calculaFaixaDescontoChain =
				new CalculaDescontoTerceiraFaixa(
					new CalculaDescontoSegundaFaixa(
						new CalculaDescontoPrimeiraFaixa(
							new CalculaSemDesconto(null))));
		
		this.pedido = new Pedido(calculaFaixaDescontoChain);
	}
	
	@Test
	public void deveAdicionarUmItemNoPedido() throws Exception {
		this.pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 10));
	}
	
	@Test
	public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		this.assertResumoPedido(0.0, 0.0);
	}
	
	@Test
	public void deveCalcularResumoParaUmItemSemDesconto() throws Exception {
		this.pedido.adicionarItem(new ItemPedido("Sabonete", 5.0, 5));
		this.assertResumoPedido(25.0, 0.0);
	}
	
	@Test
	public void deveCalcularResumoParaDoisItensSemDesconto() throws Exception {
		this.pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 3));
		this.pedido.adicionarItem(new ItemPedido("Pasta Dental", 7.0, 3));
		
		this.assertResumoPedido(30.0, 0.0);
	}
	
	@Test
	public void deveAplicarDescontoNa1aFaixa() throws Exception {
		this.pedido.adicionarItem(new ItemPedido("Creme", 20.0, 20));
		
		this.assertResumoPedido(400.0, 16.0);
	}
	
	@Test
	public void deveAplicarDescontoNa2aFaixa() throws Exception {
		this.pedido.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
		this.pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));
		
		this.assertResumoPedido(900.0, 54.0);
	}
	
	@Test
	public void deveAplicarDescontoNa3aFaixa() throws Exception {
		this.pedido.adicionarItem(new ItemPedido("Creme", 15.0, 30));
		this.pedido.adicionarItem(new ItemPedido("Shampoo", 10.0, 30));
		this.pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));
		
		this.assertResumoPedido(1200.0, 96.0);
	}

	private void assertResumoPedido(double valorTotal, double desconto) {
		ResumoPedido resumoPedido = this.pedido.resumo();
		
		assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.0001);
		assertEquals(desconto, resumoPedido.getDesconto(), 0.0001);
	}
	
}
