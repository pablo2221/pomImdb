package utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BusquedaPelicula {
	
	static WebDriver driver;

	public static void main(String[] args) {
		setUp("http://imdb.com");
		buscarPelicula("It");
		verificarExistePeliculaCiertaFecha("It", "1990");
		clickLinkPeliculaCiertaFecha("It", "1990");
		

	}

	private static void setUp(String url) {
		System.setProperty("webdriver.chrome.driver", "/Users/omarnavarro/test_automation/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);
	}

	private static void buscarPelicula(String nombrePelicula) {
		driver.findElement(By.id("navbar-query")).sendKeys(nombrePelicula);
		driver.findElement(By.id("navbar-submit-button")).click();
		
	}

	private static void verificarExistePeliculaCiertaFecha(String nombrePelicula, String fecha) {
		WebElement renglonCorrecto = null;
		List<WebElement> renglones = driver.findElements(By.xpath("//tr"));
		for(WebElement renglon: renglones) {
			if(renglon.getText().contains(nombrePelicula) && renglon.getText().contains(fecha)) {
				renglonCorrecto = renglon;
				System.out.println("La pelicula " + nombrePelicula + " con fecha " + fecha + " fue encontrada.");
				break;
			}	
		}
		if(renglonCorrecto == null) {
			System.out.println("La pelicula " + nombrePelicula + " con fecha " + fecha + " no fue encontrada.");
			System.exit(-1);
		}
		
	}

	private static void clickLinkPeliculaCiertaFecha(String nombrePelicula, String fecha) {
		WebElement renglonCorrecto = null;
		List<WebElement> renglones = driver.findElements(By.xpath("//tr"));
		for(WebElement renglon: renglones) {
			if(renglon.getText().contains(nombrePelicula) && renglon.getText().contains(fecha)) {
				renglonCorrecto = renglon;
				System.out.println("La pelicula " + nombrePelicula + " con fecha " + fecha + " fue encontrada.");
				break;
			}	
		}
		//si encuentro el renglon correcto, entonces darle click al link que esta dentro del renglon.
		 if(renglonCorrecto != null) {
			 WebElement linkPelicula = renglonCorrecto.findElement(By.xpath(".//td[@class = 'result_text']//a"));
			 linkPelicula.click();
		 }
	}

}
