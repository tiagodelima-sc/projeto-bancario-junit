package br.com.tiagodelima;

/**
 * Representa uma ag�ncia banc�ria.
 */

public class Agencia implements Cadastro{
	
	private long id;
    private Banco banco;
    private String numero;

    //@Override
    public long getId() {
        // TODO: Voc� precisa implementar este m�todo
        return 0;
    }

   // @Override
    public void setId(long id) {
        // TODO: Voc� precisa implementar este m�todo
    }

    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }

}
