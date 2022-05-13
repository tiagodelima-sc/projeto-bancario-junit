package br.com.tiagodelima;

/**
 * Representa uma institui��o banc�ria com os seguintes requisitos:
 * 
 * - Ao cadastrar um banco, deve ser criada ao menos uma ag�ncia.
 * - N�o deve-se excluir um banco se este tiver ag�ncias cadastradas.
 * 
 */
public class Banco implements Cadastro {
    private long id;
    private String nome;
    private String sigla;
    private String numero;

    //@Override
    public long getId() {
        // TODO: Voc� precisa implementar este m�todo
        return 0;
    }

    //@Override
    public void setId(long id) {
        // TODO: Voc� precisa implementar este m�todo
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
