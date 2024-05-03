package com.alura.appium;

import PageObjects.CadastroPageObject;
import PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class FeatureCadastro {
    @Test
    public void nao_consigo_cadastrar_com_senhas_que_nao_conferem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaDeCadastro = telaLogin.irParaTelaCadastro();

        telaDeCadastro.BuscarElementos();
        telaDeCadastro.Cadastrar("Matheus", "123", "321");

        Assert.assertTrue(telaDeCadastro.MensagemErro());
        driver.navigate().back();
    }

    @Test
    public void posso_cadastrar_usuarios_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaDeCadastro = telaLogin.irParaTelaCadastro();

        telaDeCadastro.BuscarElementos();
        telaLogin = telaDeCadastro.Cadastrar("Matheus", "123", "123");
        telaLogin.BuscarElementos();
    }

    @Test
    public void nao_consigo_cadastrar_usuarios_repetidos(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaDeCadastro = telaLogin.irParaTelaCadastro();

        telaDeCadastro.BuscarElementos();
        telaDeCadastro.Cadastrar("Matheus", "123", "123");

        Assert.assertTrue(telaDeCadastro.MensagemErro());
        driver.navigate().back();
    }
}
