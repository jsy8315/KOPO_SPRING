package Command;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import DAODTO.OpenBankingSelectDAO;

public class SelectCommand {
    private String identityNum;

    public void setParameters(String identityNum) {
        this.identityNum = identityNum;
    }

    public CompletableFuture<JsonArray> execute() {
        OpenBankingSelectDAO dao = new OpenBankingSelectDAO();
        List<String> banks = dao.getBanks();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("identityNum", identityNum);

        List<CompletableFuture<JsonArray>> futures = new ArrayList<>();

        for (String bank : banks) {
            CompletableFuture<JsonArray> future = dao.selectBank(bank, jsonObject);
            futures.add(future);
        }

        System.out.println("001 : 각 은행에 조회 요청 전송 완료");

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> {
                    System.out.println("002 : 모든 은행 조회 완료");

                    JsonArray resultArray = new JsonArray();
                    for (CompletableFuture<JsonArray> future : futures) {
                        JsonArray bankData = future.join();
                        resultArray.addAll(bankData);
                        System.out.println("003 : 데이터 합치기 완료");
                    }
                    return resultArray;
                    
                });
    }
}
