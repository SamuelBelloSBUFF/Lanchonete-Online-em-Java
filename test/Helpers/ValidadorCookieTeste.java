package Helpers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controllers.FileServletInputStream;
import Controllers.FileServletInputStream;
import Controllers.HttpServletRequestTeste;
import Controllers.HttpServletResponseTeste;
import Helpers.ValidadorCookie;
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
import java.io.IOException;
import javax.servlet.http.Cookie;

/**
 *
 * @author pedro
 */
public class ValidadorCookieTeste {
    
    private ValidadorCookie validadorCookie;

    @BeforeClass
    public void setUpClass() {
        validadorCookie = new ValidadorCookie();
    }

    
    @Test
    public void validarTokenValido() {
        Cookie[] cookies = {new Cookie("token", "token_value")};
        
        boolean resultado = validadorCookie.validar(cookies);

        Assert.assertTrue(resultado);
    }
   
    @Test
    public void validarTokenInvalido() {
        Cookie[] cookies = {new Cookie("token", "invalid_token_value")};

        boolean resultado = validadorCookie.validar(cookies);

        Assert.assertFalse(resultado);
    }
    
     @Test
    public void validarFuncionarioValido() {
        Cookie[] cookies = {new Cookie("tokenFuncionario", "token_value")};

        boolean resultado = validadorCookie.validarFuncionario(cookies);

        Assert.assertTrue(resultado);
    }

    @Test
    public void validarFuncionarioInvalido() {
        Cookie[] cookies = {new Cookie("tokenFuncionario", "invalid_token_value")};

        boolean resultado = validadorCookie.validarFuncionario(cookies);

        Assert.assertFalse(resultado);
    }

    @Test
    public void deletarTokenNomeDoCookieIgualTokenOuTokenFuncionario() {
        Cookie[] cookies = {
                new Cookie("token", "token_value"),
                new Cookie("tokenFuncionario", "token_value")
        };

        validadorCookie.deletar(cookies);
    }

    @Test
    public void getCookieIdClienteSucesso() {
//      Deve retornar o id do cliente quando o nome do cookie for igual ao do token

        Cookie[] cookies = {new Cookie("token", "id_cliente-token_value")};

        String resultado = validadorCookie.getCookieIdCliente(cookies);

        Assert.assertEquals("id_cliente", resultado);
    }

    @Test
    public void getCookieIdClienteErro() {
//      Deve retornar erro quando o nome do cookie for diferente do nome do token        
        
        Cookie[] cookies = {new Cookie("outroCookie", "banana")};

        String resultado = validadorCookie.getCookieIdCliente(cookies);

        Assert.assertEquals("erro", resultado);
    }

    @Test
    public void getCookieIdFuncionarioSucesso() {
//      Deve retornar o id do funcionário quando o nome do cookie for igual ao do token do funcionário
        
        Cookie[] cookies = {new Cookie("tokenFuncionario", "id_funcionario-token_value")};

        String resultado = validadorCookie.getCookieIdFuncionario(cookies);

        Assert.assertEquals("id_funcionario", resultado);
    }

    @Test
    public void getCookieIdFuncionarioErro() {
//     Deve retornar erro quando o nome do cookie for diferente do nome do token do funcionário
        Cookie[] cookies = {new Cookie("outroCookie", "banana")};

        String resultado = validadorCookie.getCookieIdFuncionario(cookies);

        Assert.assertEquals("erro", resultado);
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