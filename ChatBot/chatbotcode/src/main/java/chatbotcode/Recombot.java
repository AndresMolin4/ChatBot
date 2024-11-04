package chatbotcode;

import com.cjcrafter.openai.OpenAI;
import com.cjcrafter.openai.chat.ChatMessage;
import com.cjcrafter.openai.chat.ChatRequest;
import com.cjcrafter.openai.chat.ChatResponseChunk;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * En este ejemplo en Java, utilizaremos la API de Chatgpt para crear un chatbot sencillo.
 * En lugar de esperar a que se genere la respuesta completa, "transmitiremos" los tokens
 * uno por uno a medida que se generen.
 */
public class Recombot {

    public static void main(String[] args) {

        // Carga la clave de API usando dotenv
        Dotenv dotenv = Dotenv.configure().directory("C:\Users\ANDRES\Desktop\Programacion\ChatBot\chatbotcode").load(); 
        String key = dotenv.get("OPENAI_API_KEY");
        
        OpenAI openai = OpenAI.builder()
                .apiKey(key)
                .build();

        // Lista mutable para los mensajes de conversación
        List<ChatMessage> mensajes = new ArrayList<>();
        mensajes.add(ChatMessage.toSystemMessage("Ayuda al usuario con su problema."));

        // Configuración de la solicitud al modelo
        ChatRequest request = ChatRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(mensajes)
                .build();

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("¿En qué tienes problemas?");
            String input = scan.nextLine();

            mensajes.add(ChatMessage.toUserMessage(input));
            System.out.println("Generando respuesta...");

            for (ChatResponseChunk chunk : openai.streamChatCompletion(request)) {
                // Validar si el contenido no es nulo
                String delta = chunk.get(0).getDeltaContent();
                if (delta != null)
                    System.out.print(delta);

                // Añadir el mensaje completo a la lista cuando esté listo
                if (chunk.get(0).isFinished())
                    mensajes.add(chunk.get(0).getMessage());
            }

            // Nueva línea para separar los mensajes
            System.out.println();
        }
    }
}
