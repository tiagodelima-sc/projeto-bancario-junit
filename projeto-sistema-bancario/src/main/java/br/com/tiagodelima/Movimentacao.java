package br.com.tiagodelima;

import java.util.Objects;

/**
 * Representa uma movimentação em uma {@link Conta} bancária, que pode indicar entrada ou saída.
 */
public class Movimentacao implements Cadastro {
   
	private long id;
    private String descricao;
    private Conta conta;
    private String tipo;
    private double valor;
    private boolean confirmada;

    
    public Movimentacao(Conta conta){
        // TODO: Você precisa implementar este método
    }

    //@Override
    public long getId() {
        return id;
    }

   // @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        Objects.requireNonNull(descricao, "Descrição não pode ser nula.");

        if(descricao.trim().isEmpty()){
            throw new IllegalArgumentException("Descrição não pode ser vazia.");
        }
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

}
