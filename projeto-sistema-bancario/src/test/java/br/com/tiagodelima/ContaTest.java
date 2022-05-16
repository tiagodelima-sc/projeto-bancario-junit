package br.com.tiagodelima;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContaTest {

	//Verificando se o numero esta sendo atribuido corretamente
	@Test
	void testVerificandoNumeroValido() {

		final Conta digitos = new Conta();
		final String resultadoEsperado = "12345-7";
		
		digitos.setNumero(resultadoEsperado);
		final String resultadoObtido = digitos.getNumero();
		
		assertEquals(resultadoEsperado, resultadoObtido);
	}
	
	//Verificando se o numero atribuido esta dentro do requisito do sistema '00000-0'
	@Test
	void testVerificandoNumeroInvalido_Excessao() {

		final Conta digitos = new Conta();
		final String invalido = "123-7";
		
		assertThrows(IllegalArgumentException.class, () -> digitos.setNumero(invalido) );
	}
	
	//Verificando se o valor invalido foi armazenado no objeto
	@Test
	void testVerificandoNumeroInvalido_NaoArmazenado() {

		final Conta digitos = new Conta();
		final String invalido = "123";
		
		assertThrows(IllegalArgumentException.class, () -> digitos.setNumero(invalido) );
		
		final String resultadoObtido = digitos.getNumero();
		
		assertNotEquals(invalido, resultadoObtido);
	}
	
	//Verificando se o metodo isPoupanca retorna false
	@Test 
	void testVerificandoMetodoPoupanca_RetornaFalso(){
		
		final Conta poupanca = new Conta();
		assertFalse(poupanca.isPoupanca());
	}
	
	//Verificando se as contas especiais podem ter limite de saldo
	@Test
	void testAtribuindoLimiteConta_Especial() {
		
		final Conta contaEspecial = new Conta();
		contaEspecial.setEspecial(true);
		final double resultadoEsperado = 1000;
		contaEspecial.setLimite(resultadoEsperado);
		
		final double resultadoObtido = contaEspecial.getLimite();
		
		assertEquals(resultadoEsperado, resultadoObtido);
	}
	
	//Verificando se as contas normais podem ter limite de saldo
	@Test
	void testAtribuindoLimiteConta_NaoEspecial() {
		
		final Conta conta = new Conta();
		final double resultadoEsperado = 1000;
			
		//Estado do objeto nao E valido
		assertThrows(IllegalStateException.class, () -> conta.setLimite(resultadoEsperado));
	}
		
	//Verificando se o historico de movimentacao da conta inicia com uma lista vazia e nao null
	@Test
	void testVerificandoSeAlistaEvazia() {
			
		final Conta historicoMovimentacao = new Conta();
		assertNotNull(historicoMovimentacao.getMovimentacoes());
	}
	
	//Verificando o metodo de adicionar uma movimentacao na conta atraves do credito
	@Test
	void testAdicionandoNovaMovimentacao_Credito() {
		
		Conta movimentacao = new Conta();
		Movimentacao mov = new Movimentacao(movimentacao);
		
		mov.setConfirmada(true);
		mov.setTipo("Credito");
		final double resultadoEsperado = 100.50;
		mov.setValor(resultadoEsperado);
		movimentacao.addMovimentacao(mov);
		
		assertEquals(resultadoEsperado, movimentacao.getSaldo());
	}
	
	//Verificando o metodo de adicionar uma movimentacao na conta atraves do debito
	@Test
	void testAdicionandoNovaMovimentacao_Debito() {
		
		Conta movimentacao = new Conta();
		Movimentacao mov = new Movimentacao(movimentacao);
		
		mov.setConfirmada(true);
		mov.setTipo("Debito");
		final double valor = 100.50;
		final double resultadoEsperado = -valor;
		mov.setValor(valor);
		movimentacao.addMovimentacao(mov);
		
		assertEquals(resultadoEsperado, movimentacao.getSaldo());
	}
	
	//Verificando saldo total da conta especial
	@Test
	void testPegarSaldoTotal_ContaEspecial() {
		
		final double limite = 500;
		final double resultadoEsperado = limite;
		
		//Contas acabadas de ser criadas, devem ter saldo 0
		final Conta saldoTotal = new Conta();
		//Definindo conta especial e atribuindo limite
		saldoTotal.setEspecial(true);
		saldoTotal.setLimite(limite);
		
		final double resultadoObtido = saldoTotal.getSaldoTotal(); 
		
		assertEquals(resultadoEsperado, resultadoObtido);
	}
	
	//Verfificando se o deposito de dinheiro foi concluido com sucesso
	@Test
	void testDepositoDinheiro() {
		
		final double limite = 500.6;
		final double deposito = 500.8;
		final double resultadoEsperado = 1001.4;
		
		final Conta depositoDinheiro = new Conta();
		depositoDinheiro.setEspecial(true);
		depositoDinheiro.setLimite(limite);
		depositoDinheiro.depositoDinheiro(deposito);
		
		final double resultadoObtido = depositoDinheiro.getSaldoTotal();
		assertEquals(resultadoEsperado, resultadoObtido, 0.001);
	}
		

}
