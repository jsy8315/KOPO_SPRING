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
                result = dao.withdrawToBank01(dAccountNumber, transferAmount, wAccountNumber, wBankCode);
                break;
            case "02":
                result = dao.withdrawToBank02(dAccountNumber, transferAmount, wAccountNumber, wBankCode);
                break;
            case "03":
                result = dao.withdrawToBank03(dAccountNumber, transferAmount, wAccountNumber, wBankCode);
                break;
            case "04":
                result = dao.withdrawToBank04(dAccountNumber, transferAmount, wAccountNumber, wBankCode);
                break;
            case "05":
                result = dao.withdrawToBank05(dAccountNumber, transferAmount, wAccountNumber, wBankCode);
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
