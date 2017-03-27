package stepDefs;


import com.vpcodingclub.constants.WebDriverTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;


public class AddGame extends WebDriverTest {

    private WebDriver driver;

    public AddGame(BrowserSetUpAndTearDown bst) {
        this.driver = bst.driver;
    }
    
//###########################################################################################


    @Then("^Add a New Game$")
    public void i_add_a_new_game() throws Throwable {
        driver.findElement(By.linkText("Games")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//tbody[2]/tr/td/input")).clear();
        driver.findElement(By.xpath("//tbody[2]/tr/td/input")).sendKeys("Comandos");
        driver.findElement(By.xpath("//tbody[2]/tr/td[2]/input")).clear();
        driver.findElement(By.xpath("//tbody[2]/tr/td[2]/input")).sendKeys("XboX");
        driver.findElement(By.xpath("//tbody[2]/tr/td[3]/input")).clear();
        driver.findElement(By.xpath("//tbody[2]/tr/td[3]/input")).sendKeys("Action");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//td[4]/button")).click();

    }

    @Then("^Delete Game \"([^\"]*)\"$")
    public void delete_Game(String juego) throws Throwable {
        driver.findElement(By.linkText("Games")).click();
        Thread.sleep(5000);
        int numfilas=driver.findElements(By.xpath("//table/tbody/tr")).size();
        int eliminado = 0;
        String nombre;

        for (int i=1;i<numfilas;i++)
        {
            nombre=driver.findElement(By.xpath("//tbody/tr["+i+"]/td")).getText();
            if (nombre.equals(juego)) {
                System.out.println("Se encontro el juego: " + nombre);
                driver.findElement(By.xpath("//tbody/tr["+i+"]/td[7]/button[2]")).click();
                Thread.sleep(3000);
                eliminado = 1;
                break;
            }
        }

        if(eliminado == 1)
        {System.out.println("El juego: "+juego+" fue exitosamente eliminado");}
        else {System.out.println("El juego: "+juego+" no se encontro en la lista");}

    }



    @Then("^Add a New <name> <platform> <genre> Game$")
    public void add_a_New_Name_Platform_Genre_Game (List<Map<String,String>> juego1 ) throws Throwable {

        String name =juego1.get(0).get("name");
        String platform =juego1.get(0).get("platform");
        String genre =juego1.get(0).get("genre");

        driver.findElement(By.linkText("Games")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//tbody[2]/tr/td/input")).clear();
        driver.findElement(By.xpath("//tbody[2]/tr/td/input")).sendKeys(name);
        driver.findElement(By.xpath("//tbody[2]/tr/td[2]/input")).clear();
        driver.findElement(By.xpath("//tbody[2]/tr/td[2]/input")).sendKeys(platform);
        driver.findElement(By.xpath("//tbody[2]/tr/td[3]/input")).clear();
        driver.findElement(By.xpath("//tbody[2]/tr/td[3]/input")).sendKeys(genre);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//td[4]/button")).click();
        //throw new PendingException();
    }

    @Then("^Edit Game <game> <name> <platform> <genre>$")
    public void edit_Game_game_name_platform_genre (List<Map<String,String>> juego2 ) throws Throwable {

        String game =juego2.get(0).get("game");
        String name =juego2.get(0).get("name");
        String platform =juego2.get(0).get("platform");
        String genre =juego2.get(0).get("genre");
        int actualizado = 0;

        driver.findElement(By.linkText("Games")).click();
        Thread.sleep(5000);
        int numfilas=driver.findElements(By.xpath("//table/tbody/tr")).size();
        String nombre;

        for (int i=1;i<numfilas;i++)
        {
            nombre=driver.findElement(By.xpath("//tbody/tr["+i+"]/td")).getText();
            if (nombre.equals(game)) {
                System.out.println("Se encontro el juego: " + nombre);
                driver.findElement(By.xpath("//tbody/tr["+i+"]/td[7]/button")).click();
                Thread.sleep(3000);

                driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]/input")).clear();
                driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]/input")).sendKeys(name);
                driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]/input")).clear();
                driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]/input")).sendKeys(platform);
                driver.findElement(By.xpath("//tbody/tr["+i+"]/td[6]/input")).clear();
                driver.findElement(By.xpath("//tbody/tr["+i+"]/td[6]/input")).sendKeys(genre);
                Thread.sleep(3000);
                driver.findElement(By.xpath("//tbody/tr["+i+"]/td[8]/button")).click();
                actualizado=1;

                break;
            }
        }
        //throw new PendingException();
        if(actualizado == 1)
        {System.out.println("El juego: "+game+" fue exitosamente actualizado");}
        else {System.out.println("El juego: "+game+" no se encontro en la lista");}
    }


}
