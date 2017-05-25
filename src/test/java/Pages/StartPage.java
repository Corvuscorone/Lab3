package Pages;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage extends PageObject{
	
	public void checkCartEmpty(String message){
	    driver.findElement(By.id("open-cart")).click();
	    WebElement element = driver.findElement(By.tagName("h4"));
	    System.out.println(element.getText());
	    assertEquals(message, element.getText());
	}
	
	public void checkCartNotEmpty(String message){
	    driver.findElement(By.id("open-cart")).click();
	    WebElement element = driver.findElement(By.tagName("h4"));
	    System.out.println(element.getText());
	    assertFalse(message.equals(element.getText()));
	}
	
	//Hårdkodat japp, men startsidan har inga bättre grejjer än xpath
	public void addBookStartPage(){
		WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[2]/div/div[1]/div/div[1]/a"));
		Actions builder = new Actions(driver);
		Action mouseOverBook = builder.moveToElement(element).build();
		mouseOverBook.perform();
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@productid='6']"))));
		
		WebElement book = driver.findElement(By.xpath(".//*[@productid='6']"));
		book.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Could not go to sleep. Read me a story!");
			e.printStackTrace();
		}
	}
	
	public void checkOutStartPage(){
	    driver.findElement(By.id("open-cart")).click();
	    (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='miniCartDetails']"))));
		WebElement element = driver.findElement(By.linkText("Checkout"));
		element.click();
		
		String s = "Place your order";
		final String temp = s.toLowerCase();

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				
				return d.getTitle().toLowerCase().startsWith(temp);
			}
		});
		
		assertEquals("Place your order", driver.getTitle()); 

	}
	
	public void registerStartPage(){
		driver.findElement(By.xpath(".//*[@id='customerAccount']/button")).click();
		driver.findElement(By.partialLinkText("Not yet registered?")).click();
		WebElement rwe;
		rwe = ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='registrationForm']")))));

		assertTrue(rwe!=null);

	}
	
	
}