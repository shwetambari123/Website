package Website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yogesh on 22-08-2016.
 */
public class BaseClass {
    public static WebDriver driver;

    //------------------------Begin - Get and Set Properties ----------------------
    private static String filePath = null;
    static String configFileName = null;
    static BaseClass baseClass = new BaseClass();
//    static String TestDataFileName = "TestData.properties";

    static Properties properties = new Properties();
    static FileInputStream input;

    public static void loadFile(String filePath, String fileName) {

        try {
            input = new FileInputStream(filePath + fileName);
            if (input == null) {
                System.out.println("Sorry, unable to find " + fileName);
                return;
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Sorry, unable to find " + fileName);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getProperty(String key) {
        baseClass.setFilePath("src/test/resources/");
        loadFile(baseClass.getFilePath(), "config.properties");
        return properties.getProperty(key);
    }

    public String setFilePath(String FilePath) {
        this.filePath = FilePath;
        return filePath;
    }

    public String getFilePath() {
        return filePath;
    }


    //-------------------------End of  Get and Set Properties ----------------------

    public void openBrowser() throws IOException {
        String url = this.getProperty("url");
        String browser = this.getProperty("browser");

        if (browser.matches("firefox")) {
            driver = new FirefoxDriver();
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        } else if (browser.matches("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.matches("safari")) {
            driver = new SafariDriver();
        }

        driver.get(url);
                /* System.setProperty("webdriver.gecko.driver","geckodriver.exe");
               driver = new ChromeDriver();
              //driver.get(" https://en-gb.facebook.com/login/");
                driver.get("http://demo.nopcommerce.com/ ");
                //driver.get("https://www.google.co.uk/?gfe_rd=cr&ei=Nd28V62jLMuN8Qf7x5HYBQ&gws_rd=ssl ");*/

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    public void closeBrowser() {
        //if(driver!=null)

        driver.quit();

        // driver.close();

    }

    public boolean isTextPresentAt(By element, String text) {
        return driver.findElement(element).getText().contains(text);
    }
}




