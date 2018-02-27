package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginasResultadosPeliculas {
	
	WebElement seccionTitulosPelicula;
	WebElement seccionTitulosPelicula2;
	private WebDriver driver;
	
	public PaginasResultadosPeliculas(WebDriver driver) {
		
		this.driver = driver;
		
	}

	public void verificarPeliculaCiertaFecha (String nombrePelicula, String fecha) {
		
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
		
	public void abrirPeliculaCiertaFecha (String nombrePelicula, String fecha){
		
		WebElement renglonCorrecto = null;
		List<WebElement> renglones = driver.findElements(By.xpath("//tr"));
		
		for(WebElement renglon: renglones) {
			
			if(renglon.getText().contains(nombrePelicula) && renglon.getText().contains(fecha)) {
				
				renglonCorrecto = renglon;
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
