package javaproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatGPT {
    private static final String API_KEY = "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"; 

    public static String Recommendations_0( String mensaje) {
        String response = "";
        try {
            URL url = new URL("https://api.openai.com/v1/chat/completions");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"" + mensaje + "\"}]}";

          
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
