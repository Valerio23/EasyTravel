package entities;

public class Viaggio {
	
	int idViaggio;			//in caso di creazione di un viaggio non viene utilizzato perchè 
							//il DBMS lo autogenera
	String idUsr;
	String Destinazione;
	String Descrizione;
	Boolean Status;			//fatto si/no
	int likes;
	String creatore;
	int open;
	
	
	public Viaggio() {}
	
	//in caso in cui si sta creando un viaggio invece si chiama il costr di default ed ogni volta che si 
	//aggiunge qualcosa utilizziamo i get e set
	
	
	//in caso si 'carichi' un viaggio già bello che pronto
	
	public Viaggio(int idV, String idU, String Dst, String Dsc, Boolean St) {
		
		this.idViaggio = idV;
		this.idUsr = idU;
		this.Destinazione = Dst;
		this.Descrizione = Dsc;
		this.Status = St;
		
	}
	
	
	public Viaggio(int idV, String idU, String Dst, String Dsc) {
		
		this.idViaggio = idV;
		this.idUsr = idU;
		this.Destinazione = Dst;
		this.Descrizione = Dsc;
		
	}
	
	
	public void setIdV(int id) {
		this.idViaggio = id;
	} 
	
	
	public int getIdV() {
		return this.idViaggio;
	}
	
	
	public void setIdU(String u) {
		this.idUsr = u;
	}
	
	
	public String getIdU() {
		return this.idUsr;
	}
	
	
	public String getDst() {
		return this.Destinazione;
	}
	
	
	public void setDst(String dst) {
		this.Destinazione = dst;
	}
	
	
	public String getDesc() {
		return this.Descrizione;
	}

	
	public void setDesc(String dsc) {
		this.Descrizione = dsc;
	}
	
	
	public Boolean getStatus() {
		return this.Status;
	}

	
	public void setStatus(Boolean s) {
		this.Status = s;
	}
	
	public void setLks(int lk) {
		this.likes = lk;
	} 
	
	
	public int getLks() {
		return this.likes;
	}
	
	public void setCr(String cr) {
		this.creatore = cr;
	}
	
	public String getCr() {
		return this.creatore;
	}
	
	public int getOp() {
		return this.open;
	}
	
	
	public void setOp(String o) {
		if(o.contentEquals("y")) {
			this.open = 1;
		}else {
			this.open = 0;
		}
	}
	
	
	
	
}
