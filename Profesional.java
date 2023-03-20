/**
 *@authors :	Matias Calderon - Modelacion de clase		   
 */
package sprint;


/**
 * Clase Profesional extiende de clase Usuario
 */
public class Profesional extends Usuario{

	/** Declaracion de variables, atributos de Usuario*/
	private String tituloProfesional;
	private String fechaIngreso;

	/**
	 * Constructor vacio
	 */
	public Profesional() {

	}


	/**
	 * Constructor Profesional con datos, con Super que trae datos de Usuario
	 *
	 * @param nUsuario
	 * @param fNacimiento
	 * @param run
	 * @param tituloProfesional
	 * @param fechaIngreso
	 */
	public Profesional(String nUsuario, String fNacimiento, int run, String tituloProfesional, String fechaIngreso) {
		super(nUsuario, fNacimiento, run);
		this.tituloProfesional = tituloProfesional;
		this.fechaIngreso = fechaIngreso;

	}

	//Getter and Setter
	/**
	 * Trae titulo profesional.
	 *
	 * @return the tituloProfesional
	 */
	public String getTituloProfesional() {
		return tituloProfesional;
	}


	/**
	 * Fija titulo profesional.
	 *
	 * @param tituloProfesional the tituloProfesional to set
	 */
	public void setTituloProfesional(String tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}


	/**
	 * Trae fecha de ingreso.
	 *
	 * @return the fechaIngreso
	 */
	public String getFechaIngreso() {
		return fechaIngreso;
	}


	/**
	 * Fija fecha ingreso.
	 *
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * Metodo Analizar usuario que se deriva de Interfaz Asesoria.
	 */
	@Override
	public void analizarUsuario() {
		super.analizarUsuario();
		System.out.println("\nTitulo Profesional:" + tituloProfesional + 
				"\nFecha de Ingreso: " + fechaIngreso );
	}


	/**
	 * Metodo toString de la clase Profesional
	 *
	 * @return String con datos de la clase
	 */
	@Override
	public String toString() {
		return "Titulo Profesional= " + tituloProfesional + "\nFechaIngreso=" + fechaIngreso;
	}

}
