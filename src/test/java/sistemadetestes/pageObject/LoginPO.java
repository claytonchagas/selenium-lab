package sistemadetestes.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

	@FindBy(id = "email")
	public WebElement inputEmail;
	
	@FindBy(id = "senha")
	public WebElement inputSenha;//padrão da variável: nome do elemento html + o que ele representa
	
	//@FindBy(id = "senha")
	@FindBy(id = "btn-entrar")
	public WebElement buttonEntrar;
	
	//document.querySelector('form>div.alert>span')
	//document.querySelector('form.form-login>div.alert>span').textContent
	@FindBy(css = "form.form-login>div.alert>span")
	public WebElement spanMensagem;
	//capturar a mensagem funciona por id também
	
	/**
	 * Construtor padrão para criação de uma nova instância da página de login
	 * @param driver Driver da página de login
	 * */
	public LoginPO(WebDriver driver) {
		super(driver);
	}
	
	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
	
	public String obterTituloPagina() {
		return driver.getTitle();
	}
	
	/**
	 * Método que tenta executar a ação no sistema
	 * @param email Email para tentativa de login
	 * @param senha Senha para tentativa de login
	 * */
	public void executarAcaoDeLogar(String email, String senha) {
		escrever(inputEmail, email);
		escrever(inputSenha, senha);
		buttonEntrar.click();
	}
	
	public String obterTituloDaPagina() {
		return driver.getTitle();
	}

}
