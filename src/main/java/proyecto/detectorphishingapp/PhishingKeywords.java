package proyecto.detectorphishingapp;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author CRIZ
 */



public class PhishingKeywords {

    // Mapa de palabras clave y su valor asociado en puntos
    public static final Map<String, Integer> KEYWORDS_MAP = createKeywordsMap();

    private static Map<String, Integer> createKeywordsMap() {
        Map<String, Integer> keywordsMap = new HashMap<>();

        // Asignar palabras clave y establecer un valor de puntos a cada una
        
        keywordsMap.put("bloqueada", 2);  // Algo probable
        keywordsMap.put("comprometida", 3);  // Muy probable
        keywordsMap.put("información", 2);  // Algo probable
        keywordsMap.put("cuenta", 1);  // Poco probable
        keywordsMap.put("seguridad", 2);  // Algo probable
        keywordsMap.put("confirmar", 3);  // Muy probable
        keywordsMap.put("contraseña", 2);  // Algo probable
        keywordsMap.put("urgente", 3);  // Muy probable
        keywordsMap.put("premio", 2);  // Algo probable


        return keywordsMap;
    }
}
