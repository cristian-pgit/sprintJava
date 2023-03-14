package sprintgrupaloo;

public class Revision {

	private int idRevision;
	private int idTerreno;
	private String nombre;
	private String detalle;
	private String estado;
	
	
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Revision [idRevision=" + idRevision + ", idTerreno=" + idTerreno + ", nombre=" + nombre + ", detalle="
				+ detalle + ", estado=" + estado + "]";
	}
	public Revision () {
	
}
    public Revision (int idRevision, int idTerreno, String nombre, String detalle, String estado) {
    	
    }
}
    	
  
    