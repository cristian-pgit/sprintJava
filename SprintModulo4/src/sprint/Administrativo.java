/**
 *@authors :	Matias Calderon - Modelacion de clase		   
 */
package sprint;


/**
 * Clase Adrminisitrativo que extiende de Usuario
 */
public class Administrativo extends Usuario {

	//Declaracion Variables, que extienden de Usuarios
	private String area;
	private int experiencia;
	
	/**
	 * Constructor Vacio
	 */
	public Administrativo() {
		
	}
	
	/**
	 * Constructor con datos
	 *
	 * @param nUsuario
	 * @param userName
	 * @param fNacimiento
	 * @param run
	 * @param area
	 * @param experiencia
	 */
	public Administrativo(String nUsuario, String userName, String fNacimiento, int run, String area, int experiencia) {
		super(nUsuario, fNacimiento, run);
		this.area = area;
		this.experiencia = experiencia;
	}
	
	//Gett and Sett
	/**
	 * Trae el area.
	 *
	 * @return area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * Gets the experiencia.
	 *
	 * @return the experiencia
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * Fija area.
	 *
	 * @param area modifica el valor de area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * Fija exPrevia.
	 *
	 * @param experiencia modifica el valor de experiencia
	 */
	public void setExPrevia(int experiencia) {
		this.experiencia = experiencia;
	}
	
	/**
	 * Metodo Analizar usuario que se deriva de Interfaz Asesoria.
	 */
	@Override
	public void analizarUsuario() {
		super.analizarUsuario();
		System.out.println("Area: "+area+
				"\nAnios de Experiencia Previa: "+experiencia);
	}

	/**
	 * Metodo toString de la clase Administrativo
	 *
	 * @return string con datos
	 */
	@Override
	public String toString() {
		return "Area: "+area+
				"\nAnios de Experiencia Previa: "+experiencia;
	}
	
	
	@Override
	public void analizarUserT() {
		System.out.println("Area: "+area+
				"\nAnios de Experiencia Previa: "+experiencia);
	}
	
	
}
