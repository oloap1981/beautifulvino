package com.amazonaws.lambda.funzioni.put.backup;

import com.amazonaws.lambda.funzioni.utils.EsitoHelper;
import com.amazonaws.lambda.funzioni.utils.FunzioniUtils;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.transactions.Transaction;
import com.amazonaws.services.dynamodbv2.transactions.TransactionManager;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.modello.Azienda;
import com.marte5.modello.Esito;
import com.marte5.modello.Evento;
import com.marte5.modello.Evento.AziendaEvento;
import com.marte5.modello.Evento.ProvinciaEvento;
import com.marte5.modello.Provincia;
import com.marte5.modello.richieste.put.RichiestaPutEvento;
import com.marte5.modello.risposte.put.RispostaPutEvento;

public class putEvento implements RequestHandler<RichiestaPutEvento, RispostaPutEvento> {
	
    @Override
    public RispostaPutEvento handleRequest(RichiestaPutEvento input, Context context) {
        context.getLogger().log("Input: " + input);
        RispostaPutEvento risposta = new RispostaPutEvento();
        
        long idEventoRisposta = 0;
        Esito esito = FunzioniUtils.getEsitoPositivo(); //inizializzo l'esito a POSITIVO. In caso di problemi sovrascrivo
        
        AmazonDynamoDB client = null;
		try {
			client = AmazonDynamoDBClientBuilder.standard().build();
		} catch (Exception e1) {
			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_SALVATAGGIO);
			esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_PROCEDURA_LAMBDA + " putEvento ");
			esito.setTrace(e1.getMessage());
			risposta.setEsito(esito);
			return risposta;
		}
		if(client != null) {
			
			try {
				TransactionManager.verifyOrCreateTransactionTable(client, "BV_Transactions", 10L, 10L, 10L * 60L);
				TransactionManager.verifyOrCreateTransactionImagesTable(client, "BV_TransactionImages", 10L, 10L, 10L * 60L);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_SALVATAGGIO);
				esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_PROCEDURA_LAMBDA + " Problemi con la gestione della transazione ");
				esito.setTrace(e1.getMessage());
				risposta.setEsito(esito);
				return risposta;
			}
			TransactionManager txManager = new TransactionManager (client, "BV_Transactions","BV_TransactionImages");
			// Create a new transaction from the transaction manager
			Transaction transaction = txManager.newTransaction();

	        Evento evento = input.getEvento();
	        if(evento == null) {
	        		esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_SALVATAGGIO);
				esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_PROCEDURA_LAMBDA + " Evento NULL");
				esito.setTrace(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_PROCEDURA_LAMBDA + " Evento NULL");
				risposta.setEsito(esito);
				transaction.rollback();
				return risposta;
	        } else {
	        	
	        		long idEvento = evento.getIdEvento();
		        	if(idEvento == 0) {
	        			//insert
		        		idEvento = FunzioniUtils.getEntitaId();
		        } 
		        	idEventoRisposta = idEvento;
		        	evento.setIdEvento(idEvento);
		        
	        		//gestione provincia
	        		ProvinciaEvento provincia = evento.getProvinciaEventoInt();
	        		if(provincia != null) {
	        			Provincia prov = new Provincia();
	        			
	        			prov.setIdProvincia(provincia.getIdProvincia());
	        			prov.setNomeProvincia(provincia.getNomeProvincia());
	        			prov.setSiglaProvincia(provincia.getSiglaProvincia());
	        			long idProvincia = FunzioniUtils.aggiungiProvincia(prov, transaction);
	        			prov.setIdProvincia(idProvincia);
	        			
	        			provincia.setIdProvincia(idProvincia);
	        			
	        		}
	        		evento.setProvinciaEventoInt(provincia);
	        		
	        		//gestione aziende
	        		//OSPITANTE
	        		Azienda toLoadOspitante = new Azienda();
	        		toLoadOspitante.setIdAzienda(evento.getAziendaOspitanteEvento().getIdAzienda());
	        		Azienda aziendaOspitante = transaction.load(toLoadOspitante);
	        		if(aziendaOspitante == null) {
	        			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_SALVATAGGIO);
	    				esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_PROCEDURA_LAMBDA + " L'azienda il cui Id è associato al vino inviato non esiste");
	    				esito.setTrace(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_PROCEDURA_LAMBDA + " L'azienda il cui Id è associato al vino inviato non esiste");
	    				risposta.setEsito(esito);
	    				transaction.rollback();
	    				return risposta;
	        		}
	        		if(evento.getAziendaOspitanteEventoInt() == null){
		        		AziendaEvento aziendaVinoOspitante = new AziendaEvento();
		        		aziendaVinoOspitante.setIdAzienda(aziendaOspitante.getIdAzienda());
		        		evento.setAziendaOspitanteEventoInt(aziendaVinoOspitante);
	        		}
	        		
	        		//FORNITRICE
	        		Azienda toLoadFornitrice = new Azienda();
	        		toLoadFornitrice.setIdAzienda(evento.getAziendaFornitriceEvento().getIdAzienda());
	        		Azienda aziendaFornitrice = transaction.load(toLoadFornitrice);
	        		//Azienda azienda = mapper.load(Azienda.class, vino.getAziendaVino().getIdAzienda());
	        		if(aziendaFornitrice == null) {
	        			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_SALVATAGGIO);
	    				esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_PROCEDURA_LAMBDA + " L'azienda il cui Id è associato al vino inviato non esiste");
	    				esito.setTrace(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_PROCEDURA_LAMBDA + " L'azienda il cui Id è associato al vino inviato non esiste");
	    				risposta.setEsito(esito);
	    				transaction.rollback();
	    				return risposta;
	        		}
	        		if(evento.getAziendaFornitriceEventoInt() == null){
		        		AziendaEvento aziendaVinoFornitrice = new AziendaEvento();
		        		aziendaVinoFornitrice.setIdAzienda(aziendaFornitrice.getIdAzienda());
		        		evento.setAziendaFornitriceEventoInt(aziendaVinoFornitrice);
	        		}
	        		
		        try {
		        		transaction.save(evento);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_SALVATAGGIO);
					esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_SALVATAGGIO + "Evento " + input.getEvento().getIdEvento());
					esito.setTrace(e.getMessage());
					risposta.setEsito(esito);
					transaction.rollback();
					return risposta;
				}
	        }
	        
	        transaction.commit();
		}	
        risposta.setEsito(esito);
        risposta.setIdEvento(idEventoRisposta);
        return risposta;
    }
}
