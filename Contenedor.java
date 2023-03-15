package sprint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Contenedor {
	
	static Scanner sc = new Scanner(System.in);
	
	
	List<Asesoria> ase = new ArrayList<Asesoria>();
	static List<Capacitacion> capas = new ArrayList<Capacitacion>();
	
	
	public static void crearCliente() {
		
	}
	
	public static void crearProfesional() {
		
	}
	
	public static void crearAdministrativo() {
		
	}
	
	public static void crearCapacitacion() {
		boolean creaCapa = false;
		while (creaCapa == false) {
			Capacitacion capa = new Capacitacion();
			escribir("Bienvenido a la Creacion de Capacicationes."+
					"\nFavor ingrese Id de Capacitacion:");
			String entrada = leer(sc);
			if(!entrada.matches("\\d+")) {
				escribir("Debe solo contener numeros");
			}
			int id = Integer.parseInt(entrada);
			capa.setIdCapa(id);
			escribir("Favor ingrese RUT Cliente:");
			String rut = leer(sc);
			if(rut.isEmpty()) {
				escribir("Rut Cliente es Obligatorio, no puede estar Vacio");
			}
			if(!rut.matches("^\\d{8}$")) {
				escribir("Rut Incorrecto. 8 digitos");
			}
			int rutc = Integer.parseInt(rut);
			capa.setRun(rutc);
			escribir("Ingrese Día de la Capacitacion (dia de semana, ej Lunes):");
			String dia = leer(sc);
			if(!dia.equalsIgnoreCase("lunes")||!dia.equalsIgnoreCase("martes")||!dia.equalsIgnoreCase("miercoles")||!dia.equalsIgnoreCase("jueves")||
					!dia.equalsIgnoreCase("viernes")||!dia.equalsIgnoreCase("sabado")||!dia.equalsIgnoreCase("domingo")) {
				escribir("Debe ser un dia de semana Valido. Ej: Lunes");
			}
			capa.setDia(dia);
			escribir("Ingrese Hora de la Capacitacion."+"\nIngrese Hora (de 00 a 23):");
			String hr = leer(sc);
			if (!hr.matches("^([0-1][0-9]|2[0-3])$")) {
				escribir("Debe ingresar desde 00 a 23");
			}
			escribir("Ingrese Minutos (de 00 a 59):");
			String min = leer(sc);
			if (!min.matches("^([0-5][0-9])$\r\n")) {
				escribir("Solo de 00 a 99");
			}
			String hora = hr+":"+min;
			capa.setHora(hora);
			escribir("Ingrese Lugar:");
			String lugar = leer(sc);
			if (lugar.length()<10 && lugar.length()<51) {
				escribir("Lugar debe tener al menos 10 caracteres. Y un maximo de 50");
			}
			capa.setLugar(lugar);
			escribir("Ingrese Duracción:");
			String dur = leer(sc);
			if(dur.length()>71) {
				escribir("No puede tener mas de 70 caracteres");
			}
			if(dur.matches("^[0-9]+$\r\n")) {
				escribir("Solo numeros.");
			}
			capa.setDuracion(dur);
			escribir("Ingrese Cantidad de Asistentes:");
			String casis = leer(sc);
			if (casis.matches("^([0-9]|[1-9][0-9]{1,2})$")) {
				escribir("Numero de asistentes no puede ser mayor a 999");
			}
			int cantA = Integer.parseInt(casis);
			capa.setCantAsist(cantA);
			capas.add(capa);
			creaCapa = true;
		}
		
		
		
	}
	
	public static void eliminarUsuario() {
		
	}
	
	public static void mostrarUsuarios() {
		
	}
	
	public static void listarXTipo() {
		
	}
	
	public static void listarCapacitaciones() {
		int i = 1;
		for (Capacitacion c:capas) {
			System.out.println(ANSI_WHITE+"----------------- Vehiculo: "+i+" -----------------------"+ANSI_RESET);
			c.mostrarDetalles();
			i++;
			System.out.println(ANSI_PURPLE+"----------------------------------------------------"+ANSI_RESET);
		}
		
	}
	
	public static void escribir(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static String leer(Scanner sc) {
		return sc.nextLine();
	}
	
	
	
	
	
	/** The Constant ANSI_WHITE. */
	public static final String ANSI_WHITE = "\u001B[37m";
	
	/** The Constant ANSI_PURPLE. */
	public static final String ANSI_PURPLE = "\u001B[35m";
	
	/** The Constant ANSI_BLUE. */
	public static final String ANSI_BLUE = "\u001B[34m";
	
	/** The Constant ANSI_CYAN. */
	public static final String ANSI_CYAN = "\u001B[36m";
	
	/** The Constant ANSI_GREEN. */
	public static final String ANSI_GREEN = "\u001B[32m";
	
	/** The Constant ANSI_YELLOW. */
	public static final String ANSI_YELLOW = "\u001B[33m";
	
	/** The Constant ANSI_RESET. */
	public static final String ANSI_RESET = "\u001B[0m";
	
	/** The Constant ANSI_RED. */
	public static final String ANSI_RED = "\u001B[31m";	

}
