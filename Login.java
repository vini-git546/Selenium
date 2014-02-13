
package admin;

import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
//import static org.testng.Assert.*;
//import java.util.regex.Pattern;


public class Login extends SeleneseTestNgHelper {
	
	// *******  Case1: Valid User name and Invalid password *******
	
	@Test public void Case1() throws Exception {
		selenium.windowMaximize();
		selenium.open("http://184.164.156.56/projects/eltern_planner/admin/user/admin/login/");
		Thread.sleep(3000);
		selenium.type("id=passwd", "%%$#HBFF");
		Thread.sleep(3000);
		selenium.highlight("id=button2");
		selenium.click("id=button2");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("Incorrect username or password. Please try again."));
		Thread.sleep(1000);
		selenium.captureEntirePageScreenshot("/home/hb/Selenium/Screens/Invalid_password.png","");
		
	}
	
	
   // *******  Case 2: Valid User name and Empty password  ******
	
	@Test public void Case2() throws Exception {
		
	    Thread.sleep(3000);
		selenium.type("id=passwd", "");
		selenium.highlight("id=button2");
		selenium.click("id=button2");
	  	Thread.sleep(3000);
		verifyTrue(selenium.isTextPresent("Enter your login name and password."));
		selenium.captureEntirePageScreenshot("/home/hb/Selenium/Screens/Empty_password.png","");
		
	} 
	
	 	
   //  ******* Case 3: Valid User name and password  *******
	
	@Test public void Case3() throws Exception {
		Thread.sleep(2000);
		selenium.type("id=passwd", "admin");
		Thread.sleep(3000);
		selenium.highlight("id=button2");
		selenium.click("id=button2");
		Thread.sleep(3000);
		verifyTrue(selenium.isTextPresent("You have successfully logged in"));
		Thread.sleep(4000);
		selenium.captureEntirePageScreenshot("/home/hb/Selenium/Screens/Successfull_Login.png","");
						
	}
	
	
	// ********* Case 4 : Listing page (Adding a duplicate entry) ********
	   
	   @Test public void Case4() throws Exception {
	    Thread.sleep(3000);
	    selenium.highlight("css=li > a[title=\"Admin \"]");
	    selenium.click("css=li > a[title=\"Admin \"]");
		Thread.sleep(11000);
		selenium.highlight("link=Add New");
		selenium.click("link=Add New");
		Thread.sleep(2000);
		selenium.highlight("id=vFirstName");
	    selenium.click("id=vFirstName");
	    Thread.sleep(1000);
		selenium.type("id=vFirstName", "Allen");
		Thread.sleep(1000);
		selenium.highlight("id=vLastName");
		selenium.click("id=vLastName");
		Thread.sleep(1000);
		selenium.type("id=vLastName", "John");
   		selenium.highlight("id=vLastName");
   		Thread.sleep(1000);
   		selenium.highlight("id=vEmail");
		selenium.click("id=vEmail");
		Thread.sleep(1000);
		selenium.type("id=vEmail", "id.email0012@gmail.com");
		Thread.sleep(1000);
		selenium.highlight("id=vUserName");
		selenium.click("id=vUserName");
		Thread.sleep(1000);
		selenium.type("id=vUserName", "John12");
		Thread.sleep(1000);
		selenium.highlight("id=vPassword");
		selenium.click("id=vPassword");
		Thread.sleep(1000);
		selenium.type("id=vPassword", "1234567");
		Thread.sleep(1000);
		selenium.highlight("id=btn-submit");
		selenium.click("id=btn-submit");
		Thread.sleep(2000);
		verifyTrue(selenium.isTextPresent("Username or email address already exists"));
		Thread.sleep(1000);
		selenium.highlight("id=btn-cancel");
		selenium.click("id=btn-cancel");
		Thread.sleep(5000);
		
	} 
	   
	  
      // ********* Case 5 : Listing page (Adding new admin user) ********
	   
	   @Test public void Case5() throws Exception {
		selenium.highlight("link=Add New");
		selenium.click("link=Add New");
		Thread.sleep(2000);
		selenium.highlight("id=vFirstName");
	    selenium.click("id=vFirstName");
	            Thread.sleep(1000);
		selenium.type("id=vFirstName", "Mikel");
		Thread.sleep(1000);
		selenium.highlight("id=vLastName");
		selenium.click("id=vLastName");
		Thread.sleep(1000);
		selenium.type("id=vLastName", "Clerk");
   		selenium.highlight("id=vLastName");
   		Thread.sleep(1000);
   		selenium.highlight("id=vEmail");
		selenium.click("id=vEmail");
		Thread.sleep(1000);
		selenium.type("id=vEmail", "id.email6780@hotmail.com");
		Thread.sleep(1000);
		selenium.highlight("id=vUserName");
		selenium.click("id=vUserName");
		Thread.sleep(1000);
		selenium.type("id=vUserName", "Clerk90");
		Thread.sleep(1000);
		selenium.highlight("id=vPassword");
		selenium.click("id=vPassword");
		Thread.sleep(1000);
		selenium.type("id=vPassword", "123456");
		Thread.sleep(1000);
		selenium.highlight("id=btn-submit");
		selenium.click("id=btn-submit");
		Thread.sleep(2000);
		verifyTrue(selenium.isTextPresent("Username or email address already exists"));
		
	}   
  // ******* Case 6 : Record deletion ********
		
	@Test public void Case6() throws Exception {
	    selenium.highlight("id=btn-cancel");
		selenium.click("id=btn-cancel");
		Thread.sleep(3000);	
		selenium.highlight("xpath=(//a[contains(text(),'next>')])[2]");
		selenium.click("xpath=(//a[contains(text(),'next>')])[2]");
	    Thread.sleep(3000);
		selenium.click("name=chkbx_1");
		Thread.sleep(2000);
		selenium.chooseOkOnNextConfirmation();
		selenium.highlight("css=span.ico-delete");
		selenium.click("css=span.ico-delete");
		assertTrue(selenium.getConfirmation().matches("^Are you sure you want to Delete selected record\\(s\\)[\\s\\S]$"));
        Thread.sleep(2000);
        verifyTrue(selenium.isTextPresent("1 Record(s) deleted successfully"));
        Thread.sleep(1000);
                        
	} 
			 
	   
  //  ******** Case 7: Logout functionality  *********
	
	@Test public void Case7() throws Exception {
		
		selenium.highlight("link=Logout");
		selenium.click("link=Logout");
		Thread.sleep(3000);
		verifyTrue(selenium.isTextPresent("You have successfully logged out"));

		
	} 
	
	
}
	
		  				
	  		
 
	
  
	
	
	  	       		                          
       	
 
 
      


	



