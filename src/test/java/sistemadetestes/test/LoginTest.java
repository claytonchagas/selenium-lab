package sistemadetestes.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sistemadetestes.pageObject.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest{
	
	private static LoginPO loginPage;
	
	@BeforeClass
	public static void prepararTestes() {
		loginPage = new LoginPO(driver);
	}
	
	@Test
	public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {
		//loginPage.inputEmail.sendKeys("");
		//loginPage.escrever(loginPage.inputEmail, "");
		//loginPage.inputSenha.sendKeys("");
		
		//loginPage.buttonEntrar.click();
		loginPage.executarAcaoDeLogar("", "");
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia() {
//		loginPage.inputEmail.sendKeys("");
		loginPage.escrever(loginPage.inputEmail, "teste");
		loginPage.inputSenha.sendKeys("");
		
		loginPage.buttonEntrar.click();
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {
//		loginPage.inputEmail.sendKeys("");
		loginPage.escrever(loginPage.inputEmail, "");
		loginPage.escrever(loginPage.inputSenha, "teste");
		
		loginPage.buttonEntrar.click();
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void TC007_deveLogarNoSistemaComEmailESenhaCorretos() {
		loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
		
		assertEquals(loginPage.obterTituloDaPagina(), "Controle de Produtos");
	}
}