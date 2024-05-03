package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ProdutosPageObjects extends PageObjectBase{
    private MobileElement botaoDeslogar;
    private MobileElement bolaDeFutebol;
    private MobileElement botaoComprar;
    private MobileElement campoNumeroCartao;
    private MobileElement campoDataDeValidade;
    private MobileElement campoCVC;
    private MobileElement botaoConfirmarCompra;
    private MobileElement telaDeCompra;
    private MobileElement botaoPagamentos;
    private MobileElement idCompra;
    private MobileElement botaoListaProdutos;

    private final By botaoDeslogarID;
    private final By bolaDeFutebolID;
    private final By botaoComprarID;
    private final By botaoConfirmarCompraID;
    private final By telaDeCompraID;
    private final By idCompraID;
    private final By botaoPagamentosID;
    private final By botaoListaProdutosID;

    public ProdutosPageObjects(AppiumDriver driver) {
        super(driver);
        botaoDeslogarID = By.id("br.com.alura.aluraesporte:id/menu_principal_deslogar");
        bolaDeFutebolID = By.id("br.com.alura.aluraesporte:id/item_produto_preco");
        botaoComprarID = By.id("br.com.alura.aluraesporte:id/detalhes_produto_botao_comprar");
        botaoConfirmarCompraID = By.id("br.com.alura.aluraesporte:id/pagamento_botao_confirma_pagamento");
        telaDeCompraID = By.id("br.com.alura.aluraesporte:id/lista_produtos_recyclerview");
        idCompraID = By.id("br.com.alura.aluraesporte:id/item_pagamento_id");
        botaoPagamentosID = By.id("br.com.alura.aluraesporte:id/listaPagamentos");
        botaoListaProdutosID = By.id("br.com.alura.aluraesporte:id/listaProdutos");
    }

    @Override
    public void BuscarElementos() {
        botaoDeslogar = (MobileElement) driver.findElement(botaoDeslogarID);
        botaoListaProdutos = (MobileElement) driver.findElement(botaoListaProdutosID);
    }

    private void PreencherCampos(String numeroCartao, String dataValidade, String CVC) {
        campoNumeroCartao = (MobileElement) driver.findElement(By.xpath("//*[@text='Número cartão']"));
        campoDataDeValidade = (MobileElement) driver.findElement(By.xpath("//*[@text='Data de validade']"));
        campoCVC = (MobileElement) driver.findElement(By.xpath("//*[@text='CVC']"));

        campoNumeroCartao.click();
        campoNumeroCartao.sendKeys(numeroCartao);
        campoDataDeValidade.click();
        campoDataDeValidade.sendKeys(dataValidade);
        campoCVC.click();
        campoCVC.sendKeys(CVC);
    }

    public void selecionarProduto(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(bolaDeFutebolID));

        bolaDeFutebol = (MobileElement) driver.findElement(bolaDeFutebolID);
        bolaDeFutebol.click();
    }

    public ProdutosPageObjects preencherDadosDeCompra(String numeroCartao, String dataValidade, String CVC){
        PreencherCampos(numeroCartao, dataValidade, CVC);
        return new ProdutosPageObjects(driver);
    }

    public void comprar(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(botaoComprarID));

        botaoComprar = (MobileElement) driver.findElement(botaoComprarID);
        botaoComprar.click();
    }

    public void confirmarCompra(){
        botaoConfirmarCompra = (MobileElement) driver.findElement(botaoConfirmarCompraID);
        botaoConfirmarCompra.click();
    }

    public void voltarParaTelaProdutos(){
        BuscarElementos();
        botaoListaProdutos.click();
    }

    public int verificarCompra(){
        WebDriverWait espera = new WebDriverWait(driver, 10);

        espera.until(ExpectedConditions.presenceOfElementLocated(botaoPagamentosID));
        botaoPagamentos = (MobileElement) driver.findElement(botaoPagamentosID);
        botaoPagamentos.click();

        List<WebElement> listaDeCompras = driver.findElements(idCompraID);
        return listaDeCompras.size();
    }
}