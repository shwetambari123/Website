package Website;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

/**
 * Created by Yogesh on 22-08-2016.
 */
public class SmokeTest extends BaseTest {
    Random random = new Random();
    int r = random.nextInt();

    //Test Data for TestCase - I
    String firstname = "TestFirstname"+r;
    String lastname = "TestLastname"+r;
    String Bdate = "12";
    String Bmonth = "July";
    String Byear = "1988";
    String company = "MavenIT Solutions";
    String password = "Password1@";
    String email = "testUser"+r+"@email.com";

    //User Login details
    String CustUsername = "";
    String CustPassword = "";


    BusinessLibrary blib = new BusinessLibrary();

   // BaseClass baseClass=new BaseClass();

  /* @Test
            public void searchSomething()  {


       blib.typeSomething();

    }*/

  @Test
    public void doRegisterWithValidDetailsTest() {
      blib.doRegister(firstname,lastname,Bdate,Bmonth,Byear,email,company,password,password);
      Assert.assertTrue(baseClass.isTextPresentAt(By.cssSelector(".page registration-result-page"),"Your registration completed"));
    }

   /* @Test
    public void doRegisterWithInvalidDetailsTest() {
        blib.doRegister("","","","","","","","","");
    }*/

  /*  @Test
    public void doUncheckboxLoginTest()
    {
        blib.doUnckeckboxLogin();
        Assert.assertFalse(blib.isChecked());//to uncheck ckeckbox


    }*/

/*
  @Test
    public void doLoginTest()  {
    blib.loginAs(CustUsername,CustPassword);
    Assert.assertTrue(blib.isUserLoggedIn());
}*/


@Test
    public void searchProductTest()
{
   // blib.loginAs(CustUsername,CustPassword);
    blib.searchProduct();
    Assert.assertTrue(blib.isDisplay());
}


/*@Test
    public void doAddtoCartTest()
{
    blib.isLogin();
    blib.searchProduct();

}*/


}


