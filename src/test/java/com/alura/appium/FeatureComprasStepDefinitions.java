package com.alura.appium;

import PageObjects.CadastroPageObject;
import PageObjects.LoginPageObject;
import PageObjects.ProdutosPageObjects;
import com.alura.appium.AppiumDriverConfig;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class FeatureComprasStepDefinitions {
    private CadastroPageObject telaDeCadastro;
    private LoginPageObject telaLogin;


    @Então("devo ser redirecionado para a página inicial")
    public void paginaDeComprasInicial(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        ProdutosPageObjects telaProdutos = new ProdutosPageObjects(driver);
        telaProdutos.BuscarElementos();
    }

    @When("eu selecionar um produto para comprar")
    public void selecionarOProdutoParaCompra(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        ProdutosPageObjects telaProdutos = new ProdutosPageObjects(driver);
        telaProdutos.selecionarProduto();
        telaProdutos.comprar();
    }

    @And("preencher os dados com o numero do cartao {string}, data de validade {string} e CVC {string}")
    public void preencherDadosDoCartaoCorretamente(String numeroCartao, String dataDeValidade, String CVC){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        ProdutosPageObjects telaProdutos = new ProdutosPageObjects(driver);
        telaProdutos.preencherDadosDeCompra(numeroCartao, dataDeValidade, CVC);
        telaProdutos.confirmarCompra();
    }

    @Then("minha compra deve ser realizada")
    public void verificarSeACompraFoiFeita(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        ProdutosPageObjects telaProdutos = new ProdutosPageObjects(driver);
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        int quantidadeElementos = telaProdutos.verificarCompra();

        Assert.assertTrue(quantidadeElementos >= 1);
    }

    @Then("minha compra não deve ser realizada")
    public void verificarSeACompraFalhou(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        ProdutosPageObjects telaProdutos = new ProdutosPageObjects(driver);

        telaProdutos.BuscarElementos();
        telaProdutos.verificarCompra();

        Assert.assertEquals(0, telaProdutos.verificarCompra());
    }

    @Then("minha compra não deve ser realizada e o item não deve aparecer na lista")
    public void verificarSeACompraFalhouEOProdutoNaoFoiRegistrado(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        ProdutosPageObjects telaProdutos = new ProdutosPageObjects(driver);

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        int quantidadeElementos = telaProdutos.verificarCompra();

        Assert.assertFalse(quantidadeElementos >= 1);
    }
}
