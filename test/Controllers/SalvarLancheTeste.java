package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author palloma.nunes
 */
public class SalvarLancheTeste {
    
    public SalvarLancheTeste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Test
    public void testSalvarLancheNulo() throws ServletException, IOException {
        salvarLanche salvarlanche = new salvarLanche();
        HttpServletRequestTeste request = new HttpServletRequestTeste();
        HttpServletResponse response = new HttpServletResponseTeste();
        
        request.setInputStream(null);

        try {
            salvarlanche.processRequest(request, response);
            fail("Não deu NullPointer");
        } catch (NullPointerException e) {
            Assert.assertEquals(true,true);
        }
        
    }
    
    @Test
    public void testSalvarLancheSucesso() throws ServletException, IOException {
        salvarLanche salvarlanche = new salvarLanche();
        HttpServletRequestTeste request = new HttpServletRequestTeste();
        HttpServletResponse response = new HttpServletResponseTeste();
        
        File file = new File("test\\Controllers\\lancheTeste.json");

        FileServletInputStream inputStream = new FileServletInputStream(file);
        
        request.setInputStream(inputStream);
        
        salvarlanche.processRequest(request, response);
        
        Assert.assertEquals(response.getHeader("resultado"), "sucesso");
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

}
