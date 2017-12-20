package com.amazonaws.lambda.funzioni.get;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.funzioni.utils.EsitoHelper;
import com.amazonaws.lambda.funzioni.utils.FunzioniUtils;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.modello.Esito;
import com.marte5.modello.Provincia;
import com.marte5.modello.richieste.Richiesta;
import com.marte5.modello.richieste.get.RichiestaGetGenerica;
import com.marte5.modello.richieste.get.RichiestaGetProvince;
import com.marte5.modello.risposte.Risposta;
import com.marte5.modello.risposte.get.RispostaGetGenerica;
import com.marte5.modello.risposte.get.RispostaGetProvince;

public class getProvinceGen implements RequestHandler<RichiestaGetGenerica, RispostaGetGenerica> {

    @Override
    public RispostaGetGenerica handleRequest(RichiestaGetGenerica input, Context context) {
        context.getLogger().log("Input: " + input);
        RispostaGetGenerica risposta = getRisposta(input);
        return risposta;
    }
    
    private RispostaGetGenerica getRisposta(RichiestaGetGenerica input) {
    	RispostaGetGenerica risposta = new RispostaGetGenerica();
        
        Esito esito = FunzioniUtils.getEsitoPositivo();
        List<Provincia> provinceTotali = new ArrayList<>();
        
        //inizializzo con valore ALL
        Provincia all = new Provincia();
        all.setIdProvincia(0);
        all.setNomeProvincia("TUTTE");
        all.setSiglaProvincia("00");
        provinceTotali.add(all);
       
        
        AmazonDynamoDB client = null;
		try {
			client = AmazonDynamoDBClientBuilder.standard().build();
		} catch (Exception e1) {
			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " getProvince ");
			esito.setTrace(e1.getMessage());
			risposta.setEsito(esito);
			return risposta;
		}
		if(client != null) {
			DynamoDBMapper mapper = new DynamoDBMapper(client);
			DynamoDBScanExpression expr = new DynamoDBScanExpression();
			List<Provincia> province;
			try {
				province = mapper.scan(Provincia.class, expr);
			} catch (Exception e) {
				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
				esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " getProvince ");
				esito.setTrace(e.getMessage());
				risposta.setEsito(esito);
				return risposta;
			}
			provinceTotali.addAll(province);
			risposta.setProvince(provinceTotali);
		}	
        
        risposta.setEsito(esito);
        return risposta;
    }
}
