/**
 * 
 */
package com.marte5.modello;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * @author paolosalvadori
 *
 */
@DynamoDBTable(tableName="BV_Azienda")
public class Azienda {

	private long idAzienda;
	private String zonaAzienda;
	private String nomeAzienda;
	private String infoAzienda;
	private String descrizioneAzienda;
	private String cittaAzienda;
	private String regioneAzienda;
	private String indirizzoAzienda;
	private double latitudineAzienda;
	private double longitudineAzienda;
	private String urlLogoAzienda;
	private String urlImmagineAzienda;
	private String sitoAzienda;
	private String emailAzienda;
	private String emailSecondariaAzienda;
	private String telefonoAzienda;
	private List<Evento> eventiAzienda;
	private List<Vino> viniAzienda;
	private List<EventoAzienda> eventiAziendaInt;
	private List<VinoAzienda> viniAziendaInt;
	private int numEventiAzienda;
	private int numViniAzienda;
	
	//@DynamoDBAttribute(attributeName="")
	
	/**
	 * @return the idAzienda
	 */
	@DynamoDBHashKey(attributeName="idAzienda")
	public long getIdAzienda() {
		return idAzienda;
	}
	/**
	 * @param idAzienda the idAzienda to set
	 */
	public void setIdAzienda(long idAzienda) {
		this.idAzienda = idAzienda;
	}
	/**
	 * @return the zonaAzienda
	 */
	@DynamoDBAttribute(attributeName="zonaAzienda")
	public String getZonaAzienda() {
		return zonaAzienda;
	}
	/**
	 * @param zonaAzienda the zonaAzienda to set
	 */
	public void setZonaAzienda(String zonaAzienda) {
		this.zonaAzienda = zonaAzienda;
	}
	/**
	 * @return the nomeAzienda
	 */
	@DynamoDBAttribute(attributeName="nomeAzienda")
	public String getNomeAzienda() {
		return nomeAzienda;
	}
	/**
	 * @param nomeAzienda the nomeAzienda to set
	 */
	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}
	/**
	 * @return the infoAzienda
	 */
	@DynamoDBAttribute(attributeName="infoAzienda")
	public String getInfoAzienda() {
		return infoAzienda;
	}
	/**
	 * @param infoAzienda the infoAzienda to set
	 */
	public void setInfoAzienda(String infoAzienda) {
		this.infoAzienda = infoAzienda;
	}
	/**
	 * @return the descrizioneAzienda
	 */
	@DynamoDBAttribute(attributeName="descrizioneAzienda")
	public String getDescrizioneAzienda() {
		return descrizioneAzienda;
	}
	/**
	 * @param descrizioneAzienda the descrizioneAzienda to set
	 */
	public void setDescrizioneAzienda(String descrizioneAzienda) {
		this.descrizioneAzienda = descrizioneAzienda;
	}
	/**
	 * @return the luogoAzienda
	 */
	@DynamoDBAttribute(attributeName="cittaAzienda")
	public String getCittaAzienda() {
		return cittaAzienda;
	}
	/**
	 * @param cittaAzienda the luogoAzienda to set
	 */
	public void setCittaAzienda(String cittaAzienda) {
		this.cittaAzienda = cittaAzienda;
	}
	/**
	 * @return the regionezienda
	 */
	@DynamoDBAttribute(attributeName="regioneAzienda")
	public String getRegioneAzienda() {
		return regioneAzienda;
	}
	/**
	 * @param cittaAzienda the luogoAzienda to set
	 */
	public void setRegioneAzienda(String regioneAzienda) {
		this.regioneAzienda = regioneAzienda;
	}
	
	/**
	 * @return the indirizzoAzienda
	 */
	@DynamoDBAttribute(attributeName="indirizzoAzienda")
	public String getiIdirizzoAzienda() {
		return indirizzoAzienda;
	}
	/**
	 * @param indirizzoAzienda the indirizzoAzienda to set
	 */
	public void setIndirizzoAzienda(String indirizzoAzienda) {
		this.indirizzoAzienda = indirizzoAzienda;
	}
	/**
	 * @return the latitudineAzienda
	 */
	@DynamoDBAttribute(attributeName="latitudineAzienda")
	public double getLatitudineAzienda() {
		return latitudineAzienda;
	}
	/**
	 * @param latitudineAzienda the latitudineAzienda to set
	 */
	public void setLatitudineAzienda(double latitudineAzienda) {
		this.latitudineAzienda = latitudineAzienda;
	}
	/**
	 * @return the longitudineAzienda
	 */
	@DynamoDBAttribute(attributeName="longitudineAzienda")
	public double getLongitudineAzienda() {
		return longitudineAzienda;
	}
	/**
	 * @param longitudineAzienda the longitudineAzienda to set
	 */
	public void setLongitudineAzienda(double longitudineAzienda) {
		this.longitudineAzienda = longitudineAzienda;
	}
	/**
	 * @return the urlLogoAzienda
	 */
	@DynamoDBAttribute(attributeName="urlLogoAzienda")
	public String getUrlLogoAzienda() {
		return urlLogoAzienda;
	}
	/**
	 * @param urlLogoAzienda the urlLogoAzienda to set
	 */
	public void setUrlLogoAzienda(String urlLogoAzienda) {
		this.urlLogoAzienda = urlLogoAzienda;
	}
	
	/**
	 * @return the urlImmagineAzienda
	 */
	@DynamoDBAttribute(attributeName="urlImmagineAzienda")
	public String getUrlImmagineAzienda() {
		return urlImmagineAzienda;
	}
	/**
	 * @param urlImmagineAzienda the urlImmagineAzienda to set
	 */
	public void setUrlImmagineAzienda(String urlImmagineAzienda) {
		this.urlImmagineAzienda = urlImmagineAzienda;
	}
	
	/**
	 * @return the sitoAzienda
	 */
	@DynamoDBAttribute(attributeName="sitoAzienda")
	public String getSitoAzienda() {
		return sitoAzienda;
	}
	/**
	 * @param sitoAzienda the sitoAzienda to set
	 */
	public void setSitoAzienda(String sitoAzienda) {
		this.sitoAzienda = sitoAzienda;
	}
	/**
	 * @return the emailAzienda
	 */
	@DynamoDBAttribute(attributeName="emailAzienda")
	public String getEmailAzienda() {
		return emailAzienda;
	}
	/**
	 * @param emailAzienda the emailAzienda to set
	 */
	public void setEmailAzienda(String emailAzienda) {
		this.emailAzienda = emailAzienda;
	}
	/**
	 * @return the emailSecondariaAzienda
	 */
	@DynamoDBAttribute(attributeName="emailSecondariaAzienda")
	public String getEmailSecondariaAzienda() {
		return emailSecondariaAzienda;
	}
	/**
	 * @param emailSecondariaAzienda the emailSecondariaAzienda to set
	 */
	public void setEmailSecondariaAzienda(String emailSecondariaAzienda) {
		this.emailSecondariaAzienda = emailSecondariaAzienda;
	}
	/**
	 * @return the telefonoAzienda
	 */
	@DynamoDBAttribute(attributeName="telefonoAzienda")
	public String getTelefonoAzienda() {
		return telefonoAzienda;
	}
	/**
	 * @param telefonoAzienda the telefonoAzienda to set
	 */
	public void setTelefonoAzienda(String telefonoAzienda) {
		this.telefonoAzienda = telefonoAzienda;
	}
	
	/**
	 * @return the eventiAzienda
	 */
	@DynamoDBIgnore
	public List<Evento> getEventiAzienda() {
		return eventiAzienda;
	}
	/**
	 * @param eventiAzienda the eventiAzienda to set
	 */
	public void setEventiAzienda(List<Evento> eventiAzienda) {
		this.eventiAzienda = eventiAzienda;
	}
	/**
	 * @return the viniAzienda
	 */
	@DynamoDBIgnore
	public List<Vino> getViniAzienda() {
		return viniAzienda;
	}
	/**
	 * @param viniAzienda the viniAzienda to set
	 */
	public void setViniAzienda(List<Vino> viniAzienda) {
		this.viniAzienda = viniAzienda;
	}
	/**
	 * @return the numEventiAzienda
	 */
	@DynamoDBIgnore
	public int getNumEventiAzienda() {
		return numEventiAzienda;
	}
	/**
	 * @param numEventiAzienda the numEventiAzienda to set
	 */
	public void setNumEventiAzienda(int numEventiAzienda) {
		this.numEventiAzienda = numEventiAzienda;
	}
	/**
	 * @return the numViniAzienda
	 */
	@DynamoDBIgnore
	public int getNumViniAzienda() {
		return numViniAzienda;
	}
	/**
	 * @param numViniAzienda the numViniAzienda to set
	 */
	public void setNumViniAzienda(int numViniAzienda) {
		this.numViniAzienda = numViniAzienda;
	}
	
	/**
	 * @return the eventiAziendaInt
	 */
	@DynamoDBAttribute(attributeName="eventiAziendaInt")
	public List<EventoAzienda> getEventiAziendaInt() {
		return eventiAziendaInt;
	}
	/**
	 * @param eventiAziendaInt the eventiAziendaInt to set
	 */
	public void setEventiAziendaInt(List<EventoAzienda> eventiAziendaInt) {
		this.eventiAziendaInt = eventiAziendaInt;
	}
	/**
	 * @return the viniAziendaInt
	 */
	@DynamoDBAttribute(attributeName="viniAziendaInt")
	public List<VinoAzienda> getViniAziendaInt() {
		return viniAziendaInt;
	}
	/**
	 * @param viniAziendaInt the viniAziendaInt to set
	 */
	public void setViniAziendaInt(List<VinoAzienda> viniAziendaInt) {
		this.viniAziendaInt = viniAziendaInt;
	}
	
	@DynamoDBDocument
	public static class VinoAzienda{
		private long idVino;
		private String nomeVino;
		private int annoVino;
		
		@DynamoDBAttribute(attributeName="idVino")
		public long getIdVino() {
			return idVino;
		}
		public void setIdVino(long idVino) {
			this.idVino = idVino;
		}
		@DynamoDBAttribute(attributeName="nomeVino")
		public String getNomeVino() {
			return nomeVino;
		}
		public void setNomeVino(String nomeVino) {
			this.nomeVino = nomeVino;
		}
		/**
		 * @return the annoVino
		 */
		@DynamoDBAttribute(attributeName="annoVino")
		public int getAnnoVino() {
			return annoVino;
		}
		/**
		 * @param annoVino the annoVino to set
		 */
		public void setAnnoVino(int annoVino) {
			this.annoVino = annoVino;
		}
	}
	
	@DynamoDBDocument
	public static class EventoAzienda{
		private long idEvento;
		
		@DynamoDBAttribute(attributeName="idEvento")
		public long getIdEvento() {
			return idEvento;
		}
		public void setIdEvento(long idEvento) {
			this.idEvento = idEvento;
		}
	}

	
}
