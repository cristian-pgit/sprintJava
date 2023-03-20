/**
 *@authors :	Cristian Carrillo - correcciones
 *				Matias Calderon - Comentarios
 *				Jorge Arancbia - modelacion de clase			   
 */
package sprint;

// TODO: Auto-generated Javadoc
/**
 * Clase Revision.
 */
public class Revision {

	/** Declaracion de variables: idRevision, idTerreno, nombre, detalle, estado */
	private int idRevision;
	private int idTerreno;
	private String nombre;
	private String detalle;
	private int estado;

	//Get  y Set
	/**
	 * Trae valor de idRevision
	 *
	 * @return  idRevision retorna id Revision
	 */
	public int getIdRevision() {
		return idRevision;
	}
	
	/**
	 * Fija idRevision.
	 *
	 * @param  idRevision modifica el valor de id revision
	 */
	public void setIdRevision(int idRevision) {
		this.idRevision = idRevision;
	}
	
	/**
	 * Trae el idTerreno.
	 *
	 * @return idTerreno retorna id Terreno
	 */
	public int getIdTerreno() {
		return idTerreno;
	}
	
	/**
	 * SFija idTerreno.
	 *
	 * @param idTerreno modifica el valor de id Terreno
	 */
	public void setIdTerreno(int idTerreno) {
		this.idTerreno = idTerreno;
	}
	
	/**
	 * Fija el nombre.
	 *
	 * @return  nombre retorna nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Fija el nombre.
	 *
	 * @param nombre modifica el valor de nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets the detalle.
	 *
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * Fija detalle.
	 *
	 * @param detalle retorna detalle
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	/**
	 * Trae el estado.
	 *
	 * @return  estado retorna estado
	 */
	public int getEstado() {
		return estado;
	}
	
	/**
	 * Fija el estado.
	 *
	 * @param estado modifica el valor de estado
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	/**
	 * Metodo toString de la clase Revision
	 *
	 * @return String de la clase
	 */
	@Override
	public String toString() {
		return "Id Revision: " + idRevision + 
				"\nId Visita a Terreno: " + idTerreno + 
				"\nNombre de Revision: " + nombre + 
				"\nDetalle: "+ detalle + 
				"\nEstado: " + mosEstado();
	}
	
	/**
	 * Constructor vacio
	 */
	public Revision () {

	}
	
	/**
	 * Constructor con datos
	 *
	 * @param idRevision
	 * @param idTerreno 
	 * @param nombre
	 * @param detalle
	 * @param estado 
	 */
	public Revision (int idRevision, int idTerreno, String nombre, String detalle, String estado) {

	}

	/**
	 * Metodo mostrar estado.
	 *
	 * @return String que despliega 1 de tres estados segun valor
	 */
	public String mosEstado() {
		if (estado == 1) {
			return "Sin Problemas";
		} else if (estado == 2) {
			return "Con Observaciones";
		} else {
			return "No Aprueba";
		}
	}
}


