package Command;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import DAODTO.OpenBankingSelectDAO;

public class SelectCommand {
    private String identityNum;
    private OpenBankingSelectDAO dao = new OpenBankingSelectDAO();

    public void setParameters(String identityNum) {
        this.identityNum = identityNum;
    }

    public String[] getBankUrls() {
        return new String[]{
            "http://localhost:8081/MemberAuthentication01/select",
            "http://localhost:8082/MemberAuthentication02/select",
            "http://localhost:8083/MemberAuthentication03/select",
            "http://localhost:8084/MemberAuthentication04/select",
            "http://localhost:8085/MemberAuthentication05/select"
        };
    }

    public OpenBankingSelectDAO getDao() {
        return this.dao;
    }

    public CompletableFuture<JsonArray> execute() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("identityNum", identityNum);

        CompletableFuture<JsonArray>[] futures = Arrays.stream(getBankUrls())
            .map(url -> getDao().selectBank(url, jsonObject))
            .toArray(CompletableFuture[]::new);

        return CompletableFuture.allOf(futures)
                .thenApply(v -> {
                    JsonArray resultArray = new JsonArray();
                    for (CompletableFuture<JsonArray> future : futures) {
                        resultArray.addAll(future.join());
                    }
                    return resultArray;
                });
    }
}
