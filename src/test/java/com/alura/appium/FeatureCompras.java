package com.alura.appium;

import PageObjects.CadastroPageObject;
import PageObjects.LoginPageObject;
import PageObjects.ProdutosPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;

public class FeatureCompras {
    @Test
    public void compras_de_produtos_com_dados_em_branco(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();

        CadastroPageObject telaDeCadastro = telaLogin.irParaTelaCadastro();
        telaDeCadastro.BuscarElementos();

        telaLogin = telaDeCadastro.Cadastrar("Matheus", "123", "123");
        telaLogin.BuscarElementos();
        telaLogin.FazerLogin("Matheus", "123");

        ProdutosPageObjects telaProdutos = new ProdutosPageObjects(driver);
        telaProdutos.selecionarProduto();
        telaProdutos.comprar();

        telaProdutos.confirmarCompra();

        driver.navigate().back();
        driver.navigate().back();

        int quantidadeElementos = telaProdutos.verificarCompra();

        Assert.assertFalse(quantidadeElementos >= 1);
        telaProdutos.voltarParaTelaProdutos();
    }

    @Test
    public void compras_de_produtos_com_dados_de_formatacao_maiores(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();

        CadastroPageObject telaDeCadastro = telaLogin.irParaTelaCadastro();
        telaDeCadastro.BuscarElementos();

        telaLogin = telaDeCadastro.Cadastrar("Matheus", "123", "123");
        telaLogin.BuscarElementos();
        telaLogin.FazerLogin("Matheus", "123");

        ProdutosPageObjects telaProdutos = new ProdutosPageObjects(driver);
        telaProdutos.selecionarProduto();
        telaProdutos.comprar();
        telaProdutos.preencherDadosDeCompra("123456789876543212345678", "03/12/39", "999999");
        telaProdutos.confirmarCompra();

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        int quantidadeElementos = telaProdutos.verificarCompra();

        Assert.assertFalse(quantidadeElementos >= 1);
        telaProdutos.voltarParaTelaProdutos();
    }

    @Test
    public void compras_de_produtos_com_dados_incorretos(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();

        CadastroPageObject telaDeCadastro = telaLogin.irParaTelaCadastro();
        telaDeCadastro.BuscarElementos();

        telaLogin = telaDeCadastro.Cadastrar("Matheus", "123", "123");
        telaLogin.BuscarElementos();
        telaLogin.FazerLogin("Matheus", "123");

        ProdutosPageObjects telaProdutos = new ProdutosPageObjects(driver);
        telaProdutos.BuscarElementos();
        telaProdutos.selecionarProduto();
        telaProdutos.comprar();
        telaProdutos.preencherDadosDeCompra("123", "03/29", "999");
        telaProdutos.confirmarCompra();

        telaProdutos.BuscarElementos();

        telaProdutos.verificarCompra();

        Assert.assertEquals(0, telaProdutos.verificarCompra());
        telaProdutos.voltarParaTelaProdutos();
    }

    @Test
    public void compras_de_produtos_com_dados_corretos() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();

        CadastroPageObject telaDeCadastro = telaLogin.irParaTelaCadastro();
        telaDeCadastro.BuscarElementos();

        telaLogin = telaDeCadastro.Cadastrar("Matheus", "123", "123");
        telaLogin.BuscarElementos();
        telaLogin.FazerLogin("Matheus", "123");

        ProdutosPageObjects telaProdutos = new ProdutosPageObjects(driver);
        telaProdutos.selecionarProduto();
        telaProdutos.comprar();
        telaProdutos.preencherDadosDeCompra("1234567898765432", "03/29", "999");
        telaProdutos.confirmarCompra();

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        int quantidadeElementos = telaProdutos.verificarCompra();

        Assert.assertTrue(quantidadeElementos >= 1);
        telaProdutos.voltarParaTelaProdutos();
    }
}