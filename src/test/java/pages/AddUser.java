package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUser {
 @FindBy(name = "username")
 
 private WebElement uName;
 @FindBy(name = "password")
 private WebElement pWord;
 
 
 public void signUp(String str, String pw) {
	 uName.sendKeys(str);
	 pWord.sendKeys(pw);
	 pWord.submit();
	 
 }
 
}
