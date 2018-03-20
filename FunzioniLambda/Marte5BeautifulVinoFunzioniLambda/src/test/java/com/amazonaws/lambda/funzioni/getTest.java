package com.amazonaws.lambda.funzioni;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.lambda.funzioni.common.BeautifulVinoGet;
import com.amazonaws.services.lambda.runtime.Context;
import com.marte5.modello.richieste.get.RichiestaGetGenerica;
import com.marte5.modello.risposte.Risposta;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class getTest {

    private static RichiestaGetGenerica input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        input = new RichiestaGetGenerica();
//        input.setFunctionName("getViniEventoGen");
//        input.setIdEvento(1513789129406L);
//        input.setDataEvento(1513724400000L);
        
//        input.setFunctionName("getUtenteGen");
//        input.setIdUtente("eu-central-1:2b62862a-01d4-4a20-8651-ca8ab601972e");
        
        /*	"functionName":"getViniEventoGen",
	"idEvento":"1513789129406",
	"dataEvento": 1513724400000*/
        
//        input.setFunctionName("getEventoGen");
//        input.setIdEvento("1513789129406");
//        input.setDataEvento(1513724400000L);
//        input.setIdUtente("eu-central-1:2b62862a-01d4-4a20-8651-ca8ab601972e");
        
        input.setFunctionName("getVinoGen");
        input.setIdVino("1513357582823");
        input.setIdUtente("eu-central-1:2b62862a-01d4-4a20-8651-ca8ab601972e");
        
        //getUtenteGen
//        input.setFunctionName("getUtenteGen");
//        input.setIdUtente("eu-central-1:2b62862a-01d4-4a20-8651-ca8ab601972e");
        
        //input.setIdAzienda(1513241364518L);
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testgetEventi() {
        BeautifulVinoGet handler = new BeautifulVinoGet();
        Context ctx = createContext();

        Risposta output = handler.handleRequest(input, ctx);

        // TODO: validate output here if needed.
        Assert.assertEquals(100, output.getEsito().getCodice());
    }
}