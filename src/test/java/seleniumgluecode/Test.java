package seleniumgluecode;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;


public class Test {

    private ChromeDriver driver = Hooks.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 10);


    @Given("^user in the DNV home page$")
    public void user_in_the_DNV_home_page() throws Throwable {
        driver.get("https://www.dnvgl.com/");
        driver.manage().window().maximize();
        String homePageTitle = "DNV.com - When trust matters - DNV";
        Assert.assertEquals(homePageTitle, driver.getTitle());
    }

    @Given("^user in the Signin Veracity home page$")
    public void user_in_the_Signin_Veracity_home_page() throws Throwable {
        driver.get("https://login.veracity.com/");
        driver.manage().window().maximize();
        String homePageTitle = "Veracity by DNV - Sign In";
        wait.until(ExpectedConditions.titleIs("Veracity by DNV - Sign In"));
        Assert.assertEquals(homePageTitle, driver.getTitle());
    }

    @Given("^user accepts all cookies$")
    public void user_accepts_all_cookies() throws Throwable {
        WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
        acceptCookiesButton.click();

    }

    @When("^user clicks on Sign in button$")
    public void user_clicks_on_Sign_in_button() throws Throwable {
        WebElement signinButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='the-header__login']")));
        signinButton.click();
    }

    @And("^user type username and password and log in$")
    public void user_type_username_and_password_and_log_in() throws Throwable {
        WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));
        usernameInput.sendKeys("rodrigosanchezalonso@gmail.com");
        WebElement continueButton = driver.findElement(By.xpath("//button[@id='continue']"));
        continueButton.click();
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        passwordInput.sendKeys("E2wn5JSxT#$#7u6");
        WebElement logInButton = driver.findElement(By.xpath("//button[@id='next']"));
        logInButton.click();
    }

    @When("^user clicks on My Services$")
    public void user_clicks_on_My_Services() throws Throwable {
        WebElement myServicesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My services']")));
        myServicesButton.click();
    }

    @When("^user clicks on Add service$")
    public void user_clicks_on_Add_service() throws Throwable {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My services']")));
        WebElement addServiceButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-click='addService()']")));
        addServiceButton.click();
    }

    @When("^user types \"([^\"]*)\" on search bar$")
    public void user_types_on_search_bar(String texToSearch) throws Throwable {
        WebElement searchBarInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search the marketplace']")));
        searchBarInput.sendKeys(texToSearch);
    }

    @When("^user clicks on Rules and Standars Explorer service$")
    public void user_clicks_on_Rules_and_Standars_Explorer_service() throws Throwable {
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-button_fcad07']"));
        searchButton.click();
        WebElement rulesAndStandarsExporerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/rules-and-standards-explorer']")));
        rulesAndStandarsExporerButton.click();
    }

    @When("^user clicks on Free access button$")
    public void user_clicks_on_Free_access_button() throws Throwable {
        WebElement freeAccessButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Free access']")));
        freeAccessButton.click();
    }

    @When("^user accepts terms and conditions$")
    public void user_accepts_terms_and_conditions() throws Throwable {
        WebElement acceptTermsAndConditionsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='I accept']")));
        acceptTermsAndConditionsButton.click();

    }

    @Then("^user can read \"([^\"]*)\"$")
    public void user_can_read(String textToRead) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://services.veracity.com/']")));
        WebElement greenCheck = driver.findElement(By.xpath("//div[contains(text(), 'interest')]"));
        Assert.assertTrue("Service has not been added correctly",greenCheck.getText().contains(textToRead));
    }

    @Then("^user can see added service called \"([^\"]*)\"$")
    public void user_can_see_added_service_called(String serviceName) throws Throwable {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My services']")));
        WebElement myService = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'"+serviceName+"')]")));
        Assert.assertTrue("Service has not been added correctly",myService.getText().contains(serviceName));
    }
}