package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class InformacoesUsuarioTest2 {
    private WebDriver navegador;

   @Before
    public void steUp() {
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RobertoRegovichGuide\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.manage().window().maximize();
        // Navegando para a página
        navegador.get("http://www.juliodelima.com.br/taskit");
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        // Clicar no link que possui o texto 'Sing in'
        navegador.findElement(By.linkText("Sign in")).click();

        // Idenfificando o formulário de login
        WebElement formularioSingnInBox = navegador.findElement(By.id("signinbox"));

        // Digitar no campo com name 'login' que está dentro do formalário de id 'singnbox' o texto 'betoguides'
        formularioSingnInBox.findElement(By.name("login")).sendKeys("roberto");

        // Clicar no Campo no campo com name 'password' que está dentro do formalário de id 'singnbox' o texto '123456'
        formularioSingnInBox.findElement(By.name("password")).sendKeys("123456");

        // Clicar no link com texto 'SIGN IN'
        navegador.findElement(By.linkText("SIGN IN")).click();

        // Clicar em um link que possui a class "me"
        navegador.findElement(By.className("me")).click();

        // Clicar em um link com texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        // Clicar no botão através do seu xpath //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();

        // Identificar a popup onde está o formulário de id addmoredata
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        // No cmobo do name "type" escolhe a opção "phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");

        // No campo de name "contact" digitar "+5511930114111"
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+5511930114111");

        // Clicar no link de text "SAVE" que está no popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        // Na mensagem de id "toast-container" validar que o texto é "Your contact has been added"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Your contact has been added!", mensagem);
   }

    @After
    public void tearDown() {
        // Fechar navegador
        navegador.quit();

    }
}