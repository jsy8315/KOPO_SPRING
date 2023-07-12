package DAODTO;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class OpenBankingSelectDAO {
    private List<String> banks = Arrays.asList(
        "http://localhost:8081/MemberAuthentication01/select",
        "http://localhost:8082/MemberAuthentication02/select"
        //"http://localhost:8083/MemberAuthentication03/select",
        //"http://localhost:8084/MemberAuthentication04/select",
        //"http://localhost:8085/MemberAuthentication05/select"
    );
    private Gson gson = new Gson();


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

                    // Return the response as JSON object
                    return new JsonParser().parse(result).getAsJsonObject();
                } catch (IOException | ParseException e) {
                    throw new CompletionException(e);
                }
            } catch (Exception e) {
                throw new CompletionException(e);
            }
        });
    }

    public JsonObject sendPOSTRequest(String url, JsonObject jsonObject) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        // add header
        httpPost.setHeader("Content-type", "application/json");

        // add request body
        StringEntity stringEntity = new StringEntity(jsonObject.toString());
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        JsonObject result = null;
        try {
            String resultString = EntityUtils.toString(response.getEntity());
            result = new JsonParser().parse(resultString).getAsJsonObject();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
        }

        return result;
    }

    public CompletableFuture<JsonArray> selectBank(String url, JsonObject jsonObject) {
        return sendPOSTRequestAsync(url, jsonObject)
            .thenApply(response -> {
                JsonArray accountArray = response.getAsJsonArray("accounts");
                if (accountArray != null) {
                    for (int i = 0; i < accountArray.size(); i++) {
                        JsonObject accountObject = accountArray.get(i).getAsJsonObject();
                        String accountNum = accountObject.get("accountNum").getAsString();
                        String bankCode = accountObject.get("bankCode").getAsString();
                        String accCode = accountObject.get("accCode").getAsString();
                        String accBalance = accountObject.get("accBalance").getAsString();

                        // Create a BankAccountInfo object with the received data
                        BankAccountInfo bankAccountInfo = new BankAccountInfo(accountNum, bankCode, accCode, accBalance);

                        // Convert the BankAccountInfo object to JsonObject and replace the original account object
                        JsonElement bankAccountInfoElement = gson.toJsonTree(bankAccountInfo);
                        accountArray.set(i, bankAccountInfoElement);
                    }
                }
                return accountArray;
            });
    }


    
}
