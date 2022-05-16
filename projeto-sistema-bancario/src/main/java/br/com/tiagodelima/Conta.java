package br.com.tiagodelima;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma conta banc�ria de um determinado {@link Cliente}, tendo os
 * seguintes requisitos:
 */
public class Conta implements Cadastro {

    private long id;
    private String numero;
    private boolean poupanca;
    private boolean especial;
    private double saldo;
    private double limite;
    private List<Movimentacao> movimentacoes = new ArrayList();

    public Conta() {
        // TODO: Voc� precisa implementar este m�todo
    }

    public Conta(Agencia agencia, boolean especial, final double limite) {
        // TODO: Voc� precisa implementar este m�todo
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void addMovimentacao(Movimentacao movimentacao) {
        if(movimentacao.isConfirmada()) {
        	if(movimentacao.getTipo() == "Credito") {
        		saldo += movimentacao.getValor();
        	} else if (movimentacao.getTipo() == "Debito") {
        		saldo -= movimentacao.getValor();
        	}
        }
    }

    public double getSaldoTotal() {
        return saldo + limite;
    }

    public void saque(final double valor) {

    }

    public void depositoDinheiro(final double valor) {
        Movimentacao movimentacao = new Movimentacao(this);
        movimentacao.setConfirmada(true);
        movimentacao.setTipo("Credito");
        movimentacao.setValor(valor);
        saldo += valor;
        movimentacoes.add(movimentacao);
    }

    public void depositoCheque(final double valor) {
        // TODO: Voc� precisa implementar este m�todo
    }

    //@Override
    public long getId() {
        return id;
    }

    //@Override
    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
    	//Verificando se o numero tem 5 digitos, 1 hifen e 1 digito no final
    	if(!numero.matches("\\d{5}-\\d")) {
    		throw new IllegalArgumentException("Numero Invalido. Digite no formato correto: 00000-0");
    	}
        this.numero = numero;
    }

    public boolean isPoupanca() {
        return poupanca;
    }

    public void setPoupanca(boolean poupanca) {
        this.poupanca = poupanca;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
    	if(!especial && limite > 0) {
    		throw new IllegalStateException("Somente contas especiais podem ter limite");
    	}
        this.limite = limite;
    }
}
