package sprintgrupaloo;

public class Visitaterreno {
	
	private int idTerreno;
	private String run;
	private String dia;
	private String hora;
	private String lugar;
	private String comentarios;
	
	
	public int getIdTerreno() {
		return idTerreno;
	}
	public void setIdTerreno(int idTerreno) {
		this.idTerreno = idTerreno;
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
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	@Override
	public String toString() {
		return "Visitaterreno [idTerreno=" + idTerreno + ", run=" + run + ", dia=" + dia + ", hora=" + hora + ", lugar="
				+ lugar + ", comentarios=" + comentarios + "]";
	}
	
	public Visitaterreno () {
	}
	public Visitaterreno (int idTerreno, String run, String dia, String  hora, String lugar, String comentarios ) {
	}
	

}
