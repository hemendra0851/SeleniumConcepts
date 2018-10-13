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

public class jQueryDropdown_1 {

	public void select(WebDriver driver) throws InterruptedException, IOException{
		
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		
		System.out.println("Input Forms link clicked");
				Thread.sleep(1500);
				driver.findElement(By.partialLinkText("JQuery Select dropdown")).click();
				System.out.println("Select link clicked");
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				System.out.println(driver.getTitle());
				
		//Drop Down with Search box
		
		WebElement drp1 = driver.findElement(By.xpath("//*[@id='country']"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", drp1);
		Select option1 = new Select(drp1);
		List<WebElement> list1 = option1.getOptions();
		
		System.out.println("Dropdown Notify function test");
				
		System.out.println("Multiple Select allowed = " + option1.isMultiple());
		
		//Print list values
		for(WebElement i : list1) {
			
			System.out.println(i.getText());
			
		}
		
		option1.selectByIndex(2);
		Thread.sleep(2000);
		System.out.println("Value selected is : " + option1.getFirstSelectedOption().getText());
		
		//Select by search field
		
		WebElement arrow = driver.findElement(By.xpath("//*[@class='select2-selection__arrow'][1]"));
		arrow.click();
		WebElement search = driver.findElement(By.xpath("//*[@class='select2-search select2-search--dropdown']/input"));
		search.sendKeys("Hong");
		search.sendKeys(Keys.ENTER);
		System.out.println(option1.getFirstSelectedOption().getText());
		
		
		TakesScreenshot	 ts = (TakesScreenshot)driver;
		File source	= ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Screenshots/select1.png"));
		
		System.out.println("----------------------------");
		System.out.println("--Test Passed : jQueryDrp1--");
		System.out.println("----------------------------");
			//driver.quit();
		
	}
	
}
