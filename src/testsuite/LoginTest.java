package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        //Launch website
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //click on Sign in link
        clickOnElement(By.linkText("Sign In"));

        //This is requirement
        String expectedMessage = "Welcome Back!";

        //Find the welcome test element and get the text
        WebElement actualTextMessageElement = BaseTest.driver.findElement(By.xpath("//h1[@class='page__heading']"));
        String actualMessage = actualTextMessageElement.getText();
        //This is requirement
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //click on Sign in link
        clickOnElement(By.linkText("Sign In"));

        //click on username
        sendTextToElement(By.id("user[email]"), "prime123@gmail.com" );

        //Enter password
        sendTextToElement(By.name("user[password]"), "password");

        //click on login button
        clickOnElement(By.xpath("//input[@type='submit']"));


        //This is requirement
        String expectedMessage = "Invalid email or password.";

        //Find the welcome test element and get the text
        WebElement actualTextMessageElement = BaseTest.driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMessage = actualTextMessageElement.getText();
        //This is requirement
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @After
    public void testDown() {
        //Closing browser
        closeBrowser();
  }
}
