package sistemadetestes.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//document.getElementsByName('q')[0].value = "teste de software"
//document.getElementsByName('q')[0].value
//document.getElementById('result-stats')

public class GoogleFirstTest {
	private WebDriver driver;
	private String URL_BASE = "https://www.google.com";
	private String PATH_DRIVE = "src/test/resources/chromedriver";
//	OBS: no Linux precisa executar o comando: chmod +x chromedriver
	
	private void iniciar() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL_BASE);
	}
	
	@Test
	public void pesquisarNoGoogle() {
		//Montagem do cenário
		iniciar();
		//Preparação
		WebElement inputPesquisa = driver.findElement(By.name("q"));
		
		//Execução
		inputPesquisa.sendKeys("receita de bolo de laranja" + Keys.ENTER);
		
		String resultado = driver.findElement(By.id("result-stats")).getText();
		
		//Verificação e Análise
		assertTrue(resultado, resultado.contains("Aproximadamente"));
		
		driver.quit();
	}

}
