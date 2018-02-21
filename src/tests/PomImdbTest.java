package tests;

import org.junit.Test;

import pages.PaginaDetallesPelicula;
import pages.PaginaPrincipal;
import pages.PaginasResultadosPeliculas;

public class PomImdbTest extends ParentTest {
	
	@Test
	public void testFindMovie() {
		
		/*paginaPrincipal > buscarPelicula > WebElement campoBusqueda, botonBusqueda*/
		
		
		pagPrincipal.buscarPelicula("Thor");
		
		/*PaginasResultadosDePeliculas > verificarPeliculaCiertaFecha > abrirPeliculaCiertaFecha > WebElement seccionTitulosPelicula*/
		
		
		pagResultados.verificarPeliculaCiertaFecha("Thor", "2011");
		pagResultados.abrirPeliculaCiertaFecha("Thor","2011");

		/*paginaDetallesDePelicula > verificarDirector > WebElement nombreDirectorPelicula*/
		
		//PaginaDetallesPelicula pagDetallesPelicula = new PaginaDetallesPelicula("Kenneth Branagh");
		pagDetallesPelicula.verificarDirector("Kenneth Branagh");
	}

}
