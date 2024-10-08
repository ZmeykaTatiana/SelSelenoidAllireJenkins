import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class TestSetup {
    private static final String URL="http://google.com";


    public static void openBrowser(){
        Selenide.open(URL);
    }
    public static void setup() {

        if("ok".equals(System.getenv("isRemote"))){
           Map<String,Object>options=new HashMap<>();
           options.put("enableVNC",true);
           options.put("sessionTimeout","2m");
           options.put("name","agata");

            ChromeOptions capabilities = new ChromeOptions();
            capabilities.setCapability("selenoid:options", options);
            RemoteWebDriver remoteWebDriver=null;
            try{
                remoteWebDriver=new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), capabilities);
            }catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            remoteWebDriver.manage().window().setSize(new Dimension(1500,900));
            remoteWebDriver.get(URL);
            WebDriverRunner.setWebDriver(remoteWebDriver);

        }else{
            openBrowser();
        }
    }
}
