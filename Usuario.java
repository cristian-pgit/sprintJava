package sprint;

// Clase Usuario
public class Usuario implements Asesoria {
	
	//Declaracion de variable nombre, fecha de nacimiento y rut
	private String nUsuario;
	private String fNacimiento;
	private int run;

	
	//Constructor vacio
	public Usuario() {
		
	}
	
	//Constructor Usuario
	public Usuario(String nUsuario, String fNacimiento,int run) {
		this.nUsuario = nUsuario;
		this.fNacimiento = fNacimiento;
		this.run = run;
	}
	

	//Getter and Setter
	

	/**
	 * @return the nombre
	 */
	public String getUsuario() {
		return nUsuario;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setUsuario(String usuario) {
		this.nUsuario = usuario;
	}

	/**
	 * @return the fNacimiento
	 */
	public String getfNacimiento() {
		return fNacimiento;
	}

	/**
	 * @param fNacimiento the fNacimiento to set
	 */
	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	/**
	 * @return the rut
	 */
	public int getRun() {
		return run;
	}

	/**
	 * @param rut the rut to set
	 */
	public void setRun(int run) {
		this.run = run;
	}
	
	
	@Override
	public String toString() {
		return "Usuario: " + nUsuario + 
				"\nFecha de Nacimiento: " + fNacimiento + 
				"\nRun: " + run ;
	}
	@Override
	public void analizarUsuario() {
		System.out.println("Usuario: " + nUsuario + 
				"\nFecha de Nacimiento: " + fNacimiento + 
				"\nRun: " + run );
		
	}
	
}
