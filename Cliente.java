/**
 *@authors :	Matias Calderon - Modelacion de clase		   
 */
package sprint;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase Cliente extiende de clase Usuario
 */
public class Cliente extends Usuario {
	
	/** Declaracion de variables, atributos de Usuario */
	private int rut;
	private String nombres;
	private String apellidos;
	private int telefono;
	private String afp;
	private int sds;
	private String direccion;
	private String comuna;
	private int edad;
	private List<Capacitacion> capas = new ArrayList<Capacitacion>();
	private List<Accidente> acc = new ArrayList<Accidente>();
	
	/**
	 * Constructor Cliente vacio
	 */
	public Cliente() {
		
	}
	
	/**
	 * Constructor Cliente con datos
	 *
	 * @param uName
	 * @param fNacimiento
	 * @param run
	 * @param rut
	 * @param nombres
	 * @param apellidos
	 * @param telefono
	 * @param afp
	 * @param sds
	 * @param direccion
	 * @param comuna
	 * @param edad
	 */
	public Cliente (String uName, String fNacimiento, int run, int rut, String nombres, String apellidos, int telefono, String afp, int sds, String direccion,
			String comuna, int edad) {
		super(uName, fNacimiento, run);
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
	 * Trae rut.
	 *
	 * @return the rut
	 */
	public int getRut() {
		return rut;
	}

	/**
	 * Fija rut.
	 *
	 * @param rut the rut to set
	 */
	public void setRut(int rut) {
		this.rut = rut;
	}

	/**
	 * Trae nombres.
	 *
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * Fija nombres.
	 *
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * Trae apellidos.
	 *
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Fija apellidos.
	 *
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Trae telefono.
	 *
	 * @return the telefono
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * Fija telefono.
	 *
	 * @param telefono the telefono to set
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * Trae afp.
	 *
	 * @return the afp
	 */
	public String getAfp() {
		return afp;
	}

	/**
	 * Fija afp.
	 *
	 * @param afp the afp to set
	 */
	public void setAfp(String afp) {
		this.afp = afp;
	}

	/**
	 * Trae Sistema de Salud.
	 *
	 * @return the sds
	 */
	public int getSds() {
		return sds;
	}

	/**
	 * Fija Sistema de Salud.
	 *
	 * @param sds the sds to set
	 */
	public void setSds(int sds) {
		this.sds = sds;
	}

	/**
	 * Trae direccion.
	 *
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Fija direccion.
	 *
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Trae comuna.
	 *
	 * @return the comuna
	 */
	public String getComuna() {
		return comuna;
	}

	/**
	 * Fija comuna.
	 *
	 * @param comuna the comuna to set
	 */
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	/**
	 * Trae edad.
	 *
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Fija edad.
	 *
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Metodo sistSalud
	 *
	 * @return String con el Sistema de salud segun valor de sds
	 */

	/**
	 * Metodo Analizar usuario que se deriva de Interfaz Asesoria.
	 */
	@Override
	public void analizarUsuario() {
		super.analizarUsuario();
		System.out.println("\nDireccion: "+direccion+"\nComuna: "+comuna);
	}

	/**
	 * Metodo toString de la clase Cliente
	 *
	 * @return string con datos de la clase
	 */
	@Override
	public String toString() {
		return "Rut Cliente: " + rut + "\nNombre Completo" + obtenerNombre() + 
				"\nTelefono: " + telefono + 
				"\n AFP: " + afp + 
				"\nSistema de Salud: " + obtenerSistemaSalud() + 
				"\nDireccion: " + direccion + 
				"\nComuna: " + comuna + 
				"\nEdad: " + edad;
	}
	
	/**
	 * Metodo Obtener Sistema de Salud.
	 *
	 * @return String con el Sistema de salud segun valor de sds
	 */
	public String obtenerSistemaSalud() {
		if (sds == 1) {
			return "Fonasa";
		} else {
			return "Isapre";
		}
	}
	
	/**
	 * Metodo Obtener Nombre.
	 *
	 * @return String con concatenacion de nombre mas espacio y apellido
	 */
	public String obtenerNombre() {
		return nombres+" "+apellidos;
	}
	
	/**
	 * Metodo Addcapa.
	 *
	 * @param Anade capacitacion c a la lista Capacitaciones
	 */
	public void addCapa(Capacitacion c) {
		capas.add(c);
	}

	/**
	 * Metodo addAcc.
	 *
	 * @param anade accidente a a la lista de Accidente
	 */
	public void addAcc(Accidente a) {
		acc.add(a);
	}
	
}
