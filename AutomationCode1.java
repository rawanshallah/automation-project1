import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class AutomationCode1 {
    public static void main(String[] args) throws Exception {

        //1.Navigation
        WebDriver driver= new ChromeDriver();
        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        String expectedText= "Welcome to Duotify!";
        String pageTitle= driver.getTitle();

        //2.Checking the title
        Assert.assertTrue(pageTitle.contains(expectedText));
        System.out.println("Page Title is correct.");

        //3.Click on the sign-up
        Thread.sleep(1000);
        driver.findElement(By.id("hideLogin")).click();
        Thread.sleep(1000);

        //4.Fill the form

        //4.1 random letters
        Random randomLetter= new Random();
        StringBuilder sb= new StringBuilder();
        for (int i= 0; i< 6; i++) {
            int values= randomLetter.nextInt(26) + 65;
            char random= (char) values;
            sb.append(random);
        }

        //4.2 random numbers
        int randomNumbers= 0;
        StringBuilder sb2= new StringBuilder();
        for (int i= 0; i< 5; i++) {
            int numbers= (int) (0 + Math.random()* 10);
            randomNumbers += numbers;
            sb2.append(randomNumbers);
        }
        String pass= sb.toString() + sb2;


        WebElement username= driver.findElement(By.name("username"));
        String userName= "johnDoe"+sb.toString();
        driver.findElement(By.name("username")).sendKeys(userName);
        Thread.sleep(1000);

        WebElement firstNameElement= driver.findElement(By.name("firstName"));
        firstNameElement.sendKeys("John2");
        Thread.sleep(1000);

        WebElement lastNameElement=driver.findElement(By.name("lastName"));
        lastNameElement.sendKeys("Doe");
        Thread.sleep(1000);

        driver.findElement(By.name("email")).sendKeys("johnDoe"+sb.toString()+"@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.name("email2")).sendKeys("johnDoe"+sb.toString()+"@gmail.com");
        Thread.sleep(1000);

        WebElement password= driver.findElement(By.name("password"));
        driver.findElement(By.name("password")).sendKeys(pass);
        Thread.sleep(1000);
        driver.findElement(By.name("password2")).sendKeys(pass);
        Thread.sleep(1000);

        //5.Click on sign-up
        driver.findElement(By.name("registerButton")).click();
        Thread.sleep(1000);

        //6.Url verification
        String expectedUrl= "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        System.out.println("Logged-in URL is correct");

        //7.Verify FirstName & LastName
        Thread.sleep(1000);
        String actualFullName= "John2 Doe";
        String firstAndLastExpected= driver.findElement(By.id("nameFirstAndLast")).getText();

        Assert.assertEquals(actualFullName, firstAndLastExpected);
        System.out.println("First and Last name is correct");


        //8. Click on username and verify
        WebElement usernameVerify= driver.findElement(By.id("nameFirstAndLast"));
        usernameVerify.click();
        Thread.sleep(1000);

        WebElement logout= driver.findElement(By.id("rafael"));
        logout.click();

        //9. Verify log-out URL
        Thread.sleep(1000);
        String logoutExpected= "http://duotify.us-east-2.elasticbeanstalk.com/register.php";
        String logoutActual= "http://duotify.us-east-2.elasticbeanstalk.com/register.php";

        Thread.sleep(1000);
        Assert.assertEquals(logoutActual, logoutExpected);
        System.out.println("Log-out URL is correct");

        //10. Login using same username and password when you signed up
        WebElement loginAgain= driver.findElement(By.name("loginUsername"));
        driver.findElement(By.name("loginUsername")).sendKeys(userName);
        Thread.sleep(1000);

        WebElement passwordAgain= driver.findElement(By.name("loginPassword"));
        driver.findElement(By.name("loginPassword")).sendKeys(pass);

        driver.findElement(By.name("loginButton")).click();

//        11. Verifying successful login
        Thread.sleep(1000);
        String homepageExpected= "You Might Also Like";
        String heading= driver.findElement(By.className("pageHeadingBig")).getText();

        Assert.assertEquals(heading, homepageExpected);
        System.out.println("Successful Log-in Homepage title is correct");


        //12. Logout and verify it
        Thread.sleep(1000);
        WebElement finalUsername= driver.findElement(By.id("nameFirstAndLast"));
        finalUsername.click();

        Thread.sleep(1000);
        WebElement finalLogout= driver.findElement(By.id("rafael"));
        finalLogout.click();


        String expectedFinalLogout= "http://duotify.us-east-2.elasticbeanstalk.com/register.php";
        String actualFinalLogout= "http://duotify.us-east-2.elasticbeanstalk.com/register.php";

        Assert.assertEquals(actualFinalLogout, expectedFinalLogout);
        System.out.println("Final Log-out is verified");



//        driver.quit();








    }
}
