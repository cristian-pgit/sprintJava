/**
 *@authors :	Cristian Carrillo.	   
 */
package sprint;

import java.util.Scanner;

/**
 * Clase Principal es la que Trae el Menu y el ejecutable del programa
 */
public class Principal {
	
	/** Instanciacion del Scanner para llamarlo para elegir opcion en menu */
	private static Scanner sc = new Scanner(System.in);
	
	
	/**
	 * Mtodo main
	 *
	 * @param Ejecutable
	 */
	public static void main (String[]Args) {
		Contenedor cont = new Contenedor(); // Instanciacion de la clase Contenedor
		boolean keepGoing = true;
		while(keepGoing) {
			try {
				Contenedor.escribir("Bienvenido al Sistema de Prevencion de Riesgos "+cont.tAma("<<Piker Dans Les Youx>>")+"\nElija una opcion:\n"+
			"\t1.- Crear Cliente\n"+ "\t2.- Crear Profesional\n"+"\t3.- Crear Administrativo\n"+
						"\t4.- Crear Capacitaciones\n"+
						"\t5.- Eliminar Usuario\n"+"\t6.- Listar Usuarios\n"+"\t7.- Listar Usuarios por Tipo\n"+
			"\t8.- Listar Capacitaciones\n"+"\t9.- Salir");
				String opcion = "";
				opcion = sc.nextLine();
				if(!opcion.matches("[1-9]")) {
					System.out.println("Opcion Equivocada");
				}
				int opc = Integer.parseInt(opcion);
				
				switch (opc) {
				
				case 1:
					/** Crear Cliente*/
					cont.crearCliente();
					break;
				case 2:
					/** Crear Profesional*/
					cont.crearProfesional();
					break;
					
				case 3:
					/** Crear Administrativo*/
					cont.crearAdministrativo();
					break;
					
				case 4:
					/** Crear Capacitacion*/
					cont.crearCapacitacion();
					break;
				case 5:
					/** Eliminar Usuario*/
					cont.eliminarUsuario();
					break;
				case 6:
					/** Listar Usuarios*/
					cont.mostrarUsuarios();
					break;
				case 7:
					/** Listar Usuarios x Tipo*/
					cont.listarXTipo();
					break;
				case 8:
					/** Listar Capacitaciones*/
					cont.listarCapacitaciones();
					break;
				case 9:
					/** Opcion de Apagado de programa*/
					Contenedor.escribir(cont.tAma("Apagando sistema"));
					keepGoing = false;
					break;
					
				}
				
			} catch(Exception e) {
				e.printStackTrace();
				Contenedor.escribir("Opcions es de 1 a 9, sin caracteres o simbolos.");
			}
		}
		
		
		
	}

}
