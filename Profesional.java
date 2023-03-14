package sprint;

public class Profesional {
	
	//Declaracion de variables, atributos de Usuario
		private String tituloProfesional;
		private String fechaIngreso;
		
		//Constructor vacio
		public Profesional() {
			
		}
		
		
		//Constructor Profesional con datos, con Super que trae datos de Usuario
		public Profesional(String nUsuario, String fNacimiento, int run, String tituloProfesional, String fechaIngreso) {
			super(nUsuario, fNacimiento, run);
			this.tituloProfesional = tituloProfesional;
			this.fechaIngreso = fechaIngreso;
			
		}

		//Getter and Setter

		
		/**
		 * @return the tituloProfesional
		 */
		public String getTituloProfesional() {
			return tituloProfesional;
		}


		/**
		 * @param tituloProfesional the tituloProfesional to set
		 */
		public void setTituloProfesional(String tituloProfesional) {
			this.tituloProfesional = tituloProfesional;
		}


		/**
		 * @return the fechaIngreso
		 */
		public String getFechaIngreso() {
			return fechaIngreso;
		}


		/**
		 * @param fechaIngreso the fechaIngreso to set
		 */
		public void setFechaIngreso(String fechaIngreso) {
			this.fechaIngreso = fechaIngreso;
		}

		
		public void analizarUsuario() {
			super.
			System.out.println("\nTitulo Profesional:" + tituloProfesional + 
			"\nFecha de Ingreso: " + fechaIngreso );
		}
		
		
		@Override
		public String toString() {
			return "Titulo Profesional= " + tituloProfesional + "\nFechaIngreso=" + fechaIngreso;
		}

}
