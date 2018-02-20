package tests;

import org.junit.Test;

import pages.PaginaDetallesPelicula;
import pages.PaginaPrincipal;
import pages.PaginasResultadosPeliculas;

public class PomImdbTest extends ParentTest {
	
	@Test
	public void testFindMovie() {
		
		/*paginaPrincipal > buscarPelicula > WebElement campoBusqueda, botonBusqueda*/
		
		PaginaPrincipal pagPrincipal = new PaginaPrincipal();
		pagPrincipal.buscarPelicula("Thor");
		
		/*PaginasResultadosDePeliculas > verificarPeliculaCiertaFecha > abrirPeliculaCiertaFecha > WebElement seccionTitulosPelicula*/
		
		PaginasResultadosPeliculas pagResultadosPelicula = new PaginasResultadosPeliculas();
		pagResultadosPelicula.verificarPeliculaCiertaFecha("Thor", "2011");
		pagResultadosPelicula.abrirPeliculaCiertaFecha("Thor","2011");

		/*paginaDetallesDePelicula > verificarDirector > WebElement nombreDirectorPelicula*/
		
		PaginaDetallesPelicula pagDetallesPelicula = new PaginaDetallesPelicula();
		pagDetallesPelicula.verificarDirector("Kenneth Branagh");
	}

}
