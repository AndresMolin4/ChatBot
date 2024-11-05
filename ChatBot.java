package javaproject;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Hola! ¿En qué película o libro estás interesado?");
        String input = scanner.nextLine();

        String resultadoBD = buscarRecomendacionEnBD(input);

        if (resultadoBD != null) {
            System.out.println("Recomendación de la base de datos: " + resultadoBD);
        } else {
            System.out.println("Buscando recomendación usando ChatGPT...");
            String respuestaAPI = ChatGPT.Recommendations_0("Recomienda un libro para la película: " + input);
            System.out.println("Respuesta de ChatGPT: " + respuestaAPI);
        }

        scanner.close();
    }

    public static String buscarRecomendacionEnBD(String input) {
        
        return null;
    }
}

