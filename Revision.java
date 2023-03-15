package sprint;

public class Revision {

	private int idRevision;
	private int idTerreno;
	private String nombre;
	private String detalle;
	private int estado;


	public int getIdRevision() {
		return idRevision;
	}
	public void setIdRevision(int idRevision) {
		this.idRevision = idRevision;
	}
	public int getIdTerreno() {
		return idTerreno;
	}
	public void setIdTerreno(int idTerreno) {
		this.idTerreno = idTerreno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Id Revision: " + idRevision + 
				"\nId Visita a Terreno: " + idTerreno + 
				"\nNombre de Revision: " + nombre + 
				"\nDetalle: "+ detalle + 
				"\nEstado: " + mosEstado();
	}
	public Revision () {

	}
	public Revision (int idRevision, int idTerreno, String nombre, String detalle, String estado) {

	}

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


