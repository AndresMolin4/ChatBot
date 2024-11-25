package chatbotcode;

import java.util.Scanner;

/**
 * En este ejemplo en Java, utilizaremos la API de LMStudio para crear un
 * chatbot sencillo.
 * En lugar de esperar a que se genere la respuesta completa, "transmitiremos"
 * los tokens
 * uno por uno a medida que se generen.
 */
public class Recomombot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("¡Hola soy Recomombot! ¿Qué película o libro te puedo recomendar? ");

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

                System.out.println("Buscando recomendación usando Recomombot...");
                String respuestaAPI = ChatGPT.Recommendations_0("Recomienda un libro para la película: " + input);
                System.out.println("Respuesta de Recomombot: " + respuestaAPI);

                Interaccion.guardar(input, respuestaAPI);
            }

            System.out.println("\n¿En qué más puedo ayudarte? (escribe 'salir' para terminar)");
        }
        while (true) {
            System.out.println("¿Desea ver su historial en la base de datos? (si/no)");
            String input2 = scanner.nextLine().trim().toLowerCase();

            if (input2.equals("si")) {
                Interaccion.select(); 
                break; 
            } else if (input2.equals("no")) {
                System.out.println("Gracias por usar Recomombot. ¡Hasta la próxima!");
                break; 
            } else {
                System.out.println("Respuesta Invalida.\nPor favor, responde con 'si' o 'no'.");
            }
        }
        while (true) {
            System.out.println("¿Desea borrar su historial de la base de datos? (si/no)");
            String input3 = scanner.nextLine().trim().toLowerCase();

            if (input3.equals("si")) {
                Interaccion.deleteAll(); 
                break; 
            } else if (input3.equals("no")) {
                System.out.println("Gracias por usar Recomombot. ¡Hasta la próxima!");
                break; 
            } else {
                System.out.println("Respuesta Invalida.\nPor favor, responde con 'si' o 'no'.");
            }
        }

        scanner.close(); 
    }

    public static String buscarRecomendacionEnBD(String input) {
        return null;
    }
}
