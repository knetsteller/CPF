/*
 * Segunda versão para a implementação do método de verificação de CPF.
 */
package br.uf.inf.es.construcao.cadastropessoafisica_versao2;

public class CPF {
    
    public static boolean verificaCPF(int[] cpf) {
        
        if (cpf.length != 11) {
            throw new IllegalArgumentException("O número de caracteres é diferente"
                    + "de 11");
        }
        
        boolean isCPFValido;
        int sj;
        int sk;
        int j;
        int k;
        
        int[] cpfAjustado = ajustaIndicesCPF(cpf);
        
        sj = cpfAjustado[1] + 2 * cpfAjustado[2] + 3 * cpfAjustado[3] +
                4 * cpfAjustado[4] + 5 * cpfAjustado[5] + 
                6 * cpfAjustado[6] + 7 * cpfAjustado[7] +
                8 * cpfAjustado[8] + 7 * cpfAjustado[9];
        
        sk = cpfAjustado[2] + 2 * cpfAjustado[3] + 3 * cpfAjustado[4] +
                4 * cpfAjustado[5] + 5 * cpfAjustado[6] + 
                6 * cpfAjustado[7] + 7 * cpfAjustado[8] +
                8 * cpfAjustado[9] + 7 * cpfAjustado[10];
        
        j = (sj % 11) % 10;
        k = (sk % 11) % 10;
        
        if (j == cpfAjustado[10] && k == cpfAjustado[11]) {
            isCPFValido = true;
        } else {
            isCPFValido = false;
        }
        
        return isCPFValido;
    }
    
    // Retorna um array, sendo o elemento de índice 1, o primeiro elemento do 
    // array fornecido como cpf
    public static int[] ajustaIndicesCPF(int[] cpf) {
        
        int[] cpfAjustado = new int[12];
        int indice = 1;
        
        for (int i = 0; i <= 10; i++) {
            cpfAjustado[indice] = cpf[i];
            indice++;
        }
        
        return cpfAjustado;
    }
}
