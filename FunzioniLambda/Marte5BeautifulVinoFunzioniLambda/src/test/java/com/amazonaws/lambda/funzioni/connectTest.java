package com.amazonaws.lambda.funzioni;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.lambda.funzioni.common.BeautifulVinoConnect;
import com.amazonaws.services.lambda.runtime.Context;
import com.marte5.modello.richieste.connect.RichiestaConnectGenerica;
import com.marte5.modello.risposte.connect.RispostaConnectGenerica;
import com.marte5.modello2.Utente;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class connectTest {

    private static RichiestaConnectGenerica input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        input = new RichiestaConnectGenerica();
        
//        input.setIdEvento(1511197222754L);
//        input.setIdUtente(1511887612956L);
//        input.setStatoEvento("D");
//        input.setFunctionName("connectBadgeAUtenteGen");
//        input.setIdUtente("b6118563-1486-4448-8994-c121b60534ea");
        
        input.setFunctionName("connectUtentiAUtenteGen");
        input.setIdUtente("1521197385816");
        List<Utente> utenti = new ArrayList<>();
        Utente u =new Utente();
        u.setIdUtente("1522320091366");
        utenti.add(u);
        input.setUtenti(utenti);
        input.setStatoVariazione("A");
        
        
        /*"functionName":"connectViniAUtenteGen",
	"idVino":"1513240022473",
	"idUtente":"eu-central-1:2b62862a-01d4-4a20-8651-ca8ab601972e",
	"statoEvento":"D"*/
        
//        List<Badge> badges = new ArrayList<>();
//        
////        Badge badge = new Badge();
////        badge.setIdBadge("1513700266196");
////        badges.add(badge);
//        
//        Badge badge2 = new Badge();
//        badge2.setIdBadge("1513700051679");
//        badges.add(badge2);
//        
        
//        input.setBadges(badges);
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testdeleteEvento() {
        BeautifulVinoConnect handler = new BeautifulVinoConnect();
        Context ctx = createContext();

        RispostaConnectGenerica output = handler.handleRequest(input, ctx);

        // TODO: validate output here if needed.
        Assert.assertEquals("Hello from Lambda!", output);
    }
}
