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
		

}
