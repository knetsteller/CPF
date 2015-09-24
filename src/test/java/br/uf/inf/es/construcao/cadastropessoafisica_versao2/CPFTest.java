
package br.uf.inf.es.construcao.cadastropessoafisica_versao2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CPFTest {
    
    public CPFTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of verificaCPF method, of class CPF.
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testNumeroCaracteresDiferenteDeOnze() {
        System.out.println("verificaCPF");
        int[] cpf = {5, 1, 7, 1, 8};
        CPF.verificaCPF(cpf);
    }
    
    @Test
    public void testVerificaCPFValido() {
        System.out.println("verificaCPF");
        int[] cpf = {5, 1, 7, 1, 8, 5, 2, 6, 0, 0, 8};
        boolean expResult = true;
        boolean result = CPF.verificaCPF(cpf);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testVerificaCPFInvalido() {
        System.out.println("verificaCPF");
        int[] cpf = {0, 0, 6, 0, 6, 9, 9, 0, 0, 0, 0};
        boolean expResult = false;
        boolean result = CPF.verificaCPF(cpf);
        assertEquals(expResult, result);
    }

    @Test
    public void testAjustaIndicesCPF() {
        System.out.println("ajustaIndicesCPF");
        int[] cpf = {5, 1, 7, 1, 8, 5, 2, 6, 0, 0, 8};
        int[] expResult = {0, 5, 1, 7, 1, 8, 5, 2, 6, 0, 0, 8};;
        int[] result = CPF.ajustaIndicesCPF(cpf);
        assertArrayEquals(expResult, result);        
    }
    
}
