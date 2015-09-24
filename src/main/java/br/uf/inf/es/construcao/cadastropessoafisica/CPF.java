/**
 * Pequeno método que verifica a validade do número de Cadastro de Pessoa Física
 * fornecido.
 */
package br.uf.inf.es.construcao.cadastropessoafisica;

/**
 * @param cpf um array que representa o cpf a ser verificado
 */

public class CPF {
    
    public static boolean verificaCPF(int[] cpf) {
        
        if (cpf.length != 11) {
            throw new IllegalArgumentException("O número de caracteres é "
                    + "diferente de 11.");
        }
        
        int[] cpfAjustado = ajustaIndicesCPF(cpf);
        
        int c = 8;
        int p = cpfAjustado[9];
        int s = cpfAjustado[9];
        boolean isCPF;
        
        while (c >= 1) {            
            p += cpfAjustado[c];
            s += p;
            c--;
        }
        
        int j = (s % 11) % 10;
        int k = ((s - p + (9 * j)) % 11) % 10;
        
        if (j == cpfAjustado[10] && k == cpfAjustado[11]) {
            isCPF = true;
        } else {
            isCPF = false; 
        }
        
        return isCPF;
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
