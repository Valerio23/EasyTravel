package entities;

import java.util.Date;

public class ViaggioGruppo {
	
	int idViaggioGr;
	String creatore;
	float prezzo;
	int numMaxUt;
	Boolean pagAnt;
	int impAnt;
	Date scadenza;
	Date dataV;
	
	public ViaggioGruppo(int idV, User usr, float pr, int numMax, Boolean pagA, int impA, Date sc, Date dV) {
		
		this.idViaggioGr = idV;
		this.creatore = usr.getUsername();
		this.prezzo = pr;
		this.numMaxUt = numMax;
		this.pagAnt = pagA;
		this.impAnt = impA;
		this.scadenza = sc;
		this.dataV = dV;
		
	}
	
	public int getIdV() {
		return this.idViaggioGr;
	}
	
}
