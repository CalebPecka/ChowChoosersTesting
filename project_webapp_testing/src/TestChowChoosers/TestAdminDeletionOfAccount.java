package TestChowChoosers;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.apache.commons.io.FileUtils;
import java.io.File;

public class TestAdminDeletionOfAccount {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "lib/win/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testAdminDeletionOfAccount() throws Exception {
    driver.get("http://ec2-18-219-122-60.us-east-2.compute.amazonaws.com:8080/chow-choosers/index.jsp");
    Thread.sleep(1500);
    driver.findElement(By.linkText("Sign Up")).click();
    Thread.sleep(1500);
    driver.findElement(By.name("email")).click();
    Thread.sleep(1500);
    driver.findElement(By.name("email")).clear();
    Thread.sleep(1500);
    driver.findElement(By.name("email")).sendKeys("todelete@gmail.com");
    Thread.sleep(1500);
    driver.findElement(By.name("username")).click();
    Thread.sleep(1500);
    driver.findElement(By.name("username")).clear();
    Thread.sleep(1500);
    driver.findElement(By.name("username")).sendKeys("todelete");
    Thread.sleep(1500);
    driver.findElement(By.name("password")).click();
    Thread.sleep(1500);
    driver.findElement(By.name("password")).clear();
    Thread.sleep(1500);
    driver.findElement(By.name("password")).sendKeys("1234");
    Thread.sleep(1500);
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    Thread.sleep(1500);
    driver.findElement(By.name("username")).click();
    Thread.sleep(1500);
    driver.findElement(By.name("username")).clear();
    Thread.sleep(1500);
    driver.findElement(By.name("username")).sendKeys("user1");
    Thread.sleep(1500);
    driver.findElement(By.name("password")).click();
    Thread.sleep(1500);
    driver.findElement(By.name("password")).clear();
    Thread.sleep(1500);
    driver.findElement(By.name("password")).sendKeys("pass1");
    Thread.sleep(1500);
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    Thread.sleep(1500);
    driver.findElement(By.linkText("Admin")).click();
    Thread.sleep(1500);
    driver.findElement(By.xpath("//div[@id='wrapper']/main/table/tbody/tr[7]/td[7]/form/input[2]")).click();
    Thread.sleep(1500);
    driver.findElement(By.linkText("RobinHoodLogout")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
