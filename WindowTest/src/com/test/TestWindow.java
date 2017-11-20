package com.test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestWindow {
	WebDriver driver;
	WebDriver second_driver;
	@BeforeTest
	 public void setup() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\drivers\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		 }
		
    @Test(priority=1)
    public void setGetWinSize(){
        //WebDriver setSize method used to set window size width = 300 and height = 500.
        driver.manage().window().setSize(new Dimension(300,500));

        //WebDriver getSize method used to get window width and height.
        System.out.println("Window1 height Is -> "+driver.manage().window().getSize().getHeight());
        System.out.println("Window1 width Is -> "+driver.manage().window().getSize().getWidth());
    }

    @Test(priority=2)
    public void setGetWinPosition(){
        //WebDriver setPosition method used to set window position x coordinate = 50 and y coordinate = 100.
        driver.manage().window().setPosition(new Point(50,100));

        //WebDriver getPosition method used to get window position x,y coordinates.
        System.out.println("Window1 position X coordinates Is -> "+driver.manage().window().getPosition().getX());
        System.out.println("Window1 position Y coordinates Is -> "+driver.manage().window().getPosition().getY());
   
    }
    @Test(priority=3)
    public void SecondWindow(){
		 /* // Store the current window handle
    	String winHandleBefore = driver.getWindowHandle();*/

    	// Perform the click operation that opens new window
    	second_driver = new FirefoxDriver();
    	second_driver.get("https://ruter.no/");
    	// Switch to new window opened
    	for(String winHandle : driver.getWindowHandles()){
    		second_driver.switchTo().window(winHandle);
    	}

    	// Perform the actions on new window
    	second_driver.manage().window().setSize(new Dimension(300,500));
    	 System.out.println("Window2 height Is -> "+second_driver.manage().window().getSize().getHeight());
         System.out.println("Window2 width Is -> "+second_driver.manage().window().getSize().getWidth());
         second_driver.manage().window().setPosition(new Point(400,100));
    	 System.out.println("Window2 position X coordinates Is -> "+second_driver.manage().window().getPosition().getX());
         System.out.println("Window2 position Y coordinates Is -> "+second_driver.manage().window().getPosition().getY());
    	System.out.println("Window 2");
    	// Close the new window, if that window no more required
    	//second_driver.close();

    /*	// Switch back to original browser (first window)
    	driver.switchTo().window(winHandleBefore);
*/
    	// Continue with original browser (first window)
    }
}

