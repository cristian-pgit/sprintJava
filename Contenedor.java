package sprint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Contenedor {
	
	static Scanner sc = new Scanner(System.in);
	
	
	protected List<Asesoria> ase;
	protected List<Capacitacion> capas;
	
	public Contenedor () {
		this.ase = new ArrayList<Asesoria>();
		this.capas = new ArrayList<Capacitacion>();
	}
	
	
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
	//	// anade el usuario creado a la lista de Asesoria,
	//	ase.add(cli);
		//despliega mensaje indicando que el usuario se ha creado exitosamente.
		escribir(ANSI_CYAN+"Usuario Creado Exitosamente"+ANSI_RESET);

	}
	
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
	
	public void crearCapacitacion() {
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
			escribir(ANSI_BLUE+"Capacitacion Creada Exitosamente"+ANSI_RESET);
			capa.mostrarDetalles();
		}		
	}
	
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
	
	public void mostrarUsuarios() {
		int i = 1;
		for (Asesoria a:ase) {
			System.out.println(ANSI_WHITE+"----------------- Usuario: "+i+" -----------------------"+ANSI_RESET);
			a.analizarUsuario();
			i++;
			System.out.println(ANSI_PURPLE+"----------------------------------------------------"+ANSI_RESET);
		}
	}
	
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
	
	public void listarCapacitaciones() {
		int i = 1;
		for (Capacitacion c:capas) {
			System.out.println(ANSI_WHITE+"----------------- Capacitacion: "+i+" -----------------------"+ANSI_RESET);
			c.mostrarDetalles();
			i++;
			System.out.println(ANSI_PURPLE+"----------------------------------------------------"+ANSI_RESET);
		}
		
	}
	
	public Usuario buscarRun(List<Asesoria> ase) {
	    boolean runOk = false;
	    Usuario usuario = null;
	    while (!runOk) {
	    	showRunExistentes();
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
	
	public static String fechaN() {
		escribir("Ingrese Fecha de Nacimiento (DD/MM/AAAA):");
		return fDia()+"/"+fMes()+"/"+fAnio();
	}
	public static String fechaV() {
		escribir("Ingrese Fecha de Visita (DD/MM/AAAA):");
		return fDia()+"/"+fMes()+"/"+vAnio();
	}
	public static String fechaA() {
		escribir("Ingrese Dia del Accidente (DD/MM/AAAA):");
		return fDia()+"/"+fMes()+"/"+vAnio();
	}
	public static String fechaI() {
		escribir("Ingrese Fecha de Ingreso (DD/MM/AAAA):");
		return fDia()+"/"+fMes()+"/"+vAnio();
	}
	
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
	
	public static String pedirDia() {
		boolean diaOk = false;
		String dia = "";
		while(!diaOk) {
			escribir("Ingrese Dia de la Capacitacion (dia de semana, ej Lunes):");
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
			escribir("Ingrese Hora (de 00 a 23):");
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
	            escribir("No puede tener mas de 70 caracteres");
	        } else if (!dur.matches("^[0-9]+$")) {
	            escribir("Solo se permiten numeros");
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
	
	public void crearVisita() {
		boolean visOk = false;
		while(!visOk) {
			Visitaterreno vis = new Visitaterreno();
			escribir("Registrando Visita a Terreno");
			int id = idVis();
			vis.setIdTerreno(id);
			int rut = pedirRutC();
			vis.setRutC(rut);
			String fevis = fechaV();
			vis.setDia(fevis);
			String hora = pedirHr()+":"+ pedirMin();
			vis.setHora(hora);
			String lug = pedirLugar();			
			vis.setLugar(lug);
			String comm = coment();
			vis.setComentarios(comm);
			Revision rev = new Revision();
			crearRevision(rev);
			vis.addRevi(rev);
			addRevision(rev, vis);
			visOk = true;
			escribir(ANSI_BLUE+"Visita Creada Exitosamente"+ANSI_RESET);
		}
	}
	
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
	
	public void crearAccidente() { 
			Accidente acc = new Accidente();
			escribir("Registrando Accidente");
			int id = idAcc();
			acc.setidAccid(id);
			int rut = pedirRutC();
			acc.setRutC(rut);
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
	
	
	public void showRutExistentes() {
	    System.out.println(ANSI_WHITE+"----------------- Ruts existentes -----------------------"+ANSI_RESET);
	    for (Asesoria a : ase) {
	        if (a instanceof Cliente) {
	            System.out.println(ANSI_YELLOW+((Cliente) a).obtenerNombre()+" RUT: "+ ((Cliente) a).getRut()+ANSI_RESET);
	        }
	    }
	    System.out.println(ANSI_PURPLE+"----------------------------------------------------"+ANSI_RESET);
	}
	
	public void showRunExistentes() {
	    System.out.println(ANSI_WHITE+"----------------- Ruts existentes -----------------------"+ANSI_RESET);
	    for (Asesoria a : ase) {
	       System.out.println(ANSI_YELLOW+((Cliente) a).obtenerNombre()+" RUN: "+ ((Cliente) a).getRun()+ANSI_RESET);
	    }
	    System.out.println(ANSI_PURPLE+"----------------------------------------------------"+ANSI_RESET);
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
