package sprint;


public class Capacitacion {
	 private int  id_Capa;
	 private String run;
	 private String dia;
	 private String hora;
	 private String lugar;
	 private String duracion;
	 int cantAsist;
	public int getId_Capa() {
		return id_Capa;
	}
	public void setId_Capa(int id_Capa) {
		this.id_Capa = id_Capa;
	}
	public String getRun() {
		return run;
	}
	public void setRun(String run) {
		this.run = run;
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
	@Override
	public String toString() {
		return "Capacitacion [id_Capa=" + id_Capa + ", run=" + run + ", dia=" + dia + ", hora=" + hora + ", lugar="
				+ lugar + ", duracion=" + duracion + ", cantAsist=" + cantAsist + "]";
	}
	
	public Capacitacion () {
		
	}
	public Capacitacion ( int idCapa, String run, String dia, String hora, String lugar, String duracion) {
		
	}

}
