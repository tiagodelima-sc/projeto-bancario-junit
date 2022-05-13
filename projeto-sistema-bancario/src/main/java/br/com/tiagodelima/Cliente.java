package br.com.tiagodelima;

/**
 * Cliente do banco tendo os seguintes requisitos:
 * 
 * - Ao cadastrar um cliente, deve ser criada ao menos uma conta.
 * - N�o deve-se excluir um cliente se este tiver contas cadastradas.
 * 
 */
public class Cliente implements Cadastro {

    private long id;
    private String cpf;
    private String nome;

    //@Override
    public long getId() {
        // TODO: Voc� precisa implementar este m�todo
        return 0;
    }

    //@Override
    public void setId(long id) {
        // TODO: Voc� precisa implementar este m�todo
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isCpfValido(String cpf) {
        // Remove caracteres n�o num�ricos do CPF
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            return false;
        }

        final String d1 = Util.calculaDigitoModulo11(cpf, 9);
        final String d2 = Util.calculaDigitoModulo11(cpf, 10);

        /* Converte os d�gitos calculados de int para String e une (concatena) 
        os dois numa s� String.*/
        final String digVerificadorCalculado = d1 + d2;

        // Copia os 2 �ltimos d�gitos do CPF informado, pra comparar com os d�gitos calculados
        final String digVerificadorExistente = cpf.substring(cpf.length() - 2);

        /* Compara os 2 �ltimos d�gitos do CPF com os 2 calculados. 
           Se forem iguais, o CPF � v�lido. */
        return digVerificadorExistente.equals(digVerificadorCalculado);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}