/**
 *@authors :	Cristian Carrillo - correcciones
 *				Matias Calderon - Comentarios
 *				Jorge Arancbia - modelacion de clase			   
 */
package sprint;


/**
 * Clase Capacitacion.
 */
public class Capacitacion {
	
	/** Declaracion de atributos id capacitacion, rut cliente, dia, hora, lugar, duracion, cantidad de asistenes */
	private int idCapa;
	private int rutC;
	private String dia;
	private String hora;
	private String lugar;
	private String duracion;
	private int cantAsist;
	
	// Get y Set
	/**
	 * Trae idCapa.
	 *
	 * @return idCapa retorna id capacitacion
	 */
	public int getIdCapa() {
		return idCapa;
	}
	
	/**
	 * Fija idCapa.
	 *
	 * @param idCapa modifica el valor de id capacitacion
	 */
	public void setIdCapa(int idCapa) {
		this.idCapa = idCapa;
	}
	
	/**
	 * Trae rutC.
	 *
	 * @return rutC retorna rut cliente
	 */
	public int getRutC() {
		return rutC;
	}
	
	/**
	 * Fija el rut cliente.
	 *
	 * @param  rutC modifica el valor rut cliente
	 */
	public void setRun(int rutC) {
		this.rutC = rutC;
	}
	
	/**
	 * Trae el dia.
	 *
	 * @return dia retorna dia 
	 */
	public String getDia() {
		return dia;
	}
	
	/**
	 * Fija dia.
	 *
	 * @param dia modifica el valor de dia
	 */
	public void setDia(String dia) {
		this.dia = dia;
	}
	
	/**
	 * Trae hora.
	 *
	 * @return hora retorna hora 
	 */
	public String getHora() {
		return hora;
	}
	
	/**
	 * Sets the hora.
	 *
	 * @param hora modifica el valor de hora
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	/**
	 * Trae lugar.
	 *
	 * @return lugar retorna valor lugar 
	 */
	public String getLugar() {
		return lugar;
	}
	
	/**
	 * Fija lugar.
	 *
	 * @param llugar modifica el valor de lugar
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	/**
	 * Trae la duracion.
	 *
	 * @return the duracion
	 */
	public String getDuracion() {
		return duracion;
	}
	
	/**
	 * Fija duracion.
	 *
	 * @param  duracion modifica valor de duracion 
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	/**
	 * Trae la cantidad de asistentes.
	 *
	 * @return cantAsist retorna valor de cantidad asistentes 
	 */
	public int getCantAsist() {
		return cantAsist;
	}
	
	/**
	 * Fija la cantidad de asistentes.
	 *
	 * @param cantAsist modifica el valor de cantidad de asistentes
	 */
	public void setCantAsist(int cantAsist) {
		this.cantAsist = cantAsist;
	}
	
	/**
	 * Metodo toString de la clase Capacitacion
	 *
	 * @return String con los datos de la clase
	 */
	@Override
	public String toString() {
		return "Id Capacitacion: " + idCapa + "\nRun: " + rutC + "\nDia: " + dia + "\nHora: " + hora + "\nLugar: "
				+ lugar + "\nDuracion: " + duracion + "\nCantidad de Asistentes: " + cantAsist;
	}

	/**
	 * Constructor vacio
	 */
	public Capacitacion () {

	}
	
	/**
	 * Constructor con datos
	 *
	 * @param idCapa
	 * @param run
	 * @param dia
	 * @param hora
	 * @param lugar
	 * @param duracion
	 */
	public Capacitacion ( int idCapa, String run, String dia, String hora, String lugar, String duracion) {

	}
	
	/**
	 * Metodo Mostrar detalles.
	 */
	public void mostrarDetalles() {
		System.out.println(ANSI_GREEN+"La Capacitacion sera en: "+lugar+" a las: "+hora+ 
				" del día: "+dia+", y durara: "+duracion+" minutos"+ANSI_RESET);
	}

	//Estas son constantes de cadenas de caracteres en Java que contienen códigos de escape ANSI
	//que se utilizan para establecer el color del texto en la consola.
	/** The Constant ANSI_GREEN. */
	public static final String ANSI_GREEN = "\u001B[32m";
	/** The Constant ANSI_RESET. */
	public static final String ANSI_RESET = "\u001B[0m";
}
