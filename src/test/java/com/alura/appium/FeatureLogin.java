package com.alura.appium;

import PageObjects.CadastroPageObject;
import PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class FeatureLogin {
    @Test
    public void nao_consigo_logar_com_usuario_que_nao_existe(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();

        telaLogin.FazerLogin("Matheus", "123");
        Assert.assertTrue(telaLogin.MensagemErro());
    }

    @Test
    public void login_com_usuario_correto(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaDeCadastro = telaLogin.irParaTelaCadastro();

        telaDeCadastro.BuscarElementos();
        telaLogin = telaDeCadastro.Cadastrar("Matheus", "123", "123");

        telaLogin.BuscarElementos();
        telaLogin.FazerLogin("Matheus", "123");
    }
}