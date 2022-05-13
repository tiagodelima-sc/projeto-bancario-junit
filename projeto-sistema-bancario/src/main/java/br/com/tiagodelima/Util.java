package br.com.tiagodelima;

/**
 * Classe com fun��es de uso geral.
 */
public final class Util {

    private Util(){/**/}

    /**
     * Calcula um d�gito verificador utilizando o algoritmo <a href="https://pt.wikipedia.org/wiki/D�gito_verificador#M�dulo_11">modulo 11</a>.
     * @param numero n�mero para calcular o d�gito verificador (em formato como, por exemplo, dddd-d)
     * @return o d�gito verificador calculado
     */
    public static String calculaDigitoModulo11(final String numero) {
        /*Localiza a posi��o do h�fen no n�mero.
        * O total de algarimos a serem usados para calcular o d�gito
        * verificador ser� o valor que representa a posi��o do h�fen.*/
        final int posHifen = numero.indexOf('-');
        return calculaDigitoModulo11(numero, posHifen);
    }

    /**
     * Calcula um d�gito verificador utilizando o algoritmo <a href="https://pt.wikipedia.org/wiki/D�gito_verificador#M�dulo_11">modulo 11</a>.
     * @param numero n�mero para calcular o d�gito verificador (em formato como, por exemplo, dddd-d)
     * @param totalAlgarismos n�mero de algarismos a serem usados para calcular o d�gito verificador
     * @return o d�gito verificador calculado
     */
    public static String calculaDigitoModulo11(final String numero, final int totalAlgarismos) {
        //Copia todos os algarismos at� o total indicado
        final char[] vetor = numero.substring(0, totalAlgarismos).toCharArray();

        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            //Uma forma simples de converter int para char
            final int algarismo = vetor[i] - 48;
            soma += (vetor.length + 1 - i) * algarismo;
        }

        final int dig = 11 - (soma % 11);
        return dig > 9 ? "0" : Integer.toString(dig);
    }
}