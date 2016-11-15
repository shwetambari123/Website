package Website;

import org.junit.Test;

/**
 * Created by Yogesh on 22-08-2016.
 */
public class RegressionTest extends BaseTest
    //Common Test Data

    //Test Data for Testcase - I



{
    BusinessLibrary storage =new BusinessLibrary();
    @Test
    public void someRegession()
    {
        storage.loginAs("xxdv","dfdfds").searchProduct();
    }

}
