package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaDetallesPelicula {
	
	WebElement nombreDirectorPelicula;
	private WebDriver driver;
	
	public PaginaDetallesPelicula(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		
	}

	public void verificarDirector (String nombreDirector) {
		
		nombreDirectorPelicula = driver.findElement(By.linkText(nombreDirector));
		if(nombreDirectorPelicula.isDisplayed()) {
			System.out.println("El link con el texto del director(a): " + nombreDirector + " si existe.");
		} else {
			System.out.println("El link con el texto del director(a):" + nombreDirector + " no existe.");
			System.exit(-1);
		}
	
	}

}
