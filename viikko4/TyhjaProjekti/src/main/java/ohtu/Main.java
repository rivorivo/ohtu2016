package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "014029624";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2016.herokuapp.com/students/"+studentNr+"/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream =  method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        System.out.println("Oliot:");
        int teht=0;
        int tunnit=0;
        for (Submission subi : subs) {
            
            System.out.println("opiskelijanumero: "+subi.getStudent_number());
            System.out.println("viikko "+subi.getWeek()+": tehtyjä tehtäviä yhteensä: "+subi.getTehdytTehtMaara()+", aikaa kului "+subi.getHours()+" tuntia, tehdyt tehtävät:"+subi.getTehdytTeht());
            System.out.println("");   
            teht+=subi.getTehdytTehtMaara();
            tunnit+=Integer.parseInt(subi.getHours());
        }
        System.out.println("yhteensä: "+teht+" tehtävää "+tunnit+" tuntia");
    }
}