package cep;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CepTest {
    WebDriver driver;
    @Test
    public void cepTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://buscacepinter.correios.com.br/app/endereco/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(By.id("endereco")).sendKeys("06413080");
        driver.findElement(By.id("btn_pesquisar")).click();
        String numero = driver.findElement(By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]")).getText();
        Assert.assertEquals("Nome da rua, logradouro", "Rua Serra da Mantiqueira", numero);
        driver.findElement(By.id("btn_nbusca")).click();
        driver.findElement(By.id("endereco")).sendKeys("Rua Marte");
        Select optionSkills = new Select(driver.findElement(By.id("tipoCEP")));
        optionSkills.selectByVisibleText("Localidade/Logradouro");
        driver.findElement(By.id("btn_pesquisar")).click();
    }
//    @After
//    public void fecharBrowser() {
//        driver.quit();
//
//    }
}
