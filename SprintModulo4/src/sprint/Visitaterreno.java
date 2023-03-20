/**
 *@authors :	Cristian Carrillo - correcciones
 *				Matias Calderon - Comentarios
 *				Jorge Arancbia - modelacion de clase			   
 */
package sprint;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Visitaterreno.
 */
public class Visitaterreno {
	
	/** Declaracion variables id Terreno, rut cliente, dia, hora, lugar, comentarios, revision */
	private int idTerreno;
	private int rutC;
	private String dia;
	private String hora;
	private String lugar;
	private String comentarios;
	private List<Revision> revi = new ArrayList<Revision>();
	
	// Get y Set
	/**
	 * Trae idTerreno.
	 *
	 * @return idTerreno retorna id terreno
	 */
	public int getIdTerreno() {
		return idTerreno;
	}
	
	/**
	 * Fija el idTerreno.
	 *
	 * @param idTerreno modifica el valor de id terreno
	 */
	public void setIdTerreno(int idTerreno) {
		this.idTerreno = idTerreno;
	}
	
	/**
	 * Trae el rutC.
	 *
	 * @return rutC retorna rut cliente
	 */
	public int getRutC() {
		return rutC;
	}
	
	/**
	 * Fija rutC.
	 *
	 * @param rutC modifica el valor de rut cliente
	 */
	public void setRutC(int rutC) {
		this.rutC = rutC;
	}
	
	/**
	 * Trae el dia.
	 *
	 * @return  dia retorna dia
	 */
	public String getDia() {
		return dia;
	}
	
	/**
	 * Fija el dia.
	 *
	 * @param  dia modifica el valor de dia
	 */
	public void setDia(String dia) {
		this.dia = dia;
	}
	
	/**
	 * Trae la hora.
	 *
	 * @return hora retorna hora
	 */
	public String getHora() {
		return hora;
	}
	
	/**
	 * Fija la hora.
	 *
	 * @param hora modifica el valor de hora
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	/**
	 * Trae el lugar.
	 *
	 * @return lugar retorna lugar
	 */
	public String getLugar() {
		return lugar;
	}
	
	/**
	 * Fija el lugar.
	 *
	 * @param lugar modifica el valor de lugar
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	/**
	 * Trae los comentarios.
	 *
	 * @return comentarios retorna comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}
	
	/**
	 * Sets the comentarios.
	 *
	 * @param  comentarios modifica el valor de comentarios
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	/**
	 * Metodo toString de clase Visitaterreno
	 *
	 * @return String con los datos de la clase
	 */
	@Override
	public String toString() {
		return "Visitaterreno [idTerreno=" + idTerreno + ", run=" + rutC + ", dia=" + dia + ", hora=" + hora + ", lugar="
				+ lugar + ", comentarios=" + comentarios + "]";
	}
	
	/**
	 * Constructor Vacio
	 */
	public Visitaterreno () {
	}
	
	/**
	 * Constructor con datos
	 *
	 * @param idTerreno
	 * @param run
	 * @param dia
	 * @param hora
	 * @param lugar
	 * @param comentarios
	public Visitaterreno (int idTerreno, String run, String dia, String  hora, String lugar, String comentarios ) {
	}
	
	/**
	 * metodo addRevi. Anade Revision a la List<Revision>
	 *
	 * @param anade item r a la lista
	 */
	public void addRevi(Revision r) {
		revi.add(r);
	}

}
