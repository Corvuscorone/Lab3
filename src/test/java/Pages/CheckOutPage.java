package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;


public class CheckOutPage extends PageObject{

	public void changeQuatity(){

		//Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.name("quantity"))).doubleClick().build().perform();
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys("2");
		driver.findElement(By.linkText("Recalculate")).click();
		
		//Could not find a better way, so go to sleep..
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Could not go to sleep. Read me a story!");
			e.printStackTrace();
		}		
		String price = driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[3]/strong")).getText().substring(3);
		String sum = driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[3]/td[3]/strong")).getText().substring(3);

		assertEquals(Double.parseDouble(sum), Double.parseDouble(price)*2, 0);
	}
	
	public void continueShopping(){
		
		driver.findElement(By.partialLinkText(" Continue shopping")).click();;
		//(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@productid='6']"))));

		String s = "Shopizer Demo";
		final String temp = s.toLowerCase();
		//System.out.println("Page title is: " + driver.getTitle());

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith(temp);
			}
		});
		//System.out.println("Page title is: " + driver.getTitle());

		assertEquals(s+" - Default store", driver.getTitle()); 
		
	}
}