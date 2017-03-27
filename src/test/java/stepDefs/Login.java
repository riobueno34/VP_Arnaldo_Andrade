package stepDefs;

import java.util.concurrent.TimeUnit;
import com.vpcodingclub.constants.Calculator;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.vpcodingclub.constants.WebDriverTest;
import org.testng.Assert;
import stepDefs.BrowserSetUpAndTearDown;
import cucumber.api.java.en.Given;
import static org.testng.Assert.assertEquals;
import java.util.List;
import java.util.Map;



/**
 * Created by Arnaldo on 20/3/2017.
 */
public class Login extends WebDriverTest {

    private WebDriver driver;

    public Login(BrowserSetUpAndTearDown bst) {
        this.driver = bst.driver;
    }

    @Given("^Navigate to Gamedb$")
    public void navigate_to_Gamedb() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://gamedb2.herokuapp.com/");
        //throw new PendingException();
    }

    @When("^I type valid <email> and <password>$")
    public void i_type_mis_credenciales (List<Map<String,String>> arg1 ) throws Throwable {
        String email =arg1.get(0).get("email");
        String password =arg1.get(0).get("password");
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // throw new PendingException();
    }

    @Then("^I get logged$")
    public void i_get_logged() throws Throwable {
        Thread.sleep(5000);
        Assert.assertEquals("Hello Arnaldo Andrade", driver.findElement(By.cssSelector("p.navbar-text.ng-binding")).getText());

    }

}
