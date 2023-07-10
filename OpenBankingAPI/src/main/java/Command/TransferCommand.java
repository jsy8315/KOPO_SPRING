package Command;

import java.io.IOException;

import com.google.gson.Gson;

import DAODTO.OpenBankingDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TransferCommand implements Command {
    private String wBankCode;
    private String wAccountNumber;
    private String wName;
    private String transferAmount;
    private String dBankCode;
    private String dAccountNumber;
    private String dName;

    public void setParameters(String wBankCode, String wAccountNumber, String wName, String transferAmount,
                              String dBankCode, String dAccountNumber, String dName) {
        this.wBankCode = wBankCode;
        this.wAccountNumber = wAccountNumber;
        this.wName = wName;
        this.transferAmount = transferAmount;
        this.dBankCode = dBankCode;
        this.dAccountNumber = dAccountNumber;
        this.dName = dName;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        OpenBankingDAO dao = new OpenBankingDAO();
        boolean result = false;

        switch (dBankCode) {
            case "01":
                result = dao.depositToBank01(dAccountNumber, transferAmount);
                break;
            case "02":
                result = dao.depositToBank02(dAccountNumber, transferAmount);
                break;
            case "03":
                result = dao.depositToBank03(dAccountNumber, transferAmount);
                break;
            case "04":
                result = dao.depositToBank04(dAccountNumber, transferAmount);
                break;
            case "05":
                result = dao.depositToBank05(dAccountNumber, transferAmount);
                break;
            default:
                // handle error
                break;
        }

        try {
            // Send response
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
