package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RobertoRegovichGuide\\Drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        // Navegando à página
        navegador.get("http://www.juliodelima.com.br/taskit");

        // Raalizar o cadastro, clicar em no id "signup"
        navegador.findElement(By.id("signup")).click();

        // Preencher campo name="name" 'com Roberto Regovich Guides'
        navegador.findElement(By.name("name")).sendKeys("Roberto");

        // Preencher o campo name="login" com 'betoguides'
        navegador.findElement(By.name("login")).sendKeys("roberto");

        // Preencher o campo name="password" com '123456'
        navegador.findElement(By.name("password")).sendKeys("123456");

        // Clicar no Link que possui o texto 'SAVE'
        navegador.findElement(By.linkText("SAVE")).click();

        //Fechar o navegador
        navegador.close();

    }
}
