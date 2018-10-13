package form_Elements;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AjaxForm {

	public void select(WebDriver driver) throws InterruptedException, IOException{
		
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		
		System.out.println("Input Forms link clicked");
				Thread.sleep(1500);
				driver.findElement(By.partialLinkText("Ajax Form")).click();
				System.out.println("Ajax link clicked");
				
				System.out.println(driver.getTitle());
				
				WebElement input = driver.findElement(By.xpath("//*[@id='title']"));
		WebElement textarea = driver.findElement(By.xpath("//textarea[@id='description']"));
		WebElement submit = driver.findElement(By.xpath("(//*[@type='button'])[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);
		
		input.sendKeys("John ");
		Thread.sleep(800);
		input.sendKeys("Doe");
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", textarea);
		textarea.sendKeys("Test Comment");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
		
		submit.click();
		
		Thread.sleep(3000);
		
		WebElement body = driver.findElement(By.tagName("body"));
	    String bodyText = body.getText();
	    String text = "Form submited Successfully!";
	    if (bodyText.contains(text)) {
	    	
	    	System.out.println("Message present: ");
	    	int index = bodyText.indexOf(text);
	    	System.out.println(bodyText.substring(index, 550));
	    }
	    
	    else	{
	    	System.out.println("Message not present");
	    }
	    	
		TakesScreenshot	 ts = (TakesScreenshot)driver;
		File source	= ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Screenshots/ajax.png"));
		
		System.out.println("----------------------------");
		System.out.println("-- Test Passed : AjaxForm --");
		System.out.println("----------------------------");
			//driver.quit();
		
	}
	
}
