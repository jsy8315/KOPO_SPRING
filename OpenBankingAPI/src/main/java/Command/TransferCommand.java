package Command;

import java.io.IOException;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAODTO.OpenBankingDAO;

public class TransferCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        // Get parameters
        String wBankCode = request.getParameter("wBankCode");
        String wAccountNumber = request.getParameter("wAccountNumber");
        String wName = request.getParameter("wName");
        String transferAmount = request.getParameter("TransferAmount");
        String dBankCode = request.getParameter("dBankCode");
        String dAccountNumber = request.getParameter("dAccountNumber");
        String dName = request.getParameter("dName");

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
