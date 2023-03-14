package sprint;

import java.util.Scanner;

public class Principal {
	
	static Scanner sc = new Scanner(System.in);
	static Contenedor cont = new Contenedor();
	
	public static void main (String[]Args) {
		
		boolean keepGoing = true;
		while(keepGoing) {
			try {
				Contenedor.escribir("Bienvenido al Sistema de Prevencion de Riesgos <<Piker Dans Les Youx>>\n"+"Elija una opcion:\n"+
			"\t1.- Crear Cliente\n"+ "\t2.- Crear Profesional\n"+"\t3.- Crear Administrativo\n"+"\t4.- Crear Capacitaciones\n"+
						"\t5.- Eliminar Usuario\n"+"\t6.- Listar Usuarios\n"+"\t7.- Listar Usuarios por Tipo\n"+
			"\t8.- Listar Capacitaciones\n"+"\t9. Salir");
				String opcion = "";
				opcion = sc.nextLine();
				if(!opcion.matches("[1-9]")) {
					System.out.println("Opcion Equivocada");
				}
				int opc = Integer.parseInt(opcion);
				
				switch (opc) {
				
				case 1:
					cont.crearCliente();
					break;
				case 2:
					cont.crearProfesional();
					break;
					
				case 3:
					cont.crearAdministrativo();
					break;
					
				case 4:
					cont.crearCapacitacion();
					break;
				case 5:
					cont.eliminarUsuario();
					break;
				case 6:
					cont.mostrarUsuarios();
					break;
				case 7:
					cont.listarXTipo();
					break;
				case 8:
					cont.listarCapacitaciones();
					break;
				case 9:
					keepGoing = false;
					break;
					
				}
				
			} catch(Exception e) {
				cont.escribir("Opcion es de 1 a 9, sin caracteres o simbolos.");
			}
		}
		
		
		
	}

}
