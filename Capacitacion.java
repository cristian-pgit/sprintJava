package sprint;



public class Capacitacion {
	private int idCapa;
	private int rutC;
	private String dia;
	private String hora;
	private String lugar;
	private String duracion;
	private int cantAsist;
	


	
	public int getIdCapa() {
		return idCapa;
	}
	public void setIdCapa(int idCapa) {
		this.idCapa = idCapa;
	}
	public int getRutC() {
		return rutC;
	}
	public void setRun(int rutC) {
		this.rutC = rutC;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	public int getCantAsist() {
		return cantAsist;
	}
	public void setCantAsist(int cantAsist) {
		this.cantAsist = cantAsist;
	}
	@Override
	public String toString() {
		return "Id Capacitacion: " + idCapa + "\nRun: " + rutC + "\nDia: " + dia + "\nHora: " + hora + "\nLugar: "
				+ lugar + "\nDuracion: " + duracion + "\nCantidad de Asistentes: " + cantAsist;
	}

	public Capacitacion () {

	}
	public Capacitacion ( int idCapa, String run, String dia, String hora, String lugar, String duracion) {

	}
	
	public void mostrarDetalles() {
		System.out.println(ANSI_GREEN+"La Capacitacion sera en: "+lugar+" a las: "+hora+ " del día: "+dia+", y durara: "+duracion+" minutos"+ANSI_RESET);
	}

	
	/** The Constant ANSI_GREEN. */
	public static final String ANSI_GREEN = "\u001B[32m";
	/** The Constant ANSI_RESET. */
	public static final String ANSI_RESET = "\u001B[0m";
}
