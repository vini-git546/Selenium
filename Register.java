//I want to register to a website using the register(Sign Up) page. 
//If the  email is already registered, I want to build a selenium script which will enter a different email which is not registered in the database. */

package emailchecking;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import static org.junit.Assert.*;
//import java.util.regex.Pattern;

public class Register   {
   private Selenium selenium;

   @Before
   public void setUp() throws Exception {
      selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.google.com");
      selenium.setSpeed("2000");// to run the script slow
      selenium.start();
      selenium.windowMaximize(); // maximize window
      selenium.windowFocus();//focus on window
   }

   @Test
   public void CreateAccount() throws Exception {
      selenium.open("http://192.168.37.32/SpinetechFront/Registration.aspx");
      //selenium.click("link=Sign Up");
      selenium.waitForPageToLoad("30000");
      selenium.highlight("id=TxtPracticeName");
      selenium.type("id=TxtPracticeName","Proscare");
      Thread.sleep(2000);
      selenium.highlight("TxtLicenseNo");
      selenium.type("id=TxtLicenseNo","KLM-1234");
      Thread.sleep(2000);
      selenium.highlight("TxtFirstName");
      selenium.type("id=TxtFirstName", "Greg");
      selenium.type("id=TxtLastName", "Ken");
      Thread.sleep(2000);
      selenium.type("xpath=//input[@name='txtEmail']", "id.email123@gmail.com");// here is the Email ID that I entered initially (1st Email ID)
      if(selenium.isTextPresent("Email already exists")){
    	   
    	   String s[] = {"1", "2", "3","4","5"};
           for(int i=0;i<5;i++){
            selenium.highlight("xpath=//input[@name='txtEmail']");
            Thread.sleep(1500);
            selenium.type("xpath=//input[@name='txtEmail']", "id.email1267@gmail" + s[i] +".com");
            Thread.sleep(1500);
           }
       } 
           	   
            selenium.highlight("TxtPassword");
            selenium.type("id=TxtPassword","123456");
            selenium.highlight("TxtConfirmPassword");
            selenium.type("id=TxtConfirmPassword","123456");
            Thread.sleep(1000);
            selenium.highlight("xpath=//input[@name='recaptcha_response_field']");
            selenium.type("xpath=//input[@name='recaptcha_response_field']", "edoXSh reason");
            selenium.highlight("BtnRegister");
            selenium.click("id=BtnRegister");
            Thread.sleep(1500);
           
   }
            
   
   @After
   public void tearDown() throws Exception {
      selenium.stop();
   }
}                                                          
         
             
                     
   




     