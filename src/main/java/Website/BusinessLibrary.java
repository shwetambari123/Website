package Website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yogesh on 22-08-2016.
 */
public class BusinessLibrary extends BaseClass {


   /* public void typeSomething () {
       driver.findElement(By.cssSelector(".ico-register")).click();

        driver.findElement(By.cssSelector(".ico-register")).click();
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    }*/



 public boolean isUserLoggedIn() {
       return driver.findElement(By.cssSelector(".ico-logout")).isDisplayed();
  }


   public BusinessLibrary doRegister(String firstname,String lastname,String BDay,String BMonth,String BYear,String email,String company,String password,String cPassword) {
        driver.findElement(By.cssSelector(".ico-register")).click();

        WebElement radioBtn=driver.findElement(By.id("gender-female"));
        radioBtn.click();
       driver.findElement(By.cssSelector("#gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstname);
        driver.findElement(By.id("LastName")).sendKeys(lastname);
        new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText(BDay);
        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(BMonth);
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(BYear);
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Company")).sendKeys(company);

        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(cPassword);

        driver.findElement(By.id("register-button")).submit();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return this; //why to use Element storage
    }


    public BusinessLibrary doUnckeckboxLogin()
    {
        driver.findElement(By.cssSelector(".ico-register")).click();

        WebElement radioBtn=driver.findElement(By.id("gender-female"));
        radioBtn.click();
        driver.findElement(By.cssSelector("#gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("shweta11");
        driver.findElement(By.id("LastName")).sendKeys("Nikam11");
        new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText("12");
        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText("July");
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText("1981");
        driver.findElement(By.id("Email")).sendKeys("aman@yahoo.com");
        driver.findElement(By.id("Company")).sendKeys("aabcCorp");

        if(isChecked()==true)
        {

            driver.findElement(By.id("Newsletter")).click();

        }

        driver.findElement(By.id("Password")).sendKeys("aakash");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("aakash");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return this;
    }

    public BusinessLibrary loginAs(String username, String password) {
        driver.findElement(By.cssSelector(".ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys(username);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector(".button-1.login-button")).submit();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return this;
    }

    public boolean isChecked()
   {
        return driver.findElement(By.id("Newsletter")).isSelected();
    }

    public BusinessLibrary addToCart()
{
    driver.findElement(By.cssSelector(".picture>a>img")).click();
    WebElement radio= driver.findElement(By.cssSelector("#product_attribute_3_6"));
    radio.click();

    driver.findElement(By.cssSelector("#add-to-cart-button-1")).click();
    return this;
}


    public BusinessLibrary searchProduct()
    {

        WebElement menu=driver.findElement(By.cssSelector(".top-menu>li>a"));
        Actions act =new Actions(driver);//initiate mouse action using action class
        act.moveToElement(menu).build().perform();//move the mouse to earlier idetified menu option
        WebDriverWait wait=new WebDriverWait(driver,5);//wait for 5 sec before proceeding .This allows sub menu appears properly before trying to click next
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".inactive>a")));
        WebElement menuOption  =driver.findElement(By.cssSelector(".top-menu>li>a"));
         menuOption.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return this;
    }




    public boolean isDisplay()
    {
        return driver.findElement(By.cssSelector(".page-title>h1")).isDisplayed();
    }

    public void logout() {
        driver.findElement(By.cssSelector(".ico-logout")).click();
    }
}
