package sistemadetestes.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
//import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;

import sistemadetestes.pageObject.GooglePO;

//document.getElementsByName('q')[0].value = "teste de software"
//document.getElementsByName('q')[0].value
//document.getElementById('result-stats')

//Classe GoogleTest refatorada para usar BaseTest e BasePO
public class GoogleRefatorado2Test extends BaseTest{
	
	private static GooglePO googlePage;
	
	@BeforeClass
	public static void prepararTestes() {
		driver.get("https://www.google.com");
		googlePage = new GooglePO(driver);
	}

	@Test
	public void pesquisarNoGoogle() {
		//Montagem do cenário: agora é feita quando sãso chamados:
		//@BeforeClass
		//public static void iniciar()
		
		//Preparação
		//WebElement inputPesquisa = driver.findElement(By.name("q"));
		
		//Execução
		//inputPesquisa.sendKeys("receita de bolo de laranja" + Keys.ENTER);
		
		googlePage.inputPesquisa.sendKeys("receita de bolo de laranja" + Keys.ENTER);
		
		
		//String resultado = driver.findElement(By.id("result-stats")).getText();
		String resultado = googlePage.divResultadoPesquisa.getText();
		
		//Verificação e Análise
		assertTrue(resultado, resultado.contains("Aproximadamente"));
		
		//driver.quit();
		//Não precisa mais da linha acima, pois é chamada por:
		//@AfterClass
		//public static void finalizar()
	}
	
	@Test
	public void pesquisarNoGoogle2() {
		
		googlePage.inputPesquisa.sendKeys("receita de bolo de laranja" + Keys.ENTER);

		String resultado = googlePage.divResultadoPesquisa.getText();

		assertTrue(resultado, resultado.contains("resultados"));
	}

}
