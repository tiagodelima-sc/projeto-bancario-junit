package br.com.tiagodelima;

/**
 * Representa uma agência bancária.
 */

public class Agencia implements Cadastro{
	
	private long id;
    private Banco banco;
    private String numero;

    //@Override
    public long getId() {
        // TODO: Você precisa implementar este método
        return 0;
    }

   // @Override
    public void setId(long id) {
        // TODO: Você precisa implementar este método
    }

    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }

}
