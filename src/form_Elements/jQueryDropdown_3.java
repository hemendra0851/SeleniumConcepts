package form_Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class jQueryDropdown_3 {

	public void select(WebDriver driver) throws InterruptedException, IOException{
		
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		
		System.out.println("Input Forms link clicked");
				Thread.sleep(1500);
				driver.findElement(By.partialLinkText("JQuery Select dropdown")).click();
				System.out.println("Select link clicked");
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				System.out.println(driver.getTitle());
				
		//Drop Down with Search box
		
		WebElement drp1 = driver.findElement(By.xpath("//*[contains(@class,'js-example-d')]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", drp1);
		Select option1 = new Select(drp1);
		List<WebElement> list1 = option1.getOptions();
		
		System.out.println("Multiple Select allowed = " + option1.isMultiple());
		
		//Print list values
		for(WebElement i : list1) {
			
			System.out.println(i.getText());
			
		}
		
		option1.selectByIndex(5);
		Thread.sleep(1000);
		System.out.println("Value selected is : " + option1.getFirstSelectedOption().getText());
		option1.selectByValue("GU"); //disabled option
		Thread.sleep(1000);
		System.out.println("Value selected is : " + option1.getFirstSelectedOption().getText());
		option1.selectByIndex(3);
		Thread.sleep(2000);
		System.out.println("Value selected is : " + option1.getFirstSelectedOption().getText());
		
		//Select by search field
		
				//List<WebElement> arrow = driver.findElements(By.xpath("//*[@class='select2-selection__arrow']"));
				//arrow.get(1).click();
				
				driver.findElement(By.xpath("(//*[@class='select2-selection__arrow'])[2]")).click();
				Thread.sleep(1500);
				WebElement search = driver.findElement(By.xpath("//span[contains(@class,'select2-dropdown')]/span/input"));
				search.sendKeys("No");
				search.sendKeys(Keys.ENTER);
				Thread.sleep(1500);
				System.out.println(option1.getFirstSelectedOption().getText());
				
				//driver.findElement(By.xpath("//*[@class='form-control']/optgroup")).click();
				WebElement check = driver.findElement(By.xpath("(//*[@class='form-control']//option)[4]"));
				
				System.out.println(check.getText());
				check.click();
		
		TakesScreenshot	 ts = (TakesScreenshot)driver;
		File source	= ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Screenshots/select3.png"));
		
		System.out.println("----------------------------");
		System.out.println("--Test Passed : jQueryDrp3--");
		System.out.println("----------------------------");
			//driver.quit();
		
	}
	
}
