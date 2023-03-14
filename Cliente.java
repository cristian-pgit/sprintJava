package sprint;

public class Cliente extends Usuario {
	//Declaracion de variables, atributos de Usuario
	private int rut;
	private String nombres;
	private String apellidos;
	private int telefono;
	private int afp;
	private int sds;
	private String direccion;
	private String comuna;
	private int edad;
	
	//Constructor Cliente vacio
	
	public Cliente() {
		
	}
	
	// Constructor Cliente con datos
	
	public Cliente (int rut, String nombres, String apellidos, int telefono, int afp, int sds, String direccion,
			String comuna, int edad) {
		this.rut=rut;
		this.nombres=nombres;
		this.apellidos=apellidos;
		this.telefono=telefono;
		this.afp=afp;
		this.sds=sds;
		this.direccion=direccion;
		this.comuna=comuna;
		this.edad=edad;

}

	//Getter and Setter	
	/**
	 * @return the rut
	 */
	public int getRut() {
		return rut;
	}

	/**
	 * @param rut the rut to set
	 */
	public void setRut(int rut) {
		this.rut = rut;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the telefono
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the afp
	 */
	public int getAfp() {
		return afp;
	}

	/**
	 * @param afp the afp to set
	 */
	public void setAfp(int afp) {
		this.afp = afp;
	}

	/**
	 * @return the sds
	 */
	public int getSds() {
		return sds;
	}

	/**
	 * @param sds the sds to set
	 */
	public void setSds(int sds) {
		this.sds = sds;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the comuna
	 */
	public String getComuna() {
		return comuna;
	}

	/**
	 * @param comuna the comuna to set
	 */
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String sistSalud() {
		if(sds == 1) {
		return "fonasa";
		
	} else {
		return "Isapre";
	}
	}

	@Override
	public void analizarUsuario() {
		super.analizarUsuario();
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Rut Cliente: " + rut + "\nNombre Completo" + obtenerNombre() + 
				"\nTelefono: " + telefono + 
				"\n AFP: " + afp + 
				"\nSistema de Salud: " + sds + 
				"\nDireccion: " + direccion + 
				"\nComuna: " + comuna + 
				"\nEdad: " + edad;
	}
	
	public String SS() {
		if (sds == 1) {
			return "Fonasa";
		} else {
			return "Isapre";
		}
	}
	
	public String obtenerNombre() {
		return getNombres()+" "+getApellidos();
	}
	

	
}
