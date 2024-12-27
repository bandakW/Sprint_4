import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver createForName(String browserName) {
        if (browserName.equals("FIREFOX")) {
            return new FirefoxDriver();
        } else if (browserName.equals("CHROME")) {
            return new ChromeDriver();
        } else {
            throw new RuntimeException("Неизвестный браузер: " + browserName);
        }
    }
}