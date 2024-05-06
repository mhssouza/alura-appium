package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject extends PageObjectBase{
    private MobileElement botaoCadastro;
    private MobileElement mensagemErro;
    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement botaoLogin;
    private MobileElement botaoDeslogar;
    private MobileElement telaProdutos;

    private final By erroID;
    private final By campoNomeID;
    private final By campoSenhaID;
    private final By botaoLogarID;
    private final By botaoDeslogarID;
    private final By botaoCadastroID;
    private final By telaProdutosID;

    public LoginPageObject(AppiumDriver driver){
        super(driver);
        erroID = By.id("br.com.alura.aluraesporte:id/mensagem_erro_login");
        campoNomeID = By.id("br.com.alura.aluraesporte:id/input_usuario");
        campoSenhaID = By.id("br.com.alura.aluraesporte:id/input_senha");
        botaoLogarID = By.id("br.com.alura.aluraesporte:id/login_botao_logar");
        botaoDeslogarID = By.id("br.com.alura.aluraesporte:id/menu_principal_deslogar");
        botaoCadastroID = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        telaProdutosID = By.id("br.com.alura.aluraesporte:id/lista_produtos_recyclerview");

    }

    @Override
    public void BuscarElementos(){
        campoNome = (MobileElement) driver.findElement(campoNomeID);
        campoSenha = (MobileElement) driver.findElement(campoSenhaID);
        botaoLogin = (MobileElement) driver.findElement(botaoLogarID);
        botaoCadastro = (MobileElement) driver.findElement(botaoCadastroID);
    }

    private void PreencherFormulario(String usuario, String senha){
        campoNome.sendKeys(usuario);
        campoSenha.sendKeys(senha);
    }

    public LoginPageObject FazerLogin(String usuario, String senha){
        PreencherFormulario(usuario, senha);
        botaoLogin.click();
        return new LoginPageObject(driver);
    }

    public void irParaTelaCadastro(){
        botaoCadastro.click();
    }

    public CadastroPageObject telaCadastro() {
        return new CadastroPageObject(driver);
    }

    public Boolean MensagemErro(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroID));

        mensagemErro = (MobileElement) driver.findElement(erroID);
        return mensagemErro.isDisplayed();
    }
}