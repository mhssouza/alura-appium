package com.alura.appium;

import PageObjects.CadastroPageObject;
import PageObjects.LoginPageObject;
import com.alura.appium.AppiumDriverConfig;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeatureCadastroStepDefinitions {
    private CadastroPageObject telaDeCadastro;
    private LoginPageObject telaLogin;

    @And("vá para a tela de cadastro e faça o cadastro do usuário {string} e senha {string} e confirmação de senha {string}")
    public void preencherOsDadosDeCadastro(String usuario, String senha, String confirmarSenha){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        telaLogin.irParaTelaCadastro();
        CadastroPageObject telaDeCadastro = telaLogin.telaCadastro();
        telaDeCadastro.BuscarElementos();
        telaDeCadastro.Cadastrar(usuario, senha, confirmarSenha);
    }

    @Then("devo ver uma mensagem de erro dizendo que as senhas não conferem")
    public void receberMensagemDeErro(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        telaLogin = new LoginPageObject(driver);
        CadastroPageObject telaDeCadastro = telaLogin.telaCadastro();
        Assert.assertTrue(telaDeCadastro.MensagemErro());
    }

    @Then("o programa deve confirmar meu cadastro")
    public void confirmarCadastro(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
    }

    @When("eu tentar fazer o cadastro novamente com o usuario {string}, senha {string} e confirmação de senha {string}")
    public void cadastrarNovamente(String usuario, String senha, String confirmarSenha){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        telaLogin.irParaTelaCadastro();
        CadastroPageObject telaDeCadastro = telaLogin.telaCadastro();
        telaDeCadastro.BuscarElementos();
        telaDeCadastro.Cadastrar(usuario, senha, confirmarSenha);
    }

    @Then("devo ver uma mensagem de erro dizendo que o usuário já foi cadastrado")
    public void mensagemDeCadastroRepetido(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        telaLogin = new LoginPageObject(driver);
        CadastroPageObject telaDeCadastro = telaLogin.telaCadastro();
        Assert.assertTrue(telaDeCadastro.MensagemErro());
    }
}
