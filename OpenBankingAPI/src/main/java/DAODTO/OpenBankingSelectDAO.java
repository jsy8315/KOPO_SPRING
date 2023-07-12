package DAODTO;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.stream.Collectors;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class OpenBankingSelectDAO {
    private List<String> banks = Arrays.asList(
        "http://localhost:8081/MemberAuthentication01/select",
        "http://localhost:8082/MemberAuthentication02/select",
        "http://localhost:8083/MemberAuthentication03/select",
        "http://localhost:8084/MemberAuthentication04/select",
        "http://localhost:8085/MemberAuthentication05/select"
    );

    public List<String> getBanks() {
        return this.banks;
    }

    private CompletableFuture<JsonObject> sendPOSTRequestAsync(String url, JsonObject jsonObject) {
        return CompletableFuture.supplyAsync(() -> {
            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                HttpPost httpPost = new HttpPost(url);

                // add header
                httpPost.setHeader("Content-type", "application/json");

                // add request body
                StringEntity stringEntity = new StringEntity(jsonObject.toString());
                httpPost.setEntity(stringEntity);

                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    String result = EntityUtils.toString(response.getEntity());

                    // Parse the response
                    return JsonParser.parseString(result).getAsJsonObject();
                } catch (IOException | ParseException e) {
                    throw new CompletionException(e);
                }
            } catch (Exception e) {
                throw new CompletionException(e);
            }
        });
    }

    public String sendPOSTRequest(String url, JsonObject jsonObject) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        // add header
        httpPost.setHeader("Content-type", "application/json");

        // add request body
        StringEntity stringEntity = new StringEntity(jsonObject.toString());
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        String result = null;
        try {
            result = EntityUtils.toString(response.getEntity());
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
        }

        return result;
    }

    public List<CompletableFuture<JsonObject>> selectAllBank(String identityNum) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("identityNum", identityNum);

        return banks.stream()
            .map(url -> sendPOSTRequestAsync(url, jsonObject))
            .collect(Collectors.toList());
    }
}

