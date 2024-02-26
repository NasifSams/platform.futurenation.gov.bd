package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class SoftBD {
	
	WebDriver driver;
	 
	@BeforeMethod
	public void url() throws InterruptedException {
		
		System.setProperty("C:\\eclipse\\chrome-win64\\chrome.exe", "C:\\eclipse");
		
		driver= new ChromeDriver();
		
		driver.get("https://platform.futurenation.gov.bd/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String Exp_title="Futurenation | Homepage";
		String Act_title=driver.getTitle();
		System.out.println(Act_title);
		Thread.sleep(2000);
		Assert.assertEquals(Exp_title, Act_title);
		
	}
	
	
	
	@Test(priority=1,description="Invalid Email and Password")
	public void invalidSignupEmail() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div/div/div/a")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		WebElement invalidemail= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[3]/div/div/div/input"));
		js.executeScript("arguments[0].value='xy@gmail.com'", invalidemail);
		
		Thread.sleep(2000);
		WebElement invalidpass1=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[4]/div/div/div/input"));
		js.executeScript("arguments[0].value='Ppassword123'", invalidpass1);
		
		Thread.sleep(2000);
		WebElement invalidpass2=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[5]/div/div/div/input"));
		js.executeScript("arguments[0].value='Ppassword123'", invalidpass2);
		
		Thread.sleep(2000);
		
		WebElement button=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[6]/button"));
		js.executeScript("arguments[0].click();", button);
		
		String exp_result="Email required";
		String act_result= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[3]/div/div/p")).getText();
		
		Assert.assertEquals(exp_result, act_result);
	}
	
	@Test(priority=1,description="Invalid Email and Valid Password")
	public void invalidsignup() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div/div/div/a")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		WebElement invalidemail= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[3]/div/div/div/input"));
		js.executeScript("arguments[0].value='xy@gmail.com'", invalidemail);
		
		Thread.sleep(2000);
		WebElement validpass1=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[4]/div/div/div/input"));
		js.executeScript("arguments[0].value='Ppassword123'", validpass1);
		
		Thread.sleep(2000);
		WebElement validpass2=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[5]/div/div/div/input"));
		js.executeScript("arguments[0].value='Ppassword123'", validpass2);
		
		Thread.sleep(2000);
		
		WebElement button=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[6]/button"));
		js.executeScript("arguments[0].click();", button);
		
		String exp_result="invalid email";
		String act_result= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[3]/div/div/p")).getText();
		
		Assert.assertEquals(exp_result, act_result);
	}
	
	@Test(priority=1, description="valid user")
	public void validsignup() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div/div/div/a")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		WebElement invalidemail= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[3]/div/div/div/input"));
		js.executeScript("arguments[0].value='nasifsadiq16@gmail.com'", invalidemail);
		
		Thread.sleep(2000);
		WebElement invalidpass1=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[4]/div/div/div/input"));
		js.executeScript("arguments[0].value='Password123'", invalidpass1);
		
		Thread.sleep(2000);
		WebElement invalidpass2=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[5]/div/div/div/input"));
		js.executeScript("arguments[0].value='Password123'", invalidpass2);
		
		Thread.sleep(2000);
		
		WebElement button=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[6]/button"));
		js.executeScript("arguments[0].click();", button);
		
		String exp_result="Email required";
		String act_result= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div/div/div[3]/div/div/p")).getText();
		
		Assert.assertEquals(exp_result, act_result);
	
	
	}
	
	@Test(priority=1,description="valid Email and password")
	public void validSignin() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("nasifsadiq16@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Nasifsadiq16@");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/form/div[4]/input[2]")).click();
		Thread.sleep(2000);
		String Exp_title="Futurenation | Homepage";
		String Act_title=driver.getTitle();
		System.out.println(Act_title);
		Thread.sleep(2000);
		Assert.assertEquals(Exp_title, Act_title);
		
		
	}
	@Test(priority=1,description="invalid Email and  valid password")
	public void invalidSigninEmail() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("naasifsadiq16@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Nasifsadiq16@");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/form/div[4]/input[2]")).click();
		Thread.sleep(2000);
		String Exp_result="Invalid username or password.";
		String Act_result=driver.findElement(By.id("input-error")).getText();
		System.out.println(Act_result);
		Thread.sleep(2000);
		Assert.assertEquals(Exp_result, Act_result);
		
		
	}
	@Test(priority=1,description="valid Email and  invalid password")
	public void invalidSigninPassword() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("nasifsadiq16@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Naasifsadiq16@");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/form/div[4]/input[2]")).click();
		Thread.sleep(2000);
		String Exp_result="Invalid username or password.";
		String Act_result=driver.findElement(By.id("input-error")).getText();
		System.out.println(Act_result);
		Thread.sleep(2000);
		Assert.assertEquals(Exp_result, Act_result);
		
		
	}
	@Test(priority=1,description="Password Reset")
	public void forgetPassword() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/form/div[3]/div/div/div/span/a")).click();
		
		driver.findElement(By.id("username")).sendKeys("nasifsadiq16@gmail.com");
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[1]/div/form/div[2]/div/input")).click();
	}
	@Test(priority=2,description="Apply Job")
	public void JobApplay() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys("nasifsadiq16@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("Nasifsadiq16@");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/form/div[4]/input[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div/div/div[2]/div[1]")).click();
		Thread.sleep(1000);
       
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		WebElement invalidemail= driver.findElement(By.xpath("/html/body/div[5]/div[3]/ul/li[2]/a"));
		js.executeScript("arguments[0].click();", invalidemail);
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div/div/div/div/div/div[1]/ul/li[2]/p")).click();
		
		Thread.sleep(1000);
		WebElement apply= driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div/div/div/div/div/div[2]/div/div[2]/div/div[1]/div/div[5]/button"));
		js.executeScript("arguments[0].click();", apply);
		
		WebElement applyJob= driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div/div/div/div/div/div[2]/div/div[2]/div/div/div[4]/button[1]"));
		js.executeScript("arguments[0].click();", applyJob);
		
		
	}
		
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	

}
