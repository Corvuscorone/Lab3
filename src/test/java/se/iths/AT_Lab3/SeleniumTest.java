package se.iths.AT_Lab3;

import org.junit.Ignore;
import org.junit.Test;
import Pages.*;
import org.junit.Before;



public class SeleniumTest extends StartPage{
	
	StartPage startPage;
	CheckOutPage checkOutPage;
	
	@Before
	public void before(){
		startPage = new StartPage();
		checkOutPage = new CheckOutPage();
	}
	
	//@Test
	@Ignore
	//This may not work if any other test that adds to the cart has been run.
	//Cart may not empty in case of closed window
	public void cartTest(){
		startPage.checkCartEmpty("No items in your shopping cart");
	}
	
	@Test
	//@Ignore
	public void addToCartFromStartPage(){
		startPage.addBookStartPage();
		startPage.checkCartNotEmpty("No items in your shopping cart");
	}

	@Test
	//@Ignore
	public void checkOutFromStartPage(){
		startPage.addBookStartPage();
		startPage.checkOutStartPage();
		
	}
	
	@Test
	//@Ignore
	public void changeQuantityOrderPage(){
		startPage.addBookStartPage();
		startPage.checkOutStartPage();
		checkOutPage.changeQuatity();
	}
	
	@Test
	//@Ignore
	public void continueShoppingOrderPage(){
		startPage.addBookStartPage();
		startPage.checkOutStartPage();
		checkOutPage.continueShopping();
	}
	
	@Test
	//@Ignore
	public void registerFromStartPage(){
		startPage.registerStartPage();
	}
}
