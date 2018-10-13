package form_Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class SimpleDropdown {

	public void select(WebDriver driver) throws InterruptedException, IOException{
		
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		
		System.out.println("Input Forms link clicked");
		
		Thread.sleep(1500);
		
		driver.findElement(By.partialLinkText("Dropdown List")).click();
		
		System.out.println("Select link clicked");
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
		
		//Scroll down
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		//Find Select Element - Single Selection
		WebElement list1 = driver.findElement(By.xpath("//select[@id='select-demo']"));
		Select option1 = new Select(list1);
		List<WebElement> list = option1.getOptions();
		
		
		System.out.println("Multiple Select allowed = " + option1.isMultiple());
		
		//Print list values
		for(int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i).getText());
			
		}
		
		option1.selectByIndex(2);
		Thread.sleep(2000);
		System.out.println("Value selected is : " + option1.getFirstSelectedOption().getText());
		
		
		//Multiple Selection List
		WebElement list2 = driver.findElement(By.xpath("//select[@id='multi-select']"));
		Select option2 = new Select(list2);
		List<WebElement> listx = option2.getOptions();
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", list2);
		
		System.out.println("Multiple Select allowed = " + option2.isMultiple());
		//Print list values
				for(WebElement i : listx) {
					
					System.out.println(i.getText());
					
				}
		
		option2.selectByIndex(0);
		option2.selectByValue("Ohio");
		option2.selectByVisibleText("Pennsylvania");
		
		TakesScreenshot	 ts = (TakesScreenshot)driver;
		File source	= ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Screenshots/select.png"));
		
		Thread.sleep(2000);
		option2.deselectAll();
		
		System.out.println("----------------------------");
		System.out.println("-- Test Passed : Dropdown --");
		System.out.println("----------------------------");
		//driver.quit();
		
	}
	
}
