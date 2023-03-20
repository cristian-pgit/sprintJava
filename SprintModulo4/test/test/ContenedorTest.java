
package test;


import org.junit.jupiter.api.Test;

import sprint.Contenedor;

import static org.junit.jupiter.api.Assertions.*;



public class ContenedorTest {
	
	@Test
	void correctNamePedro() {
		Contenedor cont = new Contenedor();
		assertEquals("Pedro", cont.pedirNombres());
		
	}

	@Test
	void runCorrectoEightUno() {
		Contenedor cont = new Contenedor();
		assertEquals(11111111, cont.pedirRun());
	}
	
	
	

}
