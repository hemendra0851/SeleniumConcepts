package mouseEvents;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SamplePage {

	public void select(WebDriver driver) throws InterruptedException, IOException{
		
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		
		System.out.println("Input Forms link clicked");
				Thread.sleep(1500);
				driver.findElement(By.partialLinkText("Ajax Form")).click();
				System.out.println("Ajax link clicked");
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				System.out.println(driver.getTitle());
				
		//Drop Down with Search box
		
		WebElement input = driver.findElement(By.xpath("//textarea[contains(@name,'description') or @id='description']"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);
		
		Thread.sleep(1000);
				
		TakesScreenshot	 ts = (TakesScreenshot)driver;
		File source	= ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Screenshots/select3.png"));
		
		System.out.println("----------------------------");
		System.out.println("-- Test Passed : AjaxForm --");
		System.out.println("----------------------------");
			//driver.quit();
		
	}
	
}
