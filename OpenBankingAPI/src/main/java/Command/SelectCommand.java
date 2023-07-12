package Command;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonObject;

import DAODTO.OpenBankingSelectDAO;

public class SelectCommand {
    private String identityNum;

    public void setParameters(String identityNum) {
        this.identityNum = identityNum;
    }

    public List<CompletableFuture<JsonObject>> execute() {
        OpenBankingSelectDAO dao = new OpenBankingSelectDAO();
        return dao.selectAllBank(identityNum);
    }
}
