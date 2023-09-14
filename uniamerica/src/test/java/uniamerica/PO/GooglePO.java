package uniamerica.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement botaoLogin;

    @FindBy(id = "mensagem")
    public WebElement mensagemErro;

    public GooglePO(WebDriver chrome) {

        super(chrome);
    }
}
