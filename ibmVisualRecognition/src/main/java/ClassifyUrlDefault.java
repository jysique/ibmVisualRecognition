import java.io.FileNotFoundException;
import java.util.*;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;


public class ClassifyUrlDefault {

    public String ClassifyImage(String URL){
        IamAuthenticator authenticator = new IamAuthenticator("2jAm8mmSwyVKGd_d-Jgdgx4PK4ypJWz62eEX_nLPUmer");
        ClassifyOptions classifyOptions = new ClassifyOptions.Builder().url(URL).build();
        VisualRecognition visualRecognition = new VisualRecognition("2018-03-19", authenticator);
        //visualRecognition.set ("https://api.us-south.visual-recognition.watson.cloud.ibm.com/instances/e2b8be67-08fd-4ff9-953f-4589659dc2b4");
        visualRecognition.setEndPoint("https://api.us-south.visual-recognition.watson.cloud.ibm.com/instances/e2b8be67-08fd-4ff9-953f-4589659dc2b4");

        ClassifiedImages tempResults = visualRecognition.classify(classifyOptions).execute().getResult();
        //System.out.println(tempResults);
        String results = tempResults.toString();
        String parseResult = ClassifyParse(results);

        return parseResult;
    }

    public String ClassifyParse(String result){
        Scanner es = new Scanner(result);
        String[] datos;
        String tempDato  ="";
        String linea;
        int estado = -1;

        while (es.hasNext()){
            linea = es.nextLine();
            if(estado == -1 && linea.contains("\"classes\": [")){
                estado = 0;
            }else if(estado ==0) {
                linea = linea.replaceAll("\\{", "");
                linea = linea.replaceAll("\"", "");
                linea = linea.replaceAll(" ", "");
                linea = linea.replaceAll("\\s", " ");
                linea = linea.replaceAll("\\},", "\n");
                linea = linea.replaceAll(",", " ");
                linea = linea.replaceAll("}", "");
                linea = linea.replaceAll("]", "");
                tempDato = tempDato+linea;
                //System.out.println(linea);
            }
        }
        //System.out.println(tempDato);
        //datos = tempDato.split("\n");

        return tempDato;
    }


    public static void main(String[] args) throws FileNotFoundException {

    }

}
