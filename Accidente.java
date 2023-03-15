package sprint;



public class Accidente {
	
	
      private int idAccid;
      private int rutC ;
      private String dia;
      private String hora;
      private String lugar;
      private String origen;
      private String consec;
      
      
	public int getidAccid() {
		return idAccid;
	}
	public void setidAccid(int idAccid) {
		this.idAccid = idAccid;
	}
	public int getRutC() {
		return rutC;
	}
	public void setRutC(int rutC) {
		rutC = rutC;
	}
	public String getdia() {
		return dia;
	}
	public void setdia(String dia) {
		dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		hora = hora;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		lugar = lugar;
	}
	public String getOrigen() {
		return origen;
	}
	public void setorigen(String origen) {
		origen = origen;
	}
	public String getconsec() {
		return consec;
	}
	public void setconsec(String consec) {
		consec = consec;
	}
	@Override
	public String toString() {
		return "Id Accidente: " + idAccid + 
				"\nRut Cliente: " + rutC + 
				"\nDia: " + dia + 
				"\nHora: " + hora + 
				"\nLugar: " + lugar + 
				"\nOrigen: " + origen + 
				"\nConsecuencias: " + consec;
	}
      
    public Accidente () {  
      
      
}
    public Accidente(int idAccid, String run, String dia, String hora, String lugar , String origen, String consec) {
    	
    }
}