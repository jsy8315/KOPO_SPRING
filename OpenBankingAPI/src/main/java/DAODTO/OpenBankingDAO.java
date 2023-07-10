package DAODTO;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import com.google.gson.JsonObject;

public class OpenBankingDAO {
	
    private String sendPOSTRequest(String url, JsonObject jsonObject) throws IOException {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.close();

        return result;
    }

    public boolean depositToBank01(String accountNumber, String amount) {
        try {
            String url = "http://localhost:8082"; // 보낼 개별은행 주소

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("dAccountNumber", accountNumber);
            jsonObject.addProperty("transferAmount", amount);

            String response = sendPOSTRequest(url, jsonObject);

            // assuming the response body is a simple true or false
            return Boolean.parseBoolean(response);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean depositToBank02(String accountNumber, String amount) {
        // Similar to depositToBank01, but for Bank02's API.
        return true; // or false.
    }

    public boolean depositToBank03(String accountNumber, String amount) {
        // Similar to depositToBank01, but for Bank02's API.
        return true; // or false.
    }
    
    public boolean depositToBank04(String accountNumber, String amount) {
        // Similar to depositToBank01, but for Bank02's API.
        return true; // or false.
    }
    
    public boolean depositToBank05(String accountNumber, String amount) {
        // Similar to depositToBank01, but for Bank02's API.
        return true; // or false.
    }
}
