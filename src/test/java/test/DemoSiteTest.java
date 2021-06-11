package test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pages.AddUser;
import pages.HomePage;
import pages.Login;

public class DemoSiteTest {
	private static WebDriver driver;

	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));

	}

	@Before
	public void setup() {

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		try {
			driver.get(HomePage.getUrl());
		} catch (TimeoutException e) {

		}
	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		HomePage nav = PageFactory.initElements(driver, HomePage.class);
		AddUser add = PageFactory.initElements(driver, AddUser.class);
		Login info = PageFactory.initElements(driver, Login.class);
		// Navigate to "Add A user"
		nav.navAddUser();
		Thread.sleep(2000);
		
		add.signUp("amet", "amet1");
		Thread.sleep(2000);

		nav.navLogin();
		Thread.sleep(2000);
		
		info.signIn("amet", "amet1");
		Thread.sleep(2000);
		
		assertEquals("**Successful Login**", driver.findElement(By.xpath
				("//b[contains(text(),'Successful')]")).getText());
		Thread.sleep(2000);
	}
}
