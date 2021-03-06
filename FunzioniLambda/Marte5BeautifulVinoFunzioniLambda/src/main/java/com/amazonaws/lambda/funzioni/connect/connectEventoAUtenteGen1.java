package com.amazonaws.lambda.funzioni.connect;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.funzioni.common.BeautifulVinoAcquista;
import com.amazonaws.lambda.funzioni.utils.EsitoHelper;
import com.amazonaws.lambda.funzioni.utils.FunzioniUtils;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.xspec.AddAction;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.modello.Esito;
import com.marte5.modello.richieste.acquista.RichiestaAcquistaGenerica;
import com.marte5.modello.richieste.connect.RichiestaConnectGenerica;
import com.marte5.modello.risposte.Risposta;
import com.marte5.modello.risposte.connect.RispostaConnectGenerica;
import com.marte5.modello2.Evento;
import com.marte5.modello2.Utente;
import com.marte5.modello2.Utente.EventoUtente;
import com.marte5.modello2.Evento.UtenteEvento;

public class connectEventoAUtenteGen1 implements RequestHandler<RichiestaConnectGenerica, RispostaConnectGenerica>  {

	@Override
	public RispostaConnectGenerica handleRequest(RichiestaConnectGenerica input, Context context) {
		RispostaConnectGenerica risposta = new RispostaConnectGenerica();
		Utente utente = null;
		Evento evento = null;
		Esito esito = FunzioniUtils.getEsitoPositivo();
		
		String idUtente = input.getIdUtente();
		String idEvento = input.getIdEvento();
		long dataEvento = input.getDataEvento();
		long dataPrenotazioneEvento = input.getDataPrenotazioneEvento();
		int pRicevuto = input.getStatoPreferitoEvento();
		int aRicevuto = input.getStatoAcquistatoEvento();
		int numeroP = input.getNumeroPartecipanti();
		int pAttuale = 0;
		int aAttuale = 0;
		
		//mi collego al database
		AmazonDynamoDB client = null;
		try {
			client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1).build();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " connectEventoAUtente ");
			esito.setTrace(e1.getMessage());
		}
		if(client != null) {
			//controllo la correttezza dell'input
			if(idEvento == null || idEvento.equals("")) {
				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
		        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " idEvento nullo, non posso procedere");
		        risposta.setEsito(esito);
		        return risposta;
			}
			if(idUtente == null || idUtente.equals("")) {
				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
		        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " idUtente nullo, non posso procedere");
		        risposta.setEsito(esito);
		        return risposta;
			}
			if(pRicevuto != 0 && pRicevuto !=1) {
				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
		        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + "variabile preferito non settata");
		        risposta.setEsito(esito);
		        return risposta;
			}
			if(aRicevuto != 0 && aRicevuto !=1) {
				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
		        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + "variabile preferito non settata");
		        risposta.setEsito(esito);
		        return risposta;
			}
			//carico l'evento
			DynamoDBMapper mapper = new DynamoDBMapper(client);
			evento = mapper.load(Evento.class, idEvento, dataEvento);
			if(evento == null) {
				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
		        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " evento non trovato sul DB, non posso procedere");
		        risposta.setEsito(esito);
		        return risposta;
			}
			//carico l'utente
			utente = mapper.load(Utente.class, idUtente);
			if(utente == null) {
				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
		        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " utente non trovato sul DB, non posso procedere");
		        risposta.setEsito(esito);
		        return risposta;
			}
			//controllo lo stato attuale della relazione aggiornando pAttuale e aAttuale
			List<EventoUtente> leu = utente.getPreferitiEventiUtenteInt();
			if (leu != null) {
				for (EventoUtente eu : leu) {
					if (eu.getIdEvento().equals(idEvento)) {
						pAttuale = 1;
					}
				}
			}
			leu = utente.getAcquistatiEventiUtenteInt();
			if (leu != null) {
				for (EventoUtente eu: leu) {
					if (eu.getIdEvento().equals(idEvento)) {
						aAttuale = 1;
					}
				}
			}
			//vari casi di stato attuale 
			risposta.setEsito(esito);
			if (pAttuale == 0 && aAttuale == 0) {
				if (pRicevuto == 0 && aRicevuto == 0) {
					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + "00 00");
			        risposta.setEsito(esito);
			        return risposta;
				}else if (pRicevuto == 0 && aRicevuto == 1) {
					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + "00 01");
			        risposta.setEsito(esito);
			        return risposta;
				}else if (pRicevuto == 1 && aRicevuto == 0) {
					utente = aggiungiAllaListaPreferiti(utente, evento);
					evento = addUtentePreferito(idEvento, dataEvento, idUtente, evento);
				}else if (pRicevuto == 1 && aRicevuto == 1) {
					utente = aggiungiAllaListaPreferiti(utente, evento);
					utente = aggiungiAllaListaAcquistati(utente, evento, numeroP);
					evento = addUtenteIscritto(idEvento, dataPrenotazioneEvento, idUtente, evento, numeroP, evento.isEventoRicorrente());
					evento = addUtentePreferito(idEvento, dataEvento, idUtente, evento);
					sendMail(utente, evento, idEvento, evento.getTitoloEvento(), numeroP,evento.getAcquistabileEvento(), context);
				}
			}else if (pAttuale == 1 && aAttuale == 0) {
				if (pRicevuto == 0 && aRicevuto == 0) {
					utente = rimuoviDallaListaPreferiti(utente, evento);
					evento = removeUtentePreferito(idEvento, dataEvento, idUtente, evento);
				}else if (pRicevuto == 0 && aRicevuto == 1) {
					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + "10 01");
			        risposta.setEsito(esito);
			        return risposta;
				}else if (pRicevuto == 1 && aRicevuto == 0) {
					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + "10 10");
			        risposta.setEsito(esito);
			        return risposta;
				}else if (pRicevuto == 1 && aRicevuto == 1) {
					evento = addUtenteIscritto(idEvento, dataPrenotazioneEvento, idUtente, evento, numeroP, evento.isEventoRicorrente());
					utente = aggiungiAllaListaAcquistati(utente, evento, numeroP);
					sendMail(utente, evento, idEvento, evento.getTitoloEvento(), numeroP, evento.getAcquistabileEvento(), context);
				}
			}else if (pAttuale == 1 && aAttuale == 1) {
				if (pRicevuto == 0 && aRicevuto == 0) {
					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + "11 00");
			        risposta.setEsito(esito);
			        return risposta;
				}else if (pRicevuto == 0 && aRicevuto == 1) {
					utente = rimuoviDallaListaPreferiti(utente, evento);
					evento = removeUtentePreferito(idEvento, dataEvento, idUtente, evento);
				}else if (pRicevuto == 1 && aRicevuto == 0) {
					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + "11 10");
			        risposta.setEsito(esito);
			        return risposta;
				}else if (pRicevuto == 1 && aRicevuto == 1) {
					// qui è già stato acquistato ed era già preferito, devo aggiungere partecipanti
					evento = addUtenteIscritto(idEvento, dataPrenotazioneEvento, idUtente, evento, numeroP, evento.isEventoRicorrente());
					sendMail(utente, evento, idEvento, evento.getTitoloEvento(), numeroP,evento.getAcquistabileEvento(), context);
					risposta.setEsito(esito);			       
				}
			}else if (pAttuale == 0 && aAttuale == 1) {
				if (pRicevuto == 0 && aRicevuto == 0) {
					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + "01 00");
			        risposta.setEsito(esito);
			        return risposta;
				}else if (pRicevuto == 0 && aRicevuto == 1) {
					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + "01 01");
			        risposta.setEsito(esito);
			        return risposta;
				}else if (pRicevuto == 1 && aRicevuto == 0) {
					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			        esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + "01 10");
			        risposta.setEsito(esito);
			        return risposta;
				}else if (pRicevuto == 1 && aRicevuto == 1) {
					utente = aggiungiAllaListaPreferiti(utente, evento);
					evento = addUtentePreferito(idEvento, dataEvento, idUtente, evento);
				}
			}
			mapper.save(utente);
			mapper.save(evento);
		}	
		risposta.setEsito(esito);
		return risposta;
	}
	
	//aggiungo utente dall'evento se è già iscritto aggiungo posti
    private Evento addUtenteIscritto(String idEvento, long dataEvento, String idUtente, Evento evento, int numeroP, boolean ricorrente) {
    	UtenteEvento ue = new UtenteEvento();
		if(evento != null) {
			List<UtenteEvento> utentiIscritti = evento.getIscrittiEventoInt();
			if(utentiIscritti == null) {
				utentiIscritti = new ArrayList<UtenteEvento>();
			}
			boolean presente = false;
			for (UtenteEvento utenteEvento : utentiIscritti) {
			if(utenteEvento.getIdUtente().equals(idUtente)) {
				presente = true;
				ue = utenteEvento;
				}
			}		
			if(!presente) {
				ue.setIdUtente(idUtente);
				ue.setPostiAcquistati(numeroP);
				ue.setDataEvento(dataEvento);
				utentiIscritti.add(ue);
			}else {
				ue.setPostiAcquistati(ue.getPostiAcquistati() + numeroP);
			}
			evento.setIscrittiEventoInt(utentiIscritti);
			if(!ricorrente) {
				evento.setNumPostiDisponibiliEvento(evento.getNumPostiDisponibiliEvento() - numeroP);
			}
		}
		return evento;
    }
    
//    //rimuovo utente dall'evento
//    private void deleteUtenteIscritto (Evento evento,String idUtente, DynamoDBMapper mapper) {
//    	UtenteEvento ue = new UtenteEvento();
//		if(evento != null) {
//			List<UtenteEvento> utentiIscritti = evento.getIscrittiEventoInt();
//			if(utentiIscritti == null) {
//				utentiIscritti = new ArrayList<UtenteEvento>();
//			}
//			boolean presente = false;
//			for (UtenteEvento utenteEvento : utentiIscritti) {
//				if(utenteEvento.getIdUtente().equals(idUtente)) {
//					presente = true;
//					ue = utenteEvento;
//					}
//			}
//			if (presente) {
//				utentiIscritti.remove(ue);
//			}
//			mapper.save(evento);
//	    }
//		return;
//    }
    
  //aggiungo utente alla lista dei preferiti dell'evento
    private Evento addUtentePreferito(String idEvento, long dataEvento, String idUtente,Evento evento) {
    	UtenteEvento ue = new UtenteEvento();
		if(evento != null) {
			List<UtenteEvento> utentiPreferiti = evento.getPreferitiEventoInt();
			if(utentiPreferiti == null) {
				utentiPreferiti = new ArrayList<UtenteEvento>();
			}
			boolean presente = false;
			for (UtenteEvento utenteEvento : utentiPreferiti) {
				if(utenteEvento.getIdUtente().equals(idUtente)) {
					presente = true;
					ue = utenteEvento;
				}
		}		
		if(!presente) {
			ue.setIdUtente(idUtente);
			utentiPreferiti.add(ue);
		}
		evento.setPreferitiEventoInt(utentiPreferiti);
		}
		return evento;
    }
    
    //rimuovo l'utente dalla lista dei preferiti dell'evento
    private Evento removeUtentePreferito(String idEvento, long dataEvento, String idUtente,Evento evento) {
    	UtenteEvento ue = new UtenteEvento();
		if(evento != null) {
			List<UtenteEvento> utentiPreferiti = evento.getPreferitiEventoInt();
			if(utentiPreferiti == null) {
				utentiPreferiti = new ArrayList<UtenteEvento>();
			}
			boolean presente = false;
			for (UtenteEvento utenteEvento : utentiPreferiti) {
				if(utenteEvento.getIdUtente().equals(idUtente)) {
					presente = true;
					ue = utenteEvento;
				}
			}		
			if(presente) {
				utentiPreferiti.remove(ue);
			}
			evento.setPreferitiEventoInt(utentiPreferiti);
		}
		return evento;
    }
    
    //aggiungo l'utente alla lista dei preferiti
    private Utente aggiungiAllaListaPreferiti(Utente utente, Evento evento) {
    	List<EventoUtente> leu = utente.getPreferitiEventiUtenteInt();
    	if (leu == null) {
    		leu = new ArrayList<>();
    	}
    	EventoUtente eu = new EventoUtente();
    	eu.setDataEvento(evento.getDataEvento());
    	eu.setIdEvento(evento.getIdEvento());
    	leu.add(eu);
    	utente.setPreferitiEventiUtenteInt(leu);
    	return utente;
    }
    //aggiungo l'evento alla lista degli acquistati
    private Utente aggiungiAllaListaAcquistati(Utente utente, Evento evento, int numeroPartecipanti) {
    	
    	EventoUtente eu = new EventoUtente();
    	
    	// controllo se tra gli eventi acquistati dall'utente c'è già questo evento. Se c'è aumento solo il numero dei posti acquistati.
    	List<EventoUtente> eventiAcquistati = utente.getAcquistatiEventiUtenteInt();
		if(eventiAcquistati == null) {
			eventiAcquistati = new ArrayList<EventoUtente>();
		}
		boolean presente = false;
		for (EventoUtente eventoUtente : eventiAcquistati) {
			if(eventoUtente.getIdEvento().equals(evento.getIdEvento())) {
				presente = true;
				eu = eventoUtente;
			}
		}		
		if(!presente) {
			eu.setIdEvento(evento.getIdEvento());
			eu.setDataEvento(evento.getDataEvento());
			eu.setNumeroPartecipanti(numeroPartecipanti);
			
			eventiAcquistati.add(eu);
		}else {
			eu.setNumeroPartecipanti(eu.getNumeroPartecipanti() + numeroPartecipanti);
		}
    	
    	utente.setAcquistatiEventiUtenteInt(eventiAcquistati);
    	return utente;
    }
    //rimuovo l'evento dalla lista dei preferiti
    private Utente rimuoviDallaListaPreferiti(Utente utente, Evento evento) {
    	List<EventoUtente> leu = utente.getPreferitiEventiUtenteInt();
    	if (leu != null) {
	    	EventoUtente eur = null;
	    	for (EventoUtente eu : leu) {
	    		if (eu.getIdEvento().equals(evento.getIdEvento())) {
	    			eur = eu;
	    		}
	    	}
	    	if (eur != null) {
	    		leu.remove(eur);
	    	}
	    	utente.setPreferitiEventiUtenteInt(leu);
    	}
    	return utente;
    }
    
    private Esito sendMail(Utente utente, Evento evento, String idE, String nomeE, int num,int ac, Context context) {
    	RichiestaAcquistaGenerica r = new RichiestaAcquistaGenerica();
		BeautifulVinoAcquista c = new BeautifulVinoAcquista();
		r.setUtente(utente);
		r.setIdEvento(idE);
		r.setEvento(evento);
		r.setNomeEvento(nomeE);
		r.setNumeroPartecipanti(num);
		r.setAcquista(ac);
		Risposta out = c.handleRequest(r, context);
		return out.getEsito();
    }
}
