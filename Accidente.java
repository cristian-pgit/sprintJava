/**
 *@authors :	Cristian Carrillo - correcciones
 *				Matias Calderon - Comentarios
 *				Jorge Arancbia - modelacion de clase			   
 */
package sprint;




/**
 * Clase Accidente
 */
public class Accidente {
	
	
      /** Atributos de la clase Accidente */
      private int idAccid;
      private int rutC ;
      private String dia;
      private String hora;
      private String lugar;
      private String origen;
      private String consec;
      
      
	/**
	 * Trae el valor de idAccid
	 *
	 * @return el valor de Id de Accidente
	 */
	public int getidAccid() {
		return idAccid;
	}
	
	/**
	 * Fija el valor de idAccid
	 *
	 * @param idAccid modifica el valor de id Accidente
	 */
	public void setidAccid(int idAccid) {
		this.idAccid = idAccid;
	}
	
	/**
	 * Trae el valor de RutC
	 *
	 * @return rutC retorna el valor de rut cliente
	 */
	public int getRutC() {
		return rutC;
	}
	
	/**
	 * Fija el valor de rutC
	 *
	 * @param rutC modifica el valor de rut cliente
	 */
	public void setRutC(int rutC) {
		this.rutC = rutC;
	}
	
	/**
	 * Trae el valor de dia
	 *
	 * @return dia retorna valor de dia
	 */
	public String getdia() {
		return dia;
	}
	
	/**
	 * Fija el valor de dia
	 *
	 * @param dia modifica el valor de dia
	 */
	public void setdia(String dia) {
		this.dia = dia;
	}
	
	/**
	 * Trae el valor de hora
	 *
	 * @return hora retorna el valor de hora
	 */
	public String getHora() {
		return hora;
	}
	
	/**
	 * Fija hora.
	 *
	 * @param hora modifica el valor de hora
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	/**
	 * Trae el Lugar
	 *
	 * @return lugar retorna valor lugar
	 */
	public String getLugar() {
		return lugar;
	}
	
	/**
	 * Fija lugar
	 *
	 * @param lugar modifica el valor de lugar
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	/**
	 * Trae valor de origen
	 *
	 * @return origen retorna valor origen
	 */
	public String getOrigen() {
		return origen;
	}
	
	/**
	 * Fija origen.
	 *
	 * @param origen modifica el valor de origen
	 */
	public void setorigen(String origen) {
		this.origen = origen;
	}
	
	/**
	 * Fija consecuencias
	 *
	 * @return consec retorna el valor de consecuencia
	 */
	public String getconsec() {
		return consec;
	}
	
	/**
	 * Fija consecuencias
	 *
	 * @param consec modifica el valor de consecuencia
	 */
	public void setconsec(String consec) {
		this.consec = consec;
	}
	
	/**
	 * Metodo toString
	 *
	 * @return string the la clase
	 */
	@Override
	public String toString() {
		return "Id Accidente: " + idAccid + 
				"\nRut Cliente: " + rutC + 
				"\nDia: " + dia + 
				"\nHora: " + hora + 
				"\nLugar: " + lugar + 
				"\nOrigen: " + origen + 
				"\nConsecuencias: " + consec;
	}
      
    /**
     * Constructor vacio.
     */
    public Accidente () {  
      
      
}
    
    /**
     * Constructor con parametros
     *
     * @param idAccid
     * @param run 
     * @param dia 
     * @param hora
     * @param lugar
     * @param origen
     * @param consec
     */
    public Accidente(int idAccid, String run, String dia, String hora, String lugar , String origen, String consec) {
    	
    }
}