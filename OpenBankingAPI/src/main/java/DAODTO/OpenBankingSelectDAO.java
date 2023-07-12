package DAODTO;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletableFuture;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class OpenBankingSelectDAO {

    public CompletableFuture<JsonArray> selectBank(String bankUrl, JsonObject jsonObject) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL(bankUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                osw.write(jsonObject.toString());
                osw.flush();
                osw.close();

                if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }

                br.close();
                conn.disconnect();

                JsonParser parser = new JsonParser();
                JsonArray jsonArray = parser.parse(sb.toString()).getAsJsonArray();
                
                return jsonArray;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });
    }
}
