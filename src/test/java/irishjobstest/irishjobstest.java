package irishjobstest;

//import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import driver.Driver;
//import javassist.compiler.ast.Keyword;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class irishjobstest {

    @Step("Open IrishJobs Homepage")
    public void implementation1() {
        String app_url = System.getenv("APP_URL");
        Driver.webDriver.get(app_url + "/");
        Driver.webDriver.manage().window().maximize();
        assertThat(Driver.webDriver.getTitle()).contains("Jobs in Ireland");
        WebElement closeBaner = Driver.webDriver.findElement(By.id("btnCloseModal"));
        closeBaner.click();
        Driver.webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Step("Go to Log In Page")
    public void goToLogIn() throws InterruptedException {
        WebElement login = Driver.webDriver.findElement(By.xpath("//*[@id='sign-in-toggle']"));
        login.click();
    }

    @Step("Log In to page with email <email> and pass <passWord>")
    public void logInToPage(String email, String password) throws InterruptedException {
        WebElement mail = Driver.webDriver.findElement(By.id("Email"));
        WebElement pass = Driver.webDriver.findElement(By.id("Password"));
        mail.sendKeys(email);
        pass.sendKeys(password);
        pass.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @Step("Close Get Started Modal")
    public void closeGetStarted() throws InterruptedException {
        WebElement getStarted = Driver.webDriver.findElement(By.xpath("//*[@id='ProfileModalWindowBaseContent']/div[1]/button"));
        getStarted.click();
    }

    @Step("Go to Home")
    public void goToHome() {
        Driver.webDriver.navigate().to("https://www.irishjobs.ie");
        
    }

    @Step("Search For A Job")
    public void searchJob() throws InterruptedException {
        WebElement search = Driver.webDriver.findElement(By.id("Keywords"));
        search.click();
        search.sendKeys("QA");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

}
