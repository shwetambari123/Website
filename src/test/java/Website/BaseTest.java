package Website;

import org.junit.After;
import org.junit.Before;

import java.io.IOException;

/**
 * Created by Yogesh on 22-08-2016.
 */
public class BaseTest  {

    BaseClass baseClass =new BaseClass();
    BusinessLibrary blib = new BusinessLibrary();

//BusinessLibrary blib = new BusinessLibrary();

    @Before
    public void SetUp() throws IOException {
       baseClass.openBrowser();

    }



    @After
    public void tearDown()  {
//    if (blib.isUserLoggedIn() == true) {
//    blib.logout();
//    }
//        baseClass.closeBrowser();
    }

}
