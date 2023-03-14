package sprint;



public class Accidente {
	
	
      private int idAccid;
      private String run ;
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
	public String getrun() {
		return run;
	}
	public void setrun(String run) {
		run = run;
	}
	public String getdia() {
		return dia;
	}
	public void setdia(String dia) {
		dia = dia;
	}
	public String gethora() {
		return hora;
	}
	public void sethora(String hora) {
		hora = hora;
	}
	public String getlugar() {
		return lugar;
	}
	public void setlugar(String lugar) {
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
		return "Accidente [idAccid=" + idAccid + ", run=" + run + ", dia=" + dia + ", hora=" + hora + ", lugar=" + lugar
				+ ", origen=" + origen + ", consec=" + consec + "]";
	}
      
    public Accidente () {  
      
      
}
    public Accidente(int idAccid, String run, String dia, String hora, String lugar , String origen, String consec) {
    	
    }
}