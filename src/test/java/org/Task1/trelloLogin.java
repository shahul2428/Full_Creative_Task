package org.Task1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class trelloLogin {

	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	driver.get("https://trello.com/");
	
	driver.findElement(By.linkText("Log in")).click();
	driver.findElement(By.id("user")).sendKeys("xamedo8240@harcity.com");
	driver.findElement(By.id("login")).click();
	
	driver.get(driver.getCurrentUrl());
	WebElement password = driver.findElement(By.name("password"));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(password));
	password.sendKeys("Hameed@2428");
	driver.findElement(By.id("login-submit")).click();
	
	
	driver.findElement(By.xpath("//p[text()='Create']")).click();
	driver.findElement(By.xpath("//span[text()='Create board']")).click();
	driver.findElement(By.xpath("//input[@data-test-id='create-board-title-input']")).sendKeys("Task 1");
	driver.findElement(By.xpath("//button[text()='Create']")).click();
	
	
	driver.findElement(By.xpath("//input[@name='name']")).sendKeys("List A");
	driver.findElement(By.xpath("//input[@value='Add list']")).click();
	driver.findElement(By.xpath("//input[@name='name']")).sendKeys("List B");
	driver.findElement(By.xpath("//input[@value='Add list']")).click();
	
	driver.findElement(By.xpath("(//a[contains(@class,'open-card-composer')])[1]")).click();
	driver.findElement(By.xpath("//textarea[contains(@placeholder,'this card')]")).sendKeys("Move Card");
	driver.findElement(By.xpath("//input[@value='Add card']")).click();
	
	Actions action = new Actions(driver);
	WebElement Source1 = driver.findElement(By.xpath("//a[contains(@class,'ui-droppable')]"));
	WebElement Target1 = driver.findElement(By.xpath("(//div[contains(@class,'list js-list-content')])[2]"));
	action.dragAndDrop(Source1, Target1).build().perform();
	
	WebElement Moved = driver.findElement(By.xpath("//a[contains(@class,'ui-droppable')]"));
	Point location = Moved.getLocation();
	System.out.println("X Coordinate is : " + location.getX());
	System.out.println("Y Coordinate is : "	+ location.getY());
	
	}
	
	
}
