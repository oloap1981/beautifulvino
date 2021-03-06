/**
 * 
 */
package com.marte5.modello.richieste.get;

import com.marte5.modello.richieste.Richiesta;

/**
 * @author paolosalvadori
 *
 */
public class RichiestaGetEvento extends Richiesta {

	private long idEvento;
	private long idUtente;
	private long dataEvento;
	
	/**
	 * @return the idEvento
	 */
	public long getIdEvento() {
		return idEvento;
	}
	/**
	 * @param idEvento the idEvento to set
	 */
	public void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}
	/**
	 * @return the idUtente
	 */
	public long getIdUtente() {
		return idUtente;
	}
	/**
	 * @param idUtente the idUtente to set
	 */
	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}
	/**
	 * @return the dataEvento
	 */
	public long getDataEvento() {
		return dataEvento;
	}
	/**
	 * @param dataEvento the dataEvento to set
	 */
	public void setDataEvento(long dataEvento) {
		this.dataEvento = dataEvento;
	}
}
