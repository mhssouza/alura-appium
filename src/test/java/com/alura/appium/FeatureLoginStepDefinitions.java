package com.alura.appium;

import PageObjects.CadastroPageObject;
import PageObjects.LoginPageObject;
import com.alura.appium.AppiumDriverConfig;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class FeatureLoginStepDefinitions {
    private LoginPageObject telaLogin;

    @Dado("que estou na tela de login")
    public void queEstouNaTelaDeLogin() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
    }

    @Quando("tento fazer login com usuário {string} e senha {string}")
    public void tentoFazerLoginComUsuarioESenha(String usuario, String senha) {
        telaLogin.FazerLogin(usuario, senha);
    }

    @Então("devo ver uma mensagem de erro")
    public void devoVerUmaMensagemDeErroInformandoQueOUsuarioNaoExiste() {
        Assert.assertTrue(telaLogin.MensagemErro());
    }

    @Quando("fazer o login com o mesmo usuário {string} e senha {string}")
    public void fazerLoginComOMesmoUsuario(String usuario, String senha){
        telaLogin.BuscarElementos();
        telaLogin.FazerLogin(usuario, senha);
    }
}