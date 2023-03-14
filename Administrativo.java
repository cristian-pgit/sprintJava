package SprintEmpresa;

//Clase Adrminisitrativo que extiende de Usuario

public class Administrativo extends Usuario {
//Declaracion Variables, que extienden de Usuarios
	
	private String area;
	private int experiencia;
	
	//Constructor
	public Administrativo(String nUsuario, String userName, String fNacimiento, int run, String area, int exPrevia) {
		super(nUsuario, fNacimiento, run);
		this.area = area;
		this.experiencia = experiencia;
	}
	
	//Gett and Sett

	public String getArea() {
		return area;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setExPrevia(int experiencia) {
		this.experiencia = experiencia;
	}
	
	
	
	
	
	
	@Override
	public void analizarUsuario() {
		
		super.analizarUsuario();
		System.out.println("Área: "+area+
				"\nAños de Experiencia Previa: "+experiencia);
	}

	@Override
	public String toString() {
		return "Área: "+area+
				"\nAños de Experiencia Previa: "+experiencia;
	}
	
	
	
}
