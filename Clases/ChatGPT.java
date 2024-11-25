package chatbotcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChatGPT {

    public static String Recommendations_0( String mensaje) {
        String response = "";
        try {
            URL url = new URL("http://127.0.0.1:3074/v1/chat/completions");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " );
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = """
                    {"model": "llama-3.2-1b-instruct",
                    "messages": [
                    {"role": "system", "content": "Eres una persona que sabe mucho de libros y peliculas y me vas a recomendar minimo 3 opciones y maximo 5 opciones, escribe sus autores y fechas de publicacion" },    
                    {"role": "user", "content": "%s" }
                        ]
                    }
                    """.formatted(mensaje);


          
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder responseBuilder = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    responseBuilder.append(responseLine.trim());
                }
                response = responseBuilder.toString();
            }

            JSONObject jsonResponse = new JSONObject(response);
            JSONArray choices = jsonResponse.getJSONArray("choices");
            JSONObject choice = choices.getJSONObject(0);
            JSONObject message = choice.getJSONObject("message");


            String contenido = message.optString("content", "No disponible"); 
            
            

            return "\n Respuesta : " + contenido;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}

