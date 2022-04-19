package facebook;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_COOKIE_ACCEPT = "//div[contains(@class, \"_9xo5\")]/button[2]";
    public static final String XPATH_CREATE_ACCOUNT = "//div[contains(@class, \"_6ltg\")]/a";
    public static final String XPATH_WAIT_FOR = "//select[2]";
    public static final String XPATH_SELECT_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_SELECT_MONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement cookieAccept = driver.findElement(By.xpath(XPATH_COOKIE_ACCEPT));
        cookieAccept.click();

        WebElement createNewAccount = driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT));
        createNewAccount.click();

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());

        WebElement selectDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select selectDayOfBirth = new Select(selectDay);
        selectDayOfBirth.selectByIndex(25);

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select selectMonthOfBirth = new Select(selectMonth);
        selectMonthOfBirth.selectByIndex(4);
    }
}
