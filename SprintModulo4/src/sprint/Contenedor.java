/**
 *@authors :	Cristian Carrillo
 *				Adrian Fredes - Metodos Crear Profesional y Crear Administrativo		   
 */
package sprint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * Clase Contenedor que posee todas las Funciones
 */
public class Contenedor {
	
	/** Declaracion de variable estatica de objeto Scanner */
	static Scanner sc = new Scanner(System.in);
	
	
	/** Atributos unicos de la clase Contenedor: Listas de Asesoria y Capacitaciones */
	protected List<Asesoria> ase;
	protected List<Capacitacion> capas;
	
	/**
	 * Constructor de clase
	 */
	public Contenedor () {
		this.ase = new ArrayList<Asesoria>();
		this.capas = new ArrayList<Capacitacion>();
	}
	
	
	/**
	 * Metodo Crear cliente.
	 * La función crearCliente() crea un nuevo objeto de tipo Cliente, pide y establece sus atributos a 
	 * través de la invocación de varios métodos de entrada de datos.
	 */
	public void crearCliente() {

		Cliente cli = new Cliente();
		escribir("Bienvenido a la Creacion de Usuario - Cliente.");
		String userN = pedirUserName();
		cli.setUsuario(userN);
		String fecha = fechaN();
		cli.setfNacimiento(fecha);
		int run = pedirRun();
		cli.setRun(run);
		int rutc = pedirRutCIni();
		cli.setRut(rutc);
		String nom = pedirNombres();
		cli.setNombres(nom);
		String ape = pedirApellidos();
		cli.setApellidos(ape);
		int fono = pedirFono();
		cli.setTelefono(fono);
		String afp = pedirAfp();
		cli.setAfp(afp);
		int sds = pedirSdS();
		cli.setSds(sds);
		String dir = pedirDir();
		cli.setDireccion(dir);
		String com = pedirCom();
		cli.setComuna(com);
		int edad = pedirEdad();
		cli.setEdad(edad);
		// anade el usuario creado a la lista de Asesoria,
		ase.add(cli);
		// Crear Capacitacion si de desea
		hayCapacitaciones();
		//crear accidente si se desea
		hayAccidente();
		//ingresar primera visita. Visita crea una Revision y preguntara si se desean mas revisiones
		crearVisita();
		//preguntar si se desea agregar una nueva visita
		addVisita();
		//despliega mensaje indicando que el usuario se ha creado exitosamente.
		escribir(ANSI_CYAN+"Usuario Creado Exitosamente"+ANSI_RESET);

	}
	
	/**
	 * Metodo Crear profesional.
	 * Esta función se encarga de crear un nuevo objeto de la clase Profesional y 
	 * agregarlo a una lista de Asesoria llamada "ase"
	 * @author Adrian Fredes
	 */
	public  void crearProfesional() {
		Profesional user = new Profesional();
		escribir("Bienvenido a la Creacion de Usuario - Profesional");
		String userN = pedirUserName();
		user.setUsuario(userN);
		String fecha = fechaN();
		user.setfNacimiento(fecha);
		int run = pedirRun();
		user.setRun(run);
		String titulo = pedirTitulo();
		user.setTituloProfesional(titulo);
		String fechaI = fechaI();
		user.setFechaIngreso(fechaI);
		// anade el usuario creado a la lista de Asesoria,
		ase.add(user);
		escribir(ANSI_CYAN+"Usuario Creado Exitosamente"+ANSI_RESET);
	}
	
	/**
	 * Metodo Crear administrativo.
	 * La función crearAdministrativo es una función que crea un objeto de tipo 
	 * Administrativo y lo agrega a una lista llamada ase que contiene objetos de 
	 * tipo Asesoria.
	 * El usuario es guiado a través de varias funciones para ingresar información 
	 * necesaria para crear el objeto Administrativo.
	 * @author Adrian Fredes
	 */
	public void crearAdministrativo() {
		Administrativo adm = new Administrativo();
		escribir("Bienvenido a la Creacion de Usuario - Cliente.");
		String userN = pedirUserName();
		adm.setUsuario(userN);
		String fecha = fechaN();
		adm.setfNacimiento(fecha);
		int run = pedirRun();
		adm.setRun(run);
		String area = pedirArea();
		adm.setArea(area);
		int exp = expPre();
		adm.setExPrevia(exp);
		// anade el usuario creado a la lista de Asesoria,
		ase.add(adm);
		escribir(ANSI_CYAN+"Usuario Creado Exitosamente"+ANSI_RESET);
	}
	
	/**
	 * Metodo Crear capacitacion.
	 * La función crearCapacitacion() se encarga de crear una capacitación para un 
	 * usuario y agregarla a la lista de capacitaciones existentes. 
	 * La función utiliza varios métodos para solicitar información del usuario, 
	 * como pedirIdCapa(), pedirRutC(), pedirDia(), pedirHr(), pedirMin(), 
	 * pedirLugar(), pedirDur() y pedirCant().
	 */
	public void crearCapacitacion() {
		if(ase.isEmpty()) {
			escribir(tRojo("No hay Clientes a quien crear una Capacitacion")+
					"\n"+tVerde("Favor cree un Usuario-Cliente primero"));
		} else {
			boolean creaCapa = false;
			while (creaCapa == false) {
				Capacitacion capa = new Capacitacion();
				escribir("Bienvenido a la Creacion de Capacicationes.");
				int id = pedirIdCapa();
				capa.setIdCapa(id);
				showRutExistentes();
				Cliente cli = buscarRutC(ase);
				int rutC = cli.getRut();
				capa.setRutC(rutC);
				capa.setDia(pedirDia());
				String hora = pedirHr()+":"+ pedirMin();
				capa.setHora(hora);
				capa.setLugar(pedirLugar());
				capa.setDuracion(pedirDur());
				capa.setCantAsist(pedirCant());
				capas.add(capa);
				cli.addCapa(capa);
				creaCapa = true;
				escribir(ANSI_BLUE+"Capacitacion Creada Exitosamente"+ANSI_RESET);
				capa.mostrarDetalles();
			}
		}
				
	}
	
	/**
	 * Metodo Eliminar usuario.
	 * // La función eliminarUsuario busca un usuario en la lista ase a través de su 
	 * número de RUN. Si el usuario es encontrado, muestra una advertencia para 
	 * confirmar si el usuario debe ser eliminado. 
	 * Si la respuesta es 'y' o 'Y', el usuario es removido de la lista. Si la 
	 * respuesta es 'n' o 'N', no se hace nada y se vuelve al menú principal. 
	 */
	public void eliminarUsuario() {
		Usuario usuario = buscarRun(ase);
		if (usuario != null) {
			boolean seguro = false;
			while (!seguro) {
				usuario.analizarUsuario();
				escribir("Run: "+usuario.getRun());
				escribir(ANSI_RED+"[ADVERTENCIA] "+ANSI_RESET+"Esta seguro que desea borrar este usuario? (y/n): ");
				String ans = leer(sc);
				if (ans.matches("[yYnN]") && ans.equalsIgnoreCase("y")) {
					ase.remove(usuario);
					escribir(ANSI_YELLOW+"Usuario Eliminado"+ANSI_RESET);
					seguro = true;
				} else if (ans.matches("[yYnN]") && ans.equalsIgnoreCase("n")) {
					seguro = true;
				} 
			}
			
		} else {
		    escribir("Usuario no encontrado, o no existe");
		}
	}
	
	/**
	 * Metodo Mostrar usuarios.
	 * La función mostrarUsuarios() se encarga de mostrar en pantalla todos los 
	 * usuarios registrados en el sistema de asesorías.
	 */
	public void mostrarUsuarios() {
		int i = 1;
		for (Asesoria a:ase) {
			System.out.println(ANSI_WHITE+"----------------- Usuario: "+i+" -----------------------"+ANSI_RESET);
			a.analizarUsuario();
			i++;
			System.out.println(ANSI_PURPLE+"----------------------------------------------------"+ANSI_RESET);
		}
	}
	
	/**
	 * Metodo Listar X tipo.
	 * La función listarXTipo es utilizada para mostrar una lista de usuarios según 
	 * su tipo, que puede ser Cliente, Profesional o Administrativo.
	 */
	public void listarXTipo() {
		
		boolean elige = false;
		while(!elige) {
			try {
				escribir("Que tipo desea ver?\n"+"\t1.- Clientes\n"+"\t2.- Profesionales\n"+"\t3.- Administrativos\n");
				String opcion = "";
				opcion = sc.nextLine();
				if(!opcion.matches("[1-3]")) {
					System.out.println("Opcion Equivocada");
				}
				int opc = Integer.parseInt(opcion);
				
				switch (opc) {
				
				case 1:
				    int i = 1;
				    boolean hay = false;
				    for (Asesoria a : ase) {
				        if (a instanceof Cliente) {
				            System.out.println(ANSI_WHITE + "----------------- Cliente: " + i + " -----------------------" + ANSI_RESET);
				            a.analizarUsuario();
				            i++;
				            System.out.println(ANSI_PURPLE + "----------------------------------------------------" + ANSI_RESET);
				            hay = true;
				        }
				    }
				    if (!hay) {
				        escribir("No hay Usuarios de este tipo");
				    }
				    elige = true;
				    break;
				case 2:
				    i = 1;
				    hay = false;
				    for (Asesoria a : ase) {
				        if (a instanceof Profesional) {
				            System.out.println(ANSI_WHITE + "----------------- Profesional: " + i + " -----------------------" + ANSI_RESET);
				            a.analizarUsuario();
				            i++;
				            System.out.println(ANSI_PURPLE + "----------------------------------------------------" + ANSI_RESET);
				            hay = true;
				        }
				    }
				    if (!hay) {
				        escribir("No hay Usuarios de este tipo");
				    }
				    elige = true;
				    break;
				case 3:
				    i = 1;
				    hay = false;
				    for (Asesoria a : ase) {
				        if (a instanceof Administrativo) {
				            System.out.println(ANSI_WHITE + "----------------- Administrativo: " + i + " -----------------------" + ANSI_RESET);
				            a.analizarUsuario();
				            i++;
				            System.out.println(ANSI_PURPLE + "----------------------------------------------------" + ANSI_RESET);
				            hay = true;
				        }
				    }
				    if (!hay) {
				        escribir("No hay Usuarios de este tipo");
				    }
				    elige = true;
				    break;
			
				}	
			} catch(Exception e) {
				escribir("Opcion es de 1 a 3, sin caracteres o simbolos.");
			}
		}
		
	}
	
	/**
	 * Listar capacitaciones.
	 * La función listarCapacitaciones se encarga de mostrar por pantalla los 
	 * detalles de todas las capacitaciones que se han registrado en el sistema.
	 */
	public void listarCapacitaciones() {
		int i = 1;
	    boolean hay = false;
	    for (Capacitacion c:capas) {
			System.out.println(ANSI_WHITE+"----------------- Capacitacion: "+i+" -----------------------"+ANSI_RESET);
			escribir(tVerde("Cliente: " + obtClibRut(ase, c.getRutC()).mosDatoCli()));
			c.mostrarDetalles();
			hay=true;
			i++;
			System.out.println(ANSI_PURPLE+"----------------------------------------------------"+ANSI_RESET);
		}
	    if (!hay) {
	        escribir(tRojo("No hay Capacitaciones inscritas"));
	    }
	}
	
	/**
	 * Metodo Buscar run.
	 * La función buscarRun recibe como parámetro una lista de Asesorías llamada ase. 
	 * Esta función permite buscar un usuario dentro de la lista de asesorías, 
	 * ingresando su RUT (run) de 8 dígitos.
	 *
	 * @param ase Lista de Asesorias
	 * @return el usuario
	 */
	public Usuario buscarRun(List<Asesoria> ase) {
	    boolean runOk = false;
	    Usuario usuario = null;
	    while (!runOk) {
	        System.out.print("Ingrese el Rut del usuario a buscar: ");
	        String runs = leer(sc);
	        if (runs.matches("^\\d{8}$")) {
	            int run = Integer.parseInt(runs);
	            for (Asesoria a : ase) {
	                if (a instanceof Usuario && ((Usuario) a).getRun() == run) {
	                    usuario = (Usuario) a; // encuentra el usuario con el run buscado
	                    runOk = true;
	                    break;
	                }
	            }
	        } else {
	            System.out.println("Ingreso invalido. Solo numeros, 8 digitos");
	        }
	    }
	    return usuario; // retorna usuario buscado o retorna null
	}
	
	
	/**
	 * Metodo Buscar rutC.
	 * La función buscarRutC recibe como parámetro una lista de Asesorías llamada ase. 
	 * Esta función permite buscar un cliente dentro de la lista de asesorías, 
	 * ingresando su RUT de 8 dígitos.
	 *
	 * @param ase Lista de Asesorias
	 * @return el usuario
	 */
	public Cliente buscarRutC(List<Asesoria> ase) {
		boolean rutOk = false;
		boolean hayCliente = false;
		Cliente cliente = null;
		while (!rutOk) {
			System.out.print("Ingrese el Rut del Cliente a buscar: ");
			String rutS = leer(sc);
			if (rutS.matches("^\\d{8}$")) {
				int rutC = Integer.parseInt(rutS);
				for (Asesoria a : ase) {
					if (a instanceof Cliente) { 
						for (Asesoria as : ase) {
							if (as instanceof Cliente) {
								hayCliente = true; // cambia el valor si hay al menos un cliente
								if (((Cliente) as).getRut() == rutC) {
									cliente = (Cliente) as; // encuentra el cliente con el rut buscado
									rutOk = true;
									break;
								}
							}
						}
						if (!hayCliente) { // si no hay ningún cliente en la lista
							System.out.println("El rut no existe"); // muestra el mensaje
							return null; // aborta la función
						}
					} else {
						System.out.println("Ingreso invalido. Solo numeros, 8 digitos");
					}
				}
			}
		}
		return cliente; // retorna cliente buscado o retorna null
	}
	       
	           
	  //          for (Asesoria a : ase) {
	  //              if (a instanceof Cliente && ((Cliente) a).getRut() == rutC) {
	  //                  cliente = (Cliente) a; // encuentra el cliente con el rut buscado
	  //                  rutOk = true;
	  //                  break;
	  //              }
	  //              else if (a instanceof Cliente && ((Cliente) a).getRut() != rutC) {
	  //              	escribir("Rut buscado no existe");
	  //              }
	  //          }
	  //      } else {
	  //          System.out.println("Ingreso invalido. Solo numeros, 8 digitos");
	  //      }
	  //  }
	  //  return cliente; // retorna cliente buscado o retorna null
//	}
	
	/**
	 * Metodo Buscar rutC.
	 * La función buscarRutC recibe como parámetro una lista de Asesorías llamada ase. 
	 * Esta función permite buscar un cliente dentro de la lista de asesorías, 
	 * ingresando su RUT de 8 dígitos.
	 *
	 * @param ase Lista de Asesorias
	 * @return el usuario
	 */
	public Cliente obtClibRut(List<Asesoria> ase, int rutC) {
	    boolean hayCliente = false; // nueva variable
	    Cliente cliente = null;
	    for (Asesoria a : ase) {
	        if (a instanceof Cliente) {
	            hayCliente = true; // cambia el valor si hay al menos un cliente
	            if (((Cliente) a).getRut() == rutC) {
	                cliente = (Cliente) a; // encuentra el cliente con el rut buscado
	                break;
	            }
	        }
	    }
	    if (!hayCliente) { // si no hay ningún cliente en la lista
	        System.out.println("El rut no existe"); // muestra el mensaje
	        return null; // aborta la función
	    }
	    return cliente; // retorna cliente buscado o retorna null
	}

	
	/**
	 * Metodo Pedir user name.
	 * La función pedirUserName() es utilizada para pedir al usuario que ingrese un 
	 * nombre de usuario. La función devuelve el nombre de usuario ingresado.
	 *
	 * @return the string
	 */
	public static String pedirUserName() {
		boolean uSnMOk = false;
		String userName = "";
		while(!uSnMOk) {
			escribir("Ingrese Nombre de Usuario:");
			userName = leer(sc);
			if (userName.length()<10 || userName.length()>50) {
				escribir("Nombre de Usuario debe tener al menos 10 caracteres. Y un maximo de 50");
			} else {
				uSnMOk = true;
			}	
		}
		return userName;
	}
	
	/**
	 * Metodo Fecha Nacimiento.
	 * Estas cuatro funciones están relacionadas con la validación y solicitud de 
	 * fechas en formato "DD/MM/AAAA".
	 *
	 * @return string con fecha de nacimiento formateada
	 */
	public static String fechaN() {
		escribir("Ingrese Fecha de Nacimiento (DD/MM/AAAA):");
		return fDia()+"/"+fMes()+"/"+fAnio();
	}
	
	/**
	 * Metodo Fecha Visita.
	 *
	 * @return string con la fecha de visita
	 */
	public static String fechaV() {
		escribir("Ingrese Fecha de Visita (DD/MM/AAAA):");
		return fDia()+"/"+fMes()+"/"+vAnio();
	}
	
	/**
	 * Metodo Fecha Accidente.
	 *
	 * @return string con fecha de Accidente
	 */
	public static String fechaA() {
		escribir("Ingrese Dia del Accidente (DD/MM/AAAA):");
		return fDia()+"/"+fMes()+"/"+vAnio();
	}
	
	/**
	 * Metodo Fecha de Ingreso.
	 *
	 * @return string con formato fe Fecha de Ingreso a Compania
	 */
	public static String fechaI() {
		escribir("Ingrese Fecha de Ingreso (DD/MM/AAAA):");
		return fDia()+"/"+fMes()+"/"+vAnio();
	}
	
	/**
	 * Metodo Fdia.
	 * Esta función es utilizada para pedir y validar el ingreso del día de una 
	 * fecha, y retorna el día en formato de String.
	 *
	 * @return string con dia despues de validar que sea valido.
	 */
	public static String fDia() {
		boolean fechaOk = false;
		String fDia = "";
		while(!fechaOk) {
			escribir("Ingrese Dia (01 a 31[salvo Febrero]):");
			fDia = leer(sc);
			if (!fDia.matches("^(0[1-9]|[1-2][0-9]|3[0-1])$")) {
				escribir("Ingrese un dia de valido. De 01 a 31 (favor recuerde Febrero tiene hasta 28 o 29)");
			} else {
				fechaOk = true;
			}	
		}
		return fDia;
	}
	
	/**
	 * Metodo fMes.
	 * La función fMes solicita al usuario que ingrese un mes válido en formato de 
	 * dos dígitos (por ejemplo, "01" para enero y "12" para diciembre).
	 *
	 * @return string con mes despues de validar que sea valido.
	 */
	public static String fMes() {
		boolean fechaOk = false;
		String fMes = "";
		while(!fechaOk) {
			escribir("Ingrese Mes (01 a 12):");
			fMes = leer(sc);
			if (!fMes.matches("0[1-9]|1[0-2]")) {
				escribir("Ingrese un mes Valido. De 01 a 12");
			} else {
				fechaOk = true;
			}	
		}
		return fMes;
	}
	
	/**
	 * Metodo fAnio.
	 * Esta función se encarga de solicitar al usuario un año en formato de cuatro 
	 * dígitos y asegurarse de que esté dentro del rango válido de años (de 1900 a 2100).
	 *
	 * @return string con formato de anio despues de validar que sea valido.
	 */
	public static String fAnio() {
		boolean fechaOk = false;
		String fAnio = "";
		while(!fechaOk) {
			escribir("Ingrese Anio (de 1900 - 2100):");
			fAnio = leer(sc);
			if (!fAnio.matches("19\\d{2}|20\\d{2}|2100")) {
				escribir("Ingrese un anio valido. Desde 1900 a 2100 .... no se aceptan vampiros, inmortales y gente del futuro");
			} else {
				fechaOk = true;
			}	
		}
		return fAnio;
	}
	
	/**
	 * Metodo vAnio.
	 * La función vAnio solicita al usuario que ingrese un año entre 2000 y 2050 y 
	 * devuelve el año ingresado en forma de cadena de caracteres.
	 *
	 * @return  string con formato de anio despues de validar que sea valido.
	 */
	public static String vAnio() {
		boolean fechaOk = false;
		String fAnio = "";
		while(!fechaOk) {
			escribir("Ingrese Anio (2000 a 2050):");
			fAnio = leer(sc);
			if (!fAnio.matches("20[0-4][0-9]|2050")) {
				escribir("Ingrese un anio valido. Desde 2000 a 2050. No habian registros antes del 2000, ni confiamos llegar mas alla del 2050");
			} else {
				fechaOk = true;
			}	
		}
		return fAnio;
	}
	
	
	
	/**
	 * Pedir run.
	 * La función pedirRun() solicita al usuario que ingrese el número de RUN, que 
	 * debe tener 8 dígitos sin puntos, guiones ni dígitos verificadores.
	 *
	 * @return int que simboliza el run ya validado
	 */
	public static int pedirRun() {
		boolean rutOk = false;
		int rutu = 0;
		while(!rutOk) {
			escribir("Favor ingrese Run Usuario (no lleva puntos, guion ni digito):");
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
	
	/**
	 * Metodo Pedir nombres.
	 * Esta función pedirNombres se encarga de solicitar el ingreso de los nombres del usuario, 
	 * validando que la entrada tenga una longitud entre 5 y 30 caracteres.
	 *
	 * @return string con Nombres
	 */
	public static String pedirNombres() {
		boolean uSnMOk = false;
		String names = "";
		while(!uSnMOk) {
			escribir("Ingrese Nombres:");
			names = leer(sc);
			if (names.length()<5 || names.length()>30) {
				escribir("Nombres debe tener al menos 5 caracteres. Y un maximo de 30");
			} else {
				uSnMOk = true;
			}	
		}
		return names;
	}
	
	/**
	 * Pedir apellidos.
	 * La función pedirApellidos() solicita al usuario ingresar sus apellidos y 
	 * valida que estos tengan al menos 5 caracteres y no superen los 30 caracteres de longitud.
	 *
	 * @return string con Apellidos
	 */
	public static String pedirApellidos() {
		boolean uSnMOk = false;
		String lNames = "";
		while(!uSnMOk) {
			escribir("Ingrese Apellidos:");
			lNames = leer(sc);
			if (lNames.length()<5 || lNames.length()>30) {
				escribir("Apellidos debe tener al menos 5 caracteres. Y un maximo de 30");
			} else {
				uSnMOk = true;
			}	
		}
		return lNames;
	}
	
	/**
	 * Metodo Pedir fono.
	 * La función pedirFono() se encarga de solicitar al usuario un número de 
	 * teléfono de 8 dígitos y validar que cumpla con ciertas condiciones.
	 *
	 * @return int de telefono
	 */
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
	
	/**
	 * Metodo Pedir AFP.
	 * La función pedirAfp es una función que solicita al usuario que ingrese una 
	 * AFP y se asegura de que la entrada del usuario sea válida antes de devolverla.
	 *
	 * @return the string
	 */
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
	
	/**
	 * Metodo Pedir Sistema de Salud.
	 * La función pedirSdS() solicita al usuario que ingrese un valor que represente 
	 * el sistema de salud (Fonasa o Isapre) al que pertenece un paciente.
	 *
	 * @return int con Sistema de salud
	 */
	public static int pedirSdS() {
		boolean ssOk = false;
		int sds = 0;
		while (!ssOk) {
			escribir("Favor ingrese Sistema de Salud (1.- Fonasa / 2.- Isapre):");
			String entrada = leer(sc);
			if(entrada.isEmpty() || !entrada.matches("[1-2]")) {
				escribir("Solo 1 o 2");
			} else {
	            sds = Integer.parseInt(entrada);
	            ssOk = true;
	        }
		}
		return sds;
	}
	
	/**
	 * Metodo Pedir Direccion.
	 *  La función pedirDir() se encarga de pedir al usuario que ingrese una 
	 *  dirección y validar que no exceda los 70 caracteres.
	 *
	 * @return the string
	 */
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
	
	/**
	 * Metodo Pedir Comuna.
	 * La función pedirCom() solicita al usuario que ingrese una comuna y valida que 
	 * no tenga más de 50 caracteres
	 *
	 * @return string con Comuna
	 */
	public static String pedirCom() {
		boolean comOk = false;
		String com = "";
		while(!comOk) {
			escribir("Ingrese Comuna:");
			com = leer(sc);
			if (com.length()>50) {
				escribir("Comuna tiene un maximo de 50 caracteres");
			} else {
				comOk = true;
			}
		}	
		return com;
	}
	
	/**
	 * Metodo Pedir edad.
	 * Esta función llamada pedirEdad solicita al usuario que ingrese su edad y 
	 * realiza la validación correspondiente para asegurarse de que el valor 
	 * ingresado sea válido.
	 *
	 * @return the int
	 */
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
	
	/**
	 * Metodo Hay capacitaciones.
	 * La función hayCapacitaciones() tiene como objetivo preguntar al usuario si 
	 * desea ingresar una capacitación o no.
	 */
	public void hayCapacitaciones() {
	    boolean hayCap = true;
	    while (hayCap) {
	        escribir("Desea ingresar una Capacitacion? (y/n)");
	        String resp = leer(sc);
	        if (resp.equalsIgnoreCase("y")) {
	            crearCapacitacion();
	        } else if (resp.equalsIgnoreCase("n")) {
	            hayCap = false;
	        } else {
	            escribir("Respuesta invalida. Ingrese 'y' para sí o 'n' para no.");
	        }
	    }
	}

	
	/**
	 * Metodo Pedir id capa.
	 * La función pedirIdCapa() se encarga de solicitar al usuario el ingreso del ID 
	 * de una capacitación y validarlo para asegurarse de que es un número entero válido.
	 *
	 * @return int con IdCapa
	 */
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
	
	/**
	 * Metodo Pedir rutC.
	 * Esta función solicita al usuario el ingreso del RUT de un cliente y verifica si es válido.
	 * @deprecated
	 * @return int con Rut Cliente
	 */
	public int pedirRutC() {
		boolean rutOk = false;
		int rutc = 0;
		while(!rutOk) {
			escribir("Favor ingrese RUT Cliente (no lleva puntos, guion ni digito):");
			showRutExistentes();
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
	
	/**
	 * Metodo Pedir rutC inicial.
	 *
	 * @return int de la primera vez que se pide el Rut Cliente (al crear el cliente)
	 */
	public static int pedirRutCIni() {
		boolean rutOk = false;
		int rutc = 0;
		while(!rutOk) {
			escribir("Favor ingrese RUT Cliente (no lleva puntos, guion ni digito):");
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
	
	/**
	 * Metodo Pedir dia.
	 * La función pedirDia() solicita al usuario que ingrese el día de la semana en 
	 * el que se llevará a cabo una capacitación.(lunes a domingo)
	 *
	 * @return string con el dia
	 */
	public static String pedirDia() {
		boolean diaOk = false;
		String dia = "";
		while(!diaOk) {
			escribir("Ingrese Dia de la Capacitacion (dia de semana, ej Lunes):");
			dia = leer(sc);
			if ( dia.equalsIgnoreCase("lunes") || 
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
	
	/**
	 * Metodo Pedir hr.
	 * La función pedirHr() solicita al usuario ingresar la hora de una visita a terreno.
	 *
	 * @return string con Hora
	 */
	public static String pedirHr() {
		boolean hrOk = false;
		String hr = "";
		while(!hrOk) {
			escribir("Ingrese Hora (de 00 a 23):");
			hr = leer(sc);
			if (hr.isEmpty() ||!hr.matches("^([0-1][0-9]|2[0-3])$")) {
				escribir("Debe ingresar desde 00 a 23");
			} else {
				hrOk = true;
			}	
		}
		return hr;
	}
	
	/**
	 * Metodo Pedir min.
	 * Esta función, llamada pedirMin(), solicita al usuario que ingrese un valor numérico de minutos válido.
	 *
	 * @return string con minutos
	 */
	public static String pedirMin() {
	    boolean minOk = false;
	    String min = "";
	    while (!minOk) {
	        escribir("Ingrese Minutos (de 00 a 59):");
	        min = leer(sc);
	        if (min.isEmpty() || !min.matches("^([0-5][0-9]|00)$")) {
	            escribir("Solo de 00 a 59");
	        } else {
	            minOk = true;
	        }
	    }
	    return min;
	}

	
	/**
	 * Metodo Pedir lugar.
	 * La función pedirLugar() solicita al usuario que ingrese un lugar y se asegura 
	 * de que tenga una longitud mínima de 10 caracteres y una longitud máxima de 50 caracteres.
	 *
	 * @return string con lugar
	 */
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
	
	/**
	 * Metodo Pedir dur.
	 * Esta función llamada pedirDur() permite al usuario ingresar una duración y 
	 * validar que cumpla con ciertas condiciones.
	 *
	 * @return string de Duracion
	 */
	public static String pedirDur() {
	    boolean durOk = false;
	    String dur = "";
	    while (!durOk) {
	        escribir("Ingrese Duración:");
	        dur = leer(sc);
	        if (dur.length() > 70) {
	            escribir("No puede tener mas de 70 caracteres");
	        } else if (!dur.matches("^[0-9]+$")) {
	            escribir("Solo se permiten numeros");
	        } else {
	            durOk = true;
	        }
	    }
	    return dur;
	}

	
	/**
	 * Metodo Pedir cant.
	 * La función pedirCant() es una función que permite al usuario ingresar la 
	 * cantidad de asistentes a una actividad.
	 *
	 * @return int con cantidad
	 */
	public static int pedirCant() {
		boolean cantOk = false;
		int cantA = 0;
		while(!cantOk) {
			escribir("Ingrese Cantidad de Asistentes:");
			String casis = leer(sc);
			int cant = Integer.parseInt(casis);
			if (casis == null || casis.isEmpty() || !casis.matches("^[0-9]+$")) {
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
	
	/**
	 * Metodo Crear visita.
	 * La función crearVisita() es una función que permite al usuario crear una nueva visita a terreno.
	 */
	public void crearVisita() {
		boolean visOk = false;
		while(!visOk) {
			Visitaterreno vis = new Visitaterreno();
			escribir("Registrando Visita a Terreno");
			int id = idVis();
			vis.setIdTerreno(id);
			showRutExistentes();
			Cliente cli = buscarRutC(ase);
			int rutC = cli.getRut();
			vis.setRutC(rutC);
			String fevis = fechaV();
			vis.setDia(fevis);
			String hora = pedirHr()+":"+ pedirMin();
			vis.setHora(hora);
			String lug = pedirLugar();			
			vis.setLugar(lug);
			String comm = coment();
			vis.setComentarios(comm);
			cli.addVis(vis);
			Revision rev = new Revision();
			crearRevision(rev);
			vis.addRevi(rev);
			addRevision(rev, vis);
			visOk = true;
			escribir(ANSI_BLUE+"Visita Creada Exitosamente"+ANSI_RESET);
		}
	}
	
	/**
	 * Metodo Id vis.
	 * La función idVis es una función que solicita al usuario ingresar el id de una 
	 * visita a terreno. La función devuelve un entero que representa el id ingresado.
	 *
	 * @return the int
	 */
	public static int idVis() {
		boolean idOK = false;
		int id = 0;
		while (!idOK) {
			escribir("Favor ingrese Id de Visita a Terreno:");
			String entrada = leer(sc);
			if(!entrada.matches("\\d+")) {
				escribir("Debe solo contener numeros");
			} else {
				id = Integer.parseInt(entrada);
				idOK = true;
			}
		}
		return id;
	}
	
	/**
	 * Metodo Coment.
	 * La función "coment()" es una función que solicita al usuario ingresar un 
	 * comentario y retorna ese comentario como un String
	 *
	 * @return string
	 */
	public static String coment() {
		boolean comOK = false;
		String comment = "";
		while(!comOK) {
			escribir("Ingrese Comentarios:");
			comment = leer(sc);
			if(comment.length()>100) {
				escribir("Maximo 100 caracteres");
			} else {
				comOK = true;
			}
		}
		
		return comment;	
	}
	
	/**
	 * Metodo Detalle.
	 * La función detalle() solicita al usuario que ingrese el detalle de una
	 * revisión y devuelve una cadena de caracteres con el detalle ingresado.
	 *
	 * @return the string
	 */
	public static String detalle() {
		boolean comOK = false;
		String comment = "";
		while(!comOK) {
			escribir("Ingrese Detalle:");
			comment = leer(sc);
			if(comment.length()>100) {
				escribir("Maximo 100 caracteres");
			} else {
				comOK = true;
			}
		}
		
		return comment;	
	}
	
	/**
	 * Metodo Origen.
	 * La función origen() es una función que recibe como entrada el origen del 
	 * accidente y se encarga de validar que el origen tenga una longitud menor o igual a 100 caracteres.
	 *
	 * @return the string
	 */
	public static String origen() {
		boolean comOK = false;
		String comment = "";
		while(!comOK) {
			escribir("Ingrese Origen del Accidente:");
			comment = leer(sc);
			if(comment.length()>100) {
				escribir("Maximo 100 caracteres");
			} else {
				comOK = true;
			}
		}
		
		return comment;	
	}
	
	/**
	 * Metodo Consecuencia.
	 * La función consecuencia() es una función estática que solicita al usuario que 
	 * ingrese las consecuencias de un accidente.
	 *
	 * @return the string
	 */
	public static String consecuencia() {
		boolean comOK = false;
		String comment = "";
		while(!comOK) {
			escribir("Ingrese Consecuencias del Accidente:");
			comment = leer(sc);
			if(comment.length()>100) {
				escribir("Maximo 100 caracteres");
			} else {
				comOK = true;
			}
		}
		
		return comment;	
	}
	
	/**
	 * Metodo Pedir titulo.
	 * La función "pedirTitulo" es una función estática que permite solicitar al 
	 * usuario el ingreso de un título de un profesional y validar que cumpla con 
	 * los requisitos especificados.
	 * Esta función tiene un valor de retorno de tipo String, que es el título 
	 * ingresado por el usuario.
	 *@author Adrian Fredes
	 * @return the string
	 */
	public static String pedirTitulo() {
		boolean comOK = false;
		String titulo = "";
		while(!comOK) {
			escribir("Ingrese Titulo del Profesional:");
			titulo = leer(sc);
			if(titulo.length()<10 && titulo.length()>50) {
				escribir("Minimo 10, Maximo 50 caracteres");
			} else {
				comOK = true;
			}
		}
		
		return titulo;	
	}
	
	/**
	 * Metodo Pedir area.
	 * unción que solicita al usuario ingresar el nombre del área de trabajo de un
	// visitador en el sistema y devuelve el nombre ingresado.
	 *@author Adrian Fredes
	 * @return the string
	 */
	public static String pedirArea() {
		boolean uSnMOk = false;
		String names = "";
		while(!uSnMOk) {
			escribir("Ingrese Area:");
			names = leer(sc);
			if (names.length()<5 && names.length()<31) {
				escribir("Area debe tener al menos 5 caracteres. Y un maximo de 30");
			} else {
				uSnMOk = true;
			}	
		}
		return names;
	}
	
	/**
	 * Metodo Exp pre.
	 * Esta función es encargada de pedir la experiencia previa de un trabajador. 
	 * En particular, se utiliza una estructura iterativa con el fin de asegurarse 
	 * de que se ingrese un valor numérico y que no sea mayor a 100 caracteres.
	 *
	 *@author Adrian Fredes
	 * @return the int
	 */
	public static int expPre() {
		boolean comOK = false;
		int exp = 0;
		while(!comOK) {
			escribir("Ingrese Experiencia Previa:");
			String exps = leer(sc);
			if(!exps.matches("\\d+") && exps.length()>100) {
				escribir("Maximo 100 caracteres");
			} else {
				exp = Integer.parseInt(exps);
				comOK = true;
			}
		}
		
		return exp;	
	}
	

	/**
	 * Metodo Adds the visita.
	 * La función addVisita() es un método que permite agregar nuevas visitas a terreno al sistema.
	 */
	public void addVisita() {
		boolean hayCap = false;
		String resp = "";
		while(!hayCap) {
			escribir("Ingrese Desea ingresar otra Visita a Terreno? (y/n)");
			resp = leer(sc);
			if (resp.matches("[yYnN]") && resp.equalsIgnoreCase("y")) {
				crearVisita();
			} else if (resp.matches("[yYnN]") && resp.equalsIgnoreCase("n")) {
				hayCap = true;
			} 
		}	
	}
	
	/**
	 * MetodoCrear revision.
	 * Esta función, crearRevision, recibe como parámetro un objeto Revision. 
	 * La función solicita al usuario ingresar los datos necesarios para crear una revisión,
	 * y luego actualiza los campos del objeto Revision recibido con los valores ingresados.
	 *
	 * @param rev the rev
	 */
	public static void crearRevision(Revision rev) {
		boolean visOk = false;
		while(!visOk) {
			escribir("Registrando Revision");
			int id = idRev();
			rev.setIdRevision(id);
			int idv = idVis();
			rev.setIdTerreno(idv);
			String nomR = nomRev();
			rev.setNombre(nomR);
			String detalle = detalle();
			rev.setDetalle(detalle);
			int estado = pedirEst();
			rev.setEstado(estado);
			visOk = true;
			escribir(ANSI_BLUE+"Visita Creada Exitosamente"+ANSI_RESET);
		}
	}
	
	/**
	 * Metodo Id rev.
	 * Esta función solicita al usuario ingresar un número de identificación para 
	 * una revisión y valida que la entrada sea un número entero.
	 *
	 * @return the int
	 */
	public static int idRev() {
		boolean idOK = false;
		int id = 0;
		while (!idOK) {
			escribir("Favor ingrese Id de Revision:");
			String entrada = leer(sc);
			if(!entrada.matches("\\d+")) {
				escribir("Debe solo contener numeros");
			} else {
				id = Integer.parseInt(entrada);
				idOK = true;
			}
		}
		return id;
	}
	
	/**
	 * Metodo Nom rev.
	 * La función nomRev() es utilizada para pedirle al usuario que ingrese el 
	 * nombre de una revisión, y asegurarse de que cumpla con ciertos criterios de longitud.
	 *
	 * @return the string
	 */
	public static String nomRev() {
		boolean comOK = false;
		String nomR = "";
		while(!comOK) {
			escribir("Ingrese Nombre de la Revision:");
			nomR = leer(sc);
			if(nomR.length()>10 && nomR.length()>50) {
				escribir("Minimo 10 caracteres, Maximo 50 caracteres");
			} else {
				comOK = true;
			}
		}
		return nomR;	
	}
	
	/**
	 * Metodo Pedir est.
	 * La función pedirEst() solicita al usuario que ingrese el estado de una 
	 * revisión (sin problemas, con observaciones o no aprobada) y devuelve el valor 
	 * numérico correspondiente.
	 *
	 * @return the int
	 */
	public static int pedirEst() {
		boolean ssOk = false;
		int estado = 0;
		while (!ssOk) {
			escribir("Favor ingrese Estado de Revision (1.- Sin Problemas / 2.- Con Observaciones / 3.- No Aprueba):");
			String entrada = leer(sc);
			if(!entrada.matches("[1-3]")) {
				escribir("Solo 1, 2 o 3");
			} else {
	            estado = Integer.parseInt(entrada);
	            ssOk = true;
	        }
		}
		return estado;
	}
	
	/**
	 * Metodo Adds the revision.
	 * Función addRevision permite agregar una revisión a una visita de terreno y
	 * también permite agregar múltiples revisiones a la misma visita. 
	 * Recibe dos parámetros: un objeto Revision que representa la revisión a 
	 * agregar y un objeto Visitaterreno que representa la visita de terreno a la 
	 * cual se le desea agregar la revisión.
	 *
	 * @param rev the rev
	 * @param vis the vis
	 */
	public static void addRevision(Revision rev, Visitaterreno vis) {
		boolean hayCap = false;
		String resp = "";
		while(!hayCap) {
			escribir("Ingrese Desea ingresar otra Revision? (y/n)");
			resp = leer(sc);
			if (resp.matches("[yYnN]") && resp.equalsIgnoreCase("y")) {
				crearRevision(rev);
				vis.addRevi(rev);
			} else if (resp.matches("[yYnN]") && resp.equalsIgnoreCase("n")) {
				hayCap = true;
			} 
		}
	}
	
	/**
	 * Metodo Hay accidente.
	 * La función "hayAccidente()" pregunta al usuario si desea ingresar un accidente.
	 */
	public void hayAccidente() {
		boolean hayAcc = false;
		String resp = "";
		while(!hayAcc) {
			escribir("Desea ingresar un Accidente? (y/n)");
			resp = leer(sc);
			if (resp.matches("[yYnN]") && resp.equalsIgnoreCase("y")) {
				crearAccidente();
				
			} else if (resp.matches("[yYnN]") && resp.equalsIgnoreCase("n")) {
				hayAcc = true;
			} 
		}	
	}
	
	/**
	 * Metodo Crear accidente.
	 * Funcion utilizada para registrar un nuevo accidente en el sistema.
	 */
	public void crearAccidente() { 
			Accidente acc = new Accidente();
			escribir("Registrando Accidente");
			int id = idAcc();
			acc.setidAccid(id);
			showRutExistentes();
			Cliente cli = buscarRutC(ase);
			int rutC = cli.getRut();
			acc.setRutC(rutC);
			String dia = fechaA();
			acc.setdia(dia);
			escribir("Ingrese la Hora del Accidente");
			String hora = pedirHr()+":"+pedirMin();
			acc.setdia(hora);
			String lug = pedirLugar();
			acc.setLugar(lug);
			String ori = origen();
			acc.setorigen(ori);
			String cons = consecuencia();
			acc.setconsec(cons);
			escribir(ANSI_BLUE+"Accidente creado Exitosamente"+ANSI_RESET);
	}
	
	/**
	 * Metodo Id acc.
	 * Funcion se encarga de pedir al usuario que ingrese un identificador 
	 * numérico para un accidente y luego verificar que este identificador sea válido 
	 * (es decir, que solo contenga números) 
	 * La función retorna el identificador válido ingresado por el usuario.
	 *
	 * @return the int
	 */
	public static int idAcc() {
		boolean idOK = false;
		int id = 0;
		while (!idOK) {
			escribir("Favor ingrese Id de Accidente:");
			String entrada = leer(sc);
			if(!entrada.matches("\\d+")) {
				escribir("Debe solo contener numeros");
			} else {
				id = Integer.parseInt(entrada);
				idOK = true;
			}
		}
		return id;
	}
	
	/**
	 * Metodo Adds the accidente.
	 * Función es responsable de permitir al usuario ingresar información sobre 
	 * accidentes y almacenarla en objetos "Accidente".
	 */
	public void addAccidente() {
		boolean hayCap = false;
		String resp = "";
		while(!hayCap) {
			escribir("Ingrese Desea ingresar otro Accidente? (y/n)");
			resp = leer(sc);
			if (resp.matches("[yYnN]") && resp.equalsIgnoreCase("y")) {
				crearAccidente();
			} else if (resp.matches("[yYnN]") && resp.equalsIgnoreCase("n")) {
				hayCap = true;
			} 
		}
	}
	
	
	/**
	 * Metodo Show rut existentes.
	 * Función que muestra en la consola todos los clientes existentes 
	 * (objetos de la clase "Cliente") y sus RUT
	 */
	public void showRutExistentes() {
		boolean hay = false;
		System.out.println(ANSI_WHITE+"----------------- Ruts existentes -----------------------"+ANSI_RESET);
	    for (Asesoria a : ase) {
	        if (a instanceof Cliente) {
	            System.out.println(ANSI_YELLOW+((Cliente) a).obtenerNombre()+" RUT: "+ ((Cliente) a).getRut()+ANSI_RESET);
	            hay = true;
	        }
	    }
	    System.out.println(ANSI_PURPLE+"----------------------------------------------------"+ANSI_RESET);
	    if (!hay) {
	    	escribir("No hay Usuario-Cliente registrados. Primero Registre uno.");
	    }
	}
	
	
	
	
	/**
	 * Metodo Escribir.
	 * Abreviacion para no estar escribiendo siempre el System.out.println(),
	 * @param pasa mensaje del llamado a Print Pantalla
	 */
	public static void escribir(String mensaje) {
		System.out.println(mensaje);
	}
	
	/**
	 * Metodo Leer.
	 * Abreviacion para no estar escribiendo siempre el sc.nextLine()
	 *
	 * @param sc the sc
	 * @return the string
	 */
	public static String leer(Scanner sc) {
		return sc.nextLine();
	}
	
	public String tRojo(String textoenRojo) {
		return ANSI_RED+textoenRojo+ANSI_RESET;
	}
	
	public String tVerde(String textoenVerde) {
		return ANSI_GREEN+textoenVerde+ANSI_RESET;
	}
	
	public String tAma(String textoenAmarillo) {
		return ANSI_YELLOW+textoenAmarillo+ANSI_RESET;
	}
	
	public String tCyan(String textoenCyan) {
		return ANSI_CYAN+textoenCyan+ANSI_RESET;
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
