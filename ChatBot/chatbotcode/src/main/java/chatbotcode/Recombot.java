package chatbotcode;

import java.util.Scanner;

/**
 * En este ejemplo en Java, utilizaremos la API de LMStudio para crear un chatbot sencillo.
 * En lugar de esperar a que se genere la respuesta completa, "transmitiremos" los tokens
 * uno por uno a medida que se generen.
 */
public class Recombot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("!Hola soy Recombot!  que película o libro te puedo recomendar");
        
        
        while (true) {
            input = scanner.nextLine();
            
           
            if (input.equalsIgnoreCase("salir")) {
                System.out.println("¡Hasta luego!");
                break; 
            }
    
            String resultadoBD = buscarRecomendacionEnBD(input);
    
            if (resultadoBD != null) {
                System.out.println("Recomendación de la base de datos: " + resultadoBD);
            } else {
                System.out.println("Buscando recomendación usando Recombot...");
                String respuestaAPI = ChatGPT.Recommendations_0("Recomienda un libro para la película: " + input);
                System.out.println("Respuesta de Recombot: " + respuestaAPI);
            } 
            
            System.out.println("\n¿En qué más puedo ayudarte? (escribe 'salir' para terminar)");
        }
        
        scanner.close();
    }

    public static String buscarRecomendacionEnBD(String input) {
        // Aquí iría la lógica para buscar recomendaciones en la base de datos
        return null;  // De momento retorna null para indicar que no se encontró una recomendación
    }
}
