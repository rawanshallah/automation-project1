import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

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
        Random random= new Random();
        StringBuilder sb= new StringBuilder();
        for (int i= 0; i< 6; i++) {
            int values= random.nextInt(26) + 65;
            char randomLetter= (char) values;
            sb.append(randomLetter);
        }

        WebElement username= driver.findElement(By.name("username"));
        driver.findElement(By.name("username")).sendKeys("johnDoe"+sb.toString());
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
        driver.findElement(By.name("password")).sendKeys("abcdef1234");
        Thread.sleep(1000);
        driver.findElement(By.name("password2")).sendKeys("abcdef1234");
        Thread.sleep(1000);

        //5.Click on sign-up
        driver.findElement(By.name("registerButton")).click();
        Thread.sleep(1000);

        //6.Url verification
        String expectedUrl= "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?";
        String actualUrl= driver.getCurrentUrl();
//
        Assert.assertEquals(actualUrl, expectedUrl);

        //7.Verify FirstName & LastName
        Thread.sleep(1000);
        WebElement firstAndLastExpected= driver.findElement(By.id("nameFirstAndLast"));
        String actualFullName= firstAndLastExpected.getText();
//        firstAndLastExpected.click();

        String firstNameActual= firstNameElement.getText();
        String lastNameActual= lastNameElement.getText();
        Thread.sleep(1000);

        String fullNameExpected= firstAndLastExpected.getText();
        String[] expectedNames= actualFullName.split("");
        String firstEx= expectedNames[0];
        String lastEx= expectedNames[1];

        Assert.assertEquals(firstNameActual , firstEx, "Mismatch in first name");
        Assert.assertEquals(lastNameActual, lastEx, "Mismatch in last name");
        System.out.println("Are the same as provided");

        //8. Click on username and verify
        Thread.sleep(1000);
        WebElement usernameLink= driver.findElement(By.id("nameFirstAndLast"));
        usernameLink.click();

        WebElement usernameElement= driver.findElement(By.id("nameFirstAndLast"));
        usernameElement.click();


//        if ((firstNameActual.equals(firstAndLastExpected)) && (lastNameActual.equals(firstAndLastExpected))) {
//            System.out.println("First name and Last name matches");
//        } else {
//            System.out.println("No match for First and Last name");
//        }




    }
}
