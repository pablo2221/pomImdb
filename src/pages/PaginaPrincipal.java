package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaPrincipal {
	
	WebElement campoBusqueda;
	WebElement botonBusqueda;
	private WebDriver driver;
	
	
	
	public PaginaPrincipal(WebDriver driver) {
		
		this.driver = driver;
		
	}



	public void buscarPelicula(String nombrePelicula) {
		
		campoBusqueda = driver.findElement(By.id("navbar-query"));
		campoBusqueda.clear();
		campoBusqueda.sendKeys(nombrePelicula);
		botonBusqueda = driver.findElement(By.id("navbar-submit-button"));
		botonBusqueda.click();
		
	}
	
	

}
