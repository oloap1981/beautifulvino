/**
 * 
 */
package com.marte5.modello;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * @author paolosalvadori
 *
 */
@DynamoDBTable(tableName="BV_Evento")
public class Evento {

	private long idEvento;
	private long dataEvento;
	private String dataEventoStringa;
	private String cittaEvento;
	private String titoloEvento;
	private String temaEvento;
	private float prezzoEvento;
	private String urlFotoEvento;
	private String statoEvento;
	private String testoEvento;
	private double latitudineEvento;
	private double longitudineEvento;
	private String indirizzoEvento;
	private String telefonoEvento;
	private String emailEvento;
	private int numMaxPartecipantiEvento;
	private int numPostiDisponibiliEvento;
	private Badge badgeEvento;
	private Provincia provinciaEvento;
	private Azienda aziendaOspitanteEvento;
	private Azienda aziendaFornitriceEvento;
	private List<Utente> iscrittiEvento;
	private List<Vino> viniEvento;
	private BadgeEvento badgeEventoInt;
	private ProvinciaEvento provinciaEventoInt;
	private AziendaEvento aziendaOspitanteEventoInt;
	private AziendaEvento aziendaFornitriceEventoInt;
	private List<UtenteEvento> iscrittiEventoInt;//solo uso interno
	private List<VinoEvento> viniEventoInt;//solo uso interno
	
	/**
	 * @return the idEvento
	 */
	@DynamoDBHashKey(attributeName="idEvento")
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
	 * @return the dataEvento
	 */
	@DynamoDBRangeKey(attributeName="dataEvento")
	public long getDataEvento() {
		return dataEvento;
	}
	/**
	 * @param dataEvento the dataEvento to set
	 */
	public void setDataEvento(long dataEvento) {
		this.dataEvento = dataEvento;
	}
	
	/**
	 * @return the cittaEvento
	 */
	@DynamoDBAttribute(attributeName="cittaEvento")
	public String getCittaEvento() {
		return cittaEvento;
	}
	/**
	 * @param cittaEvento the cittaEvento to set
	 */
	public void setCittaEvento(String cittaEvento) {
		this.cittaEvento = cittaEvento;
	}
	
	/**
	 * @return the titoloEvento
	 */
	@DynamoDBAttribute(attributeName="titoloEvento")
	public String getTitoloEvento() {
		return titoloEvento;
	}
	/**
	 * @param titoloEvento the titoloEvento to set
	 */
	public void setTitoloEvento(String titoloEvento) {
		this.titoloEvento = titoloEvento;
	}
	
	/**
	 * @return the temaEvento
	 */
	@DynamoDBAttribute(attributeName="temaEvento")
	public String getTemaEvento() {
		return temaEvento;
	}
	/**
	 * @param temaEvento the temaEvento to set
	 */
	public void setTemaEvento(String temaEvento) {
		this.temaEvento = temaEvento;
	}
	
	/**
	 * @return the prezzoEvento
	 */
	@DynamoDBAttribute(attributeName="prezzoEvento")
	public float getPrezzoEvento() {
		return prezzoEvento;
	}
	/**
	 * @param prezzoEvento the prezzoEvento to set
	 */
	public void setPrezzoEvento(float prezzoEvento) {
		this.prezzoEvento = prezzoEvento;
	}
	
	/**
	 * @return the urlFotoEvento
	 */
	@DynamoDBAttribute(attributeName="urlFotoEvento")
	public String getUrlFotoEvento() {
		return urlFotoEvento;
	}
	/**
	 * @param urlFotoEvento the urlFotoEvento to set
	 */
	public void setUrlFotoEvento(String urlFotoEvento) {
		this.urlFotoEvento = urlFotoEvento;
	}
	
	/**
	 * @return the statoevento
	 */
	@DynamoDBAttribute(attributeName="statoEvento")
	public String getStatoEvento() {
		return statoEvento;
	}
	/**
	 * @param statoevento the statoevento to set
	 */
	public void setStatoEvento(String statoevento) {
		this.statoEvento = statoevento;
	}
	
	/**
	 * @return the testoEvento
	 */
	@DynamoDBAttribute(attributeName="testoEvento")
	public String getTestoEvento() {
		return testoEvento;
	}
	/**
	 * @param testoEvento the testoEvento to set
	 */
	public void setTestoEvento(String testoEvento) {
		this.testoEvento = testoEvento;
	}
	
	/**
	 * @return the latitudineEvento
	 */
	@DynamoDBAttribute(attributeName="latitudineEvento")
	public double getLatitudineEvento() {
		return latitudineEvento;
	}
	/**
	 * @param latitudineEvento the latitudineEvento to set
	 */
	public void setLatitudineEvento(double latitudineEvento) {
		this.latitudineEvento = latitudineEvento;
	}
	
	/**
	 * @return the longitudineEvento
	 */
	@DynamoDBAttribute(attributeName="longitudineEvento")
	public double getLongitudineEvento() {
		return longitudineEvento;
	}
	/**
	 * @param longitudineEvento the longitudineEvento to set
	 */
	public void setLongitudineEvento(double longitudineEvento) {
		this.longitudineEvento = longitudineEvento;
	}
	
	/**
	 * @return the indirizzoEvento
	 */
	@DynamoDBAttribute(attributeName="indirizzoEvento")
	public String getIndirizzoEvento() {
		return indirizzoEvento;
	}
	/**
	 * @param indirizzoEvento the indirizzoEvento to set
	 */
	public void setIndirizzoEvento(String indirizzoEvento) {
		this.indirizzoEvento = indirizzoEvento;
	}
	
	/**
	 * @return the telefonoEvento
	 */
	@DynamoDBAttribute(attributeName="telefonoEvento")
	public String getTelefonoEvento() {
		return telefonoEvento;
	}
	/**
	 * @param telefonoEvento the telefonoEvento to set
	 */
	public void setTelefonoEvento(String telefonoEvento) {
		this.telefonoEvento = telefonoEvento;
	}
	/**
	 * @return the emailEvento
	 */
	@DynamoDBAttribute(attributeName="emailEvento")
	public String getEmailEvento() {
		return emailEvento;
	}
	/**
	 * @param emailEvento the emailEvento to set
	 */
	public void setEmailEvento(String emailEvento) {
		this.emailEvento = emailEvento;
	}
	/**
	 * @return the badgeEvento
	 */
	@DynamoDBIgnore
	public Badge getBadgeEvento() {
		return badgeEvento;
	}
	/**
	 * @param badgeEvento the badgeEvento to set
	 */
	public void setBadgeEvento(Badge badgeEvento) {
		this.badgeEvento = badgeEvento;
	}
	
	/**
	 * @return the numeroMaxPartecipantiEvento
	 */
	@DynamoDBAttribute(attributeName="numMaxPartecipantiEvento")
	public int getNumMaxPartecipantiEvento() {
		return numMaxPartecipantiEvento;
	}
	/**
	 * @param numeroMaxPartecipantiEvento the numeroMaxPartecipantiEvento to set
	 */
	public void setNumMaxPartecipantiEvento(int numeroMaxPartecipantiEvento) {
		this.numMaxPartecipantiEvento = numeroMaxPartecipantiEvento;
	}
	
	/**
	 * @return the numeroPostiDisponibiliEvento
	 */
	@DynamoDBAttribute(attributeName="numPostiDisponibiliEvento")
	public int getNumPostiDisponibiliEvento() {
		return numPostiDisponibiliEvento;
	}
	/**
	 * @param numeroPostiDisponibiliEvento the numeroPostiDisponibiliEvento to set
	 */
	public void setNumPostiDisponibiliEvento(int numeroPostiDisponibiliEvento) {
		this.numPostiDisponibiliEvento = numeroPostiDisponibiliEvento;
	}
	
	/**
	 * @return the iscrittiEvento
	 */
	@DynamoDBIgnore
	public List<Utente> getIscrittiEvento() {
		return iscrittiEvento;
	}
	/**
	 * @param iscrittiEvento the iscrittiEvento to set
	 */
	public void setIscrittiEvento(List<Utente> iscrittiEvento) {
		this.iscrittiEvento = iscrittiEvento;
	}
	
	/**
	 * @return the aziendaEvento
	 */
	@DynamoDBIgnore
	public Azienda getAziendaOspitanteEvento() {
		return aziendaOspitanteEvento;
	}
	/**
	 * @param aziendaEvento the aziendaEvento to set
	 */
	public void setAziendaOspitanteEvento(Azienda aziendaOspitanteEvento) {
		this.aziendaOspitanteEvento = aziendaOspitanteEvento;
	}
	
	/**
	 * @return the aziendaEvento
	 */
	@DynamoDBIgnore
	public Azienda getAziendaFornitriceEvento() {
		return aziendaFornitriceEvento;
	}
	/**
	 * @param aziendaEvento the aziendaEvento to set
	 */
	public void setAziendaFornitriceEvento(Azienda aziendaFornitriceEvento) {
		this.aziendaFornitriceEvento = aziendaFornitriceEvento;
	}
	
	/**
	 * @return the viniEvento
	 */
	@DynamoDBIgnore
	public List<Vino> getViniEvento() {
		return viniEvento;
	}
	/**
	 * @param viniEvento the viniEvento to set
	 */
	public void setViniEvento(List<Vino> viniEvento) {
		this.viniEvento = viniEvento;
	}
	
	/**
	 * @return the dataEventoStringa
	 */
	@DynamoDBAttribute(attributeName="dataEventoStringa")
	public String getDataEventoStringa() {
		return dataEventoStringa;
	}
	/**
	 * @param dataEventoStringa the dataEventoStringa to set
	 */
	public void setDataEventoStringa(String dataEventoStringa) {
		this.dataEventoStringa = dataEventoStringa;
	}
	
	/**
	 * @return the provinciaEvento
	 */
	@DynamoDBIgnore
	public Provincia getProvinciaEvento() {
		return provinciaEvento;
	}
	/**
	 * @param provinciaEvento the provinciaEvento to set
	 */
	public void setProvinciaEvento(Provincia provinciaEvento) {
		this.provinciaEvento = provinciaEvento;
	}
	
	/**
	 * @return the aziendaOspitanteEventoInt
	 */
	@DynamoDBAttribute(attributeName="aziendaOspitanteEvento")
	public AziendaEvento getAziendaOspitanteEventoInt() { return aziendaOspitanteEventoInt; }
	public void setAziendaOspitanteEventoInt(AziendaEvento aziendaOspitanteEventoInt) { this.aziendaOspitanteEventoInt = aziendaOspitanteEventoInt; }
	
	/**
	 * @return the aziendaFornitriceEventoInt
	 */
	@DynamoDBAttribute(attributeName="aziendaFornitriceEvento")
	public AziendaEvento getAziendaFornitriceEventoInt() { return aziendaFornitriceEventoInt; }
	public void setAziendaFornitriceEventoInt(AziendaEvento aziendaFornitriceEventoInt) { this.aziendaFornitriceEventoInt = aziendaFornitriceEventoInt; }
	
	
	/**
	 * @return the badgeEventoInt
	 */
	@DynamoDBAttribute(attributeName="badgeEvento")
	public BadgeEvento getBadgeEventoInt() { return badgeEventoInt; }
	public void setBadgeEventoInt(BadgeEvento badgeEventoInt) { this.badgeEventoInt = badgeEventoInt; }
	
	/**
	 * @return the provinciaEventoInt
	 */
	@DynamoDBAttribute(attributeName="provinciaEvento")
	public ProvinciaEvento getProvinciaEventoInt() { return provinciaEventoInt; }
	public void setProvinciaEventoInt(ProvinciaEvento provinciaEventoInt) { this.provinciaEventoInt = provinciaEventoInt; }
	
	/**
	 * @return the iscrittiEventoInt
	 */
	@DynamoDBAttribute(attributeName="iscrittiEvento")
	public List<UtenteEvento> getIscrittiEventoInt() {
		return iscrittiEventoInt;
	}
	/**
	 * @param iscrittiEventoInt the iscrittiEventoInt to set
	 */
	public void setIscrittiEventoInt(List<UtenteEvento> iscrittiEventoInt) {
		this.iscrittiEventoInt = iscrittiEventoInt;
	}
	
	/**
	 * @return the viniEventoInt
	 */
	@DynamoDBAttribute(attributeName="viniEvento")
	public List<VinoEvento> getViniEventoInt() {
		return viniEventoInt;
	}
	/**
	 * @param viniEventoInt the viniEventoInt to set
	 */
	public void setViniEventoInt(List<VinoEvento> viniEventoInt) {
		this.viniEventoInt = viniEventoInt;
	}
	
	@DynamoDBDocument
	public static class AziendaEvento{
		private long idAzienda;

		/**
		 * @return the idAzienda
		 */
		@DynamoDBAttribute(attributeName="idAzienda")
		public long getIdAzienda() { return idAzienda; }
		public void setIdAzienda(long idAzienda) { this.idAzienda = idAzienda; }
	}
	
	@DynamoDBDocument
	public static class UtenteEvento{
		private long idUtente;

		/**
		 * @return the idUtente
		 */
		@DynamoDBAttribute(attributeName="idUtente")
		public long getIdUtente() {
			return idUtente;
		}
		/**
		 * @param idUtente the idUtente to set
		 */
		public void setIdUtente(long idUtente) {
			this.idUtente = idUtente;
		}
	}
	
	@DynamoDBDocument
	public static class VinoEvento{
		
		private long idVino;
		private String nomeVino;
		private String nomeAziendaVino;
		private long idAziendaVino;
		private int annoVino;
		
		/**
		 * @return the idVino
		 */
		@DynamoDBAttribute(attributeName="idVino")
		public long getIdVino() {
			return idVino;
		}
		/**
		 * @param idVino the idVino to set
		 */
		public void setIdVino(long idVino) {
			this.idVino = idVino;
		}
		/**
		 * @return the nomeVino
		 */
		@DynamoDBAttribute(attributeName="nomeVino")
		public String getNomeVino() {
			return nomeVino;
		}
		/**
		 * @param nomeVino the nomeVino to set
		 */
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
		/**
		 * @return the nomeAziendaVino
		 */
		@DynamoDBAttribute(attributeName="nomeAziendaVino")
		public String getNomeAziendaVino() {
			return nomeAziendaVino;
		}
		/**
		 * @param nomeAziendaVino the nomeAziendaVino to set
		 */
		public void setNomeAziendaVino(String nomeAziendaVino) {
			this.nomeAziendaVino = nomeAziendaVino;
		}
		/**
		 * @return the idAziendaVino
		 */
		@DynamoDBAttribute(attributeName="idAziendaVino")
		public long getIdAziendaVino() {
			return idAziendaVino;
		}
		/**
		 * @param idAziendaVino the idAziendaVino to set
		 */
		public void setIdAziendaVino(long idAziendaVino) {
			this.idAziendaVino = idAziendaVino;
		}
	}
	
	@DynamoDBDocument
	public static class ProvinciaEvento{
		
		private long idProvincia;
		private String nomeProvincia;
		private String siglaProvincia;

		/**
		 * @return the idProvincia
		 */
		@DynamoDBAttribute(attributeName="idProvincia")
		public long getIdProvincia() {
			return idProvincia;
		}
		/**
		 * @param idProvincia the idProvincia to set
		 */
		public void setIdProvincia(long idProvincia) {
			this.idProvincia = idProvincia;
		}
		/**
		 * @return the nomeProvincia
		 */
		@DynamoDBAttribute(attributeName="nomeProvincia")
		public String getNomeProvincia() {
			return nomeProvincia;
		}
		/**
		 * @param nomeProvincia the nomeProvincia to set
		 */
		public void setNomeProvincia(String nomeProvincia) {
			this.nomeProvincia = nomeProvincia;
		}
		/**
		 * @return the siglaProvincia
		 */
		@DynamoDBAttribute(attributeName="siglaProvincia")
		public String getSiglaProvincia() {
			return siglaProvincia;
		}
		/**
		 * @param siglaProvincia the siglaProvincia to set
		 */
		public void setSiglaProvincia(String siglaProvincia) {
			this.siglaProvincia = siglaProvincia;
		}
	}
	
	@DynamoDBDocument
	public static class BadgeEvento{
		private long idBadge;

		/**
		 * @return the idBadge
		 */
		@DynamoDBAttribute(attributeName="idBadge")
		public long getIdBadge() {
			return idBadge;
		}
		/**
		 * @param idBadge the idBadge to set
		 */
		public void setIdBadge(long idBadge) {
			this.idBadge = idBadge;
		}
	}

	
}
