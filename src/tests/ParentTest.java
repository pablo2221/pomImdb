package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.PaginaDetallesPelicula;
import pages.PaginaPrincipal;
import pages.PaginasResultadosPeliculas;

public class ParentTest {
	
	WebDriver driver;
	WebDriverWait wait;
	PaginaPrincipal pagPrincipal;
	PaginasResultadosPeliculas pagResultados;
	PaginaDetallesPelicula pagDetallesPelicula;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);
		driver.get("https://imdb.com");
		
		pagPrincipal = new PaginaPrincipal(driver);
		pagResultados = new PaginasResultadosPeliculas(driver);
		pagDetallesPelicula = new PaginaDetallesPelicula(driver);
		
	}
	
	
	
	@After
	public void tearDown() {
		
		driver.quit();
		
	}
}
