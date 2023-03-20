/**
 *@authors :	Matias Calderon - Modelacion de clase		   
 */
package sprint;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


/**
 * Clase Usuario que implementa  clase Asesoria
 */
public class Usuario implements Asesoria {
	
	/** Declaracion de variable nombre, fecha de nacimiento y run */
	private String nUsuario;
	private String fNacimiento;
	private int run;

	
	/**
	 * Constructor vacio
	 */
	public Usuario() {
		
	}
	
	/**
	 * Constructor con datos
	 *
	 * @param nUsuario
	 * @param fNacimiento
	 * @param run
	 */
	public Usuario(String nUsuario, String fNacimiento,int run) {
		this.nUsuario = nUsuario;
		this.fNacimiento = fNacimiento;
		this.run = run;
	}
	

	//Getter and Setter
	/**
	 * Trae usuario.
	 *
	 * @return el nombre
	 */
	public String getUsuario() {
		return nUsuario;
	}

	/**
	 * Fija usuario.
	 *
	 * @param nombre the nombre to set
	 */
	public void setUsuario(String usuario) {
		this.nUsuario = usuario;
	}

	/**
	 * Trae la Fecha de nacimiento.
	 *
	 * @return the fNacimiento
	 */
	public String getfNacimiento() {
		return fNacimiento;
	}

	/**
	 * Fija fNacimiento.
	 *
	 * @param fNacimiento the fNacimiento to set
	 */
	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	/**
	 * Trae el run.
	 *
	 * @return the rut
	 */
	public int getRun() {
		return run;
	}

	/**
	 * Fija run.
	 *
	 * @param run the new run
	 */
	public void setRun(int run) {
		this.run = run;
	}
	
	/**
	 * Metodo Mostrar Edad.
	 */
	public void mostrarEdad() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fNacimiento, formatter);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNac, fechaActual);
        int edad = periodo.getYears();
        System.out.println("La edad de " + nUsuario + " es: " + edad + " años.");
	}

	/**
	 * Metodo toString de la clase Usuario
	 *
	 * @return String con datos de la clase
	 */
	@Override
	public String toString() {
		return "Usuario: " + nUsuario + 
				"\nFecha de Nacimiento: " + fNacimiento + 
				"\nRun: " + run ;
	}
	
	/**
	 * Metodo Analizar usuario que se deriva de Interfaz Asesoria.
	 */
	@Override
	public void analizarUsuario() {
		System.out.println("Usuario: " + nUsuario + 
				"\nRun: " + run );
		
	}
	
}
