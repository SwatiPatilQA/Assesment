package ord.assignmnet;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assigment {

	public static void main(String[] args) throws InterruptedException 
	{
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
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='a-button a-button-dropdown a-button-small']")).click();
		driver.findElement(By.xpath("//a[text()='Price: High to Low']")).click();
		driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[3]")).click();
		//driver.findElement(By.xpath("//h1[text()=' About this item ']"));
		
		}
}
