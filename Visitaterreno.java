package sprint;

import java.util.ArrayList;
import java.util.List;

public class Visitaterreno {
	
	private int idTerreno;
	private int rutC;
	private String dia;
	private String hora;
	private String lugar;
	private String comentarios;
	private List<Revision> revi = new ArrayList<Revision>();
	
	
	public int getIdTerreno() {
		return idTerreno;
	}
	public void setIdTerreno(int idTerreno) {
		this.idTerreno = idTerreno;
	}
	public int getRutC() {
		return rutC;
	}
	public void setRutC(int rutC) {
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
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	@Override
	public String toString() {
		return "Visitaterreno [idTerreno=" + idTerreno + ", run=" + rutC + ", dia=" + dia + ", hora=" + hora + ", lugar="
				+ lugar + ", comentarios=" + comentarios + "]";
	}
	
	public Visitaterreno () {
	}
	public Visitaterreno (int idTerreno, String run, String dia, String  hora, String lugar, String comentarios ) {
	}
	
	public void addRevi(Revision r) {
		revi.add(r);
	}

}
