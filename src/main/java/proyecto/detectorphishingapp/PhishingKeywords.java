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
        keywordsMap.put("ganador", 3);  // Muy probable
        keywordsMap.put("oferta", 2);  // Algo probable
        keywordsMap.put("exclusiva", 3);  // Muy probable
        keywordsMap.put("tarjeta", 2);  // Algo probable
        keywordsMap.put("crédito", 2);  // Algo probable
        keywordsMap.put("ganaste", 3);  // Muy probable
        keywordsMap.put("seleccionado", 3);  // Muy probable
        keywordsMap.put("actualización", 2);  // Algo probable
        keywordsMap.put("inicio de sesión", 3);  // Muy probable
        keywordsMap.put("expirado", 2);  // Algo probable
        keywordsMap.put("confirme", 3);  // Muy probable
        keywordsMap.put("identidad", 2);  // Algo probable
        keywordsMap.put("cierre", 3);  // Muy probable
        keywordsMap.put("felicidades", 2);  // Algo probable
        keywordsMap.put("secreto", 3);  // Muy probable
        keywordsMap.put("gratis", 2);  // Algo probable
        keywordsMap.put("limitado", 3);  // Muy probable
        keywordsMap.put("oficial", 2);  // Algo probable
        keywordsMap.put("empresa", 1);  // Poco probable
        keywordsMap.put("confidencial", 3);  // Muy probable
        keywordsMap.put("cancelar", 2);  // Algo probable
        keywordsMap.put("llama ahora", 3);  // Muy probable

        return keywordsMap;
    }
}
