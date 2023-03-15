package sprint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Contenedor {
	
	static Scanner sc = new Scanner(System.in);
	
	
	List<Asesoria> ase = new ArrayList<Asesoria>();
	static List<Capacitacion> capas = new ArrayList<Capacitacion>();
	
	
	public static void crearCliente() {
		boolean crearCli = false;
		while (crearCli == false) {
			Cliente user = new Cliente();
			escribir("Bienvenido a la Creacion de Usuario - Cliente.");
			String userN = pedirUserName();
			user.setUsuario(userN);
			String fecha = fechaN();
			user.setfNacimiento(fecha);
			int run = pedirRun();
			user.setRun(run);
			int rutc = pedirRutC();
			user.setRut(rutc);
			String nom = pedirNombres();
			user.setNombres(nom);
			String ape = pedirApellidos();
			user.setApellidos(ape);
			int fono = pedirFono();
			user.setTelefono(fono);
			String afp = pedirAfp();
			user.setAfp(afp);
			int sds = pedirSdS();
			user.setSds(sds);
			String dir = pedirDir();
			user.setDireccion(dir);
			String com = pedirCom();
			user.setComuna(com);
			int edad = pedirEdad();
			user.setEdad(edad);
			hayCapacitaciones();
			
		}
		
	}
	
	public static void crearProfesional() {
		
	}
	
	public static void crearAdministrativo() {
		
	}
	
	public static void crearCapacitacion() {
		boolean creaCapa = false;
		while (creaCapa == false) {
			Capacitacion capa = new Capacitacion();
			escribir("Bienvenido a la Creacion de Capacicationes.");
			int id = pedirIdCapa();
			capa.setIdCapa(id);
			int run = pedirRutC();
			capa.setRun(run);
			capa.setDia(pedirDia());
			String hora = pedirHr()+":"+ pedirMin();
			capa.setHora(hora);
			capa.setLugar(pedirLugar());
			capa.setDuracion(pedirDur());
			capa.setCantAsist(pedirCant());
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
			System.out.println(ANSI_WHITE+"----------------- Capacitacion: "+i+" -----------------------"+ANSI_RESET);
			c.mostrarDetalles();
			i++;
			System.out.println(ANSI_PURPLE+"----------------------------------------------------"+ANSI_RESET);
		}
		
	}
	
	public static String pedirUserName() {
		boolean uSnMOk = false;
		String userName = "";
		while(!uSnMOk) {
			escribir("Ingrese Nombre de Usuario:");
			userName = leer(sc);
			if (userName.length()<10 && userName.length()<51) {
				escribir("Nombre de Usuario debe tener al menos 10 caracteres. Y un maximo de 50");
			} else {
				uSnMOk = true;
			}	
		}
		return userName;
	}
	
	public static String fechaN() {
		return fDia()+"/"+fMes()+"/"+fAnio();
	}
	
	public static String fDia() {
		boolean fechaOk = false;
		String fDia = "";
		while(!fechaOk) {
			escribir("Ingrese Dia de Nacimiento:");
			fDia = leer(sc);
			if (fDia.matches("0[1-9]|[12][0-9]|3[01]")) {
				escribir("Ingrese un dia de valido. De 01 a 31 (favor recuerde Febrero tiene hasta 28 o 29)");
			} else {
				fechaOk = true;
			}	
		}
		return fDia;
	}
	public static String fMes() {
		boolean fechaOk = false;
		String fMes = "";
		while(!fechaOk) {
			escribir("Ingrese Mes de Nacimiento:");
			fMes = leer(sc);
			if (fMes.matches("0[1-9]|1[0-2]")) {
				escribir("Ingrese un mes Valido. De 01 a 12");
			} else {
				fechaOk = true;
			}	
		}
		return fMes;
	}
	public static String fAnio() {
		boolean fechaOk = false;
		String fAnio = "";
		while(!fechaOk) {
			escribir("Ingrese Dia de Nacimiento:");
			fAnio = leer(sc);
			if (fAnio.matches("19\\d{2}|20\\d{2}|2100")) {
				escribir("Ingrese un anio valido. Desde 1900 a 2100 .... no se aceptan vampiros, inmortales y gente del futuro");
			} else {
				fechaOk = true;
			}	
		}
		return fAnio;
	}
	
	public static int pedirRun() {
		boolean rutOk = false;
		int rutu = 0;
		while(!rutOk) {
			escribir("Favor ingrese Run Usuario:");
			String rut = leer(sc);
			if(rut.isEmpty()) {
				escribir("Rut Cliente es Obligatorio, no puede estar Vacio");
			}
			if(!rut.matches("^\\d{8}$")) {
				escribir("Rut Incorrecto. 8 digitos");
			} else {
				rutu = Integer.parseInt(rut);
				rutOk = true;
			}
		}
		return rutu;
	}
	
	public static String pedirNombres() {
		boolean uSnMOk = false;
		String names = "";
		while(!uSnMOk) {
			escribir("Ingrese Nombres:");
			names = leer(sc);
			if (names.length()<5 && names.length()<31) {
				escribir("Nombres debe tener al menos 5 caracteres. Y un maximo de 30");
			} else {
				uSnMOk = true;
			}	
		}
		return names;
	}
	public static String pedirApellidos() {
		boolean uSnMOk = false;
		String lNames = "";
		while(!uSnMOk) {
			escribir("Ingrese Nombres:");
			lNames = leer(sc);
			if (lNames.length()<5 && lNames.length()<31) {
				escribir("Apellidos debe tener al menos 5 caracteres. Y un maximo de 30");
			} else {
				uSnMOk = true;
			}	
		}
		return lNames;
	}
	
	public static int pedirFono() {
		boolean rutOk = false;
		int fono = 0;
		while(!rutOk) {
			escribir("Favor ingrese telefono: ");
			String tel = leer(sc);
			if(tel.isEmpty()) {
				escribir("Telefono es Obligatorio, no puede estar Vacio");
			}
			if(!tel.matches("^\\d{8}$")) {
				escribir("Fono Incorrecto. 8 digitos");
			} else {
				fono = Integer.parseInt(tel);
				rutOk = true;
			}
		}
		return fono;
	}
	
	public static String pedirAfp() {
		boolean uSnMOk = false;
		String afp = "";
		while(!uSnMOk) {
			escribir("Ingrese AFP:");
			afp = leer(sc);
			if (afp.length()<4 && afp.length()<31) {
				escribir("AFP debe tener al menos 4 caracteres. Y un maximo de 30");
			} else {
				uSnMOk = true;
			}	
		}
		return afp;
	}
	
	public static int pedirSdS() {
		boolean ssOk = false;
		int sds = 0;
		while (!ssOk) {
			escribir("Favor ingrese Sistema de Salud (1.- Fonasa / 2.- Isapre):");
			String entrada = leer(sc);
			if(!entrada.matches("[1-2]")) {
				escribir("Solo 1 o 2");
			} else {
	            sds = Integer.parseInt(entrada);
	            ssOk = true;
	        }
		}
		return sds;
	}
	
	public static String pedirDir() {
		boolean dirOk = false;
		String dir = "";
		while(!dirOk) {
			escribir("Ingrese Direccion:");
			dir = leer(sc);
			if (dir.length()>70) {
				escribir("Direccion tiene un maximo de 70 caracteres");
			} else {
				dirOk = true;
			}
		}	
		return dir;
	}
	
	public static String pedirCom() {
		boolean comOk = false;
		String com = "";
		while(!comOk) {
			escribir("Ingrese Lugar:");
			com = leer(sc);
			if (com.length()>50) {
				escribir("Direccion tiene un maximo de 50 caracteres");
			} else {
				comOk = true;
			}
		}	
		return com;
	}
	
	public static int pedirEdad() {
		boolean edadOk = false;
		int edad = 0;
		while (!edadOk) {
			escribir("Favor ingrese Edad:");
			String entrada = leer(sc);
			if(!entrada.matches("1[0-9]{2}|[1-9][0-9]|\\b[1-9]\\b|150")) {
				escribir("Edad solo debe contener numeros. Maximo 150 anios");
			} else {
	            edad = Integer.parseInt(entrada);
	            edadOk = true;
	        }
		}
		return edad;
	}
	
	public static void hayCapacitaciones() {
		boolean hayCap = false;
		String resp = "";
		while(!hayCap) {
			escribir("Ingrese Desea ingresar una Capacitacion? (y/n)");
			resp = leer(sc);
			if (resp.matches("[yYnN]") && resp.equalsIgnoreCase("y")) {
				crearCapacitacion();
			} else if (resp.matches("[yYnN]") && resp.equalsIgnoreCase("n")) {
				hayCap = true;
			} 
		}	
	}
	
	public static int pedirIdCapa() {
		boolean idOk = false;
		int id = 0;
		while (!idOk) {
			escribir("Favor ingrese Id de Capacitacion:");
			String entrada = leer(sc);
			if(!entrada.matches("\\d+")) {
				escribir("Debe solo contener numeros");
			} else {
	            id = Integer.parseInt(entrada);
	            idOk = true;
	        }
		}
		return id;
	}
	
	public static int pedirRutC() {
		boolean rutOk = false;
		int rutc = 0;
		while(!rutOk) {
			escribir("Favor ingrese RUT Cliente:");
			String rut = leer(sc);
			if(rut.isEmpty()) {
				escribir("Rut Cliente es Obligatorio, no puede estar Vacio");
			}
			if(!rut.matches("^\\d{8}$")) {
				escribir("Rut Incorrecto. 8 digitos");
			} else {
				rutc = Integer.parseInt(rut);
				rutOk = true;
			}
		}
		return rutc;
	}
	
	public static String pedirDia() {
		boolean diaOk = false;
		String dia = "";
		while(!diaOk) {
			escribir("Ingrese Día de la Capacitacion (dia de semana, ej Lunes):");
			dia = leer(sc);
			if (dia.equalsIgnoreCase("lunes") || 
				    dia.equalsIgnoreCase("martes") || 
				    dia.equalsIgnoreCase("miercoles") || 
				    dia.equalsIgnoreCase("jueves") || 
				    dia.equalsIgnoreCase("viernes") || 
				    dia.equalsIgnoreCase("sabado") || 
				    dia.equalsIgnoreCase("domingo")) {
				    diaOk = true;
				} else {
				    escribir("Debe ser un dia de semana Valido. Ej: Lunes");
				}

			
		}
		return dia;
	}
	
	public static String pedirHr() {
		boolean hrOk = false;
		String hr = "";
		while(!hrOk) {
			escribir("Ingrese Hora de la Capacitacion."+"\nIngrese Hora (de 00 a 23):");
			hr = leer(sc);
			if (!hr.matches("^([0-1][0-9]|2[0-3])$")) {
				escribir("Debe ingresar desde 00 a 23");
			} else {
				hrOk = true;
			}	
		}
		return hr;
	}
	public static String pedirMin() {
	    boolean minOk = false;
	    String min = "";
	    while (!minOk) {
	        escribir("Ingrese Minutos (de 00 a 59):");
	        min = leer(sc);
	        if (!min.matches("^([0-5][0-9]|00)$")) {
	            escribir("Solo de 00 a 59");
	        } else {
	            minOk = true;
	        }
	    }
	    return min;
	}

	
	public static String pedirLugar() {
		boolean lugOk = false;
		String lugar = "";
		while(!lugOk) {
			escribir("Ingrese Lugar:");
			lugar = leer(sc);
			if (lugar.length()<10 && lugar.length()<51) {
				escribir("Lugar debe tener al menos 10 caracteres. Y un maximo de 50");
			} else {
				lugOk = true;
			}
		}	
		return lugar;
	}
	
	public static String pedirDur() {
	    boolean durOk = false;
	    String dur = "";
	    while (!durOk) {
	        escribir("Ingrese Duración:");
	        dur = leer(sc);
	        if (dur.length() > 70) {
	            escribir("No puede tener más de 70 caracteres");
	        } else if (!dur.matches("^[0-9]+$")) {
	            escribir("Solo se permiten números");
	        } else {
	            durOk = true;
	        }
	    }
	    return dur;
	}

	
	public static int pedirCant() {
		boolean cantOk = false;
		int cantA = 0;
		while(!cantOk) {
			escribir("Ingrese Cantidad de Asistentes:");
			String casis = leer(sc);
			int cant = Integer.parseInt(casis);
			if (!casis.matches("^[0-9]+$")) {
				escribir("Deben ser solo numeros");	
			} else if (cant >999) {
				escribir("Numero de asistentes no puede ser mayor a 999");
			} else {
				cantA = Integer.parseInt(casis);
				cantOk = true;
			}

		}	
		return cantA;
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
