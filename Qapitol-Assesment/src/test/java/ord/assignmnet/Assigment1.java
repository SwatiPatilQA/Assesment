package ord.assignmnet;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assigment1
{
@Test
	void demoTest() throws InterruptedException{

		WebDriver driver;
		String url = "https://www.amazon.in/";
		String path = System.getProperty("user.dir");  //user current working directory
		System.out.print("project path = "+path);
		System.setProperty("webdriver.chrome.driver", path+"\\drivers\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// versin 4 onwards

		driver.findElement(By.id("nav-hamburger-menu")).click(); 
		WebElement ele = driver.findElement(By.xpath("//div[text()='TV, Appliances, Electronics']"));
		ele.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;   //wrap the driver
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		driver.findElement(By.xpath("//li/a[@href=\"/gp/browse.html?node=1389396031&ref_=nav_em_sbc_tvelec_television_0_2_9_2\"]")).click();

		driver.findElement(By.xpath("//span[text()='Smart Televisions']")).click();
		WebElement chBox =driver.findElement(By.xpath("//li[@id='p_89/Samsung']//i"));
		chBox.click();
		Thread.sleep(3000);


		driver.findElement(By.xpath("//span[@class='a-button a-button-dropdown a-button-small']")).click();
		driver.findElement(By.xpath("//a[text()='Price: High to Low']")).click();


		String MainWindow= driver.getWindowHandle();		

		driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[3]")).click();
		String MainWindow2=driver.getWindowHandle();


		System.out.println("WindId"+MainWindow +" " +MainWindow);

		Set<String> childWind= driver.getWindowHandles();
		Iterator<String> itr =childWind.iterator();
		while(itr.hasNext())			
		{
		String s1 =itr.next();
		
		
		if(!MainWindow2.equalsIgnoreCase(s1))			
		{ 
			System.out.println("WindID :"+s1);
			driver.switchTo().window(s1);
			WebElement el = driver.findElement(By.xpath("//h1[text()=' About this item ']"));
	
			JavascriptExecutor j = (JavascriptExecutor)driver;   //wrap the driver
			j.executeScript("arguments[0].scrollIntoView(true)", el);
			String actual = el.getText();
			System.out.println(actual);
			String expected = "About this item";
	
			Assert.assertEquals(actual, expected);
			
			System.out.println("About this item section is Present ");
		}
		}
		driver.quit();

	}
}
