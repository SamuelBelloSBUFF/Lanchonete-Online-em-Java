package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
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
    public void testSalvarLanche() throws ServletException, IOException {
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
        
        Assert.assertEquals(true,true);
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
