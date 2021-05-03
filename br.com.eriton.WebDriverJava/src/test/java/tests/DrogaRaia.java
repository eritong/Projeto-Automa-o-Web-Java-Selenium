package tests;

import org.apache.http.util.Asserts;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class DrogaRaia {

    private WebDriver navegador;


    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/Users/eriton.da.goncalves/Drivers/chromedriver");
        navegador = new ChromeDriver();
        navegador.get("https://www.drogasil.com.br");

    }


    @Test
    public void Login() {

        navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        navegador.findElement(By.cssSelector("p[data-qa=account]")).click();
        navegador.findElement(By.cssSelector("button[data-qa=header_menu_btn_login]")).click();
        navegador.findElement(By.id("emailCpf")).sendKeys("23091761843");
        navegador.findElement(By.id("password")).sendKeys("1109151617");
        navegador.findElement(By.cssSelector("button[data-qa=btn_signin]")).click();
        WebElement me = navegador.findElement(By.cssSelector("a[data-qa=account_resume]"));
        String textonoelementoMe = me.getText();
        assertEquals("Resumo da conta",textonoelementoMe);

    }
    @After
    public void tearDOW(){

        navegador.quit();
    }

}
