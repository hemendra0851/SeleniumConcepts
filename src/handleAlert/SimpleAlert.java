package handleAlert;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SimpleAlert {

	public static void main(String[] args) throws InterruptedException, IOException, HeadlessException, AWTException {

		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
		
		String exePath = "F:\\Software\\Selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.manage().window().maximize();
		//Click in button
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()=\"Click me!\"])[1]")).click();
		
		String text = driver.switchTo().alert().getText();
		
		System.out.println("Alert message : "+text);
		
		Thread.sleep(2000);
		
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File(".\\Screenshots\\simpleAlert.png"));
		
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		driver.quit();

	}

}
